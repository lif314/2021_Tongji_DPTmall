package tmall.display.view.impl;

import tmall.display.view.View;

public class ShopView extends View {
    @Override
    public Object show(Object... args) {
        for (Object o:args
             ) {
            System.out.println(o);
        }
        return null;
    }
}