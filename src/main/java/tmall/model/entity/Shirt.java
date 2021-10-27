package tmall.model.entity;

import tmall.controller.impl.CommodityVisitor;
import tmall.model.entity.Commodity;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 卢子昂
 * @date 2021/10/20 22:42
 * @description: 以shirt为例，作为商品的一个分区
 */

public class Shirt extends Commodity {
    protected String size;//S, M, L, XL
    protected String color;//red, blue or something
    protected String remark;//add your comments or remarks on your shirt

    public Shirt() {}

    public Shirt(String size) {
        this.size = size;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public List<String> acceptGeneralProperty(CommodityVisitor commodityVisitor) {
        return commodityVisitor.visitGeneralProperty(this);
    }

    @Override
    public List<String> acceptSpecialProperty(CommodityVisitor commodityVisitor) {
        return commodityVisitor.visitSpecialProperty(this);
    }

    @Override
    public List<String> getSpecialProperty() {
        List<String> info = new ArrayList<>();
        info.add(size);
        info.add(color);
        info.add(remark);
        return info;
    }

}
