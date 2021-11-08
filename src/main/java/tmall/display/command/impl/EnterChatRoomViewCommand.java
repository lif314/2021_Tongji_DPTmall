package tmall.display.command.impl;

import tmall.controller.DCH_impl.ComplaintController.Chatroom;
import tmall.display.command.Command;

/**
 * @Description Command包为命令模式的实现类，包含一个父类Command，工厂类CommandFactory，以及其它具体的实现类
 * @author 王文炯
 * @version 1.0.0
 * @Description 本命令类对应买家命令Enter ChatRoom，可进入聊天界面
 */
public class EnterChatRoomViewCommand extends Command {
    private static EnterChatRoomViewCommand enterChatRoomViewCommand;

    private EnterChatRoomViewCommand() {
        super.setCommandName("EnterChatRoomViewCommand");
    }

    /**
     * 这里采用单例模式
     * @return EnterChatRoomViewCommand对象
     */
    public static EnterChatRoomViewCommand getEnterChatRoomViewCommand() {
        if (enterChatRoomViewCommand == null) {
            enterChatRoomViewCommand = new EnterChatRoomViewCommand();
        }
        return enterChatRoomViewCommand;
    }

    /**
     * @Description 本方法被FrontController调用，采用适配器模式，对于FrontController都是调用execute方法，而该方法封装了不同Controller的不同方法
     * @Description 此方法的功能为进入聊天室界面
     * @param args 命令行输入的参数
     * @return 无返回值
     */
    @Override
    public Object[] execute(Object... args) {
        return Chatroom.showReminder().toArray();
    }
}
