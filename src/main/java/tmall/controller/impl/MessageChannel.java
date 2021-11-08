package tmall.controller.impl;

import tmall.controller.Message;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MessageChannel extends Message {

    private Message message;
    private final Calendar calendar= Calendar.getInstance();
    private final SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd :hh:mm:ss");


    public void putIntoChannel(Message m) {
        this.message = m;
    }

    @Override
    public String getMessage() {
        String messageInChannel;
        String saySomething = message.getMessage();
        messageInChannel = message.whoSendMessage() + ": " + saySomething + "----at " + dateFormat.format(calendar.getTime());
        return messageInChannel;
    }
}
