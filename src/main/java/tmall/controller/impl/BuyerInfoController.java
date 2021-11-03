package tmall.controller.impl;

import tmall.controller.Interface.UserInfoMemento.CareTaker;
import tmall.controller.Interface.UserInfoMemento.Originator;
import tmall.controller.Interface.UserInfoController;
import tmall.model.entity.Buyer;
import tmall.model.entity.NullBuyer;
import tmall.model.entityDao.daoImpl.BuyerDaoImpl;
import tmall.model.entityDao.daoInterface.BuyerDao;

import java.util.List;


public class BuyerInfoController implements UserInfoController {
    private final BuyerDao BuyerDI = new BuyerDaoImpl();
    List<Buyer> buyersInfo = BuyerDI.getAll();

    // 备忘录管理器 备忘录只在修改页面有效 一旦退出就无法回滚
    Originator<Buyer> originator = new Originator<>();
    // 获得备忘录信息
    CareTaker<Buyer> careTaker = new CareTaker<>();

    /**
     * 前端调用，获得买家信息
     * @param ID
     * @return 空对象或买家实例
     */
    @Override
    public Object getInfo(String ID) {
        for(Buyer buyer : buyersInfo){
            if(buyer.getBuyerId().equals(ID))
                return buyer;
        }
        return new NullBuyer();
    }

    /**
     * 前端可调用，获得买家信息
     * @param buyer
     * @return
     */
    public Buyer getInfo(Buyer buyer) {
       return buyer;
    }

    @Override
    public Boolean editInfo(String ID) {
        Buyer editedBuyer = originator.getState();
        for(Buyer buyer : buyersInfo){
            if(buyer.getBuyerId().equals(ID)) {
                // 替换
                BuyerDI.deleteByBuyerId(ID);
                BuyerDI.create(editedBuyer.getPasswd(),editedBuyer.getBuyerId(),editedBuyer.getPhone(),
                        editedBuyer.getNickname(),editedBuyer.getGender(),editedBuyer.getBirthday());
                return true;
            }
        }
        return false;
    }


    /**
     * 用于前端调用，修改用户信息
     * @param buyer
     * @return
     */
    public Boolean editBuyerInfo(Buyer buyer){
        originator.setState(buyer);
        return editInfo(originator.getState().getBuyerId());
    }

    /**
     * 用于前端调用，通过备忘录回滚修改
     * @return
     */
    public Buyer rollbackEdite(){
        // 得到状态
        originator.getStateFromMemento(careTaker.get());
        // 回滚数据库
        Buyer editedBuyer = originator.getState();
        BuyerDI.deleteByBuyerId(editedBuyer.getBuyerId());
        BuyerDI.create(editedBuyer.getPasswd(),editedBuyer.getBuyerId(),editedBuyer.getPhone(),
                editedBuyer.getNickname(),editedBuyer.getGender(),editedBuyer.getBirthday());
        return editedBuyer;
    }
}
