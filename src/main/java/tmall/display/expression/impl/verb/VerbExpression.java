package tmall.display.expression.impl.verb;

import tmall.display.expression.Expression;

public abstract class VerbExpression extends Expression {

    @Override
    public String[] interpret(Object... args) throws Exception {
        if (args[0] != null && args[0] instanceof String) {
            String viewOrFieldName = (String) args[0];
            return new String[]{getCommandName(viewOrFieldName)};
        } else {
            throw new Exception("解释动词出错，请输入相关的页面名或属性名！");
        }
    }

    public abstract String getCommandName(String viewOrFieldName);
}
