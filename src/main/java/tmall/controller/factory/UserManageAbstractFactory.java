package tmall.controller.factory;

public interface UserManageAbstractFactory {
    public Object getUserInfoController(String args);
    public Object getUserRoleController();
}
