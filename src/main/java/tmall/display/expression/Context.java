package tmall.display.expression;

import tmall.display.expression.util.ExpressionUtil;

import java.util.Stack;

public class Context  {
    private String[] expressions;
    private Stack<Expression> stack;

    public Object[] interpret(String expression) {
        Expression verb = null;
        Expression noun = null;
        expressions = expression.split(" ");
        for (String e : expressions) {
            if (ExpressionUtil.isVerb(e)) {
                verb = ExpressionUtil.getInterpreter(e);
                stack.push(verb);
            } else {
                verb = stack.pop();
            }
        }
        return null;
    }
}
