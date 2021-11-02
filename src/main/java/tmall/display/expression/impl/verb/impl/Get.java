package tmall.display.expression.impl.verb.impl;

import tmall.display.expression.impl.verb.VerbExpression;

/**
 * @Description expression包为解释器模式的实现类，包含一个父类Expression，工具类Context、ExpressionUtil，以及其它具体的实现类：名词解释器、动词解释器父类及其实现类
 * @author 王文炯
 * @version 1.0.0
 * @Description Get类解释Get命令
 */
public class Get extends VerbExpression {
    @Override
    public String getCommandName(String viewOrFieldName) {
        return "GetCommand";
    }
}
