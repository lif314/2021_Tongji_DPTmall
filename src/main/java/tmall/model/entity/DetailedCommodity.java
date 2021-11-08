package tmall.model.entity;

public class DetailedCommodity extends Commodity{
    public ProductionPlace productionPlace;
    public void defineProductionPlace(ProductionPlace productionPlace){
        this.productionPlace=productionPlace;
    }

    public void restockDetailedCommodity(){

    }
}
