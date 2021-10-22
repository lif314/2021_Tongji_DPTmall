package tmall.model.entity;

public class Commodity {

    private String commodityId;

    // 店铺应该具有添加商品的功能，添加时将自动为商品的shipId进行初始化
    private String shopId;

    public String price;

    public String category;

    public String storeNum;

    public String cname;

    public String description;

    public Commodity() {
    }

    public Commodity(String commodityId, String shopId, String price, String category, String storeNum, String cname, String description) {
        this.commodityId = commodityId;
        this.shopId = shopId;
        this.price = price;
        this.category = category;
        this.storeNum = storeNum;
        this.cname = cname;
        this.description = description;
    }

    public String getCommodityId() {
        return commodityId;
    }

    public void setCommodityId(String commodityId) {
        this.commodityId = commodityId;
    }

    public String getShopId() {
        return shopId;
    }

    public void setShopId(String shopId) {
        this.shopId = shopId;
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

    public String getStoreNum() {
        return storeNum;
    }

    public void setStoreNum(String storeNum) {
        this.storeNum = storeNum;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Commodity{" +
                "commodityId='" + commodityId + '\'' +
                ", shopId='" + shopId + '\'' +
                ", price='" + price + '\'' +
                ", category='" + category + '\'' +
                ", storeNum='" + storeNum + '\'' +
                ", cname='" + cname + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
