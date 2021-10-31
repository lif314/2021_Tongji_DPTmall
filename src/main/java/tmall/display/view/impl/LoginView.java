package tmall.display.view.impl;



import tmall.display.command.impl.EnterHomeViewCommand;
import tmall.display.view.View;

public class LoginView extends View {

    @Override
    public Object show(Object...args) {
        if ((Boolean)args[0]){
            System.out.println("登录成功");
            System.out.println("欢迎进入天猫购物节主页");
            HomeView homeView = new HomeView();
            homeView.show(EnterHomeViewCommand.getEnterHomeViewCommand().execute());
            return true;
        }else{
            System.out.println("登陆失败");
            return false;
        }
    }


}
