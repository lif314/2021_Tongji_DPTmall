package tmall.controller.impl;

import tmall.XMLRepository.ProxyXmlContext;
import tmall.XMLRepository.XMLContext;
import tmall.model.entity.*;
import tmall.controller.*;
import tmall.model.entityDao.daoImpl.CommodityDaoImpl;
import tmall.model.entityDao.daoInterface.CommodityDao;
import tmall.model.logicalEntity.CommodityCategory;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Strange
 * @date 2021/10/23 19:26
 * @description: 商品分区控制器。由此进入不同分区（按种类分）
 */
public class CommodityDisplayController extends CommodityController{

    private final XMLContext<Commodity> context = new ProxyXmlContext<>(Commodity.class);

    /**
     * @author Strange
     * @date: 2021/10/26 23:42
     * @description: 商品分区展示 √
     * @param: args
     * @return: 字符串数组
     */
    public Object[] commodityDivisionDisplay() {

        List<String> commodityDivisionList = new ArrayList<>();

        //在xml文件中读取所有分区，把名字添加进list中
        for (CommodityCategory c : CommodityCategory.values()) {
            commodityDivisionList.add(c.toString());
        }
//        List<String> commodityDivisionList = context.gatherAllDivision();
//        //相当于如下效果
//        commodityDivisionList.add("Shirt");
//        commodityDivisionList.add("Fruit");

        return commodityDivisionList.toArray();
    }

    /**
     * @author Strange
     * @date: 2021/10/26 23:54
     * @description: 选择一个分区，进行区内商品展示
     * @param: args
     * @return: 数组
     */
    public Object[] commodityDisplayInDivision(String divisionName) {
        List<Object> commodityDisplayList = new ArrayList<>();

        CommodityDao commodityDao = new CommodityDaoImpl();
        List<Commodity> commodityList = commodityDao.getAllByCategory(divisionName);
        System.out.println(commodityList);

//        List<Commodity> commodityList = context.findByDivisionId(divisionId);
        //使用访问者模式，商品接受买家访问（意味着买家具有访问权限）
        CommodityVisitor commodityVisitor = new CommodityVisitor();

        for (Commodity c : commodityList) {
            commodityDisplayList.add(c.acceptGeneralProperty(commodityVisitor));
        }
        //元素类型为list of string
        return commodityDisplayList.toArray();
    }

    /**
     * @author Strange
     * @date: 2021/10/27 0:05
     * @description: 商品详情展示 √
     * @param: args
     * @return: 一个商品对象（数组仅有一个元素）
     */
    @Override
    public Object[] commodityDetailDisplay(String commodityId) {

        CommodityDao commodityDao = new CommodityDaoImpl();
        Commodity c = commodityDao.getByCommodityId(commodityId);

        //此列表只有一个商品对象（因为每次只能看一个商品详情）
        List<Commodity> commodityDetailList = new ArrayList<>();
        commodityDetailList.add(c);

        return commodityDetailList.toArray();
    }
}
