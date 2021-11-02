package tmall.display.command.impl;


import tmall.display.command.Command;

/**
 * @Description Command包为命令模式的实现类，包含一个父类Command，工厂类CommandFactory，以及其它具体的实现类
 * @author 王文炯
 * @version 1.0.0
 * @Description 本命令类对应命令Instruction，作用为显示本项目支持的所有命令
 */
public class InstructionCommand extends Command {
    private static InstructionCommand instructionOrder;

    private InstructionCommand() {
        super.setCommandName("InstructionView");
    }

    /**
     * 这里采用单例模式
     * @return InstructionOrder对象
     */
    public static InstructionCommand getInstructionCommand() {
        if (instructionOrder == null) {
            instructionOrder = new InstructionCommand();
        }
        return instructionOrder;
    }

    /**
     * @Description 本方法被FrontController调用，采用适配器模式，对于FrontController都是调用execute方法，而该方法封装了不同Controller的不同方法
     * @Description 此方法的功能为进入天猫购物节首页，显示首页所有商品
     * @param args 命令行输入的参数
     * @return 本方法为空方法，不需要调用对应的Controller
     */
    @Override
    public Object[] execute(Object... args) {
        return null;
    }
}
