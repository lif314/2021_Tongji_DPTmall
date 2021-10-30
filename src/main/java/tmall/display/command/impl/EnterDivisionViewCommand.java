package tmall.display.command.impl;

import tmall.controller.impl.CommodityDisplayController;
import tmall.display.command.Command;

public class EnterDivisionViewCommand extends Command {
    private static EnterDivisionViewCommand enterDivisionViewCommand;

    private EnterDivisionViewCommand() {
        super.setCommandName("EnterDivisionViewCommand");
        super.addController(new CommodityDisplayController());
    }

    /**
     * 这里采用单例模式
     * @return InstructionOrder对象
     */
    public static EnterDivisionViewCommand getEnterDivisionViewCommand() {
        if (enterDivisionViewCommand == null) {
            enterDivisionViewCommand = new EnterDivisionViewCommand();
        }
        return enterDivisionViewCommand;
    }

    @Override
    public Object[] execute(Object... args) {
        if (super.getConcreteController() instanceof CommodityDisplayController){
            return ((CommodityDisplayController) super.getConcreteController()).commodityDisplayInDivision((String) args[0]);
        }
        return null;
    }
}
