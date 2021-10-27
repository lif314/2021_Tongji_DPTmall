package tmall.model.logicalEntity;

import tmall.model.entity.Commodity;

import java.util.List;

public class OrderLogic {

    private String orderId;  // 订单Id

    private String shopId;    // 店铺Id

    public String shopName;   // 店铺名称

    public String shopAddress; // 店铺发货地址

    public String buyerName; // 收获人姓名

    public String buyerPhone; // 收货人联系方式

    public String receiveAddress; // 收获地址

    public String createTime;   // 下单时间

    public String sendTime;      // 发货时间

    public String receivedTim;   // 收获时间

    public List<OrderCommodityLogic> commodityList; // 订单商品集

    public String status;     // 订单状态

    public String orderAmount; // 含有商品总数量

    public OrderLogic() {
    }

    public OrderLogic(String orderId, String shopId, String shopName, String shopAddress, String buyerName, String buyerPhone, String receiveAddress, String createTime, String sendTime, String receivedTim, List<OrderCommodityLogic> commodityList, String status, String orderAmount) {
        this.orderId = orderId;
        this.shopId = shopId;
        this.shopName = shopName;
        this.shopAddress = shopAddress;
        this.buyerName = buyerName;
        this.buyerPhone = buyerPhone;
        this.receiveAddress = receiveAddress;
        this.createTime = createTime;
        this.sendTime = sendTime;
        this.receivedTim = receivedTim;
        this.commodityList = commodityList;
        this.status = status;
        this.orderAmount = orderAmount;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getShopId() {
        return shopId;
    }

    public void setShopId(String shopId) {
        this.shopId = shopId;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getShopAddress() {
        return shopAddress;
    }

    public void setShopAddress(String shopAddress) {
        this.shopAddress = shopAddress;
    }

    public String getBuyerName() {
        return buyerName;
    }

    public void setBuyerName(String buyerName) {
        this.buyerName = buyerName;
    }

    public String getBuyerPhone() {
        return buyerPhone;
    }

    public void setBuyerPhone(String buyerPhone) {
        this.buyerPhone = buyerPhone;
    }

    public String getReceiveAddress() {
        return receiveAddress;
    }

    public void setReceiveAddress(String receiveAddress) {
        this.receiveAddress = receiveAddress;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getSendTime() {
        return sendTime;
    }

    public void setSendTime(String sendTime) {
        this.sendTime = sendTime;
    }

    public String getReceivedTim() {
        return receivedTim;
    }

    public void setReceivedTim(String receivedTim) {
        this.receivedTim = receivedTim;
    }

    public List<OrderCommodityLogic> getCommodityList() {
        return commodityList;
    }

    public void setCommodityList(List<OrderCommodityLogic> commodityList) {
        this.commodityList = commodityList;
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
        return "OrderLogic{" +
                "orderId='" + orderId + '\'' +
                ", shopId='" + shopId + '\'' +
                ", shopName='" + shopName + '\'' +
                ", shopAddress='" + shopAddress + '\'' +
                ", buyerName='" + buyerName + '\'' +
                ", buyerPhone='" + buyerPhone + '\'' +
                ", receiveAddress='" + receiveAddress + '\'' +
                ", createTime='" + createTime + '\'' +
                ", sendTime='" + sendTime + '\'' +
                ", receivedTim='" + receivedTim + '\'' +
                ", commodityList=" + commodityList +
                ", status='" + status + '\'' +
                ", orderAmount='" + orderAmount + '\'' +
                '}';
    }
}
