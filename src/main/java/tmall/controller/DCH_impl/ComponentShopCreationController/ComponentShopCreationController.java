package tmall.controller.DCH_impl.ComponentShopCreationController;

import tmall.controller.Controller;
import tmall.controller.DCH_impl.AffiliatedShop;
import tmall.controller.DCH_impl.BranchShop;
import tmall.controller.DCH_impl.ComponentShop;
import tmall.controller.DCH_impl.ShopDisplayController.ShopDisplayController;
import tmall.model.entity.Shop;
import tmall.model.entityDao.daoImpl.ShopDaoImpl;
import tmall.model.entityDao.daoInterface.ShopDao;

import java.util.Scanner;

/**
 * @description: 创建Shop的Controller  设计模式：组合模式
 * @classification: 1. 创建总店 2. 创建新分店 3. 创建加盟店
 */
public class ComponentShopCreationController extends Controller {

    //从数据库中获得总店的信息
    private String sellerId;
    private String shopName;
    private String creditScore;
    private String category;

    public ComponentShopCreationController() {
        ShopDao shopDao=new ShopDaoImpl();
        Shop shop=shopDao.getAll().get(0);

        this.sellerId = shop.getSellerId();
        this.shopName = shop.getShopName();
        this.creditScore = shop.getCreditScore();
        this.category = shop.getCategory();

//        this.sellerId = "83540ad1-c858-48e2-8717-0b9c5789bc27";
//        this.shopName = "LzaShop";
//        this.creditScore = "10";
//        this.category = "电子";
    }

    public void createShop(String createOrder, String branchShopName){
        ComponentShop createdShop;
        if(createOrder.equals("1")){
            createdShop=createHeadQuater();  //创建总店
            ComponentShopFactory.componentshopList.add(createdShop);
        }
        else if(createOrder.equals("2")){
            createdShop=createBranchShop("0002", "LzaShop-Jiading", "5", "电子_分店");  //创建新分店
            ComponentShopFactory.componentshopList.add(createdShop);
        }
        else if(createOrder.equals("3")){
            createdShop=createAffliatedShop("0003", "LzaShop-Huangdu", "1", "电子_加盟店",branchShopName);  //创建加盟店
            ComponentShopFactory.componentshopList.add(createdShop);
        }

    }

    /**
     *
     * @return shopID 新创建的店铺的ID
     */
    public ComponentShop createHeadQuater(){

//        ShopDao shopDao=new ShopDaoImpl();

        //先获取总店
        ComponentShop headQuater=new BranchShop();
        headQuater= ComponentShopFactory.getShopByCategory("电子");

        //当前没有总店，可以创建
        if(headQuater!=null) return null;

        ComponentShop hQ=new BranchShop(sellerId,shopName,creditScore,category);  //创建方法，后期名字需要改(不能new)

        return hQ;

    }

    /**
     *
     * @return shopID 新创建的店铺的ID
     */
    public ComponentShop createBranchShop(String sellerId,String shopName,String creditScore,String category){
        //创建分店，基本流程和创建总店相同（都是BranchShop），但是必须在总店下创建
//        ShopDao shopDao=new ShopDaoImpl();

        //先获取总店
        ComponentShop headQuater=new BranchShop();
        headQuater= ComponentShopFactory.getShopByCategory("电子");

        ComponentShop bS=new BranchShop(sellerId,shopName,creditScore,category);  //创建方法，后期名字需要改(不能new)
        headQuater.add(bS);

        return bS;
    }

    /**
     *
     * @param branchShopName
     * @return shopID 新创建的店铺的ID
     */
    public ComponentShop createAffliatedShop(String sellerId,String shopName,String creditScore,String category,String branchShopName){
        //创建加盟店，加盟店不能有旗下的其他加盟店

//        ShopDao shopDao=new ShopDaoImpl();

        //先获取指定的分店
        ComponentShop branchShop=new BranchShop();
        branchShop= ComponentShopFactory.getShopByName(branchShopName);

        ComponentShop aS=new AffiliatedShop(sellerId,shopName,creditScore,category);
        branchShop.add(aS);

        return aS;
    }


}
