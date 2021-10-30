package tmall.display.command.impl;

import tmall.controller.orderController.ShoppingCenter;
import tmall.display.command.Command;

public class EnterActivityViewCommand extends Command {
    private static EnterActivityViewCommand enterActivityViewCommand;

    private EnterActivityViewCommand() {
        super.setCommandName("EnterActivityViewCommand");
        super.addController(new ShoppingCenter());
    }

    /**
     * 这里采用单例模式
     * @return InstructionOrder对象
     */
    public static EnterActivityViewCommand getEnterActivityViewCommand() {
        if (enterActivityViewCommand == null) {
            enterActivityViewCommand = new EnterActivityViewCommand();
        }
        return enterActivityViewCommand;
    }

    @Override
    public Object[] execute(Object... args) {
        if (super.getConcreteController() instanceof ShoppingCenter){
            return ((ShoppingCenter) super.getConcreteController()).displayActivities().toArray();
        }
        return null;
    }
}
