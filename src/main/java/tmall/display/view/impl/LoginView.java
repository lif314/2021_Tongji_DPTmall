package tmall.display.view.impl;



import tmall.display.view.View;

public class LoginView extends View {

    @Override
    public Object show(Object...args) {
        if ((int)args[0]==1){
            System.out.println("登录成功");
            return true;
        }else{
            System.out.println("登陆失败");
            return false;
        }
    }


}
