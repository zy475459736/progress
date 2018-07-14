import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 * Created by zhongyi on 2018/7/5.
 */
public class App {

    public static void main(String[] args) {
        //IOC初始化
        ApplicationContext applicationContext = new FileSystemXmlApplicationContext(
                "spring/aop/src/main/resources/beans.xml");
        //AOP生成代理类
        TestTarget target = (TestTarget) applicationContext.getBean("testAOP");
        target.test();
        System.out.println("----------------");
        target.test2();
//        ProxyFactoryBean proxyFactoryBean;
//        AbstractApplicationContext abstractApplicationContext;
        DefaultListableBeanFactory defaultListableBeanFactory;
    }

}
