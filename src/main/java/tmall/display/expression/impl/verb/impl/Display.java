package tmall.display.expression.impl.verb.impl;

import tmall.display.expression.impl.verb.VerbExpression;

public class Display extends VerbExpression {
    @Override
    public String getCommandName(String viewOrFieldName) {
        return "DisplayCommand";
    }
}
