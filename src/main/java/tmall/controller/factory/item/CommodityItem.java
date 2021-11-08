package tmall.controller.factory.item;

import tmall.model.entity.Commodity;
import tmall.model.entityDao.daoImpl.CommodityDaoImpl;
import tmall.model.entityDao.daoInterface.CommodityDao;

import java.util.HashMap;
import java.util.List;

/**
 * CommodityItem类的描述：
 * 用于存储数据库中多有的商品
 * @author 黄金坤（HJK）
 * @since 2021/11/4  19:01
 */

public class CommodityItem implements Item<Commodity>{

    private static CommodityItem commodityItem = new CommodityItem();

    private static List<Commodity> commodityList = null;
    private static final HashMap<String, Commodity> commodityHashMap = new HashMap<>();

    static{
        CommodityDao commodityDao = new CommodityDaoImpl();
        commodityList = commodityDao.getAll();
        for(Commodity commodity : commodityList){
            commodityHashMap.put(commodity.getCommodityId(),commodity);
        }
    }

    private CommodityItem(){}

    public static CommodityItem getInstance(){return commodityItem;}
    @Override
    public Commodity get(String commodityID) {
        Commodity commodity = commodityHashMap.get(commodityID);

        if (commodity == null) {
            CommodityDao commodityDao = new CommodityDaoImpl();
            commodity = commodityDao.getByCommodityId(commodityID);
            commodityHashMap.put(commodityID,commodity);
        }

        return commodity;
    }
}
