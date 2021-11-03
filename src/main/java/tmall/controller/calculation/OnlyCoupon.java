package tmall.controller.calculation;

/**
 * OnlyCoupon类的描述：
 * 只有优惠卷时的优惠活动
 * @author 黄金坤（HJK）
 * @since 2021/10/31  19:19
 */

public class OnlyCoupon implements Discount {
    @Override
    public void doCalculation(Calculator calculator) {
        calculator.useCoupon();
    }
}
