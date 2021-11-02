package tmall.display.expression.util;

import tmall.display.expression.Expression;
import tmall.display.expression.util.ExpressionUtil;

import java.util.Stack;

/**
 * @Description expression包为解释器模式的实现类，包含一个父类Expression，工具类Context、ExpressionUtil，以及其它具体的实现类：名词解释器、动词解释器父类及其实现类
 * @author 王文炯
 * @version 1.0.0
 * @Description Context类为解释器上下文类，作用为解释用户输入的命令，返回需要调用的命令类名，页面名及命令类可能用到的参数
 */
public class Context {
    private Stack<Expression> stack;

    public Context() {
        stack = new Stack<Expression>();
    }

    /**
     * @Description 本方法作用为解释作用为解释用户输入的命令字符串
     * @param expression 用户输入的命令
     * @return commandName, viewOrFieldName, commandArgs，即需要调用的命令类名，页面名或属性名及命令类可能用到的参数
     * @throws Exception
     */
    public Object[] interpret(String expression) throws Exception {
        Expression verb;
        Expression noun;
        String commandName = null;
        String viewOrFieldName = null;
        String[] viewNameAndArgs;
        String commandArgs = null;
//        将String拆分为单个单词的数组
        String[] expressions = expression.split(" ");
        for (String e : expressions) {
//            若输入的是一元命令Pay、XXXLogin、Instruction，则可直接返回相关参数
            if ("Pay".equals(e) ||e.contains("Login") || "Instruction".equals(e)) {
                commandName = e + "Command";
                if (e.contains("Login")) {
                    viewOrFieldName = "LoginView";
                } else if ("Instruction".equals(e)){
                    viewOrFieldName = "InstructionView";
                }
                break;
//                否则，先判断是否为动词，是，则压栈，等到遇到名词再将其取出，结合名词内容进行动词解释，进而获取对应的命令类名
            } else if (ExpressionUtil.isVerb(e)) {
                verb = ExpressionUtil.getInterpreterVerb(e);
                stack.push(verb);
            } else {
                noun = ExpressionUtil.getInterpreterNoun();
                viewNameAndArgs = noun.interpret(e);
                viewOrFieldName = viewNameAndArgs[0];
                commandArgs = viewNameAndArgs[1];
                verb = stack.pop();
                commandName = verb.interpret(e)[0];
            }
        }
        if(!stack.isEmpty()){
            verb = stack.pop();
            commandName = verb.interpret()[0];
        }
        if (viewOrFieldName == null && commandArgs == null && !("ComplaintCommand".equals(commandName)||"PayCommand".equals(commandName)||"LoginCommand".equals(commandName) || "InstructionCommand".equals(commandName)))
            throw new Exception("命令有误！不能单独输入动词！");
        return new String[]{commandName, viewOrFieldName, commandArgs};
    }
}
