package tmall.display.expression.util;

import tmall.display.expression.Expression;
import tmall.display.expression.util.ExpressionUtil;

import java.util.Stack;

public class Context {
    private Stack<Expression> stack;

    public Context() {
        stack = new Stack<Expression>();
    }

    public Object[] interpret(String expression) throws Exception {
        Expression verb;
        Expression noun;
        String commandName = null;
        String viewOrFieldName = null;
        String[] viewNameAndArgs;
        String commandArgs = null;
        String[] expressions = expression.split(" ");
        for (String e : expressions) {
            if ("Pay".equals(e) ||e.contains("Login") || "Instruction".equals(e)) {
                commandName = e + "Command";
                if (e.contains("Login")) {
                    viewOrFieldName = "LoginView";
                } else if ("Instruction".equals(e)){
                    viewOrFieldName = "InstructionView";
                }
                break;
            } else if (ExpressionUtil.isVerb(e)) {
                verb = ExpressionUtil.getInterpreterVerb(e);
                stack.push(verb);
            } else {
                noun = ExpressionUtil.getInterpreterNoun();
                viewNameAndArgs = noun.interpret(e);
                viewOrFieldName = viewNameAndArgs[0];
                commandArgs = viewNameAndArgs[1];
                verb = stack.pop();
                commandName = verb.interpret(viewOrFieldName)[0];
            }
        }
        if (viewOrFieldName == null && commandArgs == null && !("PayCommand".equals(commandName)||"LoginCommand".equals(commandName) || "InstructionCommand".equals(commandName)))
            throw new Exception("命令有误！不能单独输入动词！");
        return new String[]{commandName, viewOrFieldName, commandArgs};
    }
}
