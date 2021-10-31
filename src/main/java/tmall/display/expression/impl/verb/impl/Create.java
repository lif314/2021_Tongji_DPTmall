package tmall.display.expression.impl.verb.impl;

import tmall.display.expression.impl.verb.VerbExpression;

public class Create extends VerbExpression {
    @Override
    public String getCommandName(String viewOrFieldName) {
        return "CreateCommand";
    }
}
