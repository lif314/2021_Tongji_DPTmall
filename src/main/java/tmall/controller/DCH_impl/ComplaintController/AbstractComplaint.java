package tmall.controller.DCH_impl.ComplaintController;

public abstract class AbstractComplaint {
    protected int rank;
    private AbstractComplaint nextComplainer;

    public AbstractComplaint() {
        rank = 0;
    }

    public void setChainNext(AbstractComplaint complainer){
        nextComplainer=complainer;
    }

    public void checkChain(int rank){
        if(this.rank==rank){
            replyComplaint();
        }
        else if(nextComplainer!=null){
            nextComplainer.checkChain(rank);
        }
        else{
            System.out.println("抱歉，您的投诉无效!");
        }
    }

    public abstract void replyComplaint();
}
