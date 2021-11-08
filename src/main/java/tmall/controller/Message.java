package tmall.controller;

public abstract class Message extends Controller{

    public void send() {
        System.out.println(getMessage());
    }

    public String whoSendMessage() {
        return null;
    }

    //template method
    public abstract String getMessage();
}
