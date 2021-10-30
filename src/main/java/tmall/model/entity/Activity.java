package tmall.model.entity;

import tmall.controller.impl.ShopController;

/**
 * 活动实体表：全场打折
 * 说明：活动以打折的形式出现，优惠券以满多少减多少的形式出现
 */

public class Activity {

    public String activityId;  // 活动Id

    public String startTime;   // 起始时间

    public String endTime;     // 终止时间

    public String activityName;      // 活动名称

    public String discount;   // 打折

    public Activity() {
    }

    public Activity(String activityId, String startTime, String endTime, String activityName, String discount) {
        this.activityId = activityId;
        this.startTime = startTime;
        this.endTime = endTime;
        this.activityName = activityName;
        this.discount = discount;
    }

    public String getActivityId() {
        return activityId;
    }

    public void setActivityId(String activityId) {
        this.activityId = activityId;
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

    public String getActivityName() {
        return activityName;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }

    /**
     * @Author Sir Lancelot
     */
    @Override
    public String toString() {
        return "Activity{" +
                "activityId='" + activityId + '\'' +
                ", startTime='" + startTime + '\'' +
                ", endTime='" + endTime + '\'' +
                ", activityName='" + activityName + '\'' +
                ", discount='" + discount + '\'' +
                '}';
    }

}
