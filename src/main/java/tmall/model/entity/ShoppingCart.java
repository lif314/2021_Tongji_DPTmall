package tmall.model.entity;

public class ShoppingCart {

    private String buyerId;

    private String commodity;

    public String amount;

    public String createDate;

    public ShoppingCart() {
    }

    public ShoppingCart(String buyerId, String commodity, String amount, String createDate) {
        this.buyerId = buyerId;
        this.commodity = commodity;
        this.amount = amount;
        this.createDate = createDate;
    }

    public String getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(String buyerId) {
        this.buyerId = buyerId;
    }

    public String getCommodity() {
        return commodity;
    }

    public void setCommodity(String commodity) {
        this.commodity = commodity;
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
        return "ShoppingCart{" +
                "buyerId='" + buyerId + '\'' +
                ", commodity='" + commodity + '\'' +
                ", amount='" + amount + '\'' +
                ", createDate='" + createDate + '\'' +
                '}';
    }
}
