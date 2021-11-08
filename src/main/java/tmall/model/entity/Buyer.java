package tmall.model.entity;

/**
 * 买家实体表
 */
public class Buyer implements User{

    private String buyerId;  // 买家Id

    private String passwd;   // 密码

    private String idNumber;  // 身份证号

    public String phone;      // 电话号码

    public String nickname;   // 昵称

    public String gender;     // 性别

    public String birthday;   // 生日

    public Buyer() {
    }

    public Buyer(String buyerId, String passwd, String idNumber, String phone, String nickname, String gender, String birthday) {
        this.buyerId = buyerId;
        this.passwd = passwd;
        this.idNumber = idNumber;
        this.phone = phone;
        this.nickname = nickname;
        this.gender = gender;
        this.birthday = birthday;
    }

    public String getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(String buyerId) {
        this.buyerId = buyerId;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return  String.format("|%-10s|%-10s|%-15s|%-20s|%-11s|%-10s|%-40s|",
                nickname,gender,passwd,idNumber,phone,birthday,buyerId);
//        return "Buyer{" +
//                "buyerId='" + buyerId + '\'' +
//                ", passwd='" + passwd + '\'' +
//                ", idNumber='" + idNumber + '\'' +
//                ", phone='" + phone + '\'' +
//                ", nickname='" + nickname + '\'' +
//                ", gender='" + gender + '\'' +
//                ", birthday='" + birthday + '\'' +
//                '}';
    }

    @Override
    public boolean isNull() {
        return false;
    }
}
