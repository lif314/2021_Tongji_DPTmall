package tmall.display.command.impl;

import tmall.display.command.Command;
import tmall.display.view.View;
import tmall.tmallSystem.TMallSystem;

import java.util.Scanner;


/**
 * @Description Command包为命令模式的实现类，包含一个父类Command，工厂类CommandFactory，以及其它具体的实现类
 * @author 王文炯
 * @version 1.0.0
 * @Description 本命令类对应买家登录命令SellerLogin
 */
public class SellerLoginCommand extends Command {
    private static SellerLoginCommand sellerLoginCommander;

    private SellerLoginCommand() {
        super.setCommandName("SellerLoginCommand");
    }

    /**
     * 这里采用单例模式
     * @return LoginOrder对象
     */
    public static SellerLoginCommand getSellerLoginCommand() {
        if (sellerLoginCommander == null) {
            sellerLoginCommander = new SellerLoginCommand();
        }
        return sellerLoginCommander;
    }

    /**
     * @Description 本方法被FrontController调用，采用适配器模式，对于FrontController都是调用execute方法，而该方法封装了不同Controller的不同方法
     * @Description 此方法的功能为进行卖家登录
     * @param args 命令行输入的参数
     * @return 本方法返回卖家对象
     */
    @Override
    public Object[] execute(Object... args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入您的账号（name）：");
        String name = scanner.next();
        System.out.print("请输入您的密码（Password）：");
        String password = scanner.next();
        return new Object[]{TMallSystem.sellerLogin(name, password)};
    }
}
