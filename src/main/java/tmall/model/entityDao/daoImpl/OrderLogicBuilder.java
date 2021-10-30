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

public class OrderLogicBuilder {

    // 订单数据库上下文
    private final XMLContext<Order> orderXMLContext = new ProxyXmlContext<>(Order.class);

    // 商品订单联系集数据库上下文
    private final XMLContext<OrderCommodity> orderCommodityXMLContext = new ProxyXmlContext<>(OrderCommodity.class);

    // 商品数据库上下文
    private final XMLContext<Commodity> commodityXMLContext = new ProxyXmlContext<>(Commodity.class);

    // 订单优惠
    private final XMLContext<OrderPromotion> orderPromotionXMLContext = new ProxyXmlContext<>(OrderPromotion.class);

    private final XMLContext<OrderPayment> orderPaymentXMLContext = new ProxyXmlContext<>(OrderPayment.class);

    private final XMLContext<BuyerAddress> buyerAddressXMLContext = new ProxyXmlContext<>(BuyerAddress.class);

    private final XMLContext<Activity> activityXMLContext = new ProxyXmlContext<>(Activity.class);

    private final XMLContext<Coupon> couponXMLContext = new ProxyXmlContext<>(Coupon.class);


    /**
     * 展示order详情
     */
    private OrderLogic orderLogic;

    private String orderId;

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
    private OrderLogicBuilder(){
    }

    /**
     * 建造者模式的入口
     * @return orderBuilder, 提供链式调用
     */
    public static OrderLogicBuilder getOrderBuilderInstance(){
        OrderLogicBuilder orderLogicBuilder = new OrderLogicBuilder();
        orderLogicBuilder.orderLogic = new OrderLogic();
        return orderLogicBuilder;
    }

    /**
     * 初始订单信息
     * @param orderId 订单id
     * @return this
     */
    public OrderLogicBuilder initOrderLogicBuilder(String orderId){
        this.orderId = orderId;
        Order order = orderXMLContext.findById(orderId);
        this.orderLogic.setOrderId(order.getOrderId());
        this.orderLogic.setBuyerId(order.getBuyerId());
        this.orderLogic.setOrderPaymentId(order.getOrderPaymentId());
        this.orderLogic.setBuyerAddressId(order.getBuyerAddressId());
        this.orderLogic.setCreateTime(order.getCreateTime());
        this.orderLogic.setStatus(order.getStatus());
        return this;
    }

    /**
     * 添加商品集
     * @return this
     */
    public OrderLogicBuilder setOrderCommodities(){

        List<OrderCommodity> init = orderCommodityXMLContext.init();
        List<OrderCommodityLogic> orderCommodityLogics = new ArrayList<>();
        for (OrderCommodity oc : init) {





            if(oc.getOrderId().equals(this.orderId)){
                Commodity c = commodityXMLContext.findById(oc.getCommodityId());
                OrderCommodityLogic orderCommodityLogic = new OrderCommodityLogic(oc.getCommodityId(),c.getCname(), c.getPrice(), oc.getAmount());
                orderCommodityLogics.add(orderCommodityLogic);
            }
        }
        this.orderLogic.setCommodityList(orderCommodityLogics);
        return this;
    }

    /**
     * 添加订单促销信息
     * @return this
     */
    public OrderLogicBuilder setOrderPromotions(){
        List<OrderPromotion> init = orderPromotionXMLContext.init();
        for (OrderPromotion promotion : init) {
            if(promotion.getOrderId().equals(this.orderId)){
                if(promotion.getType().equals("activity")){
                    this.orderLogic.setActivityId(promotion.getPromotionId());
                }
                if(promotion.getType().equals("coupon")){
                    this.orderLogic.setCouponId(promotion.getPromotionId());
                }
            }
        }
        return this;
    }


    /**
     * 添加收获信息
     * @return this
     */
    public OrderLogicBuilder setOrderAddress(){
        BuyerAddress buyerAddress = buyerAddressXMLContext.findById(this.orderLogic.getBuyerAddressId());
        this.orderLogic.setReceiveName(buyerAddress.getReceiveName());
        this.orderLogic.setReceivePhone(buyerAddress.getReceivePhone());
        this.orderLogic.setReceiveAddress(buyerAddress.getReceiveAddress());
        return this;
    }

    /**
     * 设置订单支付信息
     * @return orderLogicBuilder 链式调用
     */
    public OrderLogicBuilder setOrderPayment(){
        OrderPayment orderPayment = orderPaymentXMLContext.findById(this.orderLogic.getOrderPaymentId());

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
    public OrderLogic display(){
        // 返回订单逻辑实体
        return this.orderLogic;
    }
}
