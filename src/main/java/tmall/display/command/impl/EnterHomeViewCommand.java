package tmall.display.command.impl;

import tmall.controller.impl.CommodityDisplayController;
import tmall.controller.orderController.ShoppingCenter;
import tmall.display.command.Command;

/**
 * @Description Command包为命令模式的实现类，包含一个父类Command，工厂类CommandFactory，以及其它具体的实现类
 * @author 王文炯
 * @version 1.0.0
 * @Description 本命令类对应命令Enter HomePage，可进入某天猫购物节首页
 */
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

    /**
     * @Description 本方法被FrontController调用，采用适配器模式，对于FrontController都是调用execute方法，而该方法封装了不同Controller的不同方法
     * @Description 此方法的功能为进入天猫购物节首页，显示首页所有商品
     * @param args 命令行输入的参数
     * @return 本方法返回首页内所有商品对象
     */
    @Override
    public Object[] execute(Object... args) {
        if (super.getConcreteController() instanceof ShoppingCenter){
            return ((ShoppingCenter) super.getConcreteController()).displayCommodities().toArray();
        }
        return null;
    }
}
