package tmall.controller.factory;

import tmall.controller.factory.item.CommodityItem;
import tmall.controller.factory.item.Item;
import tmall.controller.factory.item.ShopItem;

/**
 * ItemFactory类的描述：
 * 用于制造Item类的工厂
 * @since 2021/10/26  23:41
 */



public class ItemFactory implements AbstractFactory {
    @Override
    public Object getUserInfoController(String args) {
        return null;
    }

    @Override
    public Object getUserRoleController() {
        return null;
    }

    /**
     * 通过传入的Item名称来返回具体的Item子类对象
     * @param itemName
     * @return Item
     */
    public Item getItem(String itemName){
        switch(itemName){
            case "commodity":return CommodityItem.getInstance();
            case "shop":return ShopItem.getInstance();
            //还可以有其他工厂
        }
        return null;
    }
}
