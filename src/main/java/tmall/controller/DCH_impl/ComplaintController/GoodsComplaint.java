package tmall.controller.DCH_impl.ComplaintController;

//import tmall.model.entity.Seller;
//import tmall.model.entityDao.daoImpl.SellerDaoImpl;
//import tmall.model.entityDao.daoInterface.SellerDao;

import tmall.controller.DCH_impl.Tmall;
import tmall.model.entity.Seller;
import tmall.model.entityDao.daoImpl.SellerDaoImpl;
import tmall.model.entityDao.daoInterface.SellerDao;

public class GoodsComplaint extends AbstractComplaint {
    public GoodsComplaint() {
        rank=1;
    }

    @Override
    public void replyComplaint() {
        SellerDao sellerDao= new SellerDaoImpl();
        Seller seller=sellerDao.getAll().get(0);

        Chatroom.sendMessage(seller,seller.getName(),"谢谢您的评论，我将会查看您指向的产品.");
    }
}
