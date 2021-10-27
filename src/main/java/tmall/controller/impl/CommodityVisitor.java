package tmall.controller.impl;

import tmall.model.entity.Commodity;

import java.util.List;

/**
 * @author 卢子昂
 * @date 2021/10/20 22:40
 * @description: 访问者模式查看商品
 * 之所以使用访问者，是因为卖家发布商品才能被顾客看到，accept函数可以体现。
 */

public class CommodityVisitor {
    public List<String> visitGeneralProperty(Commodity commodity) {
        return commodity.getGeneralProperty();
    }

    public List<String> visitSpecialProperty(Commodity commodity) {
        return commodity.getSpecialProperty();
    }
}
