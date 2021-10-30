package tmall.display.command.impl;

import tmall.controller.impl.CommodityDisplayController;
import tmall.controller.orderController.ShoppingCenter;
import tmall.display.command.Command;

public class EnterHomeViewCommand extends Command {
    private static EnterHomeViewCommand enterHomeViewCommand;

    private EnterHomeViewCommand() {
        super.setCommandName("EnterHomeViewCommand");
        super.addController(new ShoppingCenter());
    }

    /**
     * 这里采用单例模式
     * @return InstructionOrder对象
     */
    public static EnterHomeViewCommand getEnterHomeViewCommand() {
        if (enterHomeViewCommand == null) {
            enterHomeViewCommand = new EnterHomeViewCommand();
        }
        return enterHomeViewCommand;
    }

    @Override
    public Object[] execute(Object... args) {
        if (super.getConcreteController() instanceof ShoppingCenter){
            return ((ShoppingCenter) super.getConcreteController()).displayCommodities().toArray();
        }
        return null;
    }
}
