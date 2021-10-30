package tmall.controller.impl;

import tmall.XMLRepository.ProxyXmlContext;
import tmall.XMLRepository.XMLContext;
import tmall.model.entity.Commodity;
import tmall.model.entityDao.daoImpl.CommodityDaoImpl;
import tmall.model.entityDao.daoInterface.CommodityDao;

import java.util.HashMap;
import java.util.List;

/**
 * @author Strange
 * @date 2021/10/29 23:31
 * @description: 享元+工厂模式。每访问过一个商品，将其加入哈希表。减少直接访问数据库的次数，提高效率
 */
public class CommodityFactory {

    private static List<Commodity> commodityList = null;
    private static final HashMap<String, Commodity> commodityHashMap = new HashMap<>();

    public static Commodity getCommodity(String name) {

        Commodity commodity = commodityHashMap.get(name);

        if (commodity == null) {
            if(commodityList == null){
                CommodityDao commodityDao = new CommodityDaoImpl();
                commodityList = commodityDao.getAll();
            }

            for (Commodity c : commodityList) {
                if(c.getCname().equals(name)){
                    // 把新对象加入哈希表
                    commodityHashMap.put(name, c);
                    commodity = c;
                    break;
                }
            }
        }

        return commodity;
    }
}
