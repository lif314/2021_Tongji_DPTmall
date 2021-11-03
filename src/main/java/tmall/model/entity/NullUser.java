package tmall.model.entity;

public class NullUser implements User {
    @Override
    public  boolean isNull(){return true;}

    @Override
    public String toString() {
        return "不存在此用户";
    }
}
