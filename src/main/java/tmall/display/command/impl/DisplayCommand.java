package tmall.display.command.impl;

import tmall.controller.orderController.ShoppingCenter;
import tmall.display.command.Command;
import tmall.tmallSystem.TMallSystem;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Array;

/**
 * @Description Command包为命令模式的实现类，包含一个父类Command，工厂类CommandFactory，以及其它具体的实现类
 * @author 王文炯
 * @version 1.0.0
 * @Description 本命令类对应买家命令Display XXX，可显示商品总价，打折后总价，订单详情，优惠方式，支付方式等，可选参数为（TotalMoney、PaidMoney、OrderDetail、ShopCoupon、PaidMoney）
 */
public class DisplayCommand extends Command {
    private static DisplayCommand displayCommand;

    private DisplayCommand() {
        super.setCommandName("DisplayCommand");
        super.addController(new ShoppingCenter());
    }

    /**
     * @Description 获取DisplayCommand对象
     * 这里采用单例模式
     * @return DisplayCommand对象
     */
    public static DisplayCommand getDisplayCommand() {
        if (displayCommand == null) {
            displayCommand = new DisplayCommand();
        }
        return displayCommand;
    }


    /**
     * @Description 本方法被FrontController调用，采用适配器模式，对于FrontController都是调用execute方法，而该方法封装了不同Controller的不同方法
     * @Description 本命令的此方法的功能为显示数据
     * @param args 命令行输入的参数
     * @return 本方法无返回值
     */
    @Override
    public Object[] execute(Object... args) {
        String params = (String) args[0];
        if (super.getConcreteController() instanceof ShoppingCenter) {
            // 若参数包含Money，则显示的的是商品总价或打折后的价格
            if (((String) args[0]).contains("Money")) {
                Class<? extends ShoppingCenter> aClass = ((ShoppingCenter) super.getConcreteController()).getClass();
                try {
//                    采用反射机制，动态调用calTotalMoney（）或calPaidMoney（）
                    Method method = aClass.getMethod("cal" + ((String) args[0]));
                    System.out.print("当前订单中商品总价为：");
                    System.out.println(method.invoke(super.getConcreteController()));
                } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
                    e.printStackTrace();
                }
//                若参数包含OrderDetail，则显示的是订单详情，同样是采用反射动态调用Controller方法，单独列出是因为该方法需要买家ID这一参数
            } else if ("OrderDetail".equals(params)) {
                try {
                    Class<? extends ShoppingCenter> aClass = ((ShoppingCenter) super.getConcreteController()).getClass();
                    Method method = aClass.getMethod("display" + params,String.class);
                    System.out.println(method.invoke(super.getConcreteController(), TMallSystem.getBuyer().getBuyerId()));
                } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
                    e.printStackTrace();
                }
//                其他数据的显示，因为不需要参数，所以直接反射动态调用即可，如支付方式，优惠券和活动等等
            } else {
                try {
                    Class<? extends ShoppingCenter> aClass = ((ShoppingCenter) super.getConcreteController()).getClass();
                    Method method = aClass.getMethod("display" + params);
                    System.out.println(method.invoke(super.getConcreteController()));
                } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }
}
