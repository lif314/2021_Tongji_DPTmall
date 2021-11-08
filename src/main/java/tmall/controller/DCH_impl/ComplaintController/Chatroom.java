package tmall.controller.DCH_impl.ComplaintController;

import tmall.controller.Controller;
import tmall.model.entity.Buyer;
import tmall.model.entity.Shop;
import tmall.model.entityDao.daoImpl.BuyerDaoImpl;
import tmall.model.entityDao.daoImpl.ShopDaoImpl;
import tmall.model.entityDao.daoInterface.BuyerDao;
import tmall.model.entityDao.daoInterface.ShopDao;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Chatroom extends Controller {
    private static List<String> msg;
    private static List<String> reminder;
    static{
        msg=new ArrayList<>();
        reminder = new ArrayList<>();
    }

    public static void sendMessage(Object object, String name, String message){
//        System.out.println(name+"["+object.getClass().getSimpleName()+"] : "+message);
        msg.add(name+"["+object.getClass().getSimpleName()+"] : "+message);
    }

    /**
     * @Author Sir Lancelot
     * @Description 在消息队列中添加消息
     */
    public static void addMessage(String BuyerId, String ShopId, String type){
        ShopDao shopDao = new ShopDaoImpl();
        Shop shop = shopDao.getById(ShopId);
        BuyerDao buyerDao = new BuyerDaoImpl();
        List<Buyer> buyers = buyerDao.getAll();
        String bname = "";
        for(Buyer buyer:buyers){
            if(buyer.getBuyerId().equals(BuyerId)){
                bname = buyer.getNickname();
            }
        }
        if(Objects.equals(type, "1")){
            reminder.add("亲爱的顾客" + bname +"，您关注的店铺"+shop.getShopName()+"发布新活动啦，快去看看吧！");
        }else if (Objects.equals(type, "2")) {
            reminder.add("亲爱的顾客" + bname + "，您关注的店铺" + shop.getShopName() + "上架新商品啦，快去看看吧！");
        }
    }

    public static List<String> givebackMsg(){
        return msg;
    }

    public static Object[] giveMsg(){
        return msg.toArray();
    }

    public static List<String> showReminder(){
        return reminder;
    }
}
