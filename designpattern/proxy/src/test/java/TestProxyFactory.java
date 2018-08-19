import me.personal.progress.IUserDao;
import me.personal.progress.proxy_jdk.ProxyFactory;
import me.personal.progress.proxy_jdk.UserDao;

/**
 * Created by zhongyi on 2018/8/19.
 */
public class TestProxyFactory {
    public static void main(String[] args) {
        //目标对象
        IUserDao userDao = new UserDao();
        //原始类型 class com.sschen.proxy.UserDao
        System.out.println(userDao.getClass());

        //给定目标对象，动态创建代理对象
        IUserDao proxy = (IUserDao) new ProxyFactory(userDao).getProxyInstance();
        //代理对象类型 class com.sun.proxy.$Proxy0
        System.out.println(proxy.getClass());

        proxy.save();


        proxy.save_();
    }
}

