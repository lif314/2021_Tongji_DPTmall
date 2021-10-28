package tmall.display;


import tmall.display.command.Command;
import tmall.display.command.CommandFactory;
import tmall.display.dispatcher.Dispatcher;
import tmall.display.expression.util.Context;

import java.util.ArrayList;

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
        if (command !=null){
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
            // 执行结果可能为空，可能是待展示的数据，当页面名不为空且数据也不为空时就进行展示
            Object[] args = concreteCommand.execute(commandArgs);
            if(viewName!=null && args !=null){
                dispatcher.dispatch(viewName,args);
            } else if(viewName!=null){
                dispatcher.dispatch(viewName);
            }
        }
    }

//    /**
//     * 本方法用于派发orders数组中记录的所用命令
//     */
//    public void dispatchAllCommands(){
//        for (Command o:orders){
//            dispatchSingleCommand(o);
//        }
//    }

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
