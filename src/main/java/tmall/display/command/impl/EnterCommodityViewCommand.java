package tmall.display.command.impl;

import tmall.controller.impl.CommodityDisplayController;
import tmall.controller.impl.CommodityVenueController;
import tmall.display.command.Command;
/**
 * @Description Command包为命令模式的实现类，包含一个父类Command，工厂类CommandFactory，以及其它具体的实现类
 * @author 王文炯
 * @version 1.0.0
 * @Description 本命令类对应买家命令Enter VCXXXPage，可进入商品详情页,参数为商品Id
 */
public class EnterCommodityViewCommand extends Command {
    private static EnterCommodityViewCommand enterCommodityViewCommand;

    private EnterCommodityViewCommand() {
        super.setCommandName("EnterCommodityViewCommand");
        super.addController(new CommodityDisplayController());
    }

    /**
     * 这里采用单例模式
     * @return InstructionOrder对象
     */
    public static EnterCommodityViewCommand getEnterCommodityViewCommand() {
        if (enterCommodityViewCommand == null) {
            enterCommodityViewCommand = new EnterCommodityViewCommand();
        }
        return enterCommodityViewCommand;
    }

    /**
     * @Description 本方法被FrontController调用，采用适配器模式，对于FrontController都是调用execute方法，而该方法封装了不同Controller的不同方法
     * @Description 此方法的功能为显示商品详情页
     * @param args 命令行输入的参数：商品ID
     * @return 本方法商品信息
     */
    @Override
    public Object[] execute(Object... args) {
        if (super.getConcreteController() instanceof CommodityDisplayController){
            return ((CommodityDisplayController)super.getConcreteController()).commodityDetailDisplay((String) args[0]);
        }
        return null;
    }
}
