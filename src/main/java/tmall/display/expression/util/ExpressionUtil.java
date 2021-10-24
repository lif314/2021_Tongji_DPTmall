package tmall.display.expression.util;

import tmall.display.expression.Expression;

public class ExpressionUtil {
    public static boolean isVerb(String word) {
        if ("login".equals(word) || "enter".equals(word) || "edit".equals(word) || "buy".equals(word) || "follow".equals(word) || "increase".equals(word) || "reduce".equals(word) || "add".equals(word) || "delete".equals(word)) {
            return true;
        } else
            return false;
    }

    public static Expression getInterpreter(String word) {
        try {
            Class<?> aClass = Class.forName("tmall.display.expression.impl." + word);
            Expression expression = (Expression) aClass.newInstance();
            return expression;
        } catch (InstantiationException | IllegalAccessException|ClassNotFoundException e) {
            System.out.println("你输入的单词不合法");
        }
        return null;
    }
}
