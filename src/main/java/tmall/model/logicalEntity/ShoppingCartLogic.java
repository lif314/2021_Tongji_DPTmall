package tmall.model.logicalEntity;

public class ShoppingCartLogic {

    private String commodityId;  // 商品Id

    public String cname;        // 商品名称

    public String price;        // 价格

    public String amount;       // 商品数量

    public String category;     // 类别

    public String description;   // 商品描述

    public String createDate;  // 添加时间时间

    public ShoppingCartLogic() {
    }

    public ShoppingCartLogic(String commodityId, String cname, String price, String amount, String category, String description, String createDate) {
        this.commodityId = commodityId;
        this.cname = cname;
        this.price = price;
        this.amount = amount;
        this.category = category;
        this.description = description;
        this.createDate = createDate;
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

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
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

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    @Override
    public String toString() {
        return "ShoppingCartLogic{" +
                "commodityId='" + commodityId + '\'' +
                ", cname='" + cname + '\'' +
                ", price='" + price + '\'' +
                ", amount='" + amount + '\'' +
                ", category='" + category + '\'' +
                ", description='" + description + '\'' +
                ", createDate='" + createDate + '\'' +
                '}';
    }
}
