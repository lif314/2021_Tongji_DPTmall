package tmall.model.entity;

public class OrderCommodity {

    private String orderId;

    private String commodityId;

    public String status;

    public String amount;

    public OrderCommodity() {
    }

    public OrderCommodity(String orderId, String commodityId, String status, String amount) {
        this.orderId = orderId;
        this.commodityId = commodityId;
        this.status = status;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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
                ", status='" + status + '\'' +
                ", amount='" + amount + '\'' +
                '}';
    }
}
