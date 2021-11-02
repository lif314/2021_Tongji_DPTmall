package tmall.display.command.impl;

import tmall.controller.impl.CommodityDisplayController;
import tmall.display.command.Command;

/**
 * @Description Command包为命令模式的实现类，包含一个父类Command，工厂类CommandFactory，以及其它具体的实现类
 * @author 王文炯
 * @version 1.0.0
 * @Description 本命令类对应买家命令Enter CommodityDivisionPage，可进入商品分区汇总页
 */
public class EnterCommodityDivisionViewCommand extends Command {
    private static EnterCommodityDivisionViewCommand enterCommodityDivisionViewCommand;

    private EnterCommodityDivisionViewCommand() {
        super.setCommandName("EnterCommodityDivisionCommand");
        super.addController(new CommodityDisplayController());
    }

    /**
     * 这里采用单例模式
     * @return InstructionOrder对象
     */
    public static EnterCommodityDivisionViewCommand getEnterCommodityDivisionViewCommand() {
        if (enterCommodityDivisionViewCommand == null) {
            enterCommodityDivisionViewCommand = new EnterCommodityDivisionViewCommand();
        }
        return enterCommodityDivisionViewCommand;
    }

    /**
     * @Description 本方法被FrontController调用，采用适配器模式，对于FrontController都是调用execute方法，而该方法封装了不同Controller的不同方法
     * @Description 此方法的功能为进入商品分区详情页
     * @param args 命令行输入的参数
     * @return 本方法返回所有商品分区
     */
    @Override
    public Object[] execute(Object... args) {
        if (super.getConcreteController() instanceof CommodityDisplayController){
            return ((CommodityDisplayController) super.getConcreteController()).commodityDivisionDisplay();
        }
        return null;
    }
}
