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
            // 先尝试根据卖家Id展示卖家的所有店铺
            returnArgs = ((CommodityVenueController)super.getConcreteController()).shopDisplayInVenue((String) args[0]);
            // 如果返回值为空，则根据商品Id展示与之关联的店铺
            if (returnArgs.length == 0)
                returnArgs = new ShoppingCenter().displayShopCommodities((String) args[0]).toArray();
            return returnArgs;
        }
        return null;
    }
}
