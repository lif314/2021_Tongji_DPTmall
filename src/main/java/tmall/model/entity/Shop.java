package tmall.model.entity;

/**
 * 店铺实体表
 */
public class Shop {

    private String shopId;   // 店铺Id

    private String sellerId; // 卖家Id

    public String shopName;     // 店铺名称

    public String creditScore;  // 店铺积分

    public String category;     // 店铺类别

    public String description;   // 店铺描述

    public Shop() {
    }

    public Shop(String shopId, String sellerId, String shopName, String creditScore, String category, String description) {
        this.shopId = shopId;
        this.sellerId = sellerId;
        this.shopName = shopName;
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

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
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
                ", shopName='" + shopName + '\'' +
                ", creditScore='" + creditScore + '\'' +
                ", category='" + category + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
