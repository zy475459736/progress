package singleton;

/**
 * 饿汉式
 * static final field
 * static final变量在第一次加载类到内存中就完成了初始化，
 * 好处是创建实例本身是线程安全的，坏处是如果实例的创建依赖参数或者配置文件，无法配置。
 * Created by zhongyi on 2017/12/18.
 */
public class Singleton_4 {
    //类加载时就初始化
    private static final Singleton_4 instance = new Singleton_4();

    private Singleton_4(){}

    public static Singleton_4 getInstance(){
        return instance;
    }
}
