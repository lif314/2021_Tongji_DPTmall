package tmall.display.command.impl;

import tmall.controller.Controller;
import tmall.controller.DCH_impl.ComponentShopCreDisController;
import tmall.controller.orderController.ShoppingCenter;
import tmall.display.command.Command;
import tmall.model.logicalEntity.OrderLogic;
import tmall.tmallSystem.TMallSystem;

import java.util.HashMap;
import java.util.List;

/**
 * @Description Command包为命令模式的实现类，包含一个父类Command，工厂类CommandFactory，以及其它具体的实现类
 * @author 王文炯
 * @version 1.0.0
 * @Description 本命令类对应买家生成订单命令，Create OrderDetail
 */
public class CreateCommand extends Command {
    private static CreateCommand createCommand;
    private static HashMap<String,Controller> controllerHashMap=new HashMap<>();

    private CreateCommand() {
        super.setCommandName("CreateCommand");
        super.addController(new ShoppingCenter());
        controllerHashMap.put("ComponentShopCreDisController",new ComponentShopCreDisController());
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

    /**
     * @Description 本方法被FrontController调用，采用适配器模式，对于FrontController都是调用execute方法，而该方法封装了不同Controller的不同方法
     * @Description 此方法的功能为创建订单
     * @param args 命令行输入的参数
     * @return 本方法无返回值
     */
    @Override
    public Object[] execute(Object... args) {
        String params =(String) args[0];
        if ("Order".equals(params)){
            OrderLogic orderLogic = ((ShoppingCenter) super.getConcreteController()).displayOrderDetail(TMallSystem.getBuyer().getBuyerId());
            System.out.println(orderLogic);
        } else if("Shop".equals(params)&& TMallSystem.getSeller()!=null){
            ((ComponentShopCreDisController)controllerHashMap.get("ComponentShopCreDisController")).createComponentShop_Process();
        }
        return null;
    }
}
