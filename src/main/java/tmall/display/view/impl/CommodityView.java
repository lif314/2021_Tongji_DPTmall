package tmall.display.view.impl;

import tmall.display.view.View;
import tmall.model.entity.Commodity;
import tmall.model.logicalEntity.ShoppingCartLogic;

import java.util.ArrayList;
import java.util.List;

public class CommodityView extends View {
    @Override
    public Object show(Object... args) {

        if (args[0] instanceof Commodity){
            System.out.println("欢迎您来到商品详情页，该商品属性如下：");
            Commodity commodity =(Commodity) args[0];
            System.out.println("===================COMMODITY=====================");
            System.out.println("|商品ID ："+commodity.getCommodityId());
            System.out.println("|商品名称："+commodity.getCname());
            System.out.println("|商品种类："+commodity.getCategory());
            System.out.println("|商品价格："+commodity.getPrice());
            System.out.println("|商品描述："+commodity.getDescription());
            System.out.println("|商品库存："+commodity.getCategory());
            System.out.println("=================================================");
        }
        else if(args[0] instanceof ArrayList) {

                System.out.println("==========以下是购物车内商品==============");
                List<ShoppingCartLogic> shoppingCartLogics = (ArrayList) args[0];
                System.out.println(String.format("|%-10s\t|%-20s|%-8s\t|%-5s|%-5s\t|%-40s|%-30s|",
                        "cname", "description", "amount", "price", "category", "commodityId", "createDate"));
                for (ShoppingCartLogic s : shoppingCartLogics) {
                    System.out.println(s);
                }

        }
        return null;
    }
}
