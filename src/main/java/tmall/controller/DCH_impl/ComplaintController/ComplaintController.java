package tmall.controller.DCH_impl.ComplaintController;

import tmall.controller.Controller;
import tmall.model.entity.Buyer;

import java.util.Scanner;

/**
 * @description: 买家投诉Controller
 */
public class ComplaintController extends Controller {
    /**
     * @param : Buyer buyer，将唯一的buyer对象作为参数传入（但也可以方法内部获得）
     *          还需输入投诉指令complainObj，1表示向卖家投诉商品，2表示向天猫平台投诉卖家
     *          最后需要输入投诉内容complainContext
     */
    public void buyerComplaint(Buyer buyer){
        System.out.print("请输入您希望投诉的对象：1. 商品 2. 卖家 ：");
        Scanner sc1=new Scanner(System.in);
        String complainObj=sc1.nextLine();

        System.out.print("请输入您的投诉内容 ：");
        Scanner sc2=new Scanner(System.in);
        String complainContext=sc2.nextLine();

        AbstractComplaint buyerComplaint= ComplaintChain.getChain();  //创建责任链
        int cpObj=Integer.parseInt(complainObj);  //投诉指令

        Chatroom.sendMessage(buyer,buyer.getNickname(),complainContext);  //顾客进行投诉
        buyerComplaint.checkChain(cpObj);  //进入责任链

        // 打开投诉聊天室，查看内容
        System.out.println();
        for(int i=0;i<Chatroom.givebackMsg().size();i++){
            System.out.println(Chatroom.givebackMsg().get(i));
        }
        Chatroom.givebackMsg().clear();
    }
}
