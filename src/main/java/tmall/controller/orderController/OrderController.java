package tmall.controller.orderController;

import tmall.model.entityDao.daoImpl.OrderLogicBuilder;
import tmall.model.logicalEntity.OrderLogic;

public class OrderController {


    public OrderLogic findOrderDetailById(String orderId){
        return OrderLogicBuilder.getOrderBuilderInstance()
                .initOrderLogicBuilder(orderId)
                .setOrderCommodities()
                .setShopInfo()
                .setOrderPromotions()
                .setOrderAddress()
                .setOrderPayment()
                .display();
    }


}
