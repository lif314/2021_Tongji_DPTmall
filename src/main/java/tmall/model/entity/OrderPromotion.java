package tmall.model.entity;

/**
 * 订单促销信息
 */
public class OrderPromotion {

    private String orderId;      // 订单id

    private String promotionId;  // 促销券id

    private String type;     // 类别：Activity/Coupon

    public OrderPromotion() {
    }

    public OrderPromotion(String orderId, String promotionId, String type) {
        this.orderId = orderId;
        this.promotionId = promotionId;
        this.type = type;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getPromotionId() {
        return promotionId;
    }

    public void setPromotionId(String promotionId) {
        this.promotionId = promotionId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return  String.format("|%-5s|%-40s|%-40s|",
                type,orderId,promotionId);
//        return "OrderPromotion{" +
//                "orderId='" + orderId + '\'' +
//                ", promotionId='" + promotionId + '\'' +
//                ", type='" + type + '\'' +
//                '}';
    }
}
