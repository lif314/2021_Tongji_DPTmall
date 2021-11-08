package tmall.controller.impl;


import tmall.controller.Controller;

import java.util.Objects;
import java.util.Scanner;

/**
 * @author Strange
 * @date 2021/11/1 12:48
 * @description: 联系客服。装饰器模式，状态模式。
 */
public class CustomerServiceController extends Controller {

    public static void execute() {
        System.out.println("*****欢迎您进入天猫购物节聊天页面*****");
        String msg=null;
        while(!Objects.equals(msg, "quit")) {
            System.out.print("请输入您的聊天内容（输入quit退出）：");
            Scanner input = new Scanner(System.in);
            msg = input.nextLine();
            if(msg.equals("quit"))
                break;
            MessageChannel messageChannel = new MessageChannel();
            ClientMessage clientMessage = new ClientMessage(msg);
            ServerMessage serverMessage = new ServerMessage();

            messageChannel.putIntoChannel(clientMessage);
            messageChannel.send();

            serverMessage.getClientMessage(msg);
            messageChannel.putIntoChannel(serverMessage);
            messageChannel.send();
        }
    }
}
