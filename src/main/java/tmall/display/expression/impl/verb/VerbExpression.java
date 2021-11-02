package tmall.display.expression.impl.verb;

import tmall.display.expression.Expression;
import tmall.display.expression.impl.noun.NounExpression;
import tmall.display.expression.util.ExpressionUtil;

/**
 * @author 王文炯
 * @version 1.0.0
 * @Description expression包为解释器模式的实现类，包含一个父类Expression，工具类Context、ExpressionUtil，以及其它具体的实现类：名词解释器、动词解释器父类及其实现类
 * @Description VerbExpression类为所有动词解释器类的父类
 */
public abstract class VerbExpression extends Expression {

    /**
     * 此处采用模板方法模式
     * 本方法功能对动词的进行解释，由于对动词的解释需要先判断是否需要配合相应的名词进行，且动词的解释方法也多种多样，无法在父类中统一，
     * 因此将这一个判断及解释名词的过程抽取到抽象父类中，具体的动词解释过程由具体的动词解释器实现类实现
     *
     * @param args 辅助解释动词的页面名或属性名
     * @return 对应的命令类名
     * @throws Exception 若解释出错，则向上层抛出异常，在FrontController处统一接收处理
     */
    @Override
    public String[] interpret(Object... args) throws Exception {
        // 若参数不为空，则表明对该动词的解释需要配合输入的名词，否则则表明该动词可以直接解释
        if (args.length != 0 && args[0] != null && args[0] instanceof String) {
            // 解释名词获取页面名或属性名
            NounExpression noun = (NounExpression) ExpressionUtil.getInterpreterNoun();
            String viewOrFieldName = noun.interpret(args[0])[0];
            // 将
            return new String[]{getCommandName(viewOrFieldName)};
        } else {
            return new String[]{getCommandName("")};
        }
    }

    /**
     * 本方法为抽象方法，作用为获取需要调用的命令类名
     *
     * @param viewOrFieldName 辅助解释动词的页面名或属性名
     * @return 对应的命令类名
     */
    public abstract String getCommandName(String viewOrFieldName);
}
