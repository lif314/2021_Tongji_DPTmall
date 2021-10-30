package tmall.controller.factory;

/**
 * 抽象工厂
 */
public interface AbstractFactory {
    /**
     * 产生管理用户信息的Controller
     * @param args
     * @return
     */
    public Object getUserInfoController(String args);

    /**
     * 感觉应该放一个和用户有关的Controller，但是我不知道放什么orz
     * @return
     */
    public Object getUserController();
}
