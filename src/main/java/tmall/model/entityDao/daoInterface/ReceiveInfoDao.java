package tmall.model.entityDao.daoInterface;

import org.dom4j.io.SAXReader;
import tmall.model.entity.ReceiveInfo;

import java.util.List;

public interface ReceiveInfoDao {

    /**
     * 创建买家收获信息
     * @param buyerId 买家ID
     * @param receiverName 收货人姓名
     * @param phone 收货人电话号码
     * @param address 收货人地址
     * @param status 收获状态
     * @return a ReceiveInfo
     */
    ReceiveInfo create(String buyerId, String receiverName, String phone, String address, String status);

    /**
     * 存储到数据库中
     */
    void addToDb();

    /**
     * 获取买家所有收获信息
      * @param buyerId 买家id
     * @return List receive information
     */
    List<ReceiveInfo> getAllByBuyerId(String buyerId);

    /**
     * 根据收获状态获取所有信息
     * @param status 收获状态
     * @return list receive information
     */
    List<ReceiveInfo> getAllByStatus(String status);
}
