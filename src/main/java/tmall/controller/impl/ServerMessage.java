package tmall.controller.impl;

import tmall.controller.Message;

public class ServerMessage extends Message {

    private String clientMessage;

    public void getClientMessage(String cm) {
        clientMessage = cm;
    }

    @Override
    public String getMessage() {
        String replySomething = "抱歉，我听不懂你在说什么。";
        switch (clientMessage) {
            case "这瓜多少钱一斤啊？":
                Ask ask = new Ask();
                replySomething = ask.reply();
                break;
            case "你这瓜有问题啊。":
                Complain complain = new Complain();
                replySomething = complain.reply();
                break;
            case "你tm劈我瓜！":
                Swear swear = new Swear();
                replySomething = swear.reply();
                break;
        }

        return replySomething;
    }

    @Override
    public String whoSendMessage() {
        return "Server";
    }
}

//状态模式
class Ask {
    public String reply() {
        return "五块钱一斤。";
    }
}
class Complain {
    public String reply() {
        return "这挂要是不熟，我自己吞进去。";
    }
}
class Swear {
    public String reply() {
        return "萨日朗！萨日朗！";
    }
}
