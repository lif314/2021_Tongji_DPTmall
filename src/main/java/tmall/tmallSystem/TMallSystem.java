package tmall.tmallSystem;

import tmall.XMLRepository.ProxyXmlContext;
import tmall.XMLRepository.XMLContext;
import tmall.model.entity.Buyer;
import tmall.model.entity.Seller;
import tmall.model.entityDao.daoImpl.BuyerDaoImpl;
import tmall.model.entityDao.daoImpl.SellerDaoImpl;
import tmall.model.entityDao.daoInterface.BuyerDao;
import tmall.model.entityDao.daoInterface.SellerDao;

import java.util.UUID;

/**
 * 该类时进行全局配置的类：对于没有对象去创建的对象
 * 比如：调用该类可以创建全局优惠券、卖家、买家
 */

public class TMallSystem {

    private static Buyer buyer = null;
    private static Seller seller=null;

    /**
     * 当买家请求注册时创建买家
     *
     * @param nickname 昵称
     * @param passwd   密码
     * @param idNumber 身份证
     * @param phone    电话号码
     * @param gender   性别
     * @param birthday 生日
     * @return buyer
     */
    public static void createBuyer(String nickname, String passwd, String idNumber, String phone, String gender, String birthday) {

        String buyerId = UUID.randomUUID().toString();

        BuyerDao buyerDao = new BuyerDaoImpl();

        Buyer buyer = buyerDao.create(passwd, idNumber, phone, nickname, gender, birthday);

        buyerDao.addToDb();

        TMallSystem.buyer = buyer;
    }

    /**
     * 当买家请求注册时使用
     *
     * @param password 密码
     * @param name     姓名
     * @param idNumber 身份证
     * @param nickname 昵称
     * @param phone    密码
     * @return seller
     */
    public static Seller createSeller(String password, String name, String idNumber, String nickname, String phone) {
        String sellerId = UUID.randomUUID().toString();

        SellerDao sellerDao = new SellerDaoImpl();

        Seller seller = sellerDao.create(password, name, idNumber, nickname, phone);

        sellerDao.addToDb();

        return seller;
    }

    /**
     * 获取buyer
     *
     * @return buyer
     */
    public static Buyer getBuyer() {
        return buyer;
    }

    public static Seller getSeller() {
        return seller;
    }

    /**
     * 买家登录
     *
     * @param phone    电话号码
     * @param password 密码
     * @return bool
     */
    public static boolean buyerLogin(String phone, String password) {
        BuyerDao buyerDao = new BuyerDaoImpl();
        buyer = buyerDao.login(phone, password);
        return buyer != null;
    }

    /**
     * 卖家登录
     *
     * @param name     名称
     * @param password 密码
     * @return bool
     */
    public static boolean sellerLogin(String name, String password) {
        SellerDao sellerDao = new SellerDaoImpl();
        seller = sellerDao.login(name, password);
        return seller != null;
    }
}
