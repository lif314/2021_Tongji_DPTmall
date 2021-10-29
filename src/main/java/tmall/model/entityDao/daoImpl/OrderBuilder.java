package tmall.model.entityDao.daoImpl;

import tmall.XMLRepository.ProxyXmlContext;
import tmall.XMLRepository.XMLContext;
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

    // 买家数据库上下文
    private final XMLContext<Buyer> buyerXMLContext = new ProxyXmlContext<>(Buyer.class);

    // 店铺数据库上下文
    private final XMLContext<Shop> shopXMLContext = new ProxyXmlContext<>(Shop.class);

    // 活动数据库上下文
    private final XMLContext<Activity> activityXMLContext = new ProxyXmlContext<>(Activity.class);

    // 优惠券数据库上下文
    private final XMLContext<Coupon> couponXMLContext = new ProxyXmlContext<>(Coupon.class);

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
     * 店铺id
     */
    private String shopId;


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
    public static OrderBuilder newOrderBuilder(){
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
        String initStatus = OrderStatus.WAIT_PAYMENT.toString();
        // 绑定用户
        this.order.setBuyerId(buyerId);
        this.order.setOrderId(orderId);
        this.order.setCreateTime(createTime);
        this.order.setStatus(initStatus);

        // 展示order详情初始化
        this.orderLogic.setOrderId(orderId);
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

        // 创建时间
        String createTime = LocalDateTime.now().toString();
        // 订单id
        String orderId = this.order.getOrderId();
        // 商品初始状态
        String commodityStatus = OrderStatus.WAIT_PAYMENT.toString();

        this.orderLogic.setCommodityList(commodities);

        int amount = 0;
        for (OrderCommodityLogic commodity : commodities) {
            // 计算商品数量
            amount += Integer.parseInt(commodity.getAmount());
            // 创建订单商品联系集
            OrderCommodity orderCommodity = new OrderCommodity(orderId, commodity.getCommodityId(), createTime, commodity.getAmount());
            // 初始化联系集
//            this.orderCommodities.add(orderCommodity);
            // 添加到数据库中
            orderCommodityXMLContext.add(orderCommodity);
        }
        return this;
    }

    /**
     * 设置用户收获信息
     * @param receiveId 收获信息id
     * @return orderBuilder 链式调用
     */
    public OrderBuilder setOrderAddress(String receiveId){
        // 订单收获信息联系
//        this.order.setReceiveInfoId(receiveId);


        return this;
    }


    /**
     * 设置订单促销信息
     * @return this
     */
    public OrderBuilder setOrderPromotions(){
        return this;
    }

    /**
     * 设置订单支付信息
     * @return orderBuilder 链式调用
     */
    public OrderBuilder setOrderPayment(){
        return this;
    }


    /**
     * 返回最终构建完成的订单对象的详细信息
     * @return logic order
     */
    public OrderLogic build(){
        // 存到数据库中
        orderXMLContext.add(this.order);

        return null;
    }

}
