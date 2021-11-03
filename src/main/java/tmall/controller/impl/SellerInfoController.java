package tmall.controller.impl;

import tmall.controller.Interface.UserInfoMemento.CareTaker;
import tmall.controller.Interface.UserInfoMemento.Originator;
import tmall.controller.Interface.UserInfoController;
import tmall.model.entity.NullSeller;
import tmall.model.entity.Seller;
import tmall.model.entityDao.daoImpl.SellerDaoImpl;
import tmall.model.entityDao.daoInterface.SellerDao;

import java.util.List;

public class SellerInfoController implements UserInfoController {

    // 获得数据库
    private final SellerDao sellerDao = new SellerDaoImpl();

    List<Seller> sellersInfo = sellerDao.getAll();


    // 备忘录管理器 备忘录只在修改页面有效 一旦退出就无法回滚
    Originator<Seller> originator = new Originator<>();
    // 获得备忘录信息
    CareTaker<Seller> careTaker = new CareTaker<>();

    /**
     * 前端调用，返回买家信息
     * @param ID
     * @return 空对象或买家实例
     */
    @Override
    public Object getInfo(String ID) {
        for(Seller seller : sellersInfo){
            if(seller.getSellerId().equals(ID))
                return seller;
        }
        return new NullSeller();
    }

    /**
     * 前端调用，返回买家信息
     * @param seller
     * @return 空对象或买家实例
     */
    public Seller getInfo(Seller seller) {
        return seller;
    }

    @Override
    public Boolean editInfo(String ID) {
        Seller editedSeller = originator.getState();
        for(Seller seller : sellersInfo){
            if(seller.getSellerId().equals(ID)) {
                // 数据库修改
                SellerDao sellerDao = new SellerDaoImpl();
                sellerDao.deleteById(ID);
                sellerDao.create(editedSeller.getPassword(),editedSeller.getName(),editedSeller.getSellerId(),
                        editedSeller.getNickname(),editedSeller.getPhone());
                sellerDao.addToDb();
                careTaker.add(originator.saveStateToMemento());
                return true;
            }
        }
        return false;
    }

    /**
     * 前端调用，修改买家信息
     * @param seller
     * @return 买家实例
     */
    public Boolean editSellerInfo(Seller seller){
        originator.setState(seller);
        return editInfo(originator.getState().getSellerId());
    }

    /**
     * 前端调用，回滚修改信息
     * @return
     */
    public Seller rollbackEdite(){
        // 得到状态
        originator.getStateFromMemento(careTaker.get());
        // 回滚数据库
        Seller editedSeller = originator.getState();
        sellerDao.deleteById(editedSeller.getSellerId());
        sellerDao.create(editedSeller.getPassword(),editedSeller.getName(),editedSeller.getSellerId(),
                editedSeller.getNickname(),editedSeller.getPhone());
        return editedSeller;
    }

}
