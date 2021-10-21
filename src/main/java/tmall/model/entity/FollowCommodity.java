package tmall.model.entity;

public class FollowCommodity {

    private String buyerId;

    private String commodityId;

    public String followDate;

    public FollowCommodity() {
    }

    public FollowCommodity(String buyerId, String commodityId, String followDate) {
        this.buyerId = buyerId;
        this.commodityId = commodityId;
        this.followDate = followDate;
    }


    public String getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(String buyerId) {
        this.buyerId = buyerId;
    }

    public String getCommodityId() {
        return commodityId;
    }

    public void setCommodityId(String commodityId) {
        this.commodityId = commodityId;
    }

    public String getFollowDate() {
        return followDate;
    }

    public void setFollowDate(String followDate) {
        this.followDate = followDate;
    }

    @Override
    public String toString() {
        return "FollowCommodity{" +
                "buyerId='" + buyerId + '\'' +
                ", commodityId='" + commodityId + '\'' +
                ", followDate='" + followDate + '\'' +
                '}';
    }
}
