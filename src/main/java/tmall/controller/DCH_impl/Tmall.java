package tmall.controller.DCH_impl;

import tmall.controller.DCH_impl.VerifyLevelController.VerifyCitation;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Tmall {
    private VerifyCitation cita;

    //Prepare Prototype
    public Tmall() {
        this.cita = new VerifyCitation("黄老板","Tmall",2," , 您已经成为精英卖家!",new Date());
    }

    /**
     *
     * @param nickname
     * @param level
     */
    public void verifyLevel(String nickname, int level){

        int threshold=cita.getThreshold();
        if(level>=threshold){
            VerifyCitation cita1=cita.clone();
            cita1.setNickname(nickname);
            cita1.setDate(new Date());
            System.out.println(cita1.toString());
        }
        else{
            System.out.println("抱歉，您的等级还不够!");
        }
    }
}
