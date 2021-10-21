package tmall.model.entity;

/**
 * 收获信息
 */
public class ReceiveInfo {

    private String receiveInfoId;

    private String buyerId;

    public String receiverName;

    public String phone;

    public String address;

    public String status;

    public ReceiveInfo() {
    }

    public ReceiveInfo(String receiveInfoId, String buyerId, String receiverName, String phone, String address, String status) {
        this.receiveInfoId = receiveInfoId;
        this.buyerId = buyerId;
        this.receiverName = receiverName;
        this.phone = phone;
        this.address = address;
        this.status = status;
    }

    public String getReceiveInfoId() {
        return receiveInfoId;
    }

    public void setReceiveInfoId(String receiveInfoId) {
        this.receiveInfoId = receiveInfoId;
    }

    public String getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(String buyerId) {
        this.buyerId = buyerId;
    }

    public String getReceiverName() {
        return receiverName;
    }

    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "ReceiveInfo{" +
                "receiveInfoId='" + receiveInfoId + '\'' +
                ", buyerId='" + buyerId + '\'' +
                ", receiverName='" + receiverName + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
