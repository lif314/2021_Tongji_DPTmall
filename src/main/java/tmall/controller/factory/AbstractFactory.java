package tmall.controller.factory;

import tmall.controller.factory.item.Item;

public interface AbstractFactory {
    public Object getUserInfoController(String args);
    public Object getUserRoleController();
    public Item getItem(String name);
}
