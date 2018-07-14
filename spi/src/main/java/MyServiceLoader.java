/**
 * Created by zhongyi on 2018/7/14.
 */
public class MyServiceLoader implements IMyServiceLoader {
    @Override
    public String sayHello() {
        return "hello";
    }
    @Override
    public String sayBye() {
        return "bye";
    }
}
