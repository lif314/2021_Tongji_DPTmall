package tmall.controller.DCH_impl;

import tmall.controller.Controller;
import tmall.controller.DCH_impl.ComponentShopCreationController.ComponentShopCreationController;
import tmall.controller.DCH_impl.ShopDisplayController.ShopDisplayController;
import tmall.model.entity.Seller;
import tmall.model.entityDao.daoImpl.SellerDaoImpl;
import tmall.model.entityDao.daoInterface.SellerDao;

import java.util.Scanner;

/**
 * @description: 创建店铺、显示店铺Controller
 */
public class ComponentShopCreDisController extends Controller {
    /**
     * @description: View最终调用这一个方法即可
     */
    public void createComponentShop_Process(){
        while(true){
            Scanner sc=new Scanner(System.in);
            System.out.println("创建店铺");
            System.out.println("1. 创建总店");
            System.out.println("2. 创建分店");
            System.out.println("3. 创建加盟店");
            System.out.println("4. 完成创建");
            System.out.print("请输入创建指令：");
            String createOrder=sc.nextLine();

            ComponentShopCreationController cscc=new ComponentShopCreationController();

            int stop=0;

            switch (createOrder){
                case "1":
                case "2":
                    cscc.createShop(createOrder,"");
                    break;
                case "3":
                    Scanner sc1=new Scanner(System.in);
                    System.out.print("请输入依附的分店名称：");
                    String bShopName=sc1.nextLine();
                    cscc.createShop(createOrder,bShopName);
                    break;
                case "4":
                    stop=1;
                default:
                    break;
            }
            if(stop==1){break;}
            System.out.println();
        }

        System.out.println();
        System.out.println("显示店铺：");
        System.out.println();
        ShopDisplayController sdc=new ShopDisplayController();

        SellerDao sellerDao=new SellerDaoImpl();
        Seller seller=sellerDao.getAll().get(0);

        sdc.shopInfoDisplay_Process("0002","LzaShop-Jiading");
        sdc.shopInfoDisplay_Process(seller.getSellerId(),"LzaShop-Jiading");
    }
}
