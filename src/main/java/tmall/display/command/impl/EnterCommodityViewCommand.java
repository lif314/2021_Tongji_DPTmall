package tmall.display.command.impl;

import tmall.display.command.Command;

public class EnterCommodityViewCommand extends Command {
    private static EnterCommodityViewCommand enterCommodityViewCommand;

    private EnterCommodityViewCommand() {
        super.setCommandName("EnterCommodityViewCommand");
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

    @Override
    public Object[] execute(Object... args) {
        System.out.println("EnterCommodityViewCommand被调用了");
        return null;
    }
}
