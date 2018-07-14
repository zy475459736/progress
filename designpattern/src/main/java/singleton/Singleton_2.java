package singleton;

/**
 * 懒汉模式
 * 双重检验锁
 * volatile禁止指令重排序优化
 * 缺点：`instance = new Singleton()`并非原子操作：
 *       1、给 instance 分配内存
 *       2、调用 Singleton 的构造函数来初始化成员变量
 *       3、将instance对象指向分配的内存空间（执行完这步 instance 就为非 null 了）
 * Created by zhongyi on 2017/12/18.
 */

public class Singleton_2 {
    private static Singleton_2 instance;
    private Singleton_2(){}

    public static Singleton_2 getSingleton() {
        if (instance == null) {                         //Single Checked
            synchronized (Singleton_2.class) {
                if (instance == null) {                 //Double Checked
                    instance = new Singleton_2();
                }
            }
        }
        return instance;
    }
}
