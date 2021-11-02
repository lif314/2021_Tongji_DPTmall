package tmall.controller.impl;

import tmall.controller.Controller;
import tmall.model.entity.*;
import tmall.model.entityDao.daoImpl.ActivityDaoImpl;
import tmall.model.entityDao.daoImpl.CommodityDaoImpl;
import tmall.model.entityDao.daoImpl.CouponDaoImpl;
import tmall.model.entityDao.daoImpl.OrderDaoImpl;
import tmall.model.entityDao.daoInterface.ActivityDao;
import tmall.model.entityDao.daoInterface.CommodityDao;
import tmall.model.entityDao.daoInterface.CouponDao;
import tmall.model.entityDao.daoInterface.OrderDao;

import java.util.*;

/**
 * @Author Sir Lancelot
 * @Description 店铺后台相关操作
 * 特别地，查看商品详情应调用 CommodityDisplayController 中的 commodityDetailDisplay(String commodityId)
 * 增加会场级活动的 管理员操作也在本类中，路径为 ShopController.ActivityBuilder.addVenueActivity
 */
public class ShopController extends Controller {
    /**
     * 声明数据库访问对象
     */
    CommodityDao commodityDao = new CommodityDaoImpl();
    CouponDao couponDao = new CouponDaoImpl();
    ActivityDao activityDao = new ActivityDaoImpl();
    OrderDao orderDao = new OrderDaoImpl();

    /**
     * 本函数在seller选择店铺时使用，返回店铺的商品、活动、订单等信息。返回值结构是根据流程图定义的
     * @param args shopId
     * @return obj[0]: 商品工厂，供后续上架商品用  obj[1]: 商品列表，供页面直接展示用  obj[2]: 优惠券列表，供页面直接展示用
     *         obj[3]: 订单列表，供页面直接展示用  obj[4]: 活动建造者对象
     * 商品工厂对象在初始化时已经传入shopId（seller选择店铺时传入），前端后续不需要再提供shopId
     */
    @Override
    public Object[] execute(Object... args) {
        String id = Arrays.toString(args);
        CommodityFactory commodityFactory = new CommodityFactory(id);
        ActivityBuilder activityBuilder = new ActivityBuilder(id);

        Object[] obj = new Object[5];
        obj[0] = commodityFactory;
        obj[1] = commodityFactory.commodityList;
        obj[2] = getCouponList(id);
        obj[3] = getOrderList(id);
        obj[4] = activityBuilder;
        return obj;
    }
    /**
     * 删除商品 (llf接口不允许传入错误的Id，故没有删除成功与否的判断)
     * @param commodityId id
     */
    public void deleteCommodity(String commodityId) {
        commodityDao.deleteById(commodityId);
    }

    /**
     * 应用享元和工厂模式添加商品
     */
    public class CommodityFactory{
        List<Commodity> commodityList = new ArrayList<>();
        final HashMap<String, Commodity> commodityHashMap = new HashMap<>();
        String current_shopId;

        /**
         * 构造方法，从数据库读取商品数据，并生成一个 {商品名:商品} 的HashMap
         */
        CommodityFactory(String shopId){
            commodityList = commodityDao.getAllByShopId(shopId);
            current_shopId = shopId;
            for (Commodity commodity : commodityList) {
                commodityHashMap.put(commodity.getCname(), commodity);
            }
        }

        /**
         * 添加商品
         * @param cname 名称
         * @param category 类别
         * @param price 价格
         * @param storeNum 库存
         * @param description 描述
         * @return obj[0]: 创建的新commodity对象 或 原有的商品  obj[1]:提示信息
         * 可考虑在tips为“0”时输出重名商品信息
         */
        public Object[] add(String cname, String category, String price,  String storeNum,  String description){
            Object[] obj = new Object[2];
            Commodity commodity = commodityHashMap.get(cname);
            String tips = "0";  // "该商品名已存在！";
            if(commodity == null) {
                commodity = commodityDao.create(current_shopId, price, category, storeNum, cname, description);
                commodityHashMap.put(cname, commodity);
                tips = "1";  // "添加商品成功！";
            }
            obj[0] = commodity;
            obj[1] = tips;
            return obj;
        }
    }

    /**
     * 应用策略和建造者模式添加活动
     */
    public class ActivityBuilder{
        String current_shopId;
        List<Order> observers = new ArrayList<Order>();
        ActivityBuilder(String ShopId){
            current_shopId = ShopId;
            List<Coupon> shopCoupons = couponDao.getAllByShopId(current_shopId);
//            observers = order
        }

        /**
         * 添加优惠券（不指定用户和数量）
         * @param startTime 开始
         * @param endTime 截止
         * @param full 使用条件（消费满多少元）
         * @param minus 减多少元
         */
        public Coupon addCoupon(String startTime, String endTime, String full, String minus) {
            Coupon newCoupon = couponDao.create(current_shopId, startTime, endTime, full, minus);
            return newCoupon;
        }

        /**
         * 添加活动 (全场应用)，不属于店铺后台管理范围，只是在这里实现
         * @param activityName 活动名
         * @param startTime 开始
         * @param endTime 截止
         * @param discount 打折
         */
        public Activity addActivity(String activityName, String startTime, String endTime, String discount){
            return activityDao.create(activityName, startTime, endTime, discount);
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
    public class CouponStrategy implements Strategy{
        @Override
        public double pay(String... args) {
            return Double.parseDouble(args[0]) - Double.parseDouble(args[1]);
        }
    }
    /**
     * args[0]: 原价  args[1]: 折扣
     */
    public class DiscountStrategy implements Strategy{
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
        couponDao.deleteById(couponId);
    }

    /**
     * 查看优惠券详情
     * @param couponId id
     * @return 详见 Coupon.toString()方法
     */
    public String activityDetailDisplay(String couponId) {
        Coupon coupon = couponDao.getById(couponId);

        return coupon.toString();
    }

    /**
     * 查看店铺订单列表
     */
    public List<Order> getOrderList(String shopId){
        return orderDao.getAllByShopId(shopId);
    }

    /**
     * 查看店铺优惠券
     */
    public List<Coupon> getCouponList(String shopId){
        return couponDao.getAllByShopId(shopId);
    }

    /**
     * 订单发货
     * @param orderId id
     */
    public void shipOrder(String orderId){
        orderDao.updateOrderStatus(orderId, "WAIT_RECEIVE");
    }
}
