package tmall.model.entity;

public class Seller {

    private String sellerId;

    private String shopId;

    public String sname;

    public String creditScore;

    public String category;

    public String description;

    public Seller() {
    }

    public Seller(String sellerId, String shopId, String sname, String creditScore, String category, String description) {
        this.sellerId = sellerId;
        this.shopId = shopId;
        this.sname = sname;
        this.creditScore = creditScore;
        this.category = category;
        this.description = description;
    }

    public String getSellerId() {
        return sellerId;
    }

    public void setSellerId(String sellerId) {
        this.sellerId = sellerId;
    }

    public String getShopId() {
        return shopId;
    }

    public void setShopId(String shopId) {
        this.shopId = shopId;
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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Seller{" +
                "sellerId='" + sellerId + '\'' +
                ", shopId='" + shopId + '\'' +
                ", sname='" + sname + '\'' +
                ", creditScore='" + creditScore + '\'' +
                ", category='" + category + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
