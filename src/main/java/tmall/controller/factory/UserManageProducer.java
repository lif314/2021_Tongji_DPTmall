package tmall.controller.factory;

public class UserManageProducer {
    private static UserInfoControllerFactory userInfoControllerFactory;
    private static UserRoleControllerFactory userRoleControllerFactory;
    public UserManageAbstractFactory getUserManageController(String args){

        if(args.equals("info")){
            if (userInfoControllerFactory==null){
                userInfoControllerFactory=new UserInfoControllerFactory();
            }
            return userInfoControllerFactory;
        }
        else {
            if (userRoleControllerFactory==null){
                userRoleControllerFactory=new UserRoleControllerFactory();
            }
            return userRoleControllerFactory;
        }
    }
}
