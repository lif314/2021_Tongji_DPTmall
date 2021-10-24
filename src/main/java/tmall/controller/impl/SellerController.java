package tmall.controller.impl;

import tmall.XMLRepository.XMLContext;
import tmall.controller.Controller;
import tmall.model.entity.Seller;

import java.util.Scanner;
import java.util.UUID;

public class SellerController extends Controller {

    @Override
    public Object[] execute(Object...args) {
        System.out.println("欢迎来到天猫购物节");
        System.out.println("请输入您的账号和积分");
        Scanner scanner = new Scanner(System.in);
        String sname = scanner.next();
        String creditScore = scanner.next();
        createSeller(sname,creditScore);
        Object[] judge = {1};
        return judge;
    }

    public void createSeller(String sname, String creditScore){

        UUID sellerId = UUID.randomUUID();

        Seller seller = new Seller(sellerId.toString(), sname, creditScore);

        XMLContext<Seller> sellerXMLContext = new XMLContext<>(Seller.class);
        sellerXMLContext.save(seller);

//        return seller;
    }
}
