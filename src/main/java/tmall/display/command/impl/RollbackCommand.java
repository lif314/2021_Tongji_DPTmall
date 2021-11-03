package tmall.display.command.impl;

import tmall.controller.factory.UserManageAbstractFactory;
import tmall.controller.factory.UserManageProducer;
import tmall.controller.impl.BuyerInfoController;
import tmall.display.command.Command;
import tmall.tmallSystem.TMallSystem;

/**
 * @author 王文炯
 * @version 1.0.0
 * @Description Command包为命令模式的实现类，包含一个父类Command，工厂类CommandFactory，以及其它具体的实现类
 * @Description 本命令类对应买家命令RollbackCommand XXX，可回滚用户密码等属性，参数为属性值
 */
public class RollbackCommand extends Command {
    private static RollbackCommand rollbackCommand;

    private RollbackCommand() {
        super.setCommandName("RollbackCommand");
    }

    /**
     * @return RollbackCommand对象
     * @Description 获取RollbackCommand对象
     * 这里采用单例模式
     */
    public static RollbackCommand getRollbackCommand() {
        if (rollbackCommand == null) {
            rollbackCommand = new RollbackCommand();
        }
        return rollbackCommand;
    }


    /**
     * @param args 命令行输入的参数
     * @return 本方法无返回值
     * @Description 本方法被FrontController调用，采用适配器模式，对于FrontController都是调用execute方法，而该方法封装了不同Controller的不同方法
     * @Description 本命令的此方法的功能为回滚买家属性
     */
    @Override
    public Object[] execute(Object... args) {
        String params = (String) args[0];
        if (params.startsWith("BuyerInfo")&& TMallSystem.getBuyer()!=null){
            UserManageAbstractFactory userManageAbstractFactory = new UserManageProducer().getUserManageController("info");
            BuyerInfoController buyerInfoController = (BuyerInfoController) userManageAbstractFactory.getUserInfoController("buyer");
            buyerInfoController.rollbackEdite();
            System.out.println("买家信息回滚成功！");
        }
        return null;
    }
}
