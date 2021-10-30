package tmall.controller;

/**
 * @author Strange
 * @date 2021/10/30 11:06
 * @description: 模板方法。抽象的父类定义未实现的方法，子类对其进行多样性的实现
 */
public abstract class CommodityController {
    //template method。根据某一指标找到某个商品对象，显示其详情。
    public abstract Object[] commodityDetailDisplay(String index);
}
