package tmall.model.entity;

public class OfflineRestockedCommodity extends DetailedCommodity{
    public void restockDetailedCommodity(){
        System.out.println("来自线下采购");
    }
}
