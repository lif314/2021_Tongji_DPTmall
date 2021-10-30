package tmall.display.command.impl;

import tmall.controller.impl.CommodityDisplayController;
import tmall.controller.orderController.ShoppingCenter;
import tmall.display.command.Command;

public class SelectCommand extends Command {
    private static SelectCommand selectCommand;

    private SelectCommand() {
        super.setCommandName("SelectCommand");
        super.addController(new ShoppingCenter());
    }

    /**
     * 这里采用单例模式
     *
     * @return InstructionOrder对象
     */
    public static SelectCommand getSelectCommand() {
        if (selectCommand == null) {
            selectCommand = new SelectCommand();
        }
        return selectCommand;
    }

    @Override
    public Object[] execute(Object... args) {
        if (super.getConcreteController() instanceof ShoppingCenter) {
            String[] commodityAndCount = ((String) args[0]).split("\\*");
            String commodityId = commodityAndCount[0];
            String account;
            if (commodityAndCount.length > 1) {
                account = commodityAndCount[1];
            } else {
                account = "1";
            }
            ((ShoppingCenter) super.getConcreteController()).selectCommodity(commodityId, account);
        }
        return null;
    }
}