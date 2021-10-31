package tmall.model.entityDao.daoImpl;

import tmall.XMLRepository.ProxyXmlContext;
import tmall.XMLRepository.XMLContext;
import tmall.XMLRepository.util.Nullable;
import tmall.model.entity.*;
import tmall.model.logicalEntity.OrderCommodityLogic;
import tmall.model.logicalEntity.OrderLogic;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class OrderBuilder {

    /**
     * 将需要构建的Order对象作为全局变量
     *
     * 一步一步构建完成之后返回该对象
     */
    private static Order order;

    /**
     * 展示order详情
     */
    private static OrderLogic orderLogic;

    private static OrderPayment orderPayment;

    /**
     * 订单商品联系集
     */
    private static final List<OrderCommodity> orderCommodityList = new ArrayList<>();

    private static final List<OrderPromotion> orderPromotionList = new ArrayList<>();





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
        //        order = new Order();
//        orderLogic = new OrderLogic();
        return new OrderBuilder();
    }

//    public OrderBuilder initOrderLogic(Order order){
//        orderLogic =  new OrderLogic();
//        orderLogic.setOrderId(order.getOrderId());
//        orderLogic.setBuyerId(order.getBuyerId());
//        orderLogic.setCreateTime(order.getCreateTime());
//        orderLogic.setStatus(order.getStatus());
//        return this;
//    }

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

        order = new Order("1", "2", "1", "1", "2", "1", "1");
        // 订单绑定买家
        order.setOrderId(orderId);
        order.setBuyerId(buyerId);
        order.setCreateTime(createTime);
        order.setStatus(initStatus);

        orderLogic = new OrderLogic("1");
        // 展示order详情初始化
        orderLogic.setOrderId(orderId);
        orderLogic.setBuyerId(buyerId);
        orderLogic.setCreateTime(createTime);
        orderLogic.setStatus(initStatus);

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
        XMLContext<Commodity> commodityXMLContext = new ProxyXmlContext<>(Commodity.class);
        String commodityId = commodities.get(0).getCommodityId();
        Commodity c = commodityXMLContext.findById(commodityId);
        String shopId = c.getShopId();

        XMLContext<Shop> shopXMLContext = new ProxyXmlContext<>(Shop.class);
        // 获取店铺店铺相关信息
        Shop shop = shopXMLContext.findById(shopId);
        orderLogic.setShopId(shopId);
        orderLogic.setShopName(shop.getShopName());
        orderLogic.setShopAddress(shop.getShopAddress());

        // 订单id
        String orderId = order.getOrderId();

        // 添加到逻辑实体中
        orderLogic.setCommodityList(commodities);

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
            orderLogic.setActivityId(activity.getActivityId());
            OrderPromotion orderPromotion = new OrderPromotion(order.getOrderId(), activity.getActivityId(), "activity");
            // 暂存
            orderPromotionList.add(orderPromotion);
        }

        if(coupon != null){
            orderLogic.setCouponId(coupon.getCouponId());
            OrderPromotion orderPromotion = new OrderPromotion(order.getOrderId(),coupon.getCouponId(), "coupon");
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
        order.setBuyerAddressId(buyerAddress.getBuyerAddressId());

        // logic order
        orderLogic.setBuyerAddressId(buyerAddress.getBuyerAddressId());
        orderLogic.setReceiveName(buyerAddress.getReceiveName());
        orderLogic.setReceivePhone(buyerAddress.getReceivePhone());
        orderLogic.setReceiveAddress(buyerAddress.getReceiveAddress());

        return this;
    }


    /**
     * 设置订单支付信息
     * @return orderBuilder 链式调用
     */
    public OrderBuilder setOrderPayment(OrderPayment op){

        orderPayment = op;

        String id = orderPayment.getOrderPaymentId();
        order.setOrderPaymentId(orderPayment.getOrderPaymentId());

        orderLogic.setOrderPaymentId(orderPayment.getOrderPaymentId());
        orderLogic.setPayMethod(orderPayment.getPayMethod());
        orderLogic.setPayStatus(orderPayment.getPayStatus());
        orderLogic.setTotalMoney(orderPayment.getTotalMoney());
        orderLogic.setPaidMoney(orderPayment.getPaidMoney());
        orderLogic.setPaidTime(orderPayment.getPaidTime());

        double promotionMoney = Double.parseDouble(orderPayment.getTotalMoney()) - Double.parseDouble(orderPayment.getPaidMoney());

        orderLogic.setPromotionMoney(promotionMoney + "");

        return this;
    }


    /**
     * 返回最终构建完成的订单对象的详细信息
     * @return logic order
     */
    public OrderLogic build(){

        XMLContext<Order> orderXMLContext = new ProxyXmlContext<>(Order.class);
        XMLContext<OrderCommodity> orderCommodityXMLContext = new ProxyXmlContext<>(OrderCommodity.class);
        XMLContext<OrderPromotion> orderPromotionXMLContext = new ProxyXmlContext<>(OrderPromotion.class);
        XMLContext<OrderPayment> orderPaymentXMLContext = new ProxyXmlContext<>(OrderPayment.class);

        // 存储到数据库
        for (OrderCommodity orderCommodity : orderCommodityList) {
            orderCommodityXMLContext.add(orderCommodity);
        }

        System.out.println(orderPromotionList);
        for (OrderPromotion orderPromotion : orderPromotionList) {
            orderPromotionXMLContext.add(orderPromotion);
        }

        System.out.println(orderPayment);
        orderPaymentXMLContext.add(orderPayment);

        System.out.println(order);
        orderXMLContext.add(order);

        // 返回订单逻辑实体
        return orderLogic;
    }
}
