package tmall.model.entityDao.daoInterface;

import tmall.model.entity.FollowCommodity;
import tmall.model.logicalEntity.FollowCommodityLogic;
import tmall.model.logicalEntity.FollowShopLogic;

import java.util.List;

/**
 * 收藏夹
 */
public interface FavoriteCommodityDao {

    /**
     * 关注商品
     * @param buyerId 买家id
     * @param commodityId 商品id
     * @return a follow commodity
     */
    FollowCommodity create(String buyerId, String commodityId);

    /**
     * 存储到数据库中
     */
    void addToDb();


    /**
     * 获取买家收藏夹的详细信息
     * @param buyerId 买家id
     * @return list commodity details
     */
    List<FollowCommodityLogic> getByBuyerId(String buyerId);
}
