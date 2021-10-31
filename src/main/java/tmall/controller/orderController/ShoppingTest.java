package tmall.controller.orderController;

import tmall.model.logicalEntity.OrderLogic;

public class ShoppingTest {
    public static void main(String[] args) {
        ShoppingCenter shoppingCenter = new ShoppingCenter();


        shoppingCenter.selectCommodity("1f7c3228-0daf-45fd-ab8b-777583c3a8b7", "3");
        shoppingCenter.selectPromotions(null, "5baa35b7-e61a-4783-85b4-0f826a5e7205");
        shoppingCenter.selectBuyerAddress("bb30e991-0bde-4eb7-9ee6-00a266f4120f");
        System.out.println(shoppingCenter.calTotalMoney());
        System.out.println(shoppingCenter.calPaidMoney());
        shoppingCenter.selectPayMethod("1");
        shoppingCenter.payImmediately();
        shoppingCenter.displayOrderDetail("c481e837-3461-4e11-b68e-361e40b7233a");

//        OrderController orderController = new OrderController();
//        OrderLogic orderDetailById = orderController.findOrderDetailById("5d55c3d5-c399-4165-90a0-cd0fa9834fb2");
//        System.out.println(orderDetailById);

    }
}
