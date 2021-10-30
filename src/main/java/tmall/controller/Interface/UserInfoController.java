package tmall.controller.Interface;

/**
 * BuyerInfoController SellerInfoController的基类
 */
public interface UserInfoController {
    public Object getInfo(String ID);
    public Boolean editInfo(String ID);
}
