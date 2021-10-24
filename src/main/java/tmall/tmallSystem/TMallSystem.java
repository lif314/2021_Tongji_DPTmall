package tmall.tmallSystem;

import tmall.XMLRepository.ProxyXmlContext;
import tmall.XMLRepository.XMLContext;
import tmall.model.entity.Buyer;
import tmall.model.entity.Seller;

import java.util.UUID;

/**
 * 该类时进行全局配置的类：对于没有对象去创建的对象
 * 比如：调用该类可以创建全局优惠券、卖家、买家
 */

public class TMallSystem {

    /**
     * 创建买家
     * @return 一个用户的信息，用于显示
     */
    public static Buyer createBuyer(String nickname, String passwd, String idNumber, String phone, String gender, String birthday){

        UUID buyerId = UUID.randomUUID();

        Buyer buyer = new Buyer(buyerId.toString(), passwd, idNumber, phone, nickname, gender, birthday);

        XMLContext<Buyer> buyerXMLContext = new ProxyXmlContext<>(Buyer.class);
        buyerXMLContext.save(buyer);

        return buyer;
    }

}
