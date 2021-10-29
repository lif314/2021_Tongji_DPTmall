package tmall.model.entityDao.daoImpl;

import tmall.model.entity.Order;
import tmall.model.entity.OrderStatus;
import tmall.model.entityDao.daoInterface.OrderDao;
import tmall.model.logicalEntity.OrderLogic;

import java.util.List;

public class OrderDaoImpl implements OrderDao {
    /**
     * 根据order id删除订单
     *
     * @param orderId id
     */
    @Override
    public void deleteByOrderId(String orderId) {

    }

    /**
     * 删除买家所有订单
     *
     * @param buyerId id
     */
    @Override
    public void deleteAllByBuyerId(String buyerId) {

    }

    /**
     * 删除卖家所有订单
     *
     * @param sellerId id
     */
    @Override
    public void deleteAllBySellerId(String sellerId) {

    }

    /**
     * 删除买家已完成的订单
     *
     * @param buyerId id
     */
    @Override
    public void deleteFinishOrder(String buyerId) {

    }

    /**
     * 更改订单状体
     *
     * @param orderId   订单Id
     * @param newStatus 最新状态
     */
    @Override
    public void updateOrderStatus(String orderId, OrderStatus newStatus) {

    }

    /**
     * 更新点订单中商品的状态
     *
     * @param orderId     订单id
     * @param commodityId 商品id
     * @param newStatus   最新状态
     */
    @Override
    public void updateOrderCommodityStatus(String orderId, String commodityId, OrderStatus newStatus) {

    }

    /**
     * 更新订单物流状态
     *
     * @param orderId   订单id
     * @param newStatus 物流最新状态
     */
    @Override
    public void updateOrderDeliveryStatus(String orderId, OrderStatus newStatus) {

    }

    /**
     * 获取买家所有订单
     *
     * @param buyerId id
     * @return list buyer's orders
     */
    @Override
    public List<Order> getAllByBuyerId(String buyerId) {
        return null;
    }

    /**
     * 获取店铺所有订单
     *
     * @param shopId id
     * @return shop's orders
     */
    @Override
    public List<Order> getAllByShopId(String shopId) {
        return null;
    }

    /**
     * 获取订单实体信息
     *
     * @param orderId id
     * @return order
     */
    @Override
    public Order getOrderConcise(String orderId) {
        return null;
    }

    /**
     * 获取订单详情
     *
     * @param orderId id
     * @return 订单详情
     */
    @Override
    public OrderLogic getOrderDetail(String orderId) {
        return null;
    }
}
