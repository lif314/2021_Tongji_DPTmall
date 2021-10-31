package tmall.display.expression.util;

import tmall.display.expression.Expression;

public class ExpressionUtil {
    public static boolean isVerb(String word) {
        return "Create".equals(word) || "Display".equals(word) || "Select".equals(word) || "Login".equals(word) || "Enter".equals(word) || "Edit".equals(word) || "Buy".equals(word) || "Follow".equals(word) || "Increase".equals(word) || "Reduce".equals(word) || "Add".equals(word) || "Delete".equals(word);
    }

    public static Expression getInterpreterVerb(String word) {
        try {
            Class<?> aClass = Class.forName("tmall.display.expression.impl.verb.impl." + word);
            Expression expression = (Expression) aClass.newInstance();
            return expression;
        } catch (InstantiationException | IllegalAccessException|ClassNotFoundException e) {
            System.out.println("你输入的动词不合法");
        }
        return null;
    }

    public static Expression getInterpreterNoun() {
        try {
            Class<?> nounClass = Class.forName("tmall.display.expression.impl.noun.NounExpression");
//            if ("V".equals(word.substring(0,1))){
//                nounClass = Class.forName("tmall.display.expression.impl.noun.impl" + word.substring(1,word.length()));
//            }
//            else nounClass = Class.forName("tmall.display.expression.impl.noun.impl" + word);
            Expression expression = (Expression) nounClass.newInstance();
            return expression;
        } catch (InstantiationException | IllegalAccessException|ClassNotFoundException e) {
            System.out.println("你输入的名词不合法");
        }
        return null;
    }
}
