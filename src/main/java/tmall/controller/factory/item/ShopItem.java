package tmall.controller.factory.item;

import tmall.controller.factory.item.Item;
import tmall.model.entity.Shop;
import tmall.model.entityDao.daoImpl.ShopDaoImpl;
import tmall.model.entityDao.daoInterface.ShopDao;

import java.util.Hashtable;
import java.util.List;

/**
 * ShopFactory类的描述：
 *
 * @author 黄金坤（HJK）
 * @since 2021/10/30  21:00
 */

public class ShopItem implements Item<Shop> {

    private static ShopItem shopFactory = new ShopItem();

    private static Hashtable<String,Shop> shopHashtable = new Hashtable<>();

    static{
        ShopDao shopDao = new ShopDaoImpl();
        List<Shop> shopList = shopDao.getAll();
        for(Shop shop : shopList){
            shopHashtable.put(shop.getShopId(),shop);
        }
    }

    private ShopItem(){}

    public static ShopItem getInstance(){
        return shopFactory;
    }

    @Override
    public Shop get(String key) {
        Shop shop = shopHashtable.get(key);
        if(shop == null){
            //读出xml中shopID=key的shop
            ShopDao shopDao = new ShopDaoImpl();
            shop = shopDao.getById(key);
            //存到哈希表
            shopHashtable.put(key,shop);
        }
        return shop;
    }
}
