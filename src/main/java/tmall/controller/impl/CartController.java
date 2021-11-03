package tmall.controller.impl;


import tmall.controller.iterators.checkBillIterator;
import tmall.model.entity.Buyer;
import tmall.model.entity.Commodity;

import java.util.*;

import tmall.model.entityDao.daoImpl.ShoppingCartDaoImpl;
import tmall.model.logicalEntity.*;

/**
 * 购物车的管理方法：
 *      [1] 展示购物车内所有商品
 *      [2] 修改购物车内指定商品的数量，数量为 0 则删除
 *      [3] 在购物车内增加商品
 *      [4] 选择指定商品进行结算
 *      [5] 选择优惠活动
 *      [6] 进行付款
 *      [7] 展示买家所有收获地址
 *      [8] 选择买家收货地址
 *      [9] 展示购买方式
 *      [10] 选择购买方式
 *      [11] 创建订单
 *      [12] 展示订单
 */
public class CartController {

    private final ShoppingCartDaoImpl scDIl = new ShoppingCartDaoImpl();
    // List<ShoppingCartLogic> cartsInfo = scDIl.



    /**
     * 展示指定用户购物车里的商品
     * @param buyer 用户
     * @return 一个商品集合的 List
     */
    public List<ShoppingCartLogic> showCommodity(Buyer buyer){
        return scDIl.getCartByBuyerId(buyer.getBuyerId());
    }

    public List<ShoppingCartLogic> showCommodity(String buyerID){
        return scDIl.getCartByBuyerId(buyerID);
    }

    /**
     * 修改指定用户购物车内指定商品的数量
     * @param buyerID 指定用户的ID
     * @param newInfo 新的数量
     * @param cmdtyID 指定商品的ID
     * @return 是否找到改商品并成功修改
     */
    public void editCommodityInfo(String newInfo, String cmdtyID, String buyerID){
        if(newInfo.equals("0"))
            scDIl.deleteOne(buyerID , cmdtyID);
        else
            scDIl.updateCommodityAmount(buyerID,cmdtyID,newInfo);
    }

    /**
     * 计算购物车选中物品总价
     * @param buyer 用户
     * @param cmdtyList 选中物品 List
     * @return 总价
     */
    public int checkChosenCartBill(List<Commodity> cmdtyList, Buyer buyer){
        List<ShoppingCartLogic> cartsInfo = scDIl.getCartByBuyerId(buyer.getBuyerId());
        checkBillIterator itr = new checkBillIterator(cartsInfo);
        return itr.check(cmdtyList);
    }

    /**
     * 计算购物车里所有商品总价
     * @param buyerID 买家ID
     * @return 购物车内所有商品的总价
     */
    public int checkCartBill(String buyerID){
        List<ShoppingCartLogic> cartsInfo = scDIl.getCartByBuyerId(buyerID);
        int sum = 0;
        for(ShoppingCartLogic cart : cartsInfo){
            sum += Integer.parseInt(cart.getAmount()) * Integer.parseInt(cart.getPrice());
        }
        return sum;
    }

    /**
     * 在购物车中增加商品
     * @param buyerID 买家ID
     * @param commodityId 商品ID
     * @param amount 商品数量
     */
    public void addCart(String buyerID,String commodityId,String amount){
        scDIl.create(buyerID, commodityId, amount);
        scDIl.addToDb();
    }

    public void deleteAll(Buyer buyer){
        ;
    }

}
