package tmall.controller.impl;

import tmall.controller.Message;

public class ClientMessage extends Message {

    private String saySomething;

    public ClientMessage(String msg) {
        this.saySomething = msg;
    }

    @Override
    public String getMessage() {
        return saySomething;
    }

    @Override
    public String whoSendMessage() {
        return "Client";
    }
}
