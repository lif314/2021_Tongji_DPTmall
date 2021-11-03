package tmall.controller.Interface;

import tmall.model.entity.Buyer;
import tmall.model.entity.NullBuyer;
import tmall.model.entityDao.daoImpl.BuyerDaoImpl;
import tmall.model.entityDao.daoImpl.SellerDaoImpl;

import java.util.List;

public class UserRoleController {
    private final BuyerDaoImpl buyerDIl = new BuyerDaoImpl();
    private final SellerDaoImpl sellerDIl = new SellerDaoImpl();

    /**
     * 将买家身份转换为卖家
     * @param ID 买家ID
     * @param name 买家转换为卖家必须实名认证
     * @return 成功与否
     */
    public boolean changeToSeller(String ID,String name){
        Buyer changeBuyer ;
        List<Buyer> buyers = buyerDIl.getAll();
        for(Buyer buyer : buyers){
            if(buyer.getBuyerId().equals(ID)){
                changeBuyer = buyer;
                sellerDIl.create(changeBuyer.getPasswd(),name,changeBuyer.getIdNumber(),
                        changeBuyer.getNickname(), changeBuyer.getPhone());
                sellerDIl.addToDb();
                buyerDIl.deleteByBuyerId(ID);
                return true;
            }
        }
        return false;
    }
}
