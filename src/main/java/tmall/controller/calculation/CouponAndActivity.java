package tmall.controller.calculation;

/**
 * CouponAndActivity类的描述：
 * 同时具有活动和优惠
 * @author 黄金坤（HJK）
 * @since 2021/10/31  19:22
 */

public class CouponAndActivity implements Discount {
    @Override
    public void doCalculation(Calculator calculator) {
        calculator.useCoupon();
        calculator.useActivity();
    }
}
