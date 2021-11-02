package tmall.controller.DCH_impl.VerifyLevelController;

public class Administrator {
    private CommunicationService verifyLevelService;

    public Administrator(CommunicationService levelCommand) {
        this.verifyLevelService = levelCommand;
    }

    public void verifyLevelServiceExecute(String nickname, int level){
        verifyLevelService.execute(nickname,level);
    }
}
