package tmall.model.entity;

/**
 * 商品关注实体表
 */

public class FollowCommodity {

    private String buyerId;   // 买家Id

    private String commodityId;  // 商品Id

    public String followDate;    // 关注时间

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
        return  String.format("|%-10s|%-40s|%-40s|",
                followDate,buyerId,commodityId);
//        return "FollowCommodity{" +
//                "buyerId='" + buyerId + '\'' +
//                ", commodityId='" + commodityId + '\'' +
//                ", followDate='" + followDate + '\'' +
//                '}';
    }
}
