package tmall.display.command;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

/**
 * @Description Command包为命令模式的实现类，包含一个父类Command，工厂类CommandFactory，以及其它具体的实现类
 * @author 王文炯
 * @version 1.0.0
 */
public class CommandFactory {
    /**
     * 本方法根据用户输入的命令名称返回一个对应的命令对象
     * @return 对应的命令对象
     */
    public static Command getCommand() {
        Scanner input = new Scanner(System.in);
        String orderName = input.next();
        return getCommand(orderName);
    }

    /**
     * 本方法根据传入的命令名称返回一个对应的命令对象
     * @param orderName 命令的名称
     * @return 对应的命令对象
     */
    public static Command getCommand(String orderName){
        Command order=null;
        try {
            Class<?> orderClass = Class.forName("tmall.display.command.impl."+orderName);
            Method method = orderClass.getMethod("get" + orderName);
            order = (Command) method.invoke(null);
        } catch (ClassNotFoundException | NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
        return order;
    }

}
