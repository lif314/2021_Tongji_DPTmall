package tmall.controller.calculation;

/**
 * NoDiscount类的描述：
 * 没有任何优惠的处理方式
 * @author 黄金坤（HJK）
 * @since 2021/10/31  19:16
 */

public class NoDiscount implements Discount {
    @Override
    public void doCalculation(Calculator calculator) {
        //do nothing
    }
}
