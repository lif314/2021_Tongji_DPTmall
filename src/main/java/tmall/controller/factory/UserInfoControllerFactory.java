package tmall.controller.factory;

import tmall.controller.impl.BuyerInfoController;
import tmall.controller.impl.NullUserInfoController;
import tmall.controller.impl.SellerInfoController;

/**
 * 创造卖家或买家的用户信息Controller
 */
public class UserInfoControllerFactory implements UserManageAbstractFactory {
    @Override
    public Object getUserRoleController() {
        return null;
    }

    @Override
    public Object getUserInfoController(String args) {
        if(args.equals("buyer") || args.equals("Buyer") || args.equals("BUYER")) {
            return new BuyerInfoController();
        }
        else if(args.equals("seller") || args.equals("Seller") || args.equals("SELLER")){
            return new SellerInfoController();
        }
        return new NullUserInfoController();
    }
}
