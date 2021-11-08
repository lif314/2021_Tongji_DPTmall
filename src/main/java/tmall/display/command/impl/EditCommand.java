package tmall.display.command.impl;

import tmall.controller.factory.AbstractFactory;
import tmall.controller.factory.FactoryProducer;
import tmall.controller.impl.BuyerInfoController;
import tmall.controller.impl.CartController;
import tmall.controller.impl.FavoriteController;
import tmall.controller.orderController.ShoppingCenter;
import tmall.display.command.Command;
import tmall.model.entity.User;
import tmall.tmallSystem.TMallSystem;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author 王文炯
 * @version 1.0.0
 * @Description Command包为命令模式的实现类，包含一个父类Command，工厂类CommandFactory，以及其它具体的实现类
 * @Description 本命令类对应买家命令Edit XXX，可修改用户密码等属性
 */
public class EditCommand extends Command {
    private static EditCommand editCommand;

    private EditCommand() {
        super.setCommandName("EditCommand");
    }

    /**
     * @return EditCommand对象
     * @Description 获取EditCommand对象
     * 这里采用单例模式
     */
    public static EditCommand getEditCommand() {
        if (editCommand == null) {
            editCommand = new EditCommand();
        }
        return editCommand;
    }


    /**
     * @param args 命令行输入的参数
     * @return 本方法无返回值
     * @Description 本方法被FrontController调用，采用适配器模式，对于FrontController都是调用execute方法，而该方法封装了不同Controller的不同方法
     * @Description 本命令的此方法的功能为修改用户或商品属性
     */
    @Override
    public Object[] execute(Object... args) {
        String params = (String) args[0];
        if (params.startsWith("BuyerInfo") && TMallSystem.getBuyer() != null) {
            String password = params.substring(19, params.length());
            AbstractFactory userInfoControllerFactory = FactoryProducer.getFactory("info");
            BuyerInfoController buyerInfoController = (BuyerInfoController) userInfoControllerFactory.getUserInfoController("buyer");
            buyerInfoController.editBuyerPassword(TMallSystem.getBuyer().getBuyerId(), password);
            System.out.println("密码修改成功！");
        } else if (params.startsWith("CommodityCount")) {
            String[] split = params.substring(15, params.length()).split("\\*");
            String commodityId = split[0];
            String count = split[1];
            new CartController().editCommodityInfo(count,commodityId,TMallSystem.getBuyer().getBuyerId());
            System.out.println("修改商品数量成功");
        }
        return null;
    }
}
