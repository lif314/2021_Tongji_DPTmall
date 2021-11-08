package tmall.display.view.impl;

import tmall.display.view.View;

public class ActivityView extends View {
    @Override
    public Object show(Object... args) {
        System.out.println("欢迎您来到天猫购物节活动页面，您可参加如下活动：");
        System.out.print(String.format("|%-10s|%-6s\t|%-5s\t|%-5s\t|%-40s\t|",
                "活动名称","折扣","开始时间","结束时间","活动ID"));
        System.out.println();
        for (Object e:args
        ) {
            System.out.println(e);
        }
        System.out.println("【提示】可以输入 Enter CommodityDivisionPage 查看会场");
        return null;
    }
}
