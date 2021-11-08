package tmall.model.entity;

/**
 * 订单商品实体表
 *
 * 说明：通过该联系集可以实现一个订单多件商品
 */

public class OrderCommodity {

    private String orderId;

    private String commodityId;

    public String amount;   // 同一商品的数量

    public OrderCommodity() {
    }

    public OrderCommodity(String orderId, String commodityId, String amount) {
        this.orderId = orderId;
        this.commodityId = commodityId;
        this.amount = amount;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getCommodityId() {
        return commodityId;
    }

    public void setCommodityId(String commodityId) {
        this.commodityId = commodityId;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {

        return "OrderCommodity{" +
                "orderId='" + orderId + '\'' +
                ", commodityId='" + commodityId + '\'' +
                ", amount='" + amount + '\'' +
                '}';
    }
}
