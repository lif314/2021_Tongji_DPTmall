package tmall.controller.orderController;

import tmall.XMLRepository.util.Nullable;
import tmall.model.entity.*;
import tmall.model.entityDao.daoImpl.*;
import tmall.model.entityDao.daoInterface.*;
import tmall.model.logicalEntity.OrderCommodityLogic;
import tmall.model.logicalEntity.OrderLogic;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

/**
 * 购物中心：购物流程
 */
public class ShoppingCenter {

    /**
     * 购物流程
     *      [1] 挑选商品：可以从首页中挑选，也可以从购物车中挑选
     *      [2] 当用户挑选了某件商品，我们应该将其引到店铺中，即展示该店铺中的所有商品，让用户继续挑选
     *      [3] 选好商品后，用户可以选择店家优惠券
     *      [4] 选择买家收获信息
     *      [5] 选择支付信息
     *      [6] 查看订单详情
     */

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

    /**
     * 首页展示所有商品
     * @return list commodity
     */
    public List<Commodity> displayCommodities(){
        return commodityDao.getAll();
    }

    /**
     * 展示商品详情
     * @param commodityId id
     * @return commodity
     */
    public Commodity displayCommodityDetail(String commodityId){
        return commodityDao.getByCommodityId(commodityId);
    }

    /**
     * 根据商品详情，进入店铺中所有商品
     * @param commodityId id
     * @return shop commodities
     */
    public List<Commodity> displayShopCommodities(String commodityId){
        Commodity commodity = commodityDao.getByCommodityId(commodityId);
        this.shopId = commodity.getShopId();
        return commodityDao.getAllByShopId(commodity.getShopId());
    }

    /**
     * 选择商品，需多次调用
     * @param commodityId id
     * @param amount 数量
     */
    public void selectCommodity(String commodityId, String amount){
        Commodity commodity = commodityDao.getByCommodityId(commodityId);
        OrderCommodityLogic orderCommodityLogic = new OrderCommodityLogic(commodity.getCommodityId(), commodity.getCname(), commodity.getPrice(), amount);
        orderCommodityLogics.add(orderCommodityLogic);
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

    public void selectPromotions(@Nullable String activityId,@Nullable String couponId){
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