package tmall.model.entity;

public class Buyer extends User{

    private String buyerId;

    private String passwd;

    private String idNumber;

    public String phone;

    public String nickname;

    public String gender;

    public String birthday;

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
        return "Buyer{" +
                "buyerId='" + buyerId + '\'' +
                ", passwd='" + passwd + '\'' +
                ", idNumber='" + idNumber + '\'' +
                ", phone='" + phone + '\'' +
                ", nickname='" + nickname + '\'' +
                ", gender='" + gender + '\'' +
                ", birthday='" + birthday + '\'' +
                '}';
    }
}
