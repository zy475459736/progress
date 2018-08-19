package me.personal.progress.proxy_jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by zhongyi on 2018/8/19.
 *
 * 创建动态代理对象
 * 动态代理对象不需要实现接口，但是需要指定接口类型
 */
public class ProxyFactory {
    //维护一个目标对象
    private Object target;
    //对象构造时，提供目标对象
    public ProxyFactory(Object target) {
        this.target = target;
    }
    //给目标对象生成代理对象
    public Object getProxyInstance() {
        return Proxy.newProxyInstance(
                target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                new InvocationHandler() {
                    @Override
                    public Object invoke(
                            Object proxy,
                            Method method,
                            Object[] args)
                            throws Throwable {
                        System.out.println("Begin Transaction");
                        //执行目标对象方法
                        Object returnValue = method.invoke(target, args);
                        System.out.println("Commit Transaction");
                        return returnValue;
                    }
                });
    }
}
