package tmall.display.command.impl;

import tmall.controller.impl.CommodityDisplayController;
import tmall.display.command.Command;

/**
 * @Description Command包为命令模式的实现类，包含一个父类Command，工厂类CommandFactory，以及其它具体的实现类
 * @author 王文炯
 * @version 1.0.0
 * @Description 本命令类对应买家命令Enter VDXXXPage，可进入某一分区详情页,参数为商品Id
 */
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

    /**
     * @Description 本方法被FrontController调用，采用适配器模式，对于FrontController都是调用execute方法，而该方法封装了不同Controller的不同方法
     * @Description 此方法的功能为根据商品ID进入该商品所属分区详情页
     * @param args 命令行输入的参数：商品ID
     * @return 本方法返回分区内所有商品
     */
    @Override
    public Object[] execute(Object... args) {
        if (super.getConcreteController() instanceof CommodityDisplayController){
            return ((CommodityDisplayController) super.getConcreteController()).commodityDisplayInDivision((String) args[0]);
        }
        return null;
    }
}
