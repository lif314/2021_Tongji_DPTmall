package tmall.display.command.impl;

import tmall.controller.impl.CommodityDisplayController;
import tmall.controller.impl.CustomerServiceController;
import tmall.display.command.Command;

/**
 * @Description Command包为命令模式的实现类，包含一个父类Command，工厂类CommandFactory，以及其它具体的实现类
 * @author 王文炯
 * @version 1.0.0
 * @Description 本命令类对应命令Enter ServicePage，可进入某天猫购物节聊天页面
 */
public class EnterServiceViewCommand extends Command {
    private static EnterServiceViewCommand enterServiceViewCommand;

    private EnterServiceViewCommand() {
        super.setCommandName("EnterServiceViewCommand");
        super.addController(new CustomerServiceController());
    }

    /**
     * 这里采用单例模式
     * @return EnterServiceViewCommand对象
     */
    public static EnterServiceViewCommand getEnterServiceViewCommand() {
        if (enterServiceViewCommand == null) {
            enterServiceViewCommand = new EnterServiceViewCommand();
        }
        return enterServiceViewCommand;
    }

    /**
     * @Description 本方法被FrontController调用，采用适配器模式，对于FrontController都是调用execute方法，而该方法封装了不同Controller的不同方法
     * @Description 此方法的功能为进入天猫购物节聊天页面
     * @param args 命令行输入的参数
     * @return 本方法无返回值
     */
    @Override
    public Object[] execute(Object... args) {
        if (super.getConcreteController() instanceof CustomerServiceController){
           CustomerServiceController.execute();
        }
        return null;
    }
}
