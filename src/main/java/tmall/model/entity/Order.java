package tmall.model.entity;

public class Order {

    private String orderId;

    private String buyerId;

    private String addressId;

    private String shopId;

    public String createDate;

    public String status;

    public String orderAmount;

    public Order() {
    }

    public Order(String orderId, String buyerId, String addressId, String shopId, String createDate, String status, String orderAmount) {
        this.orderId = orderId;
        this.buyerId = buyerId;
        this.addressId = addressId;
        this.shopId = shopId;
        this.createDate = createDate;
        this.status = status;
        this.orderAmount = orderAmount;
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

    public String getAddressId() {
        return addressId;
    }

    public void setAddressId(String addressId) {
        this.addressId = addressId;
    }

    public String getShopId() {
        return shopId;
    }

    public void setShopId(String shopId) {
        this.shopId = shopId;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getOrderAmount() {
        return orderAmount;
    }

    public void setOrderAmount(String orderAmount) {
        this.orderAmount = orderAmount;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId='" + orderId + '\'' +
                ", buyerId='" + buyerId + '\'' +
                ", addressId='" + addressId + '\'' +
                ", shopId='" + shopId + '\'' +
                ", createDate='" + createDate + '\'' +
                ", status='" + status + '\'' +
                ", orderAmount='" + orderAmount + '\'' +
                '}';
    }
}
