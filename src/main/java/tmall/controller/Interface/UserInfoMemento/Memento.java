package tmall.controller.Interface.UserInfoMemento;

/**
 * Memento 包含了要被恢复的对象的状态
 * @param <T>
 */
public class Memento<T>{
    private T state;

    public Memento(T state) {
        this.state = state;
    }

    public T getState() {
        return state;
    }
}
