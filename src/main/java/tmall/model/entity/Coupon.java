package tmall.model.entity;

/**
 * 优惠实体表
 *
 * 优惠券是满多少减多少
 */

public class Coupon {

    public String couponId;  // 优惠券Id

    public String startTime; // 起始时间

    public String endTime;   // 终止时间

    public String full;      // 满多少

    public String minus;     // 减多少

    public Coupon() {
    }

    public Coupon(String couponId, String startTime, String endTime, String full, String minus) {
        this.couponId = couponId;
        this.startTime = startTime;
        this.endTime = endTime;
        this.full = full;
        this.minus = minus;
    }

    public String getCouponId() {
        return couponId;
    }

    public void setCouponId(String couponId) {
        this.couponId = couponId;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getFull() {
        return full;
    }

    public void setFull(String full) {
        this.full = full;
    }

    public String getMinus() {
        return minus;
    }

    public void setMinus(String minus) {
        this.minus = minus;
    }

    @Override
    public String toString() {
        return "Coupon{" +
                "couponId='" + couponId + '\'' +
                ", startTime='" + startTime + '\'' +
                ", endTime='" + endTime + '\'' +
                ", full='" + full + '\'' +
                ", minus='" + minus + '\'' +
                '}';
    }
}
