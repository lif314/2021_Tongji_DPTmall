package tmall.display.command.impl;

import tmall.controller.orderController.ShoppingCenter;
import tmall.display.command.Command;
import tmall.tmallSystem.TMallSystem;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Array;

public class DisplayCommand extends Command {
    private static DisplayCommand displayCommand;

    private DisplayCommand() {
        super.setCommandName("DisplayCommand");
        super.addController(new ShoppingCenter());
    }

    /**
     * 这里采用单例模式
     *
     * @return InstructionOrder对象
     */
    public static DisplayCommand getDisplayCommand() {
        if (displayCommand == null) {
            displayCommand = new DisplayCommand();
        }
        return displayCommand;
    }

    @Override
    public Object[] execute(Object... args) {
        String params = (String) args[0];
        if (super.getConcreteController() instanceof ShoppingCenter) {
            if (((String) args[0]).contains("Money")) {
                Class<? extends ShoppingCenter> aClass = ((ShoppingCenter) super.getConcreteController()).getClass();
                try {
                    Method method = aClass.getMethod("cal" + ((String) args[0]));
                    System.out.println(method.invoke(super.getConcreteController()));
                } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
                    e.printStackTrace();
                }
            } else if ("OrderDetail".equals(params)) {
                try {
                    Class<? extends ShoppingCenter> aClass = ((ShoppingCenter) super.getConcreteController()).getClass();
                    Method method = aClass.getMethod("display" + params,String.class);
                    System.out.println(method.invoke(super.getConcreteController(), TMallSystem.getBuyer().getBuyerId()));
                } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
                    e.printStackTrace();
                }
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
