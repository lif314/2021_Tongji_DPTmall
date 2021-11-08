package tmall.controller.factory;

import tmall.controller.Interface.UserRoleController;
import tmall.controller.factory.item.Item;

public class UserRoleControllerFactory implements AbstractFactory {
    @Override
    public Object getUserInfoController(String args) {
        return null;
    }

    @Override
    public Item getItem(String name) {
        return null;
    }

    @Override
    public Object getUserRoleController() {
        return new UserRoleController();
    }
}
