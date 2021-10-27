package tmall.model.entity;

import tmall.controller.impl.CommodityVisitor;
import tmall.model.entity.Commodity;

import java.util.ArrayList;
import java.util.List;

public class Fruit extends Commodity {
    protected String placeOfOrigin;//产地
    protected String qualityGuaranteePeriod;//保质期

    public Fruit() {}

    public Fruit(String placeOfOrigin) {
        this.placeOfOrigin = placeOfOrigin;
    }

    public void setQualityGuaranteePeriod(String qualityGuaranteePeriod) {
        this.qualityGuaranteePeriod = qualityGuaranteePeriod;
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
        info.add(placeOfOrigin);
        info.add(qualityGuaranteePeriod);
        return info;
    }
}
