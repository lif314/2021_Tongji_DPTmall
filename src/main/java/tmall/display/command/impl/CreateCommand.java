package tmall.display.command.impl;

import tmall.controller.orderController.ShoppingCenter;
import tmall.display.command.Command;
import tmall.model.entity.Order;
import tmall.model.logicalEntity.OrderLogic;
import tmall.tmallSystem.TMallSystem;

public class CreateCommand extends Command {
    private static CreateCommand createCommand;

    private CreateCommand() {
        super.setCommandName("CreateCommand");
        super.addController(new ShoppingCenter());
    }

    /**
     * 这里采用单例模式
     * @return CreateCommand对象
     */
    public static CreateCommand getCreateCommand() {
        if (createCommand == null) {
            createCommand = new CreateCommand();
        }
        return createCommand;
    }

    @Override
    public Object[] execute(Object... args) {
        String params =(String) args[0];
        if ("Order".equals(params)){
            OrderLogic orderLogic = ((ShoppingCenter) super.getConcreteController()).displayOrderDetail(TMallSystem.getBuyer().getBuyerId());
            System.out.println(orderLogic);
        }
        return null;
    }
}
