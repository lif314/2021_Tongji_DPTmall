package tmall.controller.orderController;

import tmall.model.logicalEntity.OrderLogic;

public class ShoppingTest {
    public static void main(String[] args) {
        ShoppingCenter shoppingCenter = new ShoppingCenter();


        shoppingCenter.selectCommodity("1f7c3228-0daf-45fd-ab8b-777583c3a8b7", "3");
        shoppingCenter.selectPromotions(null, "5baa35b7-e61a-4783-85b4-0f826a5e7205");
        shoppingCenter.selectBuyerAddress("8413ab51-a04a-4571-99a4-e3cd6ac8958b");
        System.out.println(shoppingCenter.calTotalMoney());
        System.out.println(shoppingCenter.calPaidMoney());
        shoppingCenter.selectPayMethod("1");
        shoppingCenter.payImmediately();
        shoppingCenter.displayOrderDetail("c481e837-3461-4e11-b68e-361e40b7233a");

//        OrderController orderController = new OrderController();
//        OrderLogic orderDetailById = orderController.findOrderDetailById("900d5849-64a0-4fde-9e06-173fd437ee31");
//        System.out.println(orderDetailById);

    }
}
