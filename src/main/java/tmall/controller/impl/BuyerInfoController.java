package tmall.controller.impl;

import tmall.controller.Interface.UserInfoMemento.CareTaker;
import tmall.controller.Interface.UserInfoMemento.Originator;
import tmall.model.entity.Buyer;
import tmall.model.entity.NullUser;
import tmall.model.entityDao.daoImpl.BuyerDaoImpl;
import tmall.controller.Interface.UserInfoController;

import java.util.List;


/**
 * @description: 管理卖家的信息
 * @description: 使用了备忘录模式、空对象模式
 */
public class BuyerInfoController implements UserInfoController {
    private static final BuyerDaoImpl BuyerDI = new BuyerDaoImpl();
    static List<Buyer> buyersInfo = BuyerDI.getAll();

    // 备忘录管理器 备忘录只在修改页面有效 一旦退出就无法回滚
    static Originator<Buyer> originator = new Originator<>();
    // 获得备忘录信息
    static CareTaker<Buyer> careTaker = new CareTaker<>();

    /**
     * @description: 获得买家的信息
     * @description: 空对象模式
     * @param ID 用户ID
     * @return 返回买家实例或空对象
     */
    @Override
    public Object getInfo(String ID) {
        for(Buyer buyer : buyersInfo){
            if(buyer.getBuyerId().equals(ID))
                return buyer;
        }
        return new NullUser();
    }

    public Object getInfo(Buyer buyer) {
       return buyer;
    }

    @Override
    public Boolean editInfo(String ID) {
        Buyer editedBuyer = originator.getState();
        for(Buyer buyer : buyersInfo){
            if(buyer.getBuyerId().equals(ID)) {
                // 替换
                BuyerDI.deleteByBuyerId(ID);
                BuyerDI.create(editedBuyer.getPasswd(),editedBuyer.getIdNumber(),editedBuyer.getPhone(),
                        editedBuyer.getNickname(),editedBuyer.getGender(),editedBuyer.getBirthday());
                BuyerDI.addToDb();
                return true;
            }
        }
        return false;
    }

    /**
     * @description: 备忘录模式
     * @param ID 用户ID
     * @param value 修改后的值
     * @return 是否修改成功
     */
    public Boolean editBuyerPassword(String ID, String value){
        Buyer buyer = null;
        for(Buyer buyer_ : buyersInfo) {
            if (buyer_.getBuyerId().equals(ID)) {
                buyer = buyer_;
                originator.setState(buyer_);
                careTaker.add(originator.saveStateToMemento());
            }
        }
        if(buyer == null)
            return false;
        BuyerDI.updatePassword(buyer.getBuyerId(),value);
        buyer.setPasswd(value);
        originator.setState(buyer);

        return true;
    }

    /**
     * @description: 为用户提供一种回滚数据库的方法
     * @return 旧的状态
     */
    public Buyer rollbackEdite(){
        // 得到状态
        originator.getStateFromMemento(careTaker.get());
        // 回滚数据库
        Buyer editedBuyer = originator.getState();
        BuyerDI.updatePassword(editedBuyer.getBuyerId(),editedBuyer.getPasswd());
        return editedBuyer;
    }
}
