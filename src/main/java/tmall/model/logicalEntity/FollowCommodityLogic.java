package tmall.model.logicalEntity;

/**
 * 收藏夹详情
 */

public class FollowCommodityLogic {

    private String commodityId;  // 商品Id

    public String cname;        // 商品名称

    public String price;        // 价格

    public String category;     // 类别

    public String description;   // 商品描述

    public String followDate;    // 关注时间

    public FollowCommodityLogic() {
    }

    public FollowCommodityLogic(String commodityId, String cname, String price, String category, String description, String followDate) {
        this.commodityId = commodityId;
        this.cname = cname;
        this.price = price;
        this.category = category;
        this.description = description;
        this.followDate = followDate;
    }

    public String getCommodityId() {
        return commodityId;
    }

    public void setCommodityId(String commodityId) {
        this.commodityId = commodityId;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
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
        return "FollowCommodityLogic{" +
                "commodityId='" + commodityId + '\'' +
                ", cname='" + cname + '\'' +
                ", price='" + price + '\'' +
                ", category='" + category + '\'' +
                ", description='" + description + '\'' +
                ", followDate='" + followDate + '\'' +
                '}';
    }
}
