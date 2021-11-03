package tmall.controller.Interface.UserInfoMemento;

import java.util.ArrayList;
import java.util.List;

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
