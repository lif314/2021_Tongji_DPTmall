package tmall.controller.DCH_impl.ShopDisplayController;

import tmall.model.entity.Seller;
import tmall.model.entityDao.daoImpl.SellerDaoImpl;
import tmall.model.entityDao.daoInterface.SellerDao;

public class ProxyShopImage implements ShopImage {
    private RealShopImage realShopImage;

    public ProxyShopImage() {

    }

    @Override
    public void gainshopInfo(String shopName) {
        if(realShopImage==null){
            realShopImage=new RealShopImage();
            realShopImage.loadFirstTime();
            System.out.println();
            realShopImage.gainshopInfo(shopName);
            System.out.println();
        }
        else{
            realShopImage.loadSecondTimes();
            System.out.println();
            realShopImage.gainshopInfo(shopName);
            System.out.println();
        }
    }

    public void checkCertification(String sellerID,String shopName){
//        获得唯一的sellerID并进行判断
        SellerDao sellerDao=new SellerDaoImpl();
        Seller seller=sellerDao.getAll().get(0);

        String correctsellerID=seller.getSellerId();

        if(sellerID.equals(correctsellerID)){
//            shopInfo();
            System.out.println("卖家"+sellerID+":");
            gainshopInfo(shopName);
        }
        else{
            System.out.print("卖家"+sellerID+":");
            System.out.println("很抱歉，根据代理模式，您无权查看店铺情况.");
            System.out.println();
        }
    }
}
