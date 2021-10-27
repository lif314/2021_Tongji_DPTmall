package tmall.display.expression.impl.verb;

import tmall.display.expression.Expression;

public abstract class VerbExpression extends Expression {

    @Override
    public String interpret(Object... args) {
        if (args[0] != null) {
            String viewOrFieldName = (String) args[0];
            return getCommandName(viewOrFieldName);
        } else return "Login";
    }

    public abstract String getCommandName(String viewOrFieldName);
}
