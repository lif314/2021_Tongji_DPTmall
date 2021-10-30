package tmall.display.view.impl;

import tmall.display.view.View;

public class ActivityView extends View {
    @Override
    public Object show(Object... args) {
        for (Object e:args
        ) {
            System.out.println(e);
        }
        return null;
    }
}
