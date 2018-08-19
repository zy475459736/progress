import me.personal.progress.proxy_cglib.ProxyFactory;
import me.personal.progress.proxy_jdk.UserDao;

/**
 * Created by zhongyi on 2018/8/19.
 */
public class TestProxyFactory_cglib {
    public static void main (String[] args) {
        //目标对象
        UserDao userDao = new UserDao();
        //生成代理对象
        UserDao userDaoProxy = (UserDao) new ProxyFactory(userDao).getProxyInstance();
        //调用对象方法
        userDaoProxy.save();
    }
}
