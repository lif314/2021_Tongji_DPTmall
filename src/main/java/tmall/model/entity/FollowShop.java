package tmall.model.entity;

public class FollowShop {

    private String shopId;

    private String buyerId;

    public String followDate;

    public FollowShop() {
    }

    public FollowShop(String shopId, String buyerId, String followDate) {
        this.shopId = shopId;
        this.buyerId = buyerId;
        this.followDate = followDate;
    }

    public String getShopId() {
        return shopId;
    }

    public void setShopId(String shopId) {
        this.shopId = shopId;
    }

    public String getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(String buyerId) {
        this.buyerId = buyerId;
    }

    public String getFollowDate() {
        return followDate;
    }

    public void setFollowDate(String followDate) {
        this.followDate = followDate;
    }

    @Override
    public String toString() {
        return "FollowShop{" +
                "shopId='" + shopId + '\'' +
                ", buyerId='" + buyerId + '\'' +
                ", followDate='" + followDate + '\'' +
                '}';
    }
}
