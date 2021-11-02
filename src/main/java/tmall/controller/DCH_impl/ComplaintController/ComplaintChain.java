package tmall.controller.DCH_impl.ComplaintController;

public class ComplaintChain {
    public static AbstractComplaint getChain(){
        AbstractComplaint goodsComplainer=new GoodsComplaint();
        AbstractComplaint sellingComplainer=new SellingComplaint();

        goodsComplainer.setChainNext(sellingComplainer);
        return goodsComplainer;
    }
}
