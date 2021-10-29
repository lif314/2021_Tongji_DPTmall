package tmall.model.entityDao.daoInterface;

import tmall.model.entity.Order;
import tmall.model.entity.OrderStatus;
import tmall.model.logicalEntity.OrderLogic;

import java.util.List;

/**
 * 订单
 */
public interface OrderDao {

    // 增删改查

    /**
     * 根据order id删除订单
     * @param orderId id
     */
    void deleteByOrderId(String orderId);

    /**
     * 删除买家所有订单
     * @param buyerId id
     */
    void deleteAllByBuyerId(String buyerId);

    /**
     * 删除卖家所有订单
     * @param sellerId id
     */
    void deleteAllBySellerId(String sellerId);

    /**
     * 删除买家已完成的订单
     * @param buyerId id
     */
    void deleteFinishOrder(String buyerId);

    /**
     * 更改订单状体
     * @param orderId 订单Id
     * @param newStatus 最新状态
     */
    void updateOrderStatus(String orderId, OrderStatus newStatus);

    /**
     * 更新点订单中商品的状态
     * @param orderId 订单id
     * @param commodityId 商品id
     * @param newStatus 最新状态
     */
    void updateOrderCommodityStatus(String orderId, String commodityId, OrderStatus newStatus);

    /**
     * 更新订单物流状态
     * @param orderId 订单id
     * @param newStatus 物流最新状态
     */
    void updateOrderDeliveryStatus(String orderId, OrderStatus newStatus);


    /**
     * 获取买家所有订单
     * @param buyerId id
     * @return list buyer's orders
     */
    List<Order> getAllByBuyerId(String buyerId);

    /**
     * 获取店铺所有订单
     * @param shopId id
     * @return shop's orders
     */
    List<Order> getAllByShopId(String shopId);

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
