package tmall.model.entityDao.daoImpl;

import tmall.XMLRepository.ProxyXmlContext;
import tmall.XMLRepository.XMLContext;
import tmall.model.entity.*;
import tmall.model.entityDao.daoInterface.OrderDao;
import tmall.model.logicalEntity.OrderLogic;

import java.util.ArrayList;
import java.util.List;

public class OrderDaoImpl implements OrderDao {
    
    // 订单上下文
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
     * 更改订单状态
     *
     * @param orderId   订单Id
     * @param newStatus 最新状态
     */
    @Override
    public void updateOrderStatus(String orderId, String newStatus) {
        List<Order> init = orderXMLContext.init();
        orderXMLContext.deleteAll();
        for (Order order : init) {
            if(order.getOrderId().equals(orderId)){
                order.setStatus(newStatus);
                orderXMLContext.add(order);
            }
            orderXMLContext.add(order);
        }
    }

    /**
     * 获取买家所有订单
     *
     * @param buyerId id
     * @return list buyer's orders
     */
    @Override
    public List<Order> getAllByBuyerId(String buyerId) {
        List<Order> orderList = new ArrayList<>();
        List<Order> init = orderXMLContext.init();
        for (Order order : init) {
            if(order.getBuyerId().equals(buyerId))
                orderList.add(order);
        }
        return orderList;
    }

    /**
     * 获取订单实体信息
     *
     * @param orderId id
     * @return order
     */
    @Override
    public Order getOrderConcise(String orderId) {
        return orderXMLContext.findById(orderId);
    }

    /**
     * 获取订单详情
     *
     * @param orderId id
     * @return 订单详情
     */
    @Override
    public OrderLogic getOrderDetail(String orderId) {
        // 返回对象
        OrderLogic orderLogic = new OrderLogic();
        // 订单对象
        Order order = orderXMLContext.findById(orderId);


        return orderLogic;
    }
}
