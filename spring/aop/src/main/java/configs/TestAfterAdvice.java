package configs;

import org.springframework.aop.AfterReturningAdvice;

import java.lang.reflect.Method;

/**
 * Created by zhongyi on 2018/7/5.
 */
public class TestAfterAdvice implements AfterReturningAdvice {

    @Override
    public void afterReturning(Object returnValue, Method method,
                               Object[] args, Object target) throws Throwable {
        System.out.println(
                "after " + target.getClass().getSimpleName() + "." + method.getName() + "()");
    }

}
