package tmall.display.command.impl;

import tmall.controller.Controller;
import tmall.controller.DCH_impl.VerifyLevelController.VerifyLevelController;
import tmall.controller.impl.CartController;
import tmall.controller.impl.FavoriteController;
import tmall.display.command.Command;
import tmall.tmallSystem.TMallSystem;

import java.util.HashMap;

/**
 * @Description Command包为命令模式的实现类，包含一个父类Command，工厂类CommandFactory，以及其它具体的实现类
 * @author 王文炯
 * @version 1.0.0
 * @Description 本命令类对应添加命令，添加商品到购物车或收藏夹，Add XXX，参数为商品Id
 */
public class AddCommand extends Command {
    private static AddCommand addCommand;
    private static HashMap<String, Controller> controllerHashMap=new HashMap<>();

    private AddCommand() {
        super.setCommandName("AddCommand");
        super.addController(new FavoriteController());
        controllerHashMap.put("CartController",new CartController());
    }

    /**
     * 这里采用单例模式
     * @return AddCommand对象
     */
    public static AddCommand getAddCommand() {
        if (addCommand == null) {
            addCommand = new AddCommand();
        }
        return addCommand;
    }

    /**
     * @Description 本方法被FrontController调用，采用适配器模式，对于FrontController都是调用execute方法，而该方法封装了不同Controller的不同方法
     * @Description 此方法的功能为添加商品到购物车或收藏夹
     * @param args 命令行输入的参数
     * @return 本方法无返回值
     */
    @Override
    public Object[] execute(Object... args) {
        String params =(String) args[0];
        if(TMallSystem.getBuyer()!=null&&params.startsWith("C")){
//            添加商品到收藏夹，以命令ToFavorites后缀判断
            if (params.endsWith("-ToFavorites")){
                String commodityId = params.substring(1,params.length()-12);
                ((FavoriteController)super.getConcreteController()).addFavoriteCommodity(TMallSystem.getBuyer().getBuyerId(),commodityId);
                ((FavoriteController)super.getConcreteController()).displayFavoriteCommodities(TMallSystem.getBuyer().getBuyerId());
                System.out.println("***商品添加到收藏夹成功！***");
//                添加商品到购物车，以命令后缀ToShoppingCart判断
            }else if (params.endsWith("-ToShoppingCart")){
                String commodityIdAndCount = params.substring(1,params.length()-15);
                String[] split = commodityIdAndCount.split("\\*");
                String commodityId = split[0];
                String count = null;
                if (split.length>1) {
                    count = split[1];
                }else count="1";
                CartController cartController = (CartController) controllerHashMap.get("CartController");
                cartController.addCart(TMallSystem.getBuyer().getBuyerId(),commodityId,count);
                System.out.println("***商品添加到购物车成功！***");
            }
        }
        return null;
    }
}
