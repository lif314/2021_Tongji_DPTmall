package tmall.display.expression.util;

import tmall.display.expression.Expression;
import tmall.display.expression.util.ExpressionUtil;

import java.util.Stack;

public class Context {
    private String[] expressions;
    private Stack<Expression> stack;

    public String[] interpret(String expression) {
        Expression verb = null;
        Expression noun = null;
        String commandName = null;
        String viewName = null;
        expressions = expression.split(" ");
        for (String e : expressions) {
            if ("Login".equals(e)) {
                commandName = "LoginCommand";
                break;
            } else if (ExpressionUtil.isVerb(e)) {
                verb = ExpressionUtil.getInterpreterVerb(e);
                stack.push(verb);
            } else {
                noun = ExpressionUtil.getInterpreterNoun(e);
                viewName = noun.interpret();
                verb = stack.pop();
                commandName = verb.interpret(viewName);
            }
        }
        return new String[]{commandName, viewName};
    }
}
