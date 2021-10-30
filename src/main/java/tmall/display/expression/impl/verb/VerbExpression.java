package tmall.display.expression.impl.verb;

import tmall.display.expression.Expression;

public abstract class VerbExpression extends Expression {

    @Override
    public String[] interpret(Object... args) throws Exception {
        if (args[0] != null && args[0] instanceof String) {
            String viewOrFieldName = (String) args[0];
            return new String[]{getCommandName(viewOrFieldName)};
        } else {
            return new String[]{getCommandName("")};
        }
    }

    public abstract String getCommandName(String viewOrFieldName);
}
