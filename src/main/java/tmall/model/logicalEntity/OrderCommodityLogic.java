package tmall.model.logicalEntity;

/**
 * 订单商品联系集的逻辑实体
 *
 * 主要是在订单id已知的情况下商品的信息
 */
public class OrderCommodityLogic {

    // 同一建商品
    private String commodityId; // 商品id

    public String cname;        // 商品名称

    public String price;        // 价格

    public String amount;      // 商品的数量

    public OrderCommodityLogic() {
    }

    public OrderCommodityLogic(String commodityId, String cname, String price, String amount) {
        this.commodityId = commodityId;
        this.cname = cname;
        this.price = price;
        this.amount = amount;
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

    @Override
    public String toString() {

        return  String.format("|%-10s|%-5s|%-8s|%-40s|",
                cname,price,amount,commodityId);

//        return "OrderCommodityLogic{" +
//                "commodityId='" + commodityId + '\'' +
//                ", cname='" + cname + '\'' +
//                ", price='" + price + '\'' +
//                ", amount='" + amount + '\'' +
//                '}';
    }
}
