package tmall.display.command.impl;

import tmall.controller.impl.CommodityDisplayController;
import tmall.controller.impl.CommodityVenueController;
import tmall.display.command.Command;

public class EnterCommodityViewCommand extends Command {
    private static EnterCommodityViewCommand enterCommodityViewCommand;

    private EnterCommodityViewCommand() {
        super.setCommandName("EnterCommodityViewCommand");
        super.addController(new CommodityDisplayController());
    }

    /**
     * 这里采用单例模式
     * @return InstructionOrder对象
     */
    public static EnterCommodityViewCommand getEnterCommodityViewCommand() {
        if (enterCommodityViewCommand == null) {
            enterCommodityViewCommand = new EnterCommodityViewCommand();
        }
        return enterCommodityViewCommand;
    }

    @Override
    public Object[] execute(Object... args) {
        if (super.getConcreteController() instanceof CommodityDisplayController){
            return ((CommodityDisplayController)super.getConcreteController()).commodityDetailDisplay((String) args[0]);
        }
        return null;
    }
}
