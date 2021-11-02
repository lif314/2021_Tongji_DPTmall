package tmall.controller.DCH_impl;

import java.util.List;

/**
 * @description: 实现组合模式，需要一个抽象类Shop表示商店，后用两个类来继承，属性未动
 */
public abstract class ComponentShop {

    protected String shopId;   // 店铺Id

    protected String sellerId; // 卖家Id

    protected String shopName;     // 店铺名称

    protected String creditScore;  // 店铺积分

    protected String category;     // 店铺类别

    protected String shopAddress;  // 店铺发货地址

    protected String description;  // 店铺描述

    public abstract String getShopName();

    public abstract String getCategory();

    public abstract int getcreditScore();

    public abstract void showShop();

    public abstract void gainShop(List<Object> countShop);

    public abstract void add(ComponentShop componentShop);

}
