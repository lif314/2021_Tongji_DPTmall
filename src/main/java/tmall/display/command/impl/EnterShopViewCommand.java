package tmall.display.command.impl;

import tmall.controller.impl.CommodityDisplayController;
import tmall.controller.impl.CommodityVenueController;
import tmall.display.command.Command;

public class EnterShopViewCommand extends Command {
    private static EnterShopViewCommand enterShopViewCommand;

    private EnterShopViewCommand() {
        super.setCommandName("EnterShopViewCommand");
        super.addController(new CommodityVenueController());
    }

    public static EnterShopViewCommand getEnterShopViewCommand() {
        if (enterShopViewCommand == null) {
            enterShopViewCommand = new EnterShopViewCommand();
        }
        return enterShopViewCommand;
    }

    @Override
    public Object[] execute(Object... args) {
        if (super.getConcreteController() instanceof CommodityVenueController){
            return ((CommodityVenueController)super.getConcreteController()).shopDisplayInVenue((String) args[0]);
        }
        return null;
    }
}
