package tmall.controller.DCH_impl.VerifyLevelController;

import tmall.controller.Controller;
import tmall.controller.DCH_impl.Tmall;
import tmall.model.entity.Seller;
import tmall.model.entityDao.daoImpl.SellerDaoImpl;
import tmall.model.entityDao.daoInterface.SellerDao;

/**
 * @description: 验证精英买家Controller
 */
public class VerifyLevelController extends Controller {
    /**
     * @description: 只需要调用此方法
     */
    public void askforElite(){
        //需要一个天猫平台
        Tmall t1=new Tmall();

        //准备进行命令/雇工模式
        CommunicationService verifyLevelService=new VerifyLevelService(t1);

        Administrator trans1=new Administrator(verifyLevelService);

        SellerDao sellerDao=new SellerDaoImpl();
        Seller seller=sellerDao.getAll().get(0);

        trans1.verifyLevelServiceExecute(seller.getNickname(), 2);
    }
}
