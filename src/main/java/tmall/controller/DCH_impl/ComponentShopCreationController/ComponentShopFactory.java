package tmall.controller.DCH_impl.ComponentShopCreationController;

import tmall.controller.DCH_impl.ComponentShop;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ComponentShopFactory {
    public static List<ComponentShop> componentshopList = new ArrayList<>();
    private static final HashMap<String, ComponentShop> shopNameHashMap = new HashMap<>();
    private static final HashMap<String, ComponentShop> shopCategoryHashMap = new HashMap<>();

    public static ComponentShop getShopByName(String name) {

        ComponentShop componentShop = shopNameHashMap.get(name);

        if (componentShop == null) {

            for (ComponentShop cS : componentshopList) {
                if(cS.getShopName().equals(name)){
                    // 把新对象加入哈希表
                    shopNameHashMap.put(name, cS);
                    componentShop = cS;
                    break;
                }
            }
        }
        return componentShop;
    }

    public static ComponentShop getShopByCategory(String category) {

        ComponentShop componentShop = shopCategoryHashMap.get(category);

        if (componentShop == null) {

            for (ComponentShop cS : componentshopList) {
                if(cS.getCategory().equals(category)){
                    // 把新对象加入哈希表
                    shopNameHashMap.put(category, cS);
                    componentShop = cS;
                    break;
                }
            }
        }
        return componentShop;
    }


}
