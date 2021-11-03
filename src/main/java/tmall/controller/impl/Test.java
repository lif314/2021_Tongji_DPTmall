package tmall.controller.impl;

import tmall.model.entity.FollowShop;
import tmall.model.entityDao.daoImpl.CommodityDaoImpl;
import tmall.model.entityDao.daoImpl.FollowShopDaoImpl;
import tmall.model.entityDao.daoInterface.CommodityDao;
import tmall.model.entityDao.daoInterface.FollowShopDao;

import java.util.Arrays;
import java.util.List;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName Test.java
 * @Description TODO
 * @createTime 2021年11月02日 19:33:00
 */
public class Test {

    public static void main(String[] args) {
//        ShopController shopController = new ShopController();
//        ComFactory comFactory = new ComFactory("b3388015-b394-4cae-ab2c-154edd8ab8ea");
//        System.out.println(comFactory.add("设计模式","书籍","36","20","好，很有精神"));
//        System.out.println(Arrays.toString(shopController.execute("b3388015-b394-4cae-ab2c-154edd8ab8ea")));
//        ComFactory comFactory = new ComFactory("b3388015-b394-4cae-ab2c-154edd8ab8ea");
//        comFactory.add("wwj","大佬","999","1","yyds");

        FollowShopDao followShopDao = new FollowShopDaoImpl();
        followShopDao.create("b3388015-b394-4cae-ab2c-154edd8ab8ea", "c481e837-3461-4e11-b68e-361e40b7233a");
        followShopDao.addToDb();
        List<FollowShop> followShopList = followShopDao.getAllByShopId("b3388015-b394-4cae-ab2c-154edd8ab8ea");
        System.out.println(followShopList);
//                System.out.println(Arrays.toString(shopController.getCouponList("b3388015-b394-4cae-ab2c-154edd8ab8ea")));
//        CommodityDao commodityDao = new CommodityDaoImpl();
//        System.out.println(commodityDao.getAllByShopId("b3388015-b394-4cae-ab2c-154edd8ab8ea"));
    }
}
