package singleton;

/**
 * 懒汉模式
 * 缺点：当多个线程并行调用时会创建多个实例
 *
 * Created by zhongyi on 2017/12/18.
 */

public class Singleton_0 {
    private static Singleton_0 instance;
    private Singleton_0(){}
    public static Singleton_0 getInstance() {
        if (instance == null) {
            instance = new Singleton_0();
        }
        return instance;
    }
}
