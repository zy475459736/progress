package configs;

import org.springframework.aop.ClassFilter;
import org.springframework.aop.MethodMatcher;
import org.springframework.aop.Pointcut;

import java.lang.reflect.Method;


/**
 * Created by zhongyi on 2018/7/5.
 */
public class TestPointcut implements Pointcut {

    @Override
    public ClassFilter getClassFilter() {
        return ClassFilter.TRUE;
    }

    @Override
    public MethodMatcher getMethodMatcher() {
        return new MethodMatcher() {
            @Override
            public boolean matches(Method method, Class<?> targetClass, Object[] args) {
                if (method.getName().equals("test2")||method.getName().equals("test")) {
                    return true;
                }
                return false;
            }
            @Override
            public boolean matches(Method method, Class<?> targetClass) {
                if (method.getName().equals("test2")) {
                    return true;
                }
                return false;
            }
            @Override
            public boolean isRuntime() {
                return false;
            }
        };
    }

}
