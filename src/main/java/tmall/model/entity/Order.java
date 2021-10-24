package tmall.model.entity;

/**
 * 订单实体表
 */

public class Order {

    private String orderId;  // 订单Id

    private String buyerId;  // 买家Id

    private String receiveInfoId; // 收获信息Id

    private String shopId;    // 店铺Id

    public String createDate;  // 创建时间

    public String status;     // 订单状态

    public String orderAmount; // 含有商品数量

    public Order() {
    }

    public Order(String orderId, String buyerId, String receiveInfoId, String shopId, String createDate, String status, String orderAmount) {
        this.orderId = orderId;
        this.buyerId = buyerId;
        this.receiveInfoId = receiveInfoId;
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

    public String getReceiveInfoId() {
        return receiveInfoId;
    }

    public void setReceiveInfoId(String receiveInfoId) {
        this.receiveInfoId = receiveInfoId;
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
}

