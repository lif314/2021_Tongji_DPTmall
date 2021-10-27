package tmall.model.entityDao.daoImpl;

import tmall.XMLRepository.ProxyXmlContext;
import tmall.XMLRepository.XMLContext;
import tmall.model.entity.Coupon;
import tmall.model.entityDao.daoInterface.CouponDao;

import java.util.List;
import java.util.UUID;

public class CouponDaoImpl implements CouponDao {

    private final XMLContext<Coupon> couponXMLContext = new ProxyXmlContext<>(Coupon.class);

    private  Coupon coupon;

    /**
     * 发布优惠券
     *
     * @param startTime 开始时间
     * @param endTime   结束时间
     * @param full      满多少
     * @param minus     减多少
     * @return a coupon
     */
    @Override
    public Coupon create(String startTime, String endTime, String full, String minus) {
        String activityId = UUID.randomUUID().toString();
        coupon = new Coupon(activityId, startTime, endTime, full, minus);
        return coupon;
    }

    /**
     * 存储到数据库中
     */
    @Override
    public void addToDb() {
        couponXMLContext.add(coupon);
    }

    /**
     * 查找优惠券
     *
     * @param couponId 优惠券id
     * @return a coupon
     */
    @Override
    public Coupon getById(String couponId) {
        return couponXMLContext.findById(couponId);
    }

    /**
     * 获取所有优惠券
     *
     * @return list coupon
     */
    @Override
    public List<Coupon> getAll() {
        return couponXMLContext.init();
    }

    /**
     * 删除优惠券
     *
     * @param couponId id
     */
    @Override
    public void deleteById(String couponId) {
        couponXMLContext.deleteById(couponId);
    }
}
