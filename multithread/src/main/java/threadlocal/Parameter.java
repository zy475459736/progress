package threadlocal;

/**
 * Created by zhongyi on 2018/7/12.
 */
public class Parameter {
    private static ThreadLocal<Parameter> _parameter= new ThreadLocal();
    public static Parameter init() {
         _parameter.set(new Parameter());
        return _parameter.get();
    }
    public static Parameter get() {
        return _parameter.get();
    }

    public static void main(String[] args) {
        Thread thread;
        ThreadLocal threadLocal;
    }

}
