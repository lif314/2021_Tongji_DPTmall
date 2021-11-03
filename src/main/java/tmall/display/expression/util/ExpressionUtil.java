package tmall.display.expression.util;

import tmall.display.expression.Expression;


/**
 * @Description expression包为解释器模式的实现类，包含一个父类Expression，工具类Context、ExpressionUtil，以及其它具体的实现类：名词解释器、动词解释器父类及其实现类
 * @author 王文炯
 * @version 1.0.0
 * @Description ExpressionUtil类为工具类，作用为Context解释命令提供辅助
 */
public class ExpressionUtil {
    public static boolean isVerb(String word) {
        return "Add".equals(word)||"Complaint".equals(word) ||"Get".equals(word) ||"Create".equals(word) || "Display".equals(word) || "Select".equals(word) || "Login".equals(word) || "Enter".equals(word) ||  "Buy".equals(word) ||  "Delete".equals(word);
    }

    /**
     * 本方法用于获取对应的动词解释器
     * @param word 单个动词
     * @return 对应的动词解释器
     */
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

    /**
     * 本方法用于获取名词解释器
     * @return 名词解释器
     */
    public static Expression getInterpreterNoun() {
        try {
            Class<?> nounClass = Class.forName("tmall.display.expression.impl.noun.NounExpression");
            Expression expression = (Expression) nounClass.newInstance();
            return expression;
        } catch (InstantiationException | IllegalAccessException|ClassNotFoundException e) {
            System.out.println("你输入的名词不合法");
        }
        return null;
    }
}
