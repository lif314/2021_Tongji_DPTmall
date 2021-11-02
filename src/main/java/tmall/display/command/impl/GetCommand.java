package tmall.display.command.impl;

import tmall.controller.Controller;
import tmall.controller.DCH_impl.ComponentShopCreDisController;
import tmall.controller.DCH_impl.VerifyLevelController.VerifyLevelController;
import tmall.controller.orderController.ShoppingCenter;
import tmall.display.command.Command;
import tmall.model.logicalEntity.OrderLogic;
import tmall.tmallSystem.TMallSystem;

import java.util.HashMap;

/**
 * @Description Command包为命令模式的实现类，包含一个父类Command，工厂类CommandFactory，以及其它具体的实现类
 * @author 王文炯
 * @version 1.0.0
 * @Description 本命令类对应卖家获取认证，Get VerifyCitation
 */
public class GetCommand extends Command {
    private static GetCommand getCommand;
    private static HashMap<String, Controller> controllerHashMap=new HashMap<>();

    private GetCommand() {
        super.setCommandName("GetCommand");
        super.addController(new VerifyLevelController());
    }

    /**
     * 这里采用单例模式
     * @return GetCommand对象
     */
    public static GetCommand getGetCommand() {
        if (getCommand == null) {
            getCommand = new GetCommand();
        }
        return getCommand;
    }

    /**
     * @Description 本方法被FrontController调用，采用适配器模式，对于FrontController都是调用execute方法，而该方法封装了不同Controller的不同方法
     * @Description 此方法的功能为创建订单
     * @param args 命令行输入的参数
     * @return 本方法无返回值
     */
    @Override
    public Object[] execute(Object... args) {
        String params =(String) args[0];
       if("VerifyCitation".equals(params)&& TMallSystem.getSeller()!=null){
            ((VerifyLevelController)super.getConcreteController()).askforElite();
        }
        return null;
    }
}
