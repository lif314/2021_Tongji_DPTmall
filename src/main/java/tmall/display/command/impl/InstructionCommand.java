package tmall.display.command.impl;


import tmall.display.command.Command;

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
}
