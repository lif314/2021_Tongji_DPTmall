package tmall.controller.factory;

import tmall.controller.impl.BuyerInfoController;
import tmall.controller.impl.NullUserInfoController;
import tmall.controller.impl.SellerInfoController;

/**
 * 创造卖家或买家的用户信息Controller
 */
public class UserInfoControllerFactory implements UserManageAbstractFactory {
    private static BuyerInfoController buyerInfoController;
    private static SellerInfoController sellerInfoController;
    @Override
    public Object getUserRoleController() {
        return null;
    }

    @Override
    public Object getUserInfoController(String args) {
        if(args.equals("buyer") || args.equals("Buyer") || args.equals("BUYER")) {
            if (buyerInfoController==null) {
                buyerInfoController = new BuyerInfoController();
            } return buyerInfoController;
        }
        else if(args.equals("seller") || args.equals("Seller") || args.equals("SELLER")){
            if (sellerInfoController==null) {
                sellerInfoController = new SellerInfoController();
            } return sellerInfoController;
        }
        return new NullUserInfoController();
    }
}
