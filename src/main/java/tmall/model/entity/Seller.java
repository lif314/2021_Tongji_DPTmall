package tmall.model.entity;

/**
 * 卖家实体表
 */
public class Seller {

    private String sellerId;  // 卖家Id

    private String password;  // 密码

    private String name;      // 真实姓名

    private String idNumber;  // 身份证号

    public String nickname;   // 昵称

    public String phone;      // 电话号码

    public Seller() {
    }

    public Seller(String sellerId, String password, String name, String idNumber, String nickname, String phone) {
        this.sellerId = sellerId;
        this.password = password;
        this.name = name;
        this.idNumber = idNumber;
        this.nickname = nickname;
        this.phone = phone;
    }

    public String getSellerId() {
        return sellerId;
    }

    public void setSellerId(String sellerId) {
        this.sellerId = sellerId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Seller{" +
                "sellerId='" + sellerId + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", idNumber='" + idNumber + '\'' +
                ", nickname='" + nickname + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
