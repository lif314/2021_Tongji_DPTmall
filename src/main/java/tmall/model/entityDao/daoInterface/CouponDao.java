package tmall.model.entityDao.daoInterface;

import tmall.model.entity.Coupon;

import java.util.List;

public interface CouponDao {

    /**
     * 发布优惠券
     * @param startTime 开始时间
     * @param endTime 结束时间
     * @param full 满多少
     * @param minus 减多少
     * @return a coupon
     */
    Coupon create(String startTime, String endTime, String full, String minus);

    /**
     * 存储到数据库中
     */
    void addToDb();

    /**
     * 查找优惠券
     * @param couponId 优惠券id
     * @return a coupon
     */
    Coupon getById(String couponId);

    /**
     * 获取所有优惠券
     * @return list coupon
     */
    List<Coupon> getAll();

    /**
     * 删除优惠券
     * @param couponId id
     */
    void deleteById(String couponId);
}
