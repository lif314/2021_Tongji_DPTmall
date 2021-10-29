package tmall.model.entity;

/**
 * 订单实体表
 */

public class Order {

    private String orderId;          // 订单Id

    private String buyerId;          // 买家Id --- 订单用户信息

    private String orderPaymentId;     // 订单支付信息

    private String buyerAddressId;     // 订单收获信息

    public String createTime;          // 创建时间

    public String status;              // 订单状态

    public Order() {
    }

    public Order(String orderId, String buyerId, String orderDeliveryId, String orderPaymentId, String buyerAddressId, String createDate, String status) {
        this.orderId = orderId;
        this.buyerId = buyerId;
        this.orderPaymentId = orderPaymentId;
        this.buyerAddressId = buyerAddressId;
        this.createTime = createDate;
        this.status = status;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(String buyerId) {
        this.buyerId = buyerId;
    }

    public String getOrderPaymentId() {
        return orderPaymentId;
    }

    public void setOrderPaymentId(String orderPaymentId) {
        this.orderPaymentId = orderPaymentId;
    }

    public String getBuyerAddressId() {
        return buyerAddressId;
    }

    public void setBuyerAddressId(String buyerAddressId) {
        this.buyerAddressId = buyerAddressId;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

