package tmall.controller.Interface.UserInfoMemento;

import java.util.ArrayList;
import java.util.List;

/**
 * CareTaker 负责从 Memento 中恢复对象的状态
 * @param <T>
 */
public class CareTaker<T> {
    private final List<Memento<T>> mementoList = new ArrayList<>();

    public void add(Memento<T> state){
        mementoList.add(state);
    }

    public Memento<T> get(){
        Memento<T> res = mementoList.get(mementoList.size()-1);
        mementoList.remove(res);
        return res;
    }
}
