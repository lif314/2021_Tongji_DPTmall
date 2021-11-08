package tmall.display.command.impl;

import tmall.controller.orderController.ShoppingCenter;
import tmall.display.command.Command;

/**
 * @Description Command包为命令模式的实现类，包含一个父类Command，工厂类CommandFactory，以及其它具体的实现类
 * @author 王文炯
 * @version 1.0.0
 * @Description 本命令类对应命令Pay，作用为支付当前订单
 */
public class PayCommand extends Command {
    private static PayCommand payCommand;

    private PayCommand() {
        super.setCommandName("PayCommand");
        super.addController(new ShoppingCenter());
    }

    /**
     * 这里采用单例模式
     * @return PayCommand对象
     */
    public static PayCommand getPayCommand() {
        if (payCommand == null) {
            payCommand = new PayCommand();
        }
        return payCommand;
    }

    /**
     * @Description 本方法被FrontController调用，采用适配器模式，对于FrontController都是调用execute方法，而该方法封装了不同Controller的不同方法
     * @Description 此方法的功能为支付当前订单
     * @param args 命令行输入的参数
     * @return 本方法无返回值
     */
    @Override
    public Object[] execute(Object... args) {
        System.out.println("支付成功！");
        ((ShoppingCenter) super.getConcreteController()).payImmediately();
        return null;
    }
}
