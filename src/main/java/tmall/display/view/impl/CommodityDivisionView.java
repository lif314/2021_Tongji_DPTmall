package tmall.display.view.impl;

import tmall.display.view.View;

public class CommodityDivisionView extends View {

    @Override
    public Object show(Object... args) {
        System.out.println("欢迎您来到商品分区汇总页面，天猫购物节现有以下分区：");
        for (Object e:args
             ) {
            System.out.println(e);
        }
        return null;
    }
}
