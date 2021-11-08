package tmall.display.view.impl;

import tmall.display.view.View;

import java.util.List;

public class ChatRoomView extends View {
    @Override
    public Object show(Object... args) {
        for (int i = 0; i< args.length;i++) {
            System.out.println(args[i]);
        }
        return null;
    }
}
