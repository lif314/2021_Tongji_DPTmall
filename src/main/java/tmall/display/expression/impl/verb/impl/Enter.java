package tmall.display.expression.impl.verb.impl;

import tmall.display.expression.impl.verb.VerbExpression;

public class Enter extends VerbExpression {
    @Override
    public String getCommandName(String viewOrFieldName) {
        return "Enter"+viewOrFieldName+"Command";
    }
}
