package tmall.display.command;


import tmall.controller.Controller;

/**
 * @Description Command包为命令模式的实现类，包含一个父类Command，工厂类CommandFactory，以及其它具体的实现类
 * @author 王文炯
 * @version 1.0.0
 */
public abstract class Command {
    private String commandName;
    private String commandType;
    private Controller concreteController;

    public String getCommandName() {
        return commandName;
    }

    public void setCommandName(String orderType) {
        this.commandName = orderType;
    }

    public void addController(Controller concreteController) {
        this.concreteController = concreteController;
    }

    public String getCommandType() {
        return commandType;
    }

    public void setCommandType(String commandType) {
        this.commandType = commandType;
    }

    public Controller getConcreteController() {
        return concreteController;
    }
    /**
     * 调用对应Controller的execute()方法，获得需要展示的数据
     * @return 需要展示的数据（具体model的对象数组）
     */
    public Object[] execute(Object...args) {
        if (concreteController != null) {
            return concreteController.execute(args);
        } else {
            return null;
        }
    }
}
