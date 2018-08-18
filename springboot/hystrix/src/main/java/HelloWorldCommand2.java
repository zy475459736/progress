import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixCommandProperties;

import java.util.concurrent.TimeUnit;

/**
 * Created by zhongyi on 2018/8/18.
 */
public class HelloWorldCommand2 extends HystrixCommand<String> {
    private final String name;
    public HelloWorldCommand2(String name) {
        super(Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey("HelloWorldGroup2"))
                /* 配置依赖超时时间,500毫秒*/
                .andCommandPropertiesDefaults(HystrixCommandProperties.Setter().withExecutionIsolationThreadTimeoutInMilliseconds(500)));
        this.name = name;
    }
    @Override
    protected String getFallback() {
        return "exeucute Falled and into getFallback()";
    }
    @Override
    protected String run() {
        //sleep 1 秒,调用会超时
        try {
            TimeUnit.MILLISECONDS.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println("run() sleep is interrupted.");
        }
        return "Hello " + name +" thread:" + Thread.currentThread().getName();
    }
    public static void main(String[] args) throws Exception{
        HelloWorldCommand2 command = new HelloWorldCommand2("test-Fallback");
        String result = command.execute();
        System.out.println(result.toString());
    }
}
