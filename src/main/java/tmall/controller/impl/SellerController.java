package tmall.controller.impl;

import org.dom4j.io.SAXReader;
import tmall.XMLRepository.ProxyXmlContext;
import tmall.XMLRepository.XMLContext;
import tmall.controller.Controller;
import tmall.model.entity.Seller;
import tmall.model.entity.ShoppingCart;


import java.util.List;
import java.util.Scanner;
import java.util.UUID;

public class SellerController extends Controller {

    /**
     * Seller数据库上下文，一般我们会将数据库上下文定义为全局变量
     */
    private final XMLContext<Seller> sellerXMLContext = new ProxyXmlContext<>(Seller.class);

    @Override
    public Object[] execute(Object...args) {
        System.out.println("欢迎来到天猫购物节");

        System.out.println("请输入登录信息：");
        Scanner scanner = new Scanner(System.in);
        System.out.println("sellerName:");
        String sname = scanner.next();
        System.out.println("password:");
        String password = scanner.next();
        System.out.println("idNumber:");
        String idNumber = scanner.next();
        System.out.println("nickname:");
        String nickname = scanner.next();
        System.out.println("phone:");
        String phone = scanner.next();

        createSeller(sname,password, idNumber, nickname, phone);
        Object[] judge = {1};
        return judge;
    }

    public void createSeller(String sname, String password, String idNumber, String nickname, String phone){

        UUID sellerId = UUID.randomUUID();

        Seller seller = new Seller(sellerId.toString(), sname, password, idNumber, nickname, phone);

        sellerXMLContext.save(seller);
    }
}
