package tmall.model.logicalEntity;

import tmall.XMLRepository.ProxyXmlContext;
import tmall.XMLRepository.XMLContext;
import tmall.model.entity.Buyer;

import java.util.List;
import java.util.UUID;

/**
 * 买家逻辑实体
 */
public class BuyerLogic implements EntityLogic {

    private final static XMLContext<Buyer> buyerXMLContext = new ProxyXmlContext<>(Buyer.class);

    private Buyer buyer;


    /**
     * 创建用户
     * @param nickname 用户昵称
     * @param passwd 密码
     * @param idNumber 身份证号
     * @param phone 电话
     * @param gender 性别
     * @param birthday 生日
     * @return aBuyer
     */
    public Buyer create(String nickname, String passwd, String idNumber, String phone, String gender, String birthday){
        UUID buyerId = UUID.randomUUID();
        this.buyer = new Buyer(buyerId.toString(), passwd, idNumber, phone, nickname, gender, birthday);
        return buyer;
    }

    /**
     * 刷新存储：会将文件数据进行覆盖
     */
    public void save(){
        buyerXMLContext.save(buyer);
    }

    /**
     * 添加用户,不会覆盖原有数据
     */
    public void add(){

    }

    /**
     * 通过Id进行寻找，直到第一个就直接返回
     * @param id 实体集的主码
     * @return aBuyer
     */
    public Buyer findById(String id){
         return buyerXMLContext.findById(id);
    }


    /**
     * 获取数据库中所有数据存放在List中
     * @return List Object
     */
    public List<Buyer> findAllToList(){
        return buyerXMLContext.init();
    }





}