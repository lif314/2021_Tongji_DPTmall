package tmall.controller.impl;

import tmall.controller.CommodityController;
import tmall.model.entity.Commodity;
import tmall.model.entity.Shirt;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Strange
 * @date 2021/10/30 0:03
 * @description: 购买商品控制器
 */
public class PurchaseController extends CommodityController {

    /**
     * @author Strange
     * @date: 2021/10/30 0:04
     * @description: 根据名字搜索商品
     * @param: name
     * @return: 商品名称（字符串）
     */
    public String searchCommodity(String name) {

        Commodity commodity = CommodityFactory.getCommodity(name);

        return commodity.getCname();
    }

    @Override
    public Object[] commodityDetailDisplay(String name) {

        Commodity c = CommodityFactory.getCommodity(name);
        //此列表只有一个商品对象（因为每次只能看一个商品详情）
        List<Commodity> commodityDetailList = new ArrayList<>();
        commodityDetailList.add(c);

        return commodityDetailList.toArray();
    }

    /**
     * @author Strange
     * @date: 2021/10/30 11:32
     * @description: 装饰器模式。
     * @param: index
     * @return: 订单
     */
    public Object[] purchase(String name) {

        Commodity c = CommodityFactory.getCommodity(name);

        CommodityDecorator commodityDecorator = new CommodityDecorator(c);

        commodityDecorator.decorate();





    }
}
