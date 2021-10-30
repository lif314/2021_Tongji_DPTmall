package tmall.display.command.impl;

import tmall.controller.impl.CommodityDisplayController;
import tmall.controller.impl.CommodityVenueController;
import tmall.controller.orderController.ShoppingCenter;
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
        Object[] returnArgs = null;
        if (super.getConcreteController() instanceof CommodityVenueController){
            returnArgs = ((CommodityVenueController)super.getConcreteController()).shopDisplayInVenue((String) args[0]);
            if (returnArgs.length == 0)
                returnArgs = new ShoppingCenter().displayShopCommodities((String) args[0]).toArray();
            return returnArgs;
        }
        return null;
    }
}
