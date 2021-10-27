package tmall.model.entityDao.daoImpl;

import tmall.XMLRepository.ProxyXmlContext;
import tmall.XMLRepository.XMLContext;
import tmall.model.entity.Commodity;
import tmall.model.entity.ShoppingCart;
import tmall.model.entityDao.daoInterface.ShoppingCartDao;
import tmall.model.logicalEntity.ShoppingCartLogic;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ShoppingCartDaoImpl implements ShoppingCartDao {

    // 购物车数据库上下文
    private final XMLContext<ShoppingCart> shoppingCartXMLContext = new ProxyXmlContext<>(ShoppingCart.class);

    // 商品数据库上下文
    private final XMLContext<Commodity> commodityXMLContext = new ProxyXmlContext<>(Commodity.class);

    // 购物车联系集
    private ShoppingCart shoppingCart;

    /**
     * 添加商品到购物车
     *
     * @param buyerId     买家id
     * @param commodityId 商品id
     * @return 购物车简介
     */
    @Override
    public ShoppingCart create(String buyerId, String commodityId, String amount) {
        // get the current date and time
        LocalDateTime dateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyy-MM-dd HH:mm:ss");
        shoppingCart = new ShoppingCart(buyerId, commodityId, amount, dateTime.format(formatter));
        return shoppingCart;
    }

    /**
     * 存储到数据库中
     */
    @Override
    public void addToDb() {
        shoppingCartXMLContext.add(shoppingCart);
    }

    /**
     * 获取用户的购物车详情
     *
     * @param buyerId 买家id
     * @return list ShoppingCartLogic
     */
    @Override
    public List<ShoppingCartLogic> getCartByBuyerId(String buyerId) {
        List<ShoppingCartLogic>  shoppingCartLogicList = new ArrayList<>();
        // 获取购物车联系集所有数据
        List<ShoppingCart> init = shoppingCartXMLContext.init();
        for (ShoppingCart sc : init) {
            // 获取buyerId的联系集
            if (sc.getBuyerId().equals(buyerId)){
                // 根据联系集获取商品信息
                Commodity c = commodityXMLContext.findById(sc.getCommodityId());
                // 创建购物车详情
                ShoppingCartLogic shoppingCartLogic = new ShoppingCartLogic(c.getCommodityId(), c.getCname(), c.getPrice(), sc.getAmount(), c.getCategory(), c.getDescription(), sc.getCreateDate());
                shoppingCartLogicList.add(shoppingCartLogic);
            }
        }
        return shoppingCartLogicList;

    }
}
