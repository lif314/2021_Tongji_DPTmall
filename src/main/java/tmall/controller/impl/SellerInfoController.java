package tmall.controller.impl;

import tmall.controller.Interface.UserInfoMemento.CareTaker;
import tmall.controller.Interface.UserInfoMemento.Originator;
import tmall.model.entity.Buyer;
import tmall.model.entity.NullUser;
import tmall.model.entity.Seller;
import tmall.model.entityDao.daoImpl.SellerDaoImpl;
import tmall.controller.Interface.UserInfoController;

import java.util.List;

/**
 * 管理卖家的信息
 */
public class SellerInfoController implements UserInfoController {

    // 获得数据库
    private final SellerDaoImpl SellerDI = new SellerDaoImpl();
    List<Seller> sellersInfo = SellerDI.getAll();
    
    /**
     * 获得卖家的信息
     * @param ID 卖家的ID
     * @return 空对象或卖家
     */
    @Override
    public Object getInfo(String ID) {
        for(Seller seller : sellersInfo){
            if(seller.getSellerId().equals(ID))
                return seller;
        }
        return new NullUser();
    }

    @Override
    public Boolean editInfo(String ID) {
        return false;
    }


}
