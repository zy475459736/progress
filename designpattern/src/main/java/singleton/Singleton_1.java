package singleton;

/**
 * 懒汉模式
 * 线程安全
 * 缺点：同步操作仅仅在第一次调用时需要synchronize加锁，
 *       后面并不需要
 * Created by zhongyi on 2017/12/18.
 */

public class Singleton_1 {
    private static Singleton_1 instance;
    private Singleton_1(){}
    public static synchronized Singleton_1 getInstance() {
        if (instance == null) {
            instance = new Singleton_1();
        }
        return instance;
    }
}
