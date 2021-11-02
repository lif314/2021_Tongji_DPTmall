package tmall.controller.DCH_impl;

import org.junit.Test;
import tmall.controller.DCH_impl.ComplaintController.AbstractComplaint;
import tmall.controller.DCH_impl.ComplaintController.Chatroom;
import tmall.controller.DCH_impl.ComplaintController.ComplaintChain;
import tmall.controller.DCH_impl.ComponentShopCreationController.ComponentShopCreationController;
import tmall.controller.DCH_impl.ShopDisplayController.ShopDisplayController;
import tmall.controller.DCH_impl.VerifyLevelController.Administrator;
import tmall.controller.DCH_impl.VerifyLevelController.CommunicationService;
import tmall.controller.DCH_impl.VerifyLevelController.VerifyLevelService;

import java.util.Scanner;

public class TestDemo {

    @Test
    public void test1(){
        while(true){
            Scanner sc=new Scanner(System.in);
            System.out.println("创建店铺");
            System.out.println("1. 创建总店");
            System.out.println("2. 创建分店");
            System.out.println("3. 创建加盟店");
            System.out.println("4. 完成创建");
            System.out.print("请输入创建指令：");
            String createOrder=sc.nextLine();

            ComponentShopCreationController cscc=new ComponentShopCreationController();

            int stop=0;

            switch (createOrder){
                case "1":
                case "2":
                    cscc.createShop(createOrder,"");
                    break;
                case "3":
                    Scanner sc1=new Scanner(System.in);
                    System.out.print("请输入依附的分店名称：");
                    String bShopName=sc1.nextLine();
                    cscc.createShop(createOrder,bShopName);
                    break;
                case "4":
                    stop=1;
                default:
                    break;
            }
            if(stop==1){break;}
            System.out.println();
        }

        System.out.println();
        System.out.println("显示店铺：");
        System.out.println();
        ShopDisplayController sdc=new ShopDisplayController();
        sdc.shopInfoDisplay_Process("0002","iTongji-Jiading");
        sdc.shopInfoDisplay_Process("0001","iTongji-Jiading");

    }

    public void createComponentShop(){
        while(true){
            Scanner sc=new Scanner(System.in);
            System.out.println("创建店铺");
            System.out.println("1. 创建总店");
            System.out.println("2. 创建分店");
            System.out.println("3. 创建加盟店");
            System.out.println("4. 完成创建");
            System.out.print("请输入创建指令：");
            String createOrder=sc.nextLine();

            ComponentShopCreationController cscc=new ComponentShopCreationController();

            int stop=0;

            switch (createOrder){
                case "1":
                case "2":
                    cscc.createShop(createOrder,"");
                    break;
                case "3":
                    Scanner sc1=new Scanner(System.in);
                    System.out.print("请输入依附的分店名称：");
                    String bShopName=sc1.nextLine();
                    cscc.createShop(createOrder,bShopName);
                    break;
                case "4":
                    stop=1;
                default:
                    break;
            }
            if(stop==1){break;}
            System.out.println();
        }

        System.out.println();
        System.out.println("显示店铺：");
        System.out.println();
        ShopDisplayController sdc=new ShopDisplayController();
        sdc.shopInfoDisplay_Process("0002","iTongji-Jiading");
        sdc.shopInfoDisplay_Process("0001","iTongji-Jiading");
    }

    @Test
    public void test2(){

        Scanner sc=new Scanner(System.in);
        System.out.println("作为卖家，您可以：");
        System.out.println("1. 创建店铺");
        System.out.println("2. 申请精英卖家");
        System.out.print("请输入指令：");
        String sellerOrder=sc.nextLine();
        System.out.println();

        switch(sellerOrder){
            case "1":
                createComponentShop();
                break;
            case "2":
                askforElite();
            default:
                break;
        }

    }

    public void askforElite(){
        //需要一个天猫平台
        Tmall t1=new Tmall();

        //准备进行命令/雇工模式
        CommunicationService verifyLevelService=new VerifyLevelService(t1);

        Administrator trans1=new Administrator(verifyLevelService);

        trans1.verifyLevelServiceExecute("0001", 2); //需要Model进行更改
    }

    @Test
    public void test3(){
        AbstractComplaint buyerComplaint= ComplaintChain.getChain();
        System.out.print("请输入您希望的投诉对象：1.商品 2.卖家：");
        Scanner sc=new Scanner(System.in);
        String line1=sc.nextLine();
        int objComplaint=Integer.parseInt(line1);

        int cpObj=Integer.parseInt(line1);

        System.out.print("请输入您的投诉内容：");
        sc=new Scanner(System.in);
        String line2=sc.nextLine();

        Chatroom.sendMessage(new Tmall(),"buyer.getNickname()",line2);

        buyerComplaint.checkChain(cpObj);

        System.out.println();

        for(int i=0;i<Chatroom.givebackMsg().size();i++){
            System.out.println(Chatroom.givebackMsg().get(i));
        }
    }


    public static void main(String[] args) {

    }
}
