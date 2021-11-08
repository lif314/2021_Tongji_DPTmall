package tmall.display.view.impl;

import tmall.display.view.View;

public class HomeView extends View {
    @Override
    public Object show(Object... args) {
        for(int i = 0; i < 66; i ++) {System.out.print("=");}
        System.out.print("HOME");
        for(int i = 0; i < 66; i ++) {System.out.print("=");}
        System.out.print('\n');
        System.out.printf("|%-15s|%-15s|%-5s|%-10s|%-5s|%-40s|%-40s|",
                "Name","Description","Price","Category","Store","CommodityID","ShopID");
        System.out.println();
        for (Object o: args){
            System.out.println(o);
        }
        for(int i = 0; i < 66 * 2 + 4; i ++) {System.out.print("=");}
        System.out.print('\n');
        return null;
    }
}
