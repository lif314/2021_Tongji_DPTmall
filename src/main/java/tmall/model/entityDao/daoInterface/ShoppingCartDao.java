package tmall.model.entityDao.daoInterface;

import tmall.model.entity.ShoppingCart;
import tmall.model.logicalEntity.ShoppingCartLogic;

import java.util.List;

/**
 * 购物车
 */
public interface ShoppingCartDao {

    /**
     * 添加商品到购物车
     * @param buyerId 买家id
     * @param commodityId 商品id
     * @return 购物车简介
     */
    ShoppingCart create(String buyerId, String commodityId, String amount);

    /**
     * 存储到数据库中
     */
    void addToDb();

    /**
     * 获取用户的购物车详情
     * @param buyerId 买家id
     * @return list ShoppingCartLogic
     */
    List<ShoppingCartLogic> getCartByBuyerId(String buyerId);
}