package tmall.display.command.impl;


import tmall.display.command.Command;
import tmall.tmallSystem.TMallSystem;

import java.util.Scanner;

public class BuyerLoginCommand extends Command {
    private static BuyerLoginCommand buyerLoginCommand;

    private BuyerLoginCommand() {
        super.setCommandName("BuyerLoginCommand");
    }

    /**
     * 这里采用单例模式
     * @return LoginOrder对象
     */
    public static BuyerLoginCommand getBuyerLoginCommand() {
        if (buyerLoginCommand == null) {
            buyerLoginCommand = new BuyerLoginCommand();
        }
        return buyerLoginCommand;
    }

    @Override
    public Object[] execute(Object... args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入您的账号（Phone）：");
        String phone = scanner.next();
        System.out.print("请输入您的密码（Password）：");
        String password = scanner.next();
        return new Object[]{TMallSystem.buyerLogin(phone, password)};
    }
}
