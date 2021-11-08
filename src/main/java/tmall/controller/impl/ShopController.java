package tmall.controller.impl;

import tmall.controller.Controller;
import tmall.model.entity.*;
import tmall.model.entityDao.daoImpl.*;
import tmall.model.entityDao.daoInterface.*;

import java.util.*;

/**
 * @Author Sir Lancelot
 * @Description 店铺后台相关操作
 * 特别地，查看商品详情应调用 CommodityDisplayController 中的 commodityDetailDisplay(String commodityId)
 */
public class ShopController extends Controller {
    public Notify strategy;
    /**
     * 本函数在seller选择店铺时使用，返回店铺的商品、活动、订单等信息。返回值结构是根据流程图定义的
     * @param args shopId
     * @return obj[0]: 商品列表，供页面直接展示用  obj[1]: 优惠券列表，供页面直接展示用   obj[2]: 订单列表，供页面直接展示用
     */
    @Override
    public Object[] execute(Object... args) {
        String id = args[0].toString();
        CommodityDao commodityDao = new CommodityDaoImpl();
//        System.out.println(commodityDao.getAllByShopId(id));
        List<Commodity> commodityList = commodityDao.getAllByShopId(id);
        Object[] obj = new Object[3];
        obj[0] = commodityList;
        obj[1] = getCouponList(id);
        obj[2] = getOrderList(id);
        return obj;
    }
    /**
     * 删除商品 (llf接口不允许传入错误的Id，故没有删除成功与否的判断)
     * @param commodityId id
     */
    public void deleteCommodity(String commodityId) {
        CommodityDao commodityDao = new CommodityDaoImpl();
        commodityDao.deleteById(commodityId);
    }

    /**
     * 应用观察者模式和策略模式通知关注用户新活动及新商品的发布
     */

    public interface Notify{
        void notify(String shopId);
    }
    public static class notifyNewCommodity implements Notify{
        @Override
        public void notify(String shopId){
            FollowShopDao followShopDao = new FollowShopDaoImpl();
            List<FollowShop> SubscriberList = followShopDao.getAllByShopId(shopId);
//            System.out.println("Observers: "+SubscriberList);
            for(FollowShop followShop: SubscriberList){
                followShop.cheers("2");
            }
        }
    }
    public static class notifyNewCoupon implements Notify{
        @Override
        public void notify(String shopId){
            FollowShopDao followShopDao = new FollowShopDaoImpl();
            List<FollowShop> SubscriberList = followShopDao.getAllByShopId(shopId);
            for(FollowShop followShop: SubscriberList){
                followShop.cheers("1");
            }
        }
    }

    /**
     * 以下定义促销方式，分别为优惠券（满减）和活动（打折），使用反射方法实例化相应对象（由于数据库不能存储接口属性，反射放在结算时）
     * 关于使用条件的判断应在结算页面处理
     */
    public interface Strategy{
        double pay(String... args);
    }
    /**
     * args[0]: 原价   args[1]: 减多少钱
     */
    public static class CouponStrategy implements Strategy{
        @Override
        public double pay(String... args) {
            return Double.parseDouble(args[0]) - Double.parseDouble(args[1]);
        }
    }
    /**
     * args[0]: 原价  args[1]: 折扣
     */
    public static class DiscountStrategy implements Strategy{
        @Override
        public double pay(String... args) {
            return Double.parseDouble(args[0]) * Double.parseDouble(args[1]);
        }
    }
    /**
     * 应用策略模式通知所有店铺粉丝
     */
    public void notifySubscribers(String shopId){
        strategy.notify(shopId);
    }

    /**
     * 店铺后台删除优惠券
     * @param couponId id
     */
    public void deleteCoupon(String couponId){
        CouponDao couponDao = new CouponDaoImpl();
        couponDao.deleteById(couponId);
    }

    /**
     * 查看优惠券详情
     * @param couponId id
     * @return 详见 Coupon.toString()方法
     */
    public String activityDetailDisplay(String couponId) {
        CouponDao couponDao = new CouponDaoImpl();
        Coupon coupon = couponDao.getById(couponId);

        return coupon.toString();
    }

    /**
     * 查看店铺订单列表
     */
    public List<Order> getOrderList(String shopId){
        OrderDao orderDao = new OrderDaoImpl();
        return orderDao.getAllByShopId(shopId);
    }

    /**
     * 查看店铺优惠券
     */
    public List<Coupon> getCouponList(String shopId){

        CouponDao couponDao =  new CouponDaoImpl();
        return couponDao.getAllByShopId(shopId);
    }

    /**
     * 返回一个店铺实体
     */
    public Shop getShop(String shopId){
        ShopDao shopDao = new ShopDaoImpl();
        return shopDao.getById(shopId);
    }
    /**
     * 订单发货
     * @param orderId id
     */
    public void shipOrder(String orderId){
        OrderDao orderDao = new OrderDaoImpl();
        orderDao.updateOrderStatus(orderId, "WAIT_RECEIVE");
    }
    public void restock(){
        System.out.println("请选择线上订货或线下采购：");
        System.out.println("1.线上  2.线下");
        Scanner type = new Scanner(System.in);
        String t = type.next();
        DetailedCommodity line = new DetailedCommodity();
        if(t.equals("1")){
            line = new OnlineRestockedCommodity();
        }else if(t.equals("2")){
            line = new OfflineRestockedCommodity();
        }else{
            System.out.println("输入错误！");
        }
        System.out.println("请选择国内补货或海外进口：");
        System.out.println("1.国内  2.国外");
        Scanner area = new Scanner(System.in);
        String a = type.next();
        if(a.equals("1")){
            Home home = new Home();
            line.defineProductionPlace(home);
        }else if(a.equals("2")){
            Abroad abroad = new Abroad();
            line.defineProductionPlace(abroad);
        }else{
            System.out.println("输入错误！");
        }
        System.out.println("进货方式：");
        line.restockDetailedCommodity();
        line.productionPlace.restockDetailedCommodity();
    }
}
