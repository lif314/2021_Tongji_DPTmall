package tmall.XMLRepository.test;

/**
 * 订单简化：每个订单内只能包含不同数量的同一个商品，不能包含不同商品
 *
 * 为了在订单构建中使用建造者模式，可以为订单设置多个商品ID，比如默认一个订单内最多只能有三件不同商品，
 * 此时也就需要为每种商品添加数量属性
 */

public class OrderTest {

    private String orderId;

    private String buyerId;

    private String addressId;

    private String shopId;

    public String createDate;

    public String status;

    public String orderAmount;

    public OrderTest() {
    }

    public OrderTest(String orderId, String buyerId, String addressId, String shopId, String createDate, String status, String orderAmount) {
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
        return "XMLContextTest{" +
                "OrdersId='" + orderId + '\'' +
                ", BuyerId='" + buyerId + '\'' +
                ", ReceivedId='" + addressId + '\'' +
                ", ShopId='" + shopId + '\'' +
                ", OrderDate='" + createDate + '\'' +
                ", Status='" + status + '\'' +
                ", OrderAmount='" + orderAmount + '\'' +
                '}';
    }
}
