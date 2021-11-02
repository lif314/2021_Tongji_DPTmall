package tmall.display.command.impl;

import tmall.controller.impl.CommodityVenueController;
import tmall.controller.impl.ShopController;
import tmall.controller.orderController.ShoppingCenter;
import tmall.display.command.Command;

/**
 * @Description Command包为命令模式的实现类，包含一个父类Command，工厂类CommandFactory，以及其它具体的实现类
 * @author 王文炯
 * @version 1.0.0
 * @Description 本命令类对应命令Enter VSXXXPage，可进入某个店铺的详情页，参数为商品Id或卖家Id
 */
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

    /**
     * @Description 本方法被FrontController调用，采用适配器模式，对于FrontController都是调用execute方法，而该方法封装了不同Controller的不同方法
     * @Description 此方法的功能为进入天猫购物节首页，显示首页所有商品
     * @param args 命令行输入的参数：商品Id或卖家Id或店铺Id
     * @return 本方法返回首页内所有商品对象
     */
    @Override
    public Object[] execute(Object... args) {
        Object[] returnArgs = null;
        if (super.getConcreteController() instanceof CommodityVenueController){
            // 先尝试根据卖家Id展示卖家的所有店铺
            returnArgs = ((CommodityVenueController)super.getConcreteController()).shopDisplayInVenue((String) args[0]);
            if (returnArgs.length == 0)
            // 如果返回值为空，则根据商品Id展示与之关联的店铺
                try {
                    returnArgs = new ShoppingCenter().displayShopCommodities((String) args[0]).toArray();
                } catch (Exception e) {
                    System.out.println("");
                }
            if (returnArgs.length == 0)
                returnArgs = new ShopController().execute((String) args[0]);
            return returnArgs;
        }
        return null;
    }
}
