package tmall.model.entityDao.daoInterface;

import tmall.model.entity.Order;
import tmall.model.logicalEntity.OrderLogic;

import java.util.List;

/**
 * 订单
 */
public interface OrderDao {
    /**
     * 更改订单状态
     * @param orderId 订单Id
     * @param newStatus 最新状态
     */
    void updateOrderStatus(String orderId, String newStatus);

    /**
     * 获取买家所有订单
     * @param buyerId id
     * @return list buyer's orders
     */
    List<Order> getAllByBuyerId(String buyerId);

    /**
     * 获取订单实体信息
     * @param orderId id
     * @return order
     */
    Order getOrderConcise(String orderId);

    /**
     * 获取订单详情
     * @param orderId id
     * @return 订单详情
     */
    OrderLogic getOrderDetail(String orderId);
}
