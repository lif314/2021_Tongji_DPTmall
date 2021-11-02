package tmall.display.command.impl;

import tmall.controller.orderController.ShoppingCenter;
import tmall.display.command.Command;

/**
 * @Description Command包为命令模式的实现类，包含一个父类Command，工厂类CommandFactory，以及其它具体的实现类
 * @author 王文炯
 * @version 1.0.0
 * @Description 本命令对应买家命令Enter ActivityPage，可进入活动详情页
 */
public class EnterActivityViewCommand extends Command {
    private static EnterActivityViewCommand enterActivityViewCommand;

    private EnterActivityViewCommand() {
        super.setCommandName("EnterActivityViewCommand");
        super.addController(new ShoppingCenter());
    }

    /**
     * 这里采用单例模式
     * @return InstructionOrder对象
     */
    public static EnterActivityViewCommand getEnterActivityViewCommand() {
        if (enterActivityViewCommand == null) {
            enterActivityViewCommand = new EnterActivityViewCommand();
        }
        return enterActivityViewCommand;
    }

    /**
     * @Description 本方法被FrontController调用，采用适配器模式，对于FrontController都是调用execute方法，而该方法封装了不同Controller的不同方法
     * @Description 此方法的功能为进入活动详情页
     * @param args 命令行输入的参数
     * @return 本方法某个活动的所有信息
     */
    @Override
    public Object[] execute(Object... args) {
        if (super.getConcreteController() instanceof ShoppingCenter){
            return ((ShoppingCenter) super.getConcreteController()).displayActivities().toArray();
        }
        return null;
    }
}
