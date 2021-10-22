package tmall.model.entityView;


public class CommodityView {

    private String commodityId;

    // 店铺应该具有添加商品的功能，添加时将自动为商品的shipId进行初始化

    private String shopId;

    public String shopName;  // 表明该商品属于哪个店铺(对于商品，我并不需要知道卖家的信息)

    public String price;

    public String category;

    public String storeNum;

    public String cname;

    public String description;

}
