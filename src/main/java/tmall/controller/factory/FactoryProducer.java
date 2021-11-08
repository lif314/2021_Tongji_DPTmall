package tmall.controller.factory;

import tmall.controller.factory.item.Item;

import java.lang.reflect.InvocationTargetException;

/**
 * FactoryProducer类的描述：
 * 用于制造具体的工厂
 */

public class FactoryProducer {
    /**
     * 根据用户传进来的工厂名，利用java的反射机制创建对应的Factory
     * @param factoryName
     * @return AbstractFactory
     */
    public static AbstractFactory getFactory(String factoryName) {
        switch (factoryName) {
            case "info": return new UserInfoControllerFactory();
            case "role": return new UserRoleControllerFactory();
            case "item": return new ItemFactory();
        }
        return null;
    }
}
