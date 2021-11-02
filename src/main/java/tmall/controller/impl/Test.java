package tmall.controller.impl;

import tmall.model.entityDao.daoImpl.CommodityDaoImpl;
import tmall.model.entityDao.daoInterface.CommodityDao;

import java.util.Arrays;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName Test.java
 * @Description TODO
 * @createTime 2021年11月02日 19:33:00
 */
public class Test {

    public static void main(String[] args) {
        ShopController shopController = new ShopController();
        System.out.println(Arrays.toString(shopController.execute("b3388015-b394-4cae-ab2c-154edd8ab8ea")));

        CommodityDao commodityDao = new CommodityDaoImpl();
        System.out.println(commodityDao.getAllByShopId("b3388015-b394-4cae-ab2c-154edd8ab8ea"));
    }
}
