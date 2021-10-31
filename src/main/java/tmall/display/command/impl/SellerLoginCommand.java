package tmall.display.command.impl;

import tmall.display.command.Command;
import tmall.display.view.View;
import tmall.tmallSystem.TMallSystem;

import java.util.Scanner;

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
