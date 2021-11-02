package tmall.display.expression.impl.noun;

import tmall.display.expression.Expression;

import java.lang.reflect.Field;
import java.util.HashMap;

/**
 * @Description expression包为解释器模式的实现类，包含一个父类Expression，工具类Context、ExpressionUtil，以及其它具体的实现类：名词解释器、动词解释器父类及其实现类
 * @author 王文炯
 * @version 1.0.0
 * @Description NounExpression类为所有名词解释器类
 */
public class NounExpression extends Expression {
    private HashMap<String, String> variables;

    /**
     * 初始化方法，对变量Hash表进行初始化
     */
    public NounExpression() {
        variables = new HashMap<>();
        variables.put("A","Activity");
        variables.put("C", "Commodity");
        variables.put("D", "Division");
        variables.put("S", "Shop");
        variables.put("V", "Venue");
        variables.put("F", "Field");
    }

    /**
     * 本方法功能对名词的进行解释
     * @param args 用户输入的名词
     * @return 对应的页面名和可能需要的参数
     * @throws Exception 若解释出错，则向上层抛出异常，在FrontController处统一接收处理
     */
    @Override
    public String[] interpret(Object... args) throws Exception {
        if (args[0] != null && args[0] instanceof String) {
            String viewOrFieldName = (String) args[0];
            String viewName = null;
            String returnArgs = null;
            // 若参数为Page结尾，则表明用户需要进入某个页面
            if (viewOrFieldName.endsWith("Page")){
                // 若参数以V打头，则表明用户输入的名词包含变量
                if (viewOrFieldName.startsWith("V")){
                    returnArgs=viewOrFieldName.substring(2,viewOrFieldName.length()-4);
                    viewName = variables.get(viewOrFieldName.substring(1,2)) +"View";
                } else
                    viewName=viewOrFieldName.substring(0,viewOrFieldName.length()-4)+"View";
            } else {
                returnArgs = viewOrFieldName;
            }
            return new String[]{viewName, returnArgs};
        } else {
            throw new Exception("您输入的名词文法错误！请重新输入！");
        }
    }

}
