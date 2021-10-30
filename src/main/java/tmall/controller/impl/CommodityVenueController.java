package tmall.controller.impl;

import tmall.XMLRepository.ProxyXmlContext;
import tmall.XMLRepository.XMLContext;
import tmall.controller.CommodityController;
import tmall.model.entity.Commodity;
import tmall.model.entity.Shop;
import tmall.model.entityDao.daoImpl.CommodityDaoImpl;
import tmall.model.entityDao.daoImpl.ShopDaoImpl;
import tmall.model.entityDao.daoInterface.CommodityDao;
import tmall.model.entityDao.daoInterface.ShopDao;
import tmall.model.logicalEntity.CommodityVenue;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Strange
 * @date 2021/10/27 8:35
 * @description: 商品会场控制器。由此进入不同商店（按商店分）
 */
public class CommodityVenueController extends CommodityController {
    
    /** 
     * @author Strange
     * @date: 2021/10/27 8:39
     * @description: 商品会场展示
     * @param: args
     * @return: 字符串数组
     */ 
    public Object[] commodityVenueDisplay(Object...args) {
        //在xml文件中读取所有会场，把名字添加进list中
        List<String> commodityVenueList = new ArrayList<>();

        for (CommodityVenue cv : CommodityVenue.values()) {
            commodityVenueList.add(cv.toString());
        }

        return commodityVenueList.toArray();
    }

    /**
     * @author Strange
     * @date: 2021/10/27 8:45
     * @description: 在一个卖家展示所有店铺
     * @param:
     * @return:
     */
    public Object[] shopDisplayInVenue(String sellerId) {
        ShopDao shopDao = new ShopDaoImpl();
        List<Shop> shopList = shopDao.getAllBySellerId(sellerId);
        return shopList.toArray();
    }


    /**
     * @author Strange
     * @date: 2021/10/27 0:05
     * @description: 商品详情展示
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
