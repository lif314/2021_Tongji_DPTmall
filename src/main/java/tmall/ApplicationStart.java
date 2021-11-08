package tmall;

import tmall.display.FrontController;
import tmall.display.command.Command;
import tmall.display.command.CommandFactory;
import tmall.display.dispatcher.Dispatcher;
import tmall.model.entity.User;
import tmall.tmallSystem.TMallSystem;

import java.util.Objects;
import java.util.Scanner;

public class ApplicationStart {
    public static User user;

    public static void main(String[] args) {
        System.out.println("*********欢迎您来到天猫购物节！(Exit退出)*********");
        System.out.println("请选择您的登录身份(BuyerLogin/SellerLogin)");
        //添加需要用到的页面
        Scanner scanner = new Scanner(System.in);
        FrontController frontController = FrontController.getFrontController();
        String command = "";
        while(true){
            System.out.print("Command>>");
            command = scanner.nextLine();
            if (Objects.equals(command, "Exit")) {
                System.out.println("bye");
                break;
            }
            frontController.dispatchSingleCommand(command);
        }
    }


    /**
     * 用于初始化user，标识用户身份
     * @return 根据用户的选择返回卖家或买家对象
     */
    public static User getUser(){
        Scanner scanner = new Scanner(System.in);
        String identify = scanner.next();
        Class<?> aClass=null;
        User user=null;
        try {
            aClass = Class.forName("tmall.model.entity."+identify);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            user = (User)aClass.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return user;
    }



}
