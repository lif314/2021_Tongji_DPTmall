package tmall.controller.orderController;

import tmall.XMLRepository.ProxyXmlContext;
import tmall.XMLRepository.XMLContext;
import tmall.XMLRepository.util.Nullable;
import tmall.model.entity.*;
import tmall.model.logicalEntity.OrderCommodityLogic;
import tmall.model.logicalEntity.OrderLogic;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public class OrderBuilder {

    // 订单数据库上下文
    private final XMLContext<Order> orderXMLContext = new ProxyXmlContext<>(Order.class);

    // 商品订单联系集数据库上下文
    private final XMLContext<OrderCommodity> orderCommodityXMLContext = new ProxyXmlContext<>(OrderCommodity.class);

    // 商品数据库上下文
    private final XMLContext<Commodity> commodityXMLContext = new ProxyXmlContext<>(Commodity.class);

    // 店铺数据库上下文
    private final XMLContext<Shop> shopXMLContext = new ProxyXmlContext<>(Shop.class);

    // 订单优惠
    private final XMLContext<OrderPromotion> orderPromotionXMLContext = new ProxyXmlContext<>(OrderPromotion.class);

    private final XMLContext<OrderPayment> orderPaymentXMLContext = new ProxyXmlContext<>(OrderPayment.class);


    /**
     * 将需要构建的Order对象作为全局变量
     *
     * 一步一步构建完成之后返回该对象
     */
    private Order order;

    /**
     * 展示order详情
     */
    private OrderLogic orderLogic;

    /**
     * 订单商品联系集
     */
    private List<OrderCommodity> orderCommodityList;

    private List<OrderPromotion> orderPromotionList;

    private OrderPayment orderPayment;



    /**
     * 单例模式：
     * 不让使用者使用new创建构造器
     */
    private OrderBuilder(){
    }

    /**
     * 建造者模式的入口
     * @return orderBuilder, 提供链式调用
     */
    public static OrderBuilder getOrderBuilderInstance(){
        OrderBuilder orderBuilder = new OrderBuilder();
        orderBuilder.order = new Order();
        orderBuilder.orderLogic = new OrderLogic();
        return orderBuilder;
    }

    /**
     * 初始化订单
     * @param buyerId 订单所有者 ---- 买家id
     * @return orderBuilder 链式调用
     */
    public OrderBuilder initOrder(String buyerId){
        // 订单id
        String orderId = UUID.randomUUID().toString();
        // 订单创建时间
        String createTime = LocalDateTime.now().toString();
        // 订单初始状态：待支付
        String initStatus = OrderStatus.WAIT_DELIVER.toString();

        // 订单绑定买家
        this.order.setOrderId(orderId);
        this.order.setBuyerId(buyerId);
        this.order.setCreateTime(createTime);
        this.order.setStatus(initStatus);

        // 展示order详情初始化
        this.orderLogic.setOrderId(orderId);
        this.orderLogic.setBuyerId(buyerId);
        this.orderLogic.setCreateTime(createTime);
        this.orderLogic.setStatus(initStatus);

        return this;
    }

    /**
     * 初始化订单中包含的商品信息
     *
     * 一个订单中的商品应该只能来自一个店铺中
     * 同一商品可以有多件
     *
     * @param commodities 商品集：提供商品id和商品的数量
     * @return orderBuilder
     */
    public OrderBuilder setOrderCommodities(List<OrderCommodityLogic> commodities){

        // 获取shopId
        String shopId = commodityXMLContext.findById(commodities.get(0).getCommodityId()).getShopId();

        // 获取店铺店铺相关信息
        Shop shop = shopXMLContext.findById(shopId);
        this.orderLogic.setShopId(shopId);
        this.orderLogic.setShopName(shop.getShopName());
        this.orderLogic.setShopAddress(shop.getShopAddress());

        // 订单id
        String orderId = this.order.getOrderId();

        // 添加到逻辑实体中
        this.orderLogic.setCommodityList(commodities);

        // 存储到联系集中
        for (OrderCommodityLogic commodity : commodities) {
            // 创建订单商品联系集
            OrderCommodity orderCommodity = new OrderCommodity(orderId, commodity.getCommodityId(), commodity.getAmount());
            // 暂存
            orderCommodityList.add(orderCommodity);
        }

        return this;
    }

    /**
     * 设置订单促销信息
     * @return this
     */
    public OrderBuilder setOrderPromotions(@Nullable Activity activity,@Nullable Coupon coupon){

        if(activity != null){
            this.orderLogic.setActivityId(activity.getActivityId());
            OrderPromotion orderPromotion = new OrderPromotion(this.order.getOrderId(), activity.getActivityId());
            // 暂存
            orderPromotionList.add(orderPromotion);
        }

        if(coupon != null){
            this.orderLogic.setCouponId(coupon.getCouponId());
            OrderPromotion orderPromotion = new OrderPromotion(this.order.getOrderId(),coupon.getCouponId());
            // 暂存
            orderPromotionList.add(orderPromotion);
        }

        return this;
    }


    /**
     * 设置用户收获信息
     * @param buyerAddress 买家收获信息
     * @return orderBuilder 链式调用
     */
    public OrderBuilder setOrderAddress(BuyerAddress buyerAddress){
        // 订单
        this.order.setBuyerAddressId(buyerAddress.getBuyerAddressId());

        // logic order
        this.orderLogic.setBuyerAddressId(buyerAddress.getBuyerAddressId());
        this.orderLogic.setReceiveName(buyerAddress.getReceiveName());
        this.orderLogic.setReceivePhone(buyerAddress.getReceivePhone());
        this.orderLogic.setReceiveAddress(buyerAddress.getReceiveAddress());

        return this;
    }


    /**
     * 设置订单支付信息
     * @return orderBuilder 链式调用
     */
    public OrderBuilder setOrderPayment(OrderPayment orderPayment){

        this.orderPayment = orderPayment;

        this.order.setOrderPaymentId(orderPayment.getOrderPaymentId());

        this.orderLogic.setOrderPaymentId(orderPayment.getOrderPaymentId());
        this.orderLogic.setPayMethod(orderPayment.getPayMethod());
        this.orderLogic.setPayStatus(orderPayment.getPayStatus());
        this.orderLogic.setTotalMoney(orderPayment.getTotalMoney());
        this.orderLogic.setPaidMoney(orderPayment.getPaidMoney());
        this.orderLogic.setPaidTime(orderPayment.getPaidTime());

        double promotionMoney = Double.parseDouble(orderPayment.getTotalMoney()) - Double.parseDouble(orderPayment.getPaidMoney());

        this.orderLogic.setPromotionMoney(promotionMoney + "");

        return this;
    }


    /**
     * 返回最终构建完成的订单对象的详细信息
     * @return logic order
     */
    public OrderLogic build(){
        // 存储到数据库
        for (OrderCommodity orderCommodity : orderCommodityList) {
            orderCommodityXMLContext.add(orderCommodity);

        }

        for (OrderPromotion orderPromotion : orderPromotionList) {
            orderPromotionXMLContext.add(orderPromotion);
        }

        orderPaymentXMLContext.add(this.orderPayment);

        orderXMLContext.add(this.order);

        // 返回订单逻辑实体
        return this.orderLogic;
    }
}
