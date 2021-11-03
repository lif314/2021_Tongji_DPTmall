package tmall.controller.DCH_impl.ComplaintController;

import tmall.model.entity.Shop;
import tmall.model.entityDao.daoImpl.ShopDaoImpl;
import tmall.model.entityDao.daoInterface.ShopDao;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Chatroom {
    private static List<String> msg;

    static{
        msg=new ArrayList<>();
    }

    public static void sendMessage(Object object, String name, String message){
//        System.out.println(name+"["+object.getClass().getSimpleName()+"] : "+message);
        msg.add(name+"["+object.getClass().getSimpleName()+"] : "+message);
    }

    public static void addMessage(String BuyerId, String ShopId, String type){
        ShopDao shopDao = new ShopDaoImpl();
        Shop shop = shopDao.getById(ShopId);
        if(Objects.equals(type, "1")){
            msg.add("亲爱的顾客"+BuyerId+"，您关注的店铺"+shop.getShopName()+"发布新活动啦，快去看看吧！");
        }else if (Objects.equals(type, "2")) {
            msg.add("亲爱的顾客" + BuyerId + "，您关注的店铺" + shop.getShopName() + "上架新商品啦，快去看看吧！");
        }
    }

    public static List<String> givebackMsg(){
        return msg;
    }

    public static Object[] giveMsg(){
        return msg.toArray();
    }
}
