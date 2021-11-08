package tmall.controller.impl;

import tmall.model.entity.Commodity;
import tmall.model.entityDao.daoImpl.CommodityDaoImpl;
import tmall.model.entityDao.daoInterface.CommodityDao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


/**
 * @Author Sir Lancelot
 * @Description 应用享元和工厂模式上架商品
 */
public class ComFactory {
    List<Commodity> commodityList = new ArrayList<>();
    final HashMap<String, Commodity> commodityHashMap = new HashMap<>();
    String current_shopId;

    /**
     * 构造方法，从数据库读取商品数据，并生成一个 {商品名:商品} 的HashMap
     */
    public ComFactory(String shopId){
        CommodityDao commodityDao  = new CommodityDaoImpl();
        commodityList = commodityDao.getAllByShopId(shopId);
        current_shopId = shopId;
        for (Commodity commodity : commodityList) {
            commodityHashMap.put(commodity.getCname(), commodity);
        }
    }

    /**
     * 添加商品
     * @param cname 名称
     * @param category 类别
     * @param price 价格
     * @param storeNum 库存
     * @param description 描述
     * @return obj[0]: 创建的新commodity对象 或 原有的商品  obj[1]:提示信息
     * 可考虑在tips为“0”时输出重名商品信息
     */
    public String add(String cname, String category, String price,  String storeNum,  String description){
//        Object[] obj = new Object[2];
        Commodity commodity = commodityHashMap.get(cname);
        String tips = "该商品名已存在！";
        if(commodity == null) {
            CommodityDao commodityDao = new CommodityDaoImpl();
            commodity = commodityDao.create(current_shopId, price, category, storeNum, cname, description);
            commodityDao.addToDb();
            commodityHashMap.put(cname, commodity);
            tips = "商品\""+cname+"\"上架成功！";
        }
//        ShopController.Notify N = new ShopController.notifyNewCommodity();
//        N.notify(current_shopId);
        ShopController shopController = new ShopController();
        shopController.strategy = new ShopController.notifyNewCommodity();
        shopController.notifySubscribers(current_shopId);
        return tips;
    }
}
