package tmall.controller.calculation;

public interface Discount {
    //根据coupon和activity计算总价经过折扣后的价格
    void doCalculation(Calculator calculator);
}
