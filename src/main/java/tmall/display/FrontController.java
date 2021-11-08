package tmall.display;


import tmall.display.command.Command;
import tmall.display.command.CommandFactory;
import tmall.display.dispatcher.Dispatcher;
import tmall.display.expression.util.Context;
import tmall.tmallSystem.TMallSystem;
import tmall.tmallSystem.TMallSystemTest;

import java.util.ArrayList;

/**
 * @Description 本类配合Dispatcher类实现前端控制器模式，以及集合Controller层的所用功能实现外观模式，方便主客户端调用
 * @author 王文炯
 * @version 1.0.0
 * @Description 本类的功能为解释用户输入的字符串，调用对应的命令类执行该命令，然后通知Dispatcher类调用相关页面进行对应数据展示
 */
public class FrontController {
    private final Dispatcher dispatcher;
    private final Context context;
    private ArrayList<Command> orders;
    private static FrontController frontController;

    private FrontController() {
        dispatcher = Dispatcher.getDispatcher();
        context = new Context();
    }

    /**
     * 本方法用于获取FrontController对象
     * @return 一个FrontController对象
     */
    public static FrontController getFrontController() {
        if(frontController==null){
            frontController=new FrontController();
        }
        return frontController;
    }

    /**
     * 本方法用于派发单个命令，使用逻辑为：根据传入的命令对象获取其命令类型（一个命令对应一个业务逻辑或者是页面），并调用其execute方法获得需要展示的数据，然后通过页面调度器展示
     * @param command 需要派发的命令
     */
    public void dispatchSingleCommand(String command){
        if(command.equals("cd Commodity")){
            System.out.println("您已进入<购买商品>场景，可以输入以下命令：\n");
            System.out.println(
                    "Enter VS<commodityId>Page(查看商品所在的店铺)\n" +
                            "Select C<commodityId>(选择此商品)\n" +
                            "Display TotalMoney(展示原价)\n" +
                            "Display ShopCoupon(展示店铺优惠券)\n" +
                            "Select PC<couponId>(选择此优惠券)\n" +
                            "Display PaidMoney(展示优惠后总价)\n" +
                            "Add C<commodityId>*<num>-ToShoppingCart(添加商品到购物车)" +
                            "Display ShoppingCart(展示购物车)\n" +
                            "Select BuyerAddress(选择收货地址)\n" +
                            "Display PayMethod(展示所有支付方式)\n" +
                            "Select PayMethod<?>(选择支付方式)\n" +
                            "Pay(支付)\n" +
                            "Display OrderDetail(展示订单详情)\n");
        }
        else if(command.equals("cd UserInfo")){
            System.out.println("您已进入<个人信息管理>场景，可以输入以下命令：\n");
            System.out.println(
                    "Display BuyerInfo(展示买家信息)\n" +
                            "Edit BuyerInfo-password-<pwd>(修改买家密码)\n" +
                            "Rollback BuyerInfo(回滚买家状态)\n" +
                            "Get VerifyCitation(卖家获取信用评价)\n");
        }
        else if(command.equals("cd Service")){
            System.out.println("您已进入<客服>场景，可以输入以下命令：\n");
            System.out.println(
                    "Enter ServicePage(联系客服)\n" +
                            "Complaint(投诉)\n");
        }
        else if(command.equals("cd Shop")){
            System.out.println("您已进入<店铺>场景，可以输入以下命令：\n");
            System.out.println(
                    "Enter VS<shopId>Page(进入该店铺详情)\n");
        }
        else if(command.equals("cd Cart")){
            System.out.println("您已进入<购物车>场景，可以输入以下命令：\n");
            System.out.println(
                    "Add C<commodityId>*<num>(把num个商品加入购物车)\n" +
                            "Display ShoppingCart(展示购物车)\n" +
                            "Display CartBill(展示购物车总价)\n" +
                            "Edit CommodityCount<commodityId>*<num>(编辑商品数量)\n");
        }

        else if (command != null && !command.equals("")){
            // 交给解释器解释传入的命令，返回需要调用的命令类名和可能用到的页面名
            Object[] commandAndView = new String[0];
            try {
                commandAndView = context.interpret(command);
            } catch (Exception e) {
                System.out.println(e.getMessage());
                return;
            }
            String commandName = (String) commandAndView[0];
            String viewName =(String) commandAndView[1];
            Object commandArgs = commandAndView[2];
            // 生成对应的命令类，并执行该命令，需要的参数由具体的命令类负责传入，降低耦合度
            Command concreteCommand = CommandFactory.getCommand(commandName);
            TMallSystem.getAttribute().put("attribute",commandArgs);
            // 执行结果可能为空，可能是待展示的数据，当页面名不为空且数据也不为空时就进行展示
            Object[] args = concreteCommand.execute(commandArgs);
            if(viewName!=null && args !=null){
                dispatcher.dispatch(viewName,args);
            } else if(viewName!=null){
                dispatcher.dispatch(viewName);
            }
        }
    }

    /**
     * 本方法用于派发orders数组中记录的所用命令
     */
    public void dispatchAllCommands(){
        for (Command o:orders){
            dispatchSingleCommand(o.getCommandName());
        }
    }

    /**
     * 本方法用于保存命令
     * @param command 需要保存的命令
     * @return 1为保存成功，-1为保存失败
     */
    public int addOrder(Command command){
        if (command !=null){
            orders.add(command);
            return 1;
        }else
            return -1;
    }
}
