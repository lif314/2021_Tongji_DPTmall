package tmall;

import tmall.display.FrontController;
import tmall.display.command.Command;
import tmall.display.command.CommandFactory;
import tmall.model.entity.User;

import java.util.Scanner;

public class ApplicationStart {
    public static User user;

    public static void main(String[] args) {
        //添加需要用到的页面
        Scanner scanner = new Scanner(System.in);
        FrontController frontController = FrontController.getFrontController();
//        //显示登录界面
//        Command loginView = CommandFactory.getCommand("LoginCommand");
//        frontController.dispatchSingleCommand(loginView);
        //根据用户输入初始化为对应的用户对象
//        User user = getUser();
        //显示命令大全界面
//        Command orderView = CommandFactory.getCommand("InstructionCommand");
//        frontController.dispatchSingleCommand(orderView);
        // 项目主体
        while(true){
            String command = scanner.nextLine();
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
