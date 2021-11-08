package tmall.controller.factory.item;

import tmall.controller.factory.AbstractFactory;

public interface Item<T>{
    T get(String key);
}
