package tmall.model.entityDao;

import tmall.model.entity.Commodity;
import tmall.model.entity.Seller;
import tmall.model.entity.Shop;
import tmall.model.entityDao.daoImpl.*;
import tmall.model.entityDao.daoInterface.*;
import tmall.model.logicalEntity.CommodityCategory;

import java.util.List;

public class DaoTest {
    public static void main(String[] args) {

//        SellerDao sellerDao = new SellerDaoImpl();
//        Seller seller = sellerDao.create("123456", "lza", "12131433232", "Strange", "15678900876");
//        sellerDao.addToDb();
//
//        ShopDao shopDao = new ShopDaoImpl();
//        Shop shop = shopDao.create(seller.getSellerId(), "LzaShop", "10", "电子", "同济大学嘉定小区", "哈皮");
//        shopDao.addToDb();
//
//        CommodityDao commodityDao = new CommodityDaoImpl();
//        Commodity commodity = commodityDao.create(shop.getShopId(), "100", CommodityCategory.SHIRT.name(), "56", "七匹狼", "爱你所爱！");
//        commodityDao.addToDb();
//
//        List<Commodity> all = commodityDao.getAll();
//        for (Commodity commodity1 : all) {
//            System.out.println(commodity1);
//        }
//
//        commodityDao.deleteById(commodity.getCommodityId());
//
//        ActivityDao activityDao = new ActivityDaoImpl();
//        activityDao.create("2021-10-30", "2021-11-11", "双十一", "0.90");
//        activityDao.addToDb();

        CouponDao couponDao = new CouponDaoImpl();
        couponDao.create("b3388015-b394-4cae-ab2c-154edd8ab8ea", "2021-10-30","2021-11-11", "100", "10");
        couponDao.addToDb();

//        Order order = OrderBuilder.newOrderBuilder()
//                .initOrder("buyerId")
//                .setOrderAddress("receiveId")
//                .setPromotion()
//                .setPromotion()
//                .setOrderCommodities()
//                .setOrderPayment()
//                .build();

    }
}
