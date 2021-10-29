package tmall.model.entity;

/**
 * 订单促销信息
 */
public class OrderPromotion {

    private String orderId;      // 订单id

    private String promotionId;  // 促销券id

    public OrderPromotion() {
    }

    public OrderPromotion(String orderId, String promotionId) {
        this.orderId = orderId;
        this.promotionId = promotionId;
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

    @Override
    public String toString() {
        return "OrderPromotion{" +
                "orderId='" + orderId + '\'' +
                ", promotionId='" + promotionId + '\'' +
                '}';
    }
}
