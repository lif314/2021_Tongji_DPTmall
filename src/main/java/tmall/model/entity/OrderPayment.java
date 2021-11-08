package tmall.model.entity;

/**
 * 订单支付信息
 */
public class OrderPayment {

    private String orderPaymentId;   // 支付Id

    public String payMethod;   // 支付方式

    public String payStatus;   // 支付状态

    public String totalMoney;  // 未优惠价格

    public String paidMoney; // 实际支付费用

    public String paidTime;   // 支付时间

    public OrderPayment() {
    }

    public OrderPayment(String orderPaymentId, String payMethod, String payStatus, String totalMoney, String paidMoney, String paidTime) {
        this.orderPaymentId = orderPaymentId;
        this.payMethod = payMethod;
        this.payStatus = payStatus;
        this.totalMoney = totalMoney;
        this.paidMoney = paidMoney;
        this.paidTime = paidTime;
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

    @Override
    public String toString() {
        return  String.format("|%-10s|%-5s|%-10s|%-10s|%-10s|%-40s|",
                payMethod,payStatus,totalMoney,paidMoney,paidTime,orderPaymentId);
//        return "OrderPayment{" +
//                "orderPaymentId='" + orderPaymentId + '\'' +
//                ", payMethod='" + payMethod + '\'' +
//                ", payStatus='" + payStatus + '\'' +
//                ", totalMoney='" + totalMoney + '\'' +
//                ", paidMoney='" + paidMoney + '\'' +
//                ", paidTime='" + paidTime + '\'' +
//                '}';
    }
}
