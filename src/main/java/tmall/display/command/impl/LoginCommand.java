package tmall.display.command.impl;


import tmall.display.command.Command;

public class LoginCommand extends Command {
    private static LoginCommand loginOrder;

    private LoginCommand() {
        addController(new SellerController());
        super.setCommandName("LoginView");
    }

    /**
     * 这里采用单例模式
     * @return LoginOrder对象
     */
    public static LoginCommand getLoginCommand() {
        if (loginOrder == null) {
            loginOrder = new LoginCommand();
        }
        return loginOrder;
    }
}
