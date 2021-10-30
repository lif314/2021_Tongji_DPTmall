package tmall.model.entity;

public class BuyerAddress {

    private String buyerAddressId;  // 地址id

    private String buyerId;  // 用户id

    public String receiveName; // 收货人姓名

    public String receivePhone; // 收货人联系方式

    public String receiveAddress; // 收货人地址

    public BuyerAddress() {
    }

    public BuyerAddress(String buyerAddressId, String buyerId, String receiveName, String receivePhone, String receiveAddress) {
        this.buyerAddressId = buyerAddressId;
        this.buyerId = buyerId;
        this.receiveName = receiveName;
        this.receivePhone = receivePhone;
        this.receiveAddress = receiveAddress;
    }

    public String getBuyerAddressId() {
        return buyerAddressId;
    }

    public void setBuyerAddressId(String buyerAddressId) {
        this.buyerAddressId = buyerAddressId;
    }

    public String getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(String buyerId) {
        this.buyerId = buyerId;
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

    @Override
    public String toString() {
        return "BuyerAddress{" +
                "buyerAddressId='" + buyerAddressId + '\'' +
                ", buyerId='" + buyerId + '\'' +
                ", receiveName='" + receiveName + '\'' +
                ", receivePhone='" + receivePhone + '\'' +
                ", receiveAddress='" + receiveAddress + '\'' +
                '}';
    }
}