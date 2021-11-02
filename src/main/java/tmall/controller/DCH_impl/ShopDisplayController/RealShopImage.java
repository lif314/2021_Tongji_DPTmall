package tmall.controller.DCH_impl.ShopDisplayController;

import tmall.controller.DCH_impl.BranchShop;
import tmall.controller.DCH_impl.ComponentShop;
import tmall.controller.DCH_impl.ComponentShopCreationController.ComponentShopFactory;

public class RealShopImage implements ShopImage {

    public RealShopImage() {
    }

    @Override
    public void gainshopInfo(String shopName){
        ComponentShop bS = new BranchShop();
        bS = ComponentShopFactory.getShopByName(shopName);

        bS.showShop();

        System.out.println("该店铺以及旗下店铺的总营业额为: "+bS.getcreditScore()+".");
    }

    @Override
    public void checkCertification(String sellerID, String shopName) {

    }

    public void loadFirstTime(){
        System.out.println("根据代理模式，您是第一次查看店铺情况!");
    }
    public void loadSecondTimes(){
        System.out.println("根据代理模式，您已经多次查看店铺情况.");
    }
}
