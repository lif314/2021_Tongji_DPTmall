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
 * 增加会场级活动的 管理员操作也在本类中，路径为 ShopController.ActivityBuilder.addVenueActivity(管理员功能已舍弃？)
 */
public class ShopController extends Controller {

    /**
     * 本函数在seller选择店铺时使用，返回店铺的商品、活动、订单等信息。返回值结构是根据流程图定义的
     * @param args shopId
     * @return obj[1]: 商品列表，供页面直接展示用  obj[2]: 优惠券列表，供页面直接展示用   obj[3]: 订单列表，供页面直接展示用
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
     * @return
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
}
