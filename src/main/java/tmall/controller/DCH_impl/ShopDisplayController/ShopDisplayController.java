package tmall.controller.DCH_impl.ShopDisplayController;

/**
 * @description: 卖家看自己拥有的所有店铺，以及店铺的收入 设计模式：代理模式，也用到组合模式的方法
 */
public class ShopDisplayController {
    private ShopImage shopImage; //供代理模式使用

    public ShopDisplayController() {
        shopImage=new ProxyShopImage();
    }

    /**
     * @description: 第一次传入错误的sellerID，第二次传入正确的唯一的sellerID，Proxy会进行判断
     * @param sellerID，需要在方法外先获得唯一的卖家的sellerID
     * @param shopName
     */
    public void shopInfoDisplay_Process(String sellerID,String shopName){
        //第一次查看身份并访问
        shopImage.checkCertification(sellerID,shopName);
        //可以再次访问--为了体现Proxy
        shopImage.checkCertification(sellerID,shopName);
    }

}
