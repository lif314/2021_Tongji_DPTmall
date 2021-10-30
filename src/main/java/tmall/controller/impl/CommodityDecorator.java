package tmall.controller.impl;

import tmall.model.entity.Commodity;

/**
 * @author Strange
 * @date 2021/10/30 14:48
 * @description: 装饰器模式。避免继承Commodity子类爆炸的问题，为Commodity定义新的行为。
 */
public class CommodityDecorator {

    protected Commodity commodity;
    public CommodityDecorator(Commodity c) {
        this.commodity = c;
    }
    public void decorate() {

    }
}
