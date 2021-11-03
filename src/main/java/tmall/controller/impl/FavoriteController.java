package tmall.controller.impl;

import tmall.controller.Controller;
import tmall.model.entity.FollowCommodity;
import tmall.model.entity.FollowShop;
import tmall.model.entityDao.daoImpl.FavoriteCommodityDaoImpl;
import tmall.model.entityDao.daoImpl.FollowShopDaoImpl;
import tmall.model.entityDao.daoInterface.FavoriteCommodityDao;
import tmall.model.entityDao.daoInterface.FollowShopDao;
import tmall.model.logicalEntity.FollowCommodityLogic;
import tmall.model.logicalEntity.FollowShopLogic;

import java.util.ArrayList;
import java.util.List;

/**
 * FavoriteController类的描述：
 * 收藏夹控制器
 * @author 黄金坤（HJK）
 * @since 2021/10/31  13:21
 */

public class FavoriteController extends Controller {

//    private static FavoriteCommodityDao favoriteCommodityDao = new FavoriteCommodityDaoImpl();
//    private static FollowShopDao favoriteShopDao = new FollowShopDaoImpl();

    /**
     * 查看收藏的所有商品
     * @param buyerID
     * @return 收藏的商品信息集
     */
    public  Object[] displayFavoriteCommodities(String buyerID){
        FavoriteCommodityDao favoriteCommodityDao = new FavoriteCommodityDaoImpl();
        //获取收藏的商品的信息列表
        List<FollowCommodityLogic> favoriteCommodityList = favoriteCommodityDao.getByBuyerId(buyerID);

        return favoriteCommodityList.toArray();
    }

    /**
     * 获取关注的所有店铺
     * @param buyerID
     * @return 收藏的店铺信息集
     */
    public Object[] displayFavoriteShops(String buyerID){
        FollowShopDao followShopDao = new FollowShopDaoImpl();
        //获取所有收藏的店铺
        List<FollowShopLogic> favoriteShopList = followShopDao.getByBuyerId(buyerID);

        return favoriteShopList.toArray();
    }

    /**
     * 收藏一个商品
     * @param buyerID
     * @param commodityID
     */
    public void addFavoriteCommodity(String buyerID ,String commodityID){
        FavoriteCommodityDao favoriteCommodityDao =  new FavoriteCommodityDaoImpl();
        //创建需要添加到数据库的收藏商品
        FollowCommodity followCommodity = favoriteCommodityDao.create(buyerID, commodityID);
        //添加到数据库
        favoriteCommodityDao.addToDb();
    }

    /**
     * 关注一个店铺
     * @param buyerID
     * @param shopID
     */
    public void addFavoriteShop(String buyerID ,String shopID){
        FollowShopDao followShopDao =  new FollowShopDaoImpl();
        //创建需要添加到数据库的收藏店铺
        FollowShop followShop = followShopDao.create(buyerID, shopID);
        //添加到数据库
        followShopDao.addToDb();
    }

    /**
     * 取消关注一个商品
     * @param buyerID
     * @param commodityID
     */
    public void deleteFavoriteCommodity(String buyerID,String commodityID){
        FavoriteCommodityDao favoriteCommodityDao =  new FavoriteCommodityDaoImpl();
        //删除某个收藏商品
        favoriteCommodityDao.cancelFollow(buyerID,commodityID);
    }

    /**
     * 取消关注一个店铺
     * @param buyerID
     * @param shopID
     */
    public void deleteFavoriteShop(String buyerID,String shopID){
        FollowShopDao followShopDao = new FollowShopDaoImpl();
        //删除某个收藏的店铺
        followShopDao.cancelShopFollow(buyerID, shopID);
    }

    /**
     * 展示商品详情
     * @param commodityID
     * @return
     */
    public Object[] displayCommodityDetails(String commodityID){
        CommodityDisplayController controller = new CommodityDisplayController();
        return controller.commodityDetailDisplay(commodityID);
    }

    /**
     * 从收藏夹中点击店铺后会展现这个店铺的名字和旗下的commodities
     * @param shopID
     * @return 店铺的所有商品、活动
     */
    public Object[] displayShopDetails(String shopID){
        List<Object> informationList = new ArrayList<>();
        //从ShopController中获取有关店铺的所有信息，然后再从中筛选必要信息
        Object[] obj = new ShopController().execute(shopID);
        informationList.add(obj[1]);  //商品集合
        informationList.add(obj[2]);  //活动集合

        return informationList.toArray();  //获取所有的信息
    }
}
