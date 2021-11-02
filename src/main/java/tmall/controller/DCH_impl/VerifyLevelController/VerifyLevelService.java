package tmall.controller.DCH_impl.VerifyLevelController;

import tmall.controller.DCH_impl.Tmall;

public class VerifyLevelService implements CommunicationService {
    private Tmall tmall;

    public VerifyLevelService(Tmall tmall) {
        this.tmall = tmall;
    }

    @Override
    public void execute(String nickname,int level) {
        tmall.verifyLevel(nickname,level);
    }
}
