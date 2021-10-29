package tmall.model.logicalEntity;

import java.util.List;

public class OrderLogic {

    /**
     * 订单自身性质
     */
    private String orderId;     // 订单Id

    public String createTime;   // 下单时间

    public String status;       // 订单状态


    /**
     * 店铺提供信息
     */
    private String shopId;    // 店铺Id

    public String shopName;   // 店铺名称

    public String shopAddress; // 发货地址

    /**
     * 买家提供信息
     */
    private String buyerId;  // 买家id

    /**
     * 买家收获信息
     */
    public String buyerAddressId;

    public String receiveName;  // 收获人姓名

    public String receivePhone; // 收货人联系方式

    public String receiveAddress; // 收获地址

    /**
     * 优惠信息
     */
    public String activityId;   // 活动券id

    public String couponId;     // 优惠券id

    public String promotionMoney; // 优惠金额

    /**
     * 支付信息
     */
    private String orderPaymentId;   // 支付信息id

    public String payMethod;   // 支付方式

    public String payStatus;   // 支付状态

    public String totalMoney;   // 不使用优惠券后应支付费用

    public String paidMoney;    // 买家实际支付费用

    public String paidTime;     // 支付时间

    /**
     * 订单商品集
     */
    public List<OrderCommodityLogic> commodityList; // 订单商品集


    public OrderLogic() {
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
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

    public String getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(String buyerId) {
        this.buyerId = buyerId;
    }

    public String getBuyerAddressId() {
        return buyerAddressId;
    }

    public void setBuyerAddressId(String buyerAddressId) {
        this.buyerAddressId = buyerAddressId;
    }

    public String getReceiveName() {
        return receiveName;
    }

    public void setReceiveName(String receiveName) {
        this.receiveName = receiveName;
    }

    public String getReceivePhone() {
        return receivePhone;
    }

    public void setReceivePhone(String receivePhone) {
        this.receivePhone = receivePhone;
    }

    public String getReceiveAddress() {
        return receiveAddress;
    }

    public void setReceiveAddress(String receiveAddress) {
        this.receiveAddress = receiveAddress;
    }

    public String getActivityId() {
        return activityId;
    }

    public void setActivityId(String activityId) {
        this.activityId = activityId;
    }

    public String getCouponId() {
        return couponId;
    }

    public void setCouponId(String couponId) {
        this.couponId = couponId;
    }

    public String getPromotionMoney() {
        return promotionMoney;
    }

    public void setPromotionMoney(String promotionMoney) {
        this.promotionMoney = promotionMoney;
    }

    public String getOrderPaymentId() {
        return orderPaymentId;
    }

    public void setOrderPaymentId(String orderPaymentId) {
        this.orderPaymentId = orderPaymentId;
    }

    public String getPayMethod() {
        return payMethod;
    }

    public void setPayMethod(String payMethod) {
        this.payMethod = payMethod;
    }

    public String getPayStatus() {
        return payStatus;
    }

    public void setPayStatus(String payStatus) {
        this.payStatus = payStatus;
    }

    public String getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(String totalMoney) {
        this.totalMoney = totalMoney;
    }

    public String getPaidMoney() {
        return paidMoney;
    }

    public void setPaidMoney(String paidMoney) {
        this.paidMoney = paidMoney;
    }

    public String getPaidTime() {
        return paidTime;
    }

    public void setPaidTime(String paidTime) {
        this.paidTime = paidTime;
    }

    public List<OrderCommodityLogic> getCommodityList() {
        return commodityList;
    }

    public void setCommodityList(List<OrderCommodityLogic> commodityList) {
        this.commodityList = commodityList;
    }

    @Override
    public String toString() {
        return "OrderLogic{" +
                "orderId='" + orderId + '\'' +
                ", createTime='" + createTime + '\'' +
                ", status='" + status + '\'' +
                ", shopId='" + shopId + '\'' +
                ", shopName='" + shopName + '\'' +
                ", shopAddress='" + shopAddress + '\'' +
                ", buyerId='" + buyerId + '\'' +
                ", buyerAddressId='" + buyerAddressId + '\'' +
                ", receiveName='" + receiveName + '\'' +
                ", receivePhone='" + receivePhone + '\'' +
                ", receiveAddress='" + receiveAddress + '\'' +
                ", activityId='" + activityId + '\'' +
                ", couponId='" + couponId + '\'' +
                ", promotionMoney='" + promotionMoney + '\'' +
                ", orderPaymentId='" + orderPaymentId + '\'' +
                ", payMethod='" + payMethod + '\'' +
                ", payStatus='" + payStatus + '\'' +
                ", totalMoney='" + totalMoney + '\'' +
                ", paidMoney='" + paidMoney + '\'' +
                ", paidTime='" + paidTime + '\'' +
                ", commodityList=" + commodityList +
                '}';
    }
}
