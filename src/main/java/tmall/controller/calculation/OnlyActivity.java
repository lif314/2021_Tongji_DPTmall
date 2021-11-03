package tmall.controller.calculation;

/**
 * OnlyActivity类的描述：
 * 只有活动时计算优惠后的价格
 * @author 黄金坤（HJK）
 * @since 2021/10/31  19:21
 */

public class OnlyActivity implements Discount {
    @Override
    public void doCalculation(Calculator calculator) {
        calculator.useActivity();
    }
}
