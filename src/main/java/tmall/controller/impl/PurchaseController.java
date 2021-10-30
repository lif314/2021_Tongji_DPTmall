package tmall.controller.impl;

import tmall.XMLRepository.util.Nullable;
import tmall.controller.CommodityController;
import tmall.controller.orderController.OrderBuilder;
import tmall.model.entity.*;
import tmall.model.entityDao.daoImpl.*;
import tmall.model.entityDao.daoInterface.*;
import tmall.model.logicalEntity.OrderCommodityLogic;
import tmall.model.logicalEntity.OrderLogic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

/**
 * @author Strange
 * @date 2021/10/30 0:03
 * @description: 购买商品控制器
 */
public class PurchaseController extends CommodityController {

    // 商品数据访问对象
    CommodityDao commodityDao = new CommodityDaoImpl();
    // 店铺数据访问对象
    ShopDao shopDao = new ShopDaoImpl();
    // 活动数据访问对象
    ActivityDao activityDao = new ActivityDaoImpl();
    // 优惠券数据访问对象
    CouponDao couponDao = new CouponDaoImpl();

    BuyerAddressDao buyerAddressDao = new BuyerAddressDaoImpl();


    private List<OrderCommodityLogic> orderCommodityLogics;

    private Activity activity;


    private String shopId;

    private String buyerId;

    private double totalMoney = 0.0;

    private double paidMoney = 0.0;

    private Coupon coupon;

    private BuyerAddress buyerAddress;

    private OrderPayment orderPayment;

    public PurchaseController() {
    }


    public String searchCommodity(String name) {

        Commodity commodity = CommodityFactory.getCommodity(name);

        return commodity.getCname();
    }

    @Override
    public Object[] commodityDetailDisplay(String name) {

        Commodity c = CommodityFactory.getCommodity(name);
        //此列表只有一个商品对象（因为每次只能看一个商品详情）
        List<Commodity> commodityDetailList = new ArrayList<>();
        commodityDetailList.add(c);

        return commodityDetailList.toArray();
    }

    public OrderLogic purchase(String name) {

        String activityId = "001", couponId = "002";
        String buyerId = "b001", buyerAddressId = "a001";
        //需要从登录控制器获取买家id，进而在地址表中获取买家收货地址id。
        //以上二者作为下面函数的参数传入

        //展示活动和优惠券
        displayActivities();
        displayShopCoupon();

        //挑选活动（参数待入）

        selectPromotions(activityId, couponId);

        //计算原始总价
        calTotalMoney();

        //计算惠后总价
        calPaidMoney();

        //买家收货地址选择（参数待入）
        displayBuyerAddress(buyerId);
        selectBuyerAddress(buyerAddressId);

        //展示购买方式
        displayPayMethod();

        //选择支付方式
        selectPayMethod("0");

        //支付
        payImmediately();

        //返回订单（参数待入）
        return displayOrderDetail(buyerId);
    }

    /**
     * 计算总价
     * @return totalMoney
     */
    public String calTotalMoney(){
        for (OrderCommodityLogic c : orderCommodityLogics) {
            totalMoney += Double.parseDouble(c.getPrice());
        }
        return totalMoney + "";
    }

    /**
     * 返回所有活动
     * @return list activities
     */
    public List<Activity> displayActivities(){
        return activityDao.getAll();
    }

    public List<Coupon> displayShopCoupon(){
        return couponDao.getAllByShopId(this.shopId);
    }

    public void selectPromotions(@Nullable String activityId, @Nullable String couponId){
        if(activityId != null){
            this.activity = activityDao.getById(activityId);
        }
        if(couponId != null){
            this.coupon = couponDao.getById(couponId);
        }
    }

    /**
     * 计算优惠后的价格：先满减，再打折
     * @return paidMoney
     */
    public String calPaidMoney(){
        paidMoney = totalMoney;
        if(coupon != null){
            double full = Double.parseDouble(coupon.getFull());
            if(full >= paidMoney){
                paidMoney -= Double.parseDouble(coupon.getMinus());
            }
        }
        if(activity != null){
            paidMoney *= Double.parseDouble(activity.getDiscount());
        }
        return  paidMoney + "";
    }

    /**
     * 展示买家所有收获地址
     * @param buyerId id
     * @return list buyerAddress
     */
    public List<BuyerAddress> displayBuyerAddress(String buyerId){
        this.buyerId = buyerId;
        return buyerAddressDao.getBuyerAddresses(buyerId);
    }

    /**
     * 选择买家收获地址
     * @param buyerAddressId id
     */
    public void selectBuyerAddress(String buyerAddressId){
        this.buyerAddress = buyerAddressDao.getById(buyerAddressId);
    }

    /**
     * 展示购买方式
     * @return method
     */
    public String displayPayMethod(){
        return Arrays.toString(OrderPaymentMethod.values());
    }

    /**
     * 选择支付方式
     * @param index 下标
     *              0 UnionPay
     *              1 WeChat
     *              2 AliPay
     */
    public void selectPayMethod(String index){
        String id = UUID.randomUUID().toString();
        orderPayment.setOrderPaymentId(id);

        String method = "";
        switch (index){
            case "0": method = OrderPaymentMethod.UnionPay.name(); break;
            case "1": method = OrderPaymentMethod.WeChat.name(); break;
            case "2": method = OrderPaymentMethod.AliPay.name(); break;
        }
        orderPayment.setPayMethod(method);
    }

    public void payImmediately(){
        orderPayment.setTotalMoney(totalMoney + "");
        orderPayment.setPayStatus(PayStatus.Paid.toString());
        orderPayment.setPaidMoney(paidMoney + "");
    }

    public OrderLogic displayOrderDetail(String buyerId){
        return OrderBuilder
                .getOrderBuilderInstance()
                .initOrder(this.buyerId)
                .setOrderCommodities(this.orderCommodityLogics)
                .setOrderPromotions(this.activity, this.coupon)
                .setOrderAddress(this.buyerAddress)
                .setOrderPayment(this.orderPayment)
                .build();
    }

}
