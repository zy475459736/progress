import java.util.ServiceLoader;

/**
 * Created by zhongyi on 2018/7/14.
 */
public class testApp {
    public static void main(String[] args) {
        ServiceLoader<MyServiceLoader> serviceLoader = ServiceLoader.load(MyServiceLoader.class);
        for (MyServiceLoader myServiceLoader : serviceLoader){
            System.out.println(myServiceLoader.sayHello() + myServiceLoader.sayBye());

        }
    }
}
