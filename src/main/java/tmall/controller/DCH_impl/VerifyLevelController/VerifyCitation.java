package tmall.controller.DCH_impl.VerifyLevelController;

import java.util.Date;

public class VerifyCitation implements Cloneable{
    private String nickname;
    private String platform;
    private int threshold;
    private String content;
    private Date date;

    public VerifyCitation(String nickname, String platform, int threshold, String content, Date date) {
        this.nickname = nickname;
        this.platform = platform;
        this.threshold = threshold;
        this.content = content;
        this.date = date;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    //Using ProtoType Pattern to Clone
    @Override
    public VerifyCitation clone() {
        try {
            VerifyCitation clone = (VerifyCitation) super.clone();
            // TODO: copy mutable state here, so the clone can't change the internals of the original
            return clone;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }

    @Override
    public String toString() {
        return  "Congratulations:\n\n"+nickname  +
                content + "\n\n                                 by "+platform +"\n\n"+
                "Date:" + date;
    }

    public int getThreshold() {
        return threshold;
    }
}
