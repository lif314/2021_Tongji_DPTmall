package tmall.model.entity;

/**
 * 购物车实体表
 */

public class ShoppingCart {

    private String buyerId;  // 买家Id

    private String commodityId;  // 商品Id

    public String amount;  // 商品数量

    public String createDate;  // 创建时间

    public ShoppingCart() {
    }

    public ShoppingCart(String buyerId, String commodityId, String amount, String createDate) {
        this.buyerId = buyerId;
        this.commodityId = commodityId;
        this.amount = amount;
        this.createDate = createDate;
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

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }


    @Override
    public String toString() {
        return  String.format("|%-10s|%-10s|%-40s|%-40s|",
                amount,createDate,buyerId,commodityId);
//        return "ShoppingCart{" +
//                "buyerId='" + buyerId + '\'' +
//                ", commodityId='" + commodityId + '\'' +
//                ", amount='" + amount + '\'' +
//                ", createDate='" + createDate + '\'' +
//                '}';
    }
}
