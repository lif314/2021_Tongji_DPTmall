package tmall.display.command.impl;

import tmall.controller.Controller;
import tmall.controller.DCH_impl.VerifyLevelController.VerifyLevelController;
import tmall.controller.impl.FavoriteController;
import tmall.display.command.Command;
import tmall.tmallSystem.TMallSystem;

import java.util.HashMap;

/**
 * @Description Command包为命令模式的实现类，包含一个父类Command，工厂类CommandFactory，以及其它具体的实现类
 * @author 王文炯
 * @version 1.0.0
 * @Description 本命令类对应添加命令，Add XXX，参数为商品Id
 */
public class AddCommand extends Command {
    private static AddCommand addCommand;
    private static HashMap<String, Controller> controllerHashMap=new HashMap<>();

    private AddCommand() {
        super.setCommandName("AddCommand");
        super.addController(new FavoriteController());
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
            ((FavoriteController)super.getConcreteController()).addFavoriteCommodity(TMallSystem.getBuyer().getBuyerId(),(String) ((String) args[0]).substring(1,((String) args[0]).length()));
            ((FavoriteController)super.getConcreteController()).displayFavoriteCommodities(TMallSystem.getBuyer().getBuyerId());
        }
        return null;
    }
}
