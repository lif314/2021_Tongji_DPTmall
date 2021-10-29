package tmall.display.dispatcher;


import tmall.display.view.View;
import tmall.display.view.impl.CommodityView;
import tmall.display.view.impl.InstructionView;
import tmall.display.view.impl.LoginView;

import java.util.HashMap;

public class Dispatcher {
    private static Dispatcher dispatcher;
    private HashMap<String, View> views;

    private Dispatcher() {
        views = new HashMap<String, View>();
        addViews();
    }

    public static Dispatcher getDispatcher() {
        if (dispatcher == null) {
            dispatcher = new Dispatcher();
        }
        return dispatcher;
    }

    public void addViews(){
        InstructionView instructionView = new InstructionView();
        LoginView loginView = new LoginView();
        CommodityView commodityView = new CommodityView();
        this.addView("CommodityView",commodityView);
        this.addView("LoginView",loginView);
        this.addView("InstructionView", instructionView);
    }

    /**
     * 本方法用于进行页面对象的添加
     *
     * @param viewName 需要绑定的页面对象的名称
     * @param view     需要绑定的页面对象
     * @return 1为添加成功，-1为添加失败
     */
    public int addView(String viewName, View view) {
        if (view != null) {
            Class<?> aClass = null;
            try {
                aClass = Class.forName("tmall.display.view.impl." + viewName);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            if (aClass != null && aClass == view.getClass()) {
                views.put(viewName, view);
                return 1;
            }
        }
        return -1;
    }

    /**
     * 本方法用于调用指定页面进行展示，使用逻辑为:根据传入的页面名字查找相应的页面对象，并调用其show函数进行逻辑展示
     *
     * @param viewName 需要调用的页面对象的名称
     */
    public void dispatch(String viewName, Object... args) {
        if (viewName != null) {
            View view = views.get(viewName);
            if (args != null && args.length != 0) {
                view.show(args);
            } else {
                view.show();
            }
        }
    }
}
