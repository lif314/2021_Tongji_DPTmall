package tmall.display.command.impl;

import tmall.controller.Controller;
import tmall.controller.DCH_impl.ComplaintController.ComplaintController;
import tmall.controller.DCH_impl.VerifyLevelController.VerifyLevelController;
import tmall.display.command.Command;
import tmall.tmallSystem.TMallSystem;

import java.util.HashMap;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName ComplaintCommand.java
 * @Description TODO
 * @createTime 2021年11月02日 20:51:00
 */
public class ComplaintCommand extends Command {
    private static ComplaintCommand complaintCommand;
    private static HashMap<String, Controller> controllerHashMap=new HashMap<>();

    private ComplaintCommand() {
        super.setCommandName("ComplaintCommand");
        super.addController(new ComplaintController());
    }

    /**
     * 这里采用单例模式
     * @return ComplaintCommand对象
     */
    public static ComplaintCommand getComplaintCommand() {
        if (complaintCommand == null) {
            complaintCommand = new ComplaintCommand();
        }
        return complaintCommand;
    }

    /**
     * @Description 本方法被FrontController调用，采用适配器模式，对于FrontController都是调用execute方法，而该方法封装了不同Controller的不同方法
     * @Description 此方法的功能为用户投诉
     * @param args 命令行输入的参数
     * @return 本方法无返回值
     */
    @Override
    public Object[] execute(Object... args) {
        String params =(String) args[0];
        if (TMallSystem.getBuyer()!=null) {
            ((ComplaintController)super.getConcreteController()).buyerComplaint(TMallSystem.getBuyer());
        } else {
            System.out.println("您还未登录，不能投诉！");
        }
        return null;
    }
}
