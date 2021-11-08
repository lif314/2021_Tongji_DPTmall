package tmall.display.command.impl;

import tmall.controller.factory.AbstractFactory;
import tmall.controller.factory.FactoryProducer;
import tmall.controller.impl.BuyerInfoController;
import tmall.controller.impl.CartController;
import tmall.controller.impl.FavoriteController;
import tmall.controller.orderController.ShoppingCenter;
import tmall.display.command.Command;
import tmall.display.view.impl.CommodityView;
import tmall.model.entity.*;
import tmall.model.logicalEntity.OrderLogic;
import tmall.model.logicalEntity.ShoppingCartLogic;
import tmall.tmallSystem.TMallSystem;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 王文炯
 * @version 1.0.0
 * @Description Command包为命令模式的实现类，包含一个父类Command，工厂类CommandFactory，以及其它具体的实现类
 * @Description 本命令类对应买家命令Display XXX，可显示商品总价，打折后总价，订单详情，优惠方式，支付方式等，可选参数为（TotalMoney、PaidMoney、OrderDetail、ShopCoupon、PaidMoney）
 */
public class DisplayCommand extends Command {
    private static DisplayCommand displayCommand;

    private DisplayCommand() {
        super.setCommandName("DisplayCommand");
        super.addController(new ShoppingCenter());
    }

    /**
     * @return DisplayCommand对象
     * @Description 获取DisplayCommand对象
     * 这里采用单例模式
     */
    public static DisplayCommand getDisplayCommand() {
        if (displayCommand == null) {
            displayCommand = new DisplayCommand();
        }
        return displayCommand;
    }


    /**
     * @param args 命令行输入的参数
     * @return 本方法无返回值
     * @Description 本方法被FrontController调用，采用适配器模式，对于FrontController都是调用execute方法，而该方法封装了不同Controller的不同方法
     * @Description 本命令的此方法的功能为显示数据
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
                    Method method = aClass.getMethod("display" + params, String.class);
                    for(int i = 0; i < 38; i ++) {System.out.print("=");}
                    System.out.print("YOUR ORDER");
                    for(int i = 0; i < 38; i ++) {System.out.print("=");}
                    System.out.println();
                    System.out.println(method.invoke(super.getConcreteController(), TMallSystem.getBuyer().getBuyerId()));
                    for(int i = 0; i < 38 * 2 + 10; i ++) {System.out.print("=");}
                    System.out.print('\n');
                } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
                    e.printStackTrace();
                }
//                展示收藏夹里的商品
            } else if ("FavoriteCommodities".equals(params)) {
                FavoriteController favoriteController = new FavoriteController();
                return favoriteController.displayFavoriteCommodities(TMallSystem.getBuyer().getBuyerId());
            } else if ("BuyerInfo".equals(params)) {
//                展示买家信息
                AbstractFactory userInfoControllerFactory = FactoryProducer.getFactory("info");
                BuyerInfoController buyerInfoController = (BuyerInfoController) userInfoControllerFactory.getUserInfoController("buyer");
                User buyer = (User) buyerInfoController.getInfo(TMallSystem.getBuyer().getBuyerId());
                System.out.println(String.format("|%-10s|%-10s|%-15s|%-20s|%-11s|%-10s|%-40s|",
                        "nickname","gender","passwd","idNumber","phone","birthday","buyerId"));
                System.out.println(buyer);
            }
            else if ("CartBill".equals(params)) {
//                展示购物车内商品总价
                CartController cartController = new CartController();
                int i = cartController.checkCartBill(TMallSystem.getBuyer().getBuyerId());
                System.out.println("您购物车内的商品总价为：" + i + "元");
            }
            else if ("ShoppingCart".equals(params)) {
    //                展示购物车内所有商品
                    List<ShoppingCartLogic> shoppingCartLogics = new CartController().showCommodity(TMallSystem.getBuyer().getBuyerId());
                    new CommodityView().show(shoppingCartLogics);
                } else {
    //                其他数据的显示，因为不需要参数，所以直接反射动态调用即可，如支付方式，优惠券和活动等等
                    try {
                        Class<? extends ShoppingCenter> aClass = ((ShoppingCenter) super.getConcreteController()).getClass();
                        Method method = aClass.getMethod("display" + params);

                        Object list = method.invoke(super.getConcreteController());
                        if(list instanceof Commodity){

                        }else if(list instanceof String){
                            //payMethod
                            System.out.println("注：索引从0开始");
                            System.out.println(list);
                        }else {
                            List<?> alist = (List<?>) list;
                            if(alist.get(0) instanceof Commodity){
                                List<Commodity> realList = (ArrayList<Commodity>) alist;
                            }else if(alist.get(0) instanceof Activity){
                                List<Activity> realList = (ArrayList<Activity>) alist;
                            }else if(alist.get(0) instanceof Coupon){
                                for(int i = 0; i < 58; i ++) {System.out.print("=");}
                                System.out.print("YOUR COUPON");
                                for(int i = 0; i < 58; i ++) {System.out.print("=");}
                                System.out.print("\n");
                                List<Coupon> realList = (ArrayList<Coupon>) alist;
                                System.out.println(String.format("|%-8s|%-10s|%-12s|%-12s|%-40s|%-40s|",
                                        "full","minus","startTime","endTime","couponId","shopId"));
                                if(realList.size()!=0) {
                                    for (Coupon c : realList) {
                                        System.out.print(c);
                                    }
                                }
                                for(int i = 0; i < 58 * 2 + 11; i ++) {System.out.print("=");}
                                System.out.print("\n");
                            }else if(alist.get(0) instanceof BuyerAddress){
                                List<BuyerAddress> realList = (ArrayList<BuyerAddress>) alist;
                            }
                        }


//                    for(int i = 0; i < 58 * 2 + 11; i ++) {System.out.print("=");}
//                    System.out.print("\n");
//                    System.out.println(method.invoke(super.getConcreteController()));
                } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }
}
