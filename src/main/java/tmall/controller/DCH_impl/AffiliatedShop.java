package tmall.controller.DCH_impl;

import java.util.List;

public class AffiliatedShop extends ComponentShop{

    public AffiliatedShop(){}

    public AffiliatedShop(String sellerId, String shopName, String creditScore, String category) {
        this.sellerId = sellerId;
        this.shopName = shopName;
        this.creditScore = creditScore;
        this.category = category;
        this.shopAddress = "Address A";
        this.description = "None";
    }

    public String getShopId() {
        return shopId;
    }

    public String getSellerId() {
        return sellerId;
    }

    public String getShopName() {
        return shopName;
    }

    public String getCreditScore() {
        return creditScore;
    }

    public String getCategory() {
        return category;
    }

    public String getShopAddress() {
        return shopAddress;
    }

    public String getDescription() {
        return description;
    }

    public void setShopId(String shopId) {
        this.shopId = shopId;
    }

    public void setSellerId(String sellerId) {
        this.sellerId = sellerId;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public void setCreditScore(String creditScore) {
        this.creditScore = creditScore;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setShopAddress(String shopAddress) {
        this.shopAddress = shopAddress;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public int getcreditScore() {
        return Integer.parseInt(this.creditScore);
    }

    @Override
    public void showShop() {
        System.out.println("ShopName: "+shopName+" CreditScore: "+creditScore+" Category: "+category);
//        System.out.println();
    }

    @Override
    public void gainShop(List<Object> countShop) {
        countShop.add(this);
    }

    @Override
    public void add(ComponentShop componentshop) {

    }

}
