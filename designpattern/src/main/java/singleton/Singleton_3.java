package singleton;

/**
 * 懒汉模式
 * 双重检验锁
 * 在Singleton_0 he Singleton_1的基础上解决问题
 * 缺点：`instance = new Singleton()`并非原子操作：
 *       1、给 instance 分配内存
 *       2、调用 Singleton 的构造函数来初始化成员变量
 *       3、将instance对象指向分配的内存空间（执行完这步 instance 就为非 null 了）
 * Created by zhongyi on 2017/12/18.
 */

public class Singleton_3 {

    private volatile static Singleton_3 instance;

    private Singleton_3(){}

    public static Singleton_3 getSingleton() {
        if (instance == null) {                         //Single Checked
            synchronized (Singleton_3.class) {
                if (instance == null) {                 //Double Checked
                    instance = new Singleton_3();
                }
            }
        }
        return instance;
    }
}
