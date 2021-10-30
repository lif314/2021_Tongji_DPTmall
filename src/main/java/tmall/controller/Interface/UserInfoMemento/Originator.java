package tmall.controller.Interface.UserInfoMemento;

/**
 * Originator 创建并在 Memento 对象中存储状态
 * @param <T>
 */
public class Originator<T>{
    private T state;

    public void setState(T state) {
        this.state = state;
    }

    public T getState() {
        return state;
    }

    public Memento<T> saveStateToMemento() {
        return new Memento<T>(state);
    }

    public void getStateFromMemento(Memento<T> memento) {
        state = memento.getState();
    }
}
