package tmall.controller.orderController;

import tmall.XMLRepository.util.Nullable;
import tmall.controller.Controller;
import tmall.controller.calculation.Calculator;
import tmall.model.entity.*;
import tmall.model.entityDao.daoImpl.*;
import tmall.model.entityDao.daoInterface.*;
import tmall.model.logicalEntity.OrderCommodityLogic;
import tmall.model.logicalEntity.OrderLogic;
import tmall.tmallSystem.TMallSystem;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

/**
 * 购物中心：购物流程
 */
public class ShoppingCenter extends Controller {

    /**
     * 购物流程
     *      [1] 挑选商品：可以从首页中挑选，也可以从购物车中挑选
     *      [2] 当用户挑选了某件商品，我们应该将其引到店铺中，即展示该店铺中的所有商品，让用户继续挑选
     *      [3] 选好商品后，用户可以选择店家优惠券
     *      [4] 选择买家收获信息
     *      [5] 选择支付信息
     *      [6] 查看订单详情
     */
    private static final List<OrderCommodityLogic> orderCommodityLogics = new ArrayList<>();

    private static String shopId;

    private static String buyerId;

    private static double totalMoney = 0.0;

    private static double paidMoney = 0.0;

    private static Activity activity;

    private static Coupon coupon;

    private static BuyerAddress buyerAddress;

    private static OrderPayment orderPayment;

    /**
     * 首页展示所有商品 √
     * @return list commodity
     */
    public List<Commodity> displayCommodities(){
        CommodityDao commodityDao = new CommodityDaoImpl();
        return commodityDao.getAll();
    }

    /**
     * 展示商品详情
     * @param commodityId id √
     * @return commodity
     */
    public Commodity displayCommodityDetail(String commodityId){
        CommodityDao commodityDao = new CommodityDaoImpl();
        return commodityDao.getByCommodityId(commodityId);
    }

    /**
     * 根据商品详情，进入店铺中所有商品
     * @param commodityId id √
     * @return shop commodities
     */
    public List<Commodity> displayShopCommodities(String commodityId){
        CommodityDao commodityDao = new CommodityDaoImpl();
        Commodity commodity = commodityDao.getByCommodityId(commodityId);
        shopId = commodity.getShopId();
        return  commodityDao.getAllByShopId(commodity.getShopId());
    }

    /**
     * 选择商品，需多次调用
     * @param commodityId id √
     * @param amount 数量
     */
    public void selectCommodity(String commodityId, String amount){
        CommodityDao commodityDao = new CommodityDaoImpl();
        Commodity commodity = commodityDao.getByCommodityId(commodityId);
        OrderCommodityLogic orderCommodityLogic = new OrderCommodityLogic(commodity.getCommodityId(), commodity.getCname(), commodity.getPrice(), amount);
        orderCommodityLogics.add(orderCommodityLogic);
        System.out.printf("|%-10s|%-5s|%-8s|%-40s|%n",
                "Name","Price","Amount","CommodityID");
        for(OrderCommodityLogic ocl : orderCommodityLogics){
            System.out.println(ocl);
        }
    }

    /**
     * 计算总价
     * @return totalMoney √
     */
    public String calTotalMoney(){
        for (OrderCommodityLogic c : orderCommodityLogics) {
            totalMoney += Double.parseDouble(c.getPrice()) * Double.parseDouble(c.getAmount());
        }
        return totalMoney + "";
    }

    /**
     * 返回所有活动
     * @return list activities √
     */
    public List<Activity> displayActivities(){
        ActivityDao activityDao = new ActivityDaoImpl();
        return activityDao.getAll();
    }

    /**
     * 返回当前店铺的所有优惠券
     * @return List<Coupon> √
     */
    public List<Coupon> displayShopCoupon(){
        CouponDao couponDao = new CouponDaoImpl();
        return couponDao.getAllByShopId(shopId);
    }

    /**
     * 选择优惠方式 √
     * @param activityId 活动Id
     * @param couponId 优惠券Id
     */
    public void selectPromotions(@Nullable String activityId,@Nullable String couponId){
        if(activityId != null){
            ActivityDao activityDao = new ActivityDaoImpl();
            this.activity = activityDao.getById(activityId);
        }
        if(couponId != null){
            CouponDao couponDao = new CouponDaoImpl();
            this.coupon = couponDao.getById(couponId);
        }
    }

    /**
     * 计算优惠后的价格：先满减，再打折 √
     * @return paidMoney
     */
    public String calPaidMoney(){
        if(totalMoney==0) {
            calTotalMoney();//为了保证必定有totalMoney
        }
        Calculator calculator = new Calculator(totalMoney,coupon,activity);
        return Double.toString(calculator.doCalculation());
    }

    /**
     * 展示买家所有收获地址
     * @param buyerId id √
     * @return list buyerAddress
     */
    public List<BuyerAddress> displayBuyerAddress(String buyerId){
        BuyerAddressDao buyerAddressDao = new BuyerAddressDaoImpl();
        ShoppingCenter.buyerId = buyerId;
        return buyerAddressDao.getBuyerAddresses(buyerId);
    }

    /**
     * 选择买家收获地址  √
     * @param buyerAddressId id
     */
    public void selectBuyerAddress(String buyerAddressId){
        BuyerAddressDao buyerAddressDao = new BuyerAddressDaoImpl();
        buyerAddress = buyerAddressDao.getById(buyerAddressId);
    }

    /**
     * 展示购买方式 √
     * @return method
     */
    public String displayPayMethod(){
        return Arrays.toString(OrderPaymentMethod.values());
    }

    /**
     * 选择支付方式
     * @param method 下标
     *               UnionPay
     *               WeChat
     *               AliPay
     */
    public void selectPayMethod(String method){
        String id = UUID.randomUUID().toString();
        orderPayment = new OrderPayment();
        orderPayment.setOrderPaymentId(id);
        orderPayment.setPayMethod(method);
    }

    /**
     * 立即购买
     */
    public void payImmediately(){
        orderPayment.setTotalMoney(totalMoney + "");
        orderPayment.setPayStatus(PayStatus.Paid.toString());
        orderPayment.setPaidTime(LocalDateTime.now().toString());
        orderPayment.setPaidMoney(paidMoney + "");
    }

    /**
     * 展示订单
     * @param buyerId 买家Id
     * @return 订单详情
     */
    public OrderLogic displayOrderDetail(String buyerId){

        return OrderBuilder
                    .getOrderBuilderInstance()
                    .initOrder(buyerId)
                    .setOrderCommodities(orderCommodityLogics)
                    .setOrderPromotions(activity, coupon)
                    .setOrderAddress(buyerAddress)
                    .setOrderPayment(orderPayment)
                    .build();
    }

}