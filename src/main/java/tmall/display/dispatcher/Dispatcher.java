package tmall.display.dispatcher;


import tmall.controller.DCH_impl.ComplaintController.Chatroom;
import tmall.display.view.View;
import tmall.display.view.impl.*;

import java.util.HashMap;

/**
 * @Description 本类配合FrontController实现前端控制器模式
 * @author 王文炯
 * @version 1.0.0
 * @Description 本类的功能为根据FrontController的要求调取对应的页面，展示相关的数据
 */
public class Dispatcher {
    private static Dispatcher dispatcher;
    private HashMap<String, View> views;

    private Dispatcher() {
        views = new HashMap<String, View>();
        addViews();
    }

    /**
     * @Description 获取Dispatcher对象
     * 由于全局只有一个Dispatcher对象，因此这里采用单例模式
     * @return DisplayCommand对象
     */
    public static Dispatcher getDispatcher() {
        if (dispatcher == null) {
            dispatcher = new Dispatcher();
        }
        return dispatcher;
    }

    /**
     * 本方法用于初始化Dispatcher对象，添加所有可能用到的页面
     */
    public void addViews(){
        InstructionView instructionView = new InstructionView();
        LoginView loginView = new LoginView();
        CommodityView commodityView = new CommodityView();
        ShopView shopView = new ShopView();
        CommodityDivisionView commodityDivisionView = new CommodityDivisionView();
        DivisionView divisionView = new DivisionView();
        HomeView homeView = new HomeView();
        ActivityView activityView = new ActivityView();
        ServiceView serviceView = new ServiceView();
        ChatRoomView chatRoomView = new ChatRoomView();
        this.addView("CommodityView",commodityView);
        this.addView("CommodityDivisionView",commodityDivisionView);
        this.addView("LoginView",loginView);
        this.addView("InstructionView", instructionView);
        this.addView("ShopView",shopView);
        this.addView("DivisionView",divisionView);
        this.addView("HomeView",homeView);
        this.addView("ActivityView",activityView);
        this.addView("ServiceView",serviceView);
        this.addView("ChatRoomView",chatRoomView);
    }

    /**
     * 本方法用于进行单个页面对象的添加
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
