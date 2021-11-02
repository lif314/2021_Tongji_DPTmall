package tmall.controller.DCH_impl.ComplaintController;

//import tmall.tmallSystem.TMallSystem;

import tmall.controller.DCH_impl.Tmall;
import tmall.tmallSystem.TMallSystem;

public class SellingComplaint extends AbstractComplaint {
    public SellingComplaint() {
        rank=2;
    }

    @Override
    public void replyComplaint() {
        Chatroom.sendMessage(new TMallSystem(),"TMallSystem","您的评论已收到，天猫平台将马上为您处理.");
    }
}
