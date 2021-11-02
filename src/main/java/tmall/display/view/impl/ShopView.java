package tmall.display.view.impl;

import tmall.controller.impl.ShopController;
import tmall.display.view.View;
import tmall.model.entity.Commodity;
import tmall.model.entity.Coupon;
import tmall.model.entity.Order;

import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class ShopView extends View {
    @Override
    public Object show(Object... args) {
        System.out.println("==========欢迎来到我的店铺==========\n");
        System.out.println("=========店铺商品列表========");
        List<Commodity> commodityList = (List<Commodity>) args[1];
        int index1 = 1;
        for (Commodity commodity:commodityList) {
            System.out.print(index1++ +'、');
            System.out.println(commodity.toString()+'\n');
        }
        System.out.println("=========店铺订单列表========");
        List<Order> orderList = (List<Order>) args[3];
        int index2 = 1;
        for (Commodity commodity:commodityList) {
            System.out.print(index2++ +'、');
            System.out.println(commodity.toString()+'\n');
        }
        System.out.println("=========店铺优惠券列表========");
        List<Coupon> couponList = (List<Coupon>) args[2];
        int index3 = 1;
        for (Coupon coupon:couponList) {
            System.out.print(index3++ +'、');
            System.out.println(coupon.toString()+'\n');
        }
        /*
         * 定义店铺内操作
         */
        while(true){
            System.out.println("\n=======请选择您想进行的操作========\n1.上架商品\n2.发布优惠券\n3.发货\n4.下架商品\n5.删除优惠券\n6.退出店铺");
            Scanner cmd = new Scanner(System.in);
            String str = cmd.next();
            if(Objects.equals(str, "1")){
                System.out.println("请输入待上架的商品信息：");
                ShopController.CommodityFactory commodityFactory = (ShopController.CommodityFactory) args[0];
                Scanner info = new Scanner(System.in);
                String cname = info.next();
                String category = info.next();
                String price = info.next();
                String storeNum = info.next();
                String description = info.next();
                commodityFactory.add(cname, category, price, storeNum, description);
                System.out.println("商品"+cname+"上架成功！");
            }else if(Objects.equals(str, "2")){
                System.out.println("请输入待发布的优惠券信息：");
                Scanner info = new Scanner(System.in);
                String startTime = info.next();
                String endTime = info.next();
                String full = info.next();
                String minus = info.next();
                ShopController.ActivityBuilder activityBuilder = (ShopController.ActivityBuilder) args[4];
                activityBuilder.addCoupon(startTime, endTime, full, minus);
                System.out.println("优惠券发布成功！");
            }else if(Objects.equals(str, "3")){
                System.out.println("请输入要发货的订单id：");
                Scanner id = new Scanner(System.in);
                String ID = id.next();
                ShopController shopController = new ShopController();
                shopController.shipOrder(ID);
                System.out.println("订单发货成功！");
            }else if(Objects.equals(str, "4")){
                System.out.println("请输入要下架的商品id：");
                Scanner id = new Scanner(System.in);
                String ID = id.next();
                ShopController shopController = new ShopController();
                shopController.deleteCommodity(ID);
                System.out.println("商品下架成功！");
            }else if(Objects.equals(str, "5")){
                System.out.println("请输入要删除的优惠券id：");
                Scanner id = new Scanner(System.in);
                String ID = id.next();
                ShopController shopController = new ShopController();
                shopController.deleteCoupon(ID);
                System.out.println("优惠券删除成功！");
            }else if(Objects.equals(str, "6")){
                System.out.println("您已安全离开店铺后台！");
                break;
            }else{
                System.out.println("请输入正确的命令！");
            }
        }

        return null;
    }
}
