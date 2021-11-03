package tmall.controller.Interface.UserInfoMemento;

public class Memento<T>{
    private T state;

    public Memento(T state) {
        this.state = state;
    }

    public T getState() {
        return state;
    }
}
