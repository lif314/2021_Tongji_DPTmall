package tmall.controller.impl;

import tmall.model.entity.Activity;
import tmall.model.entity.Coupon;
import tmall.model.entityDao.daoImpl.ActivityDaoImpl;
import tmall.model.entityDao.daoImpl.CouponDaoImpl;
import tmall.model.entityDao.daoInterface.ActivityDao;
import tmall.model.entityDao.daoInterface.CouponDao;

import java.util.List;

/**
 * @Author Sir Lancelot
 * @Description 发布活动
 */
public class ActivityBuilder{
    String current_shopId;
    public ActivityBuilder(String ShopId){
        current_shopId = ShopId;
        CouponDao couponDao = new CouponDaoImpl();
        List<Coupon> shopCoupons = couponDao.getAllByShopId(current_shopId);
    }

    /**
     * 添加优惠券（不指定用户和数量）
     * @param startTime 开始
     * @param endTime 截止
     * @param full 使用条件（消费满多少元）
     * @param minus 减多少元
     */
    public void addCoupon(String startTime, String endTime, String full, String minus) {
        CouponDao couponDao = new CouponDaoImpl();
        couponDao.create(current_shopId, startTime, endTime, full, minus);
        couponDao.addToDb();
//        ShopController.Notify N = new ShopController.notifyNewCoupon();
//        N.notify(current_shopId);
        ShopController shopController = new ShopController();
        shopController.strategy = new ShopController.notifyNewCoupon();
        shopController.notifySubscribers(current_shopId);
    }

    /**
     * 添加活动 (全场应用)，不属于店铺后台管理范围，只是在这里实现
     * @param activityName 活动名
     * @param startTime 开始
     * @param endTime 截止
     * @param discount 打折
     */
    public Activity addActivity(String activityName, String startTime, String endTime, String discount){
        ActivityDao activityDao = new ActivityDaoImpl();
        return activityDao.create(activityName, startTime, endTime, discount);
    }
}
