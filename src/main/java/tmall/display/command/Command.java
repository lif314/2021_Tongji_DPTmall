package tmall.display.command;


import tmall.controller.Controller;

/**
 * 本类是一个抽象类，用于记录需要调用的命令的类型，对应一个方法名称或是一个类名，后期开发可根据命令类型调用制定的类的方法
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

    public Controller getConcreteController() {
        return concreteController;
    }

    public void setConcreteController(Controller concreteController) {
        this.concreteController = concreteController;
    }
}
