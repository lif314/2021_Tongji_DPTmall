package tmall.controller.calculation;

import tmall.model.entity.Activity;
import tmall.model.entity.Coupon;

/**
 * Calculator类的描述：
 * 计算器：实现状态模式——不同的状态指不同的优惠情况
 * @author 黄金坤（HJK）
 * @since 2021/10/31  19:24
 */

public class Calculator {

    private Discount calculate;//这是计算状态——某一种优惠状态（无优惠、有优惠卷、有活动、优惠卷+活动）
    private Coupon coupon;      //优惠卷
    private Activity activity;  //活动
    private double totalMoney;  //需要付的总价

    public Calculator(double totalMoney,Coupon coupon, Activity activity) {
        this.coupon = coupon;
        this.activity = activity;
        this.totalMoney = totalMoney;
    }

    public Discount getState() {
        return calculate;
    }

    public void setState(Discount calculate) {
        this.calculate = calculate;
    }

    //调用这个方法来得到优惠后的价格
    public double doCalculation(){
        //判断状态
        if(coupon != null){
            setState(new OnlyCoupon());   //设置为只有coupon折扣
            if(activity != null){
                setState(new CouponAndActivity());//设置同时具有Coupon和Activity的折扣
            }
        }
        else if(activity != null){
            setState(new OnlyActivity()); //设置为只有activity折扣
        }else{
            setState(new NoDiscount());   //没有任何折扣
        }

        //借助状态calculate组织的Calculator方法来计算totalMoney的最终结果
        calculate.doCalculation(this);
        return totalMoney;
    }

    //辅助函数，使用活动折扣
    public void useActivity(){
        totalMoney *= Double.parseDouble(activity.getDiscount());
    }

    //辅助函数，使用优惠卷折扣
    public void useCoupon(){
        double full = Double.parseDouble(coupon.getFull());
        if(full <= totalMoney){
            totalMoney -= Double.parseDouble(coupon.getMinus());
        }
    }
}
