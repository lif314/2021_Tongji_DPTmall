package tmall.XMLRepository.test;

import tmall.XMLRepository.XMLContext;

public class XMLContextTest {

    public static void main(String[] args) {

        // 订单XML数据库上下文，你可以通过对订单数据进行操作
        XMLContext<OrderTest> xmlContext = new XMLContext<>(OrderTest.class);

        OrderTest order1 = new OrderTest();
        order1.setOrderId("00001");
        order1.setAddressId("00001");
        order1.setBuyerId("00001");
        order1.setShopId("00001");
        order1.setOrderAmount("3");
        order1.setCreateDate("2021-10-21");
        order1.setStatus("已签收");

        OrderTest order2 = new OrderTest("00002", "00002", "00002", "00002", "2021-10-22", "已发送", "2");

        xmlContext.save(order1, order2);
    }

}
