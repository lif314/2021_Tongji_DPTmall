package tmall.model.entityDao.daoImpl;

import tmall.XMLRepository.ProxyXmlContext;
import tmall.XMLRepository.XMLContext;
import tmall.model.entityDao.daoInterface.ReceiveInfoDao;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ReceiveInfoDaoImpl implements ReceiveInfoDao {

    private final XMLContext<ReceiveInfo> receiveInfoXMLContext = new ProxyXmlContext<>(ReceiveInfo.class);

    private ReceiveInfo receiveInfo;

    /**
     * 创建买家收获信息
     *
     * @param buyerId      买家ID
     * @param receiverName 收货人姓名
     * @param phone        收货人电话号码
     * @param address      收货人地址
     * @param status       收获状态
     * @return a ReceiveInfo
     */
    @Override
    public ReceiveInfo create(String buyerId, String receiverName, String phone, String address, String status) {
        String receiveInfoId = UUID.randomUUID().toString();
        receiveInfo = new ReceiveInfo(receiveInfoId, buyerId, receiverName, phone, address, status);
        return receiveInfo;
    }

    /**
     * 存储到数据库中
     */
    @Override
    public void addToDb() {
        receiveInfoXMLContext.add(receiveInfo);
    }

    /**
     * 获取买家所有收获信息
     *
     * @param buyerId 买家id
     * @return List receive information
     */
    @Override
    public List<ReceiveInfo> getAllByBuyerId(String buyerId) {
        List<ReceiveInfo> init = receiveInfoXMLContext.init();
        List<ReceiveInfo> res = new ArrayList<>();
        for (ReceiveInfo info : init) {
            if(info.getBuyerId().equals(buyerId)) {
                res.add(info);
            }
        }
        return res;
    }

    /**
     * 根据收获状态获取所有信息
     *
     * @param status 收获状态
     * @return list receive information
     */
    @Override
    public List<ReceiveInfo> getAllByStatus(String status) {
        List<ReceiveInfo> init = receiveInfoXMLContext.init();
        List<ReceiveInfo> res = new ArrayList<>();
        for (ReceiveInfo info : init) {
            if(info.getStatus().equals(status)) {
                res.add(info);
            }
        }
        return res;
    }
}
