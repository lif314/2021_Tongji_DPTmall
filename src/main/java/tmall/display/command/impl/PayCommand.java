package tmall.display.command.impl;

import tmall.controller.orderController.ShoppingCenter;
import tmall.display.command.Command;

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

    @Override
    public Object[] execute(Object... args) {
        ((ShoppingCenter) super.getConcreteController()).payImmediately();
        return null;
    }
}
