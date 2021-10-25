package tmall.model.logicalEntity;

import tmall.model.entity.Buyer;

import java.util.List;

public class Test {

    public static void main(String[] args) {

        BuyerLogic buyerLogic = new BuyerLogic();
        Buyer buyer = buyerLogic.create("llf", "fd", "dfd", "df", "dfdf", "dd");
        buyerLogic.save();

        List<Buyer> allToList = buyerLogic.findAllToList();

        System.out.println(buyer);
    }
}
