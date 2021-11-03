package tmall.controller.factory;

import tmall.controller.Interface.UserRoleController;

public class UserRoleControllerFactory implements UserManageAbstractFactory {
    @Override
    public Object getUserInfoController(String args) {
        return null;
    }

    @Override
    public Object getUserRoleController() {
        return new UserRoleController();
    }
}
