package tmall.controller.DCH_impl.ComplaintController;

import java.util.ArrayList;
import java.util.List;

public class Chatroom {
    private static List<String> msg;

    static{
        msg=new ArrayList<>();
    }

    public static void sendMessage(Object object, String name, String message){
//        System.out.println(name+"["+object.getClass().getSimpleName()+"] : "+message);
        msg.add(name+"["+object.getClass().getSimpleName()+"] : "+message);
    }

    public static Object[] giveMsg(){
        return msg.toArray();
    }
    public static List<String> givebackMsg(){return msg;}
}
