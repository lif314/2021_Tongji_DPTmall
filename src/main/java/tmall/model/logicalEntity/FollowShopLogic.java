package tmall.model.logicalEntity;

public class FollowShopLogic {

    private String shopId;  // 店铺Id

    public String shopName;     // 店铺名称

    public String creditScore;  // 店铺积分

    public String category;     // 店铺类别

    public String description;   // 店铺描述

    public String followDate;  // 关注时间

    public FollowShopLogic() {
    }

    public FollowShopLogic(String shopId, String shopName, String creditScore, String category, String description, String followDate) {
        this.shopId = shopId;
        this.shopName = shopName;
        this.creditScore = creditScore;
        this.category = category;
        this.description = description;
        this.followDate = followDate;
    }

    public String getShopId() {
        return shopId;
    }

    public void setShopId(String shopId) {
        this.shopId = shopId;
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

    public String getFollowDate() {
        return followDate;
    }

    public void setFollowDate(String followDate) {
        this.followDate = followDate;
    }

    @Override
    public String toString() {
        return "FollowShopLogic{" +
                "shopId='" + shopId + '\'' +
                ", shopName='" + shopName + '\'' +
                ", creditScore='" + creditScore + '\'' +
                ", category='" + category + '\'' +
                ", description='" + description + '\'' +
                ", followDate='" + followDate + '\'' +
                '}';
    }
}
