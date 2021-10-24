package tmall.model.entity;

public class Seller extends User{

    private String sellerId;

    public String sname;

    public String creditScore;

    public Seller() {
    }

    public Seller(String sellerId, String sname, String creditScore) {
        this.sellerId = sellerId;
        this.sname = sname;
        this.creditScore = creditScore;
    }

    public String getSellerId() {
        return sellerId;
    }

    public void setSellerId(String sellerId) {
        this.sellerId = sellerId;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getCreditScore() {
        return creditScore;
    }

    public void setCreditScore(String creditScore) {
        this.creditScore = creditScore;
    }

    @Override
    public String toString() {
        return "Seller{" +
                "sellerId='" + sellerId + '\'' +
                ", sname='" + sname + '\'' +
                ", creditScore='" + creditScore + '\'' +
                '}';
    }
}
