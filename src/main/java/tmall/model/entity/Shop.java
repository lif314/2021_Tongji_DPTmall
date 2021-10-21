package tmall.model.entity;

public class Shop {

    private String shopId;

    private String sellerId;

    public String sname;

    public String creditScore;

    public String category;

    public String description;

    public Shop() {
    }

    public Shop(String shopId, String sellerId, String sname, String creditScore, String category, String description) {
        this.shopId = shopId;
        this.sellerId = sellerId;
        this.sname = sname;
        this.creditScore = creditScore;
        this.category = category;
        this.description = description;
    }

    public String getShopId() {
        return shopId;
    }

    public void setShopId(String shopId) {
        this.shopId = shopId;
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
        return "Shop{" +
                "shopId='" + shopId + '\'' +
                ", sellerId='" + sellerId + '\'' +
                ", sname='" + sname + '\'' +
                ", creditScore='" + creditScore + '\'' +
                ", category='" + category + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
