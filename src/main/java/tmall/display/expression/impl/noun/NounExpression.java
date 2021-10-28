package tmall.display.expression.impl.noun;

import tmall.display.expression.Expression;

import java.lang.reflect.Field;
import java.util.HashMap;

public class NounExpression extends Expression {
    private HashMap<String, String> variables;

    public NounExpression() {
        variables = new HashMap<>();
        variables.put("C", "Commodity");
        variables.put("D", "Division");
        variables.put("S", "Shop");
        variables.put("V", "Venue");
        variables.put("F", "Field");
    }

    @Override
    public String[] interpret(Object... args) throws Exception {
        if (args[0] != null && args[0] instanceof String && (((String) args[0]).endsWith("Page") || ((String) args[0]).endsWith("Field"))) {
            String viewOrFieldName = (String) args[0];
            String viewName = null;
            String returnArgs = null;
            if (viewOrFieldName.endsWith("Page"))
                viewName = viewOrFieldName.substring(0, viewOrFieldName.length() - 4) + "View";
            else if (viewName.endsWith("Field"))
                viewName = viewOrFieldName.substring(0, viewOrFieldName.length() - 5) + "View";
            if (viewOrFieldName.startsWith("V")) {
                returnArgs = viewOrFieldName.substring(2, viewOrFieldName.length() - 4);
                viewName = variables.get(viewOrFieldName.substring(1, 2)) + "View";
            }
            return new String[]{viewName, returnArgs};
        } else {
            throw new Exception("您输入的名词文法错误！请重新输入！");
        }
    }

}
