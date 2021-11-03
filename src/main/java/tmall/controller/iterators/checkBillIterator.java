package tmall.controller.iterators;

import tmall.model.entity.Commodity;
import tmall.model.logicalEntity.ShoppingCartLogic;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @description: 迭代器模式
 * 结算迭代器，用于计算选中商品的总假期
 */

public class checkBillIterator implements Iterator<ShoppingCartLogic> {
    int index = 0;
    private final List<ShoppingCartLogic> carts;
    public checkBillIterator(List<ShoppingCartLogic> carts){this.carts = carts;}
    @Override
    public boolean hasNext() {
        return index < carts.size();
    }

    @Override
    public ShoppingCartLogic next() {
        if(this.hasNext())
            return carts.get(index++);
        return null;
    }

    public int check(List<Commodity> cmdtyList){
        List<ShoppingCartLogic> list = new ArrayList<>();
        while(hasNext()){
            ShoppingCartLogic cart = next();
            for(Commodity cmdty : cmdtyList){
                if(cmdty.getCommodityId().equals(cart.getCommodityId())){
                    list.add(cart);
                }
            }
        }
        int sum = 0;
        for(ShoppingCartLogic cart : list){
            sum += Integer.parseInt(cart.getAmount()) * Integer.parseInt(cart.getPrice());
        }
        return sum;
    }
}
