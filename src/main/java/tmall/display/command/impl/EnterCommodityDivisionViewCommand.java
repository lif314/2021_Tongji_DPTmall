package tmall.display.command.impl;

import tmall.controller.impl.CommodityDisplayController;
import tmall.display.command.Command;

public class EnterCommodityDivisionViewCommand extends Command {
    private static EnterCommodityDivisionViewCommand enterCommodityDivisionViewCommand;

    private EnterCommodityDivisionViewCommand() {
        super.setCommandName("EnterCommodityDivisionCommand");
        super.addController(new CommodityDisplayController());
    }

    /**
     * 这里采用单例模式
     * @return InstructionOrder对象
     */
    public static EnterCommodityDivisionViewCommand getEnterCommodityDivisionViewCommand() {
        if (enterCommodityDivisionViewCommand == null) {
            enterCommodityDivisionViewCommand = new EnterCommodityDivisionViewCommand();
        }
        return enterCommodityDivisionViewCommand;
    }

    @Override
    public Object[] execute(Object... args) {
        if (super.getConcreteController() instanceof CommodityDisplayController){
            return ((CommodityDisplayController) super.getConcreteController()).commodityDivisionDisplay();
        }
        return null;
    }
}
