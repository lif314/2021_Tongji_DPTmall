package tmall.display.command.impl;

import tmall.XMLRepository.util.Nullable;
import tmall.controller.Controller;
import tmall.controller.impl.CommodityDisplayController;
import tmall.controller.orderController.ShoppingCenter;
import tmall.display.command.Command;
import tmall.model.entity.BuyerAddress;
import tmall.model.entity.OrderPaymentMethod;
import tmall.tmallSystem.TMallSystem;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Scanner;

/**
 * @Description Command包为命令模式的实现类，包含一个父类Command，工厂类CommandFactory，以及其它具体的实现类
 * @author 王文炯
 * @version 1.0.0
 * @Description 本命令类对应命令Select CXXX（参数为商品Id）/PAXXX（参数为活动Id，可选）&PCXXX（参数为优惠券Id，可选）/BuyerAddress/PayMethodX(参数为支付方式索引)，作用为选择商品，活动，优惠券，支付方式、买家地址等
 */
public class SelectCommand extends Command {
    private static SelectCommand selectCommand;

    private SelectCommand() {
        super.setCommandName("SelectCommand");
        super.addController(new ShoppingCenter());
    }

    /**
     * 这里采用单例模式
     * @return InstructionOrder对象
     */
    public static SelectCommand getSelectCommand() {
        if (selectCommand == null) {
            selectCommand = new SelectCommand();
        }
        return selectCommand;
    }

    /**
     * @Description 本方法被FrontController调用，采用适配器模式，对于FrontController都是调用execute方法，而该方法封装了不同Controller的不同方法
     * @Description 此方法的功能为选择商品，活动，优惠券，支付方式、买家地址等
     * @param args 命令行输入的参数：CXXX（参数为商品Id）/PAXXX（参数为活动Id，可选）&PCXXX（参数为优惠券Id，可选）/BuyerAddress/PayMethodX(参数为支付方式索引)
     * @return 本方法无返回值
     */
    @Override
    public Object[] execute(Object... args) {
        // params为输入的变量参数
        String params = (String) args[0];
        if (super.getConcreteController() instanceof ShoppingCenter) {
            // 如果首字母为C，则为选择商品，以“*”为分隔，前面为商品Id，后面为商品数量
            if (params.startsWith("C")) {
                String[] commodityAndCount = params.substring(1,params.length()).split("\\*");
                // 商品Id
                String commodityId = commodityAndCount[0];
                String account;
                // 商品数量
                if (commodityAndCount.length > 1) {
                    account = commodityAndCount[1];
                } else {
                    account = "1";
                }
                ((ShoppingCenter) super.getConcreteController()).selectCommodity(commodityId, account);
                // 如果首字母为P，则选择的是活动或者优惠券，活动首字母为A，优惠券首字母为C，以“&”为分割
            } else if (params.startsWith("PA") || params.startsWith("PC")){
                String[] activityAndCoupon = params.substring(1,params.length()).split("\\&");
                String activity = null;
                String coupon = null;
//                判断用户输入的是优惠券Id还是活动Id，或者两者都有
                if (activityAndCoupon.length >1){
                    if (activityAndCoupon[0].startsWith("A")){
                        activity = activityAndCoupon[0].substring(1, activityAndCoupon[0].length());
                        coupon = activityAndCoupon[1];
                    }
                } else {
                    if (activityAndCoupon[0].startsWith("A")){
                        activity = activityAndCoupon[0].substring(1, activityAndCoupon[0].length());;
                    }else{
                        coupon = activityAndCoupon[0].substring(1, activityAndCoupon[0].length());;
                    }
                }
                ((ShoppingCenter) super.getConcreteController()).selectPromotions(activity, coupon);
                // 如果输入的参数是BuyerAddress，那么则为选择买家地址，不用输入参数，买家Id直接从系统变量里读取
            } else if ("BuyerAddress".equals(params)){
                Class<? extends Controller> concreteControllerClass = this.getConcreteController().getClass();
                try {
                    String buyerId = TMallSystem.getBuyer().getBuyerId();
                    List<BuyerAddress> buyerAddresses = ((ShoppingCenter) super.getConcreteController()).displayBuyerAddress(buyerId);
                    for(BuyerAddress b : buyerAddresses){
                        System.out.println(b);
                    }
//                    获取对应的方法
                    Method method = concreteControllerClass.getMethod("select" + params, buyerId.getClass());
//                    用户输入买家地址Id
                    System.out.println("请您输入买家地址Id");
                    Scanner scanner = new Scanner(System.in);
                    String buyerAddressId = scanner.next();
                    method.invoke(this.getConcreteController(),buyerAddressId);
                } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
                    e.printStackTrace();
                }
                // 如果输入的参数是PayMethod，那么则为选择购物方式，输入参数为枚举变量的索引
            } else if (params.startsWith("PayMethod")){
                String index = params.substring(params.length()-1,params.length());
                String method = "";
                switch (index){
                    case "0": method = OrderPaymentMethod.UnionPay.name(); break;
                    case "1": method = OrderPaymentMethod.WeChat.name(); break;
                    case "2": method = OrderPaymentMethod.AliPay.name(); break;
                }
                ((ShoppingCenter) super.getConcreteController()).selectPayMethod(method);
                System.out.println("购物方式选择成功，您已选择 *"+method+"* 作为您本次购物的支付方式");
            }
        }
        return null;
    }
}