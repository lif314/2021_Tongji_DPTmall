package tmall.model.entity;

//import tmall.controller.DCH_impl.ComplaintController.Chatroom;

import tmall.controller.DCH_impl.ComplaintController.Chatroom;

/**
 * 店铺关注实体表
 */
public class FollowShop {

    private String shopId;  // 店铺Id

    private String buyerId;  // 买家Id

    public String followDate;  // 关注时间

    public FollowShop() {
    }

    public FollowShop(String shopId, String buyerId, String followDate) {
        this.shopId = shopId;
        this.buyerId = buyerId;
        this.followDate = followDate;
    }

    public String getShopId() {
        return shopId;
    }

    public void setShopId(String shopId) {
        this.shopId = shopId;
    }

    public String getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(String buyerId) {
        this.buyerId = buyerId;
    }

    public String getFollowDate() {
        return followDate;
    }

    public void setFollowDate(String followDate) {
        this.followDate = followDate;
    }

    /**
     * Observer: 店铺发布新活动（优惠券）后，买家做出响应（在消息列表中增加一条消息）
     */
    public void cheers(String type){
        Chatroom.addMessage(buyerId, shopId, type);
    }

    @Override
    public String toString() {
        return  String.format("|%-10s|%-40s|%-40s|",
                followDate,buyerId,shopId);
//        return "FollowShop{" +
//                "shopId='" + shopId + '\'' +
//                ", buyerId='" + buyerId + '\'' +
//                ", followDate='" + followDate + '\'' +
//                '}';
    }
}
