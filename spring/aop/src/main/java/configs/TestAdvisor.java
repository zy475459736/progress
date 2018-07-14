package configs;


import org.aopalliance.aop.Advice;
import org.springframework.aop.Pointcut;
import org.springframework.aop.PointcutAdvisor;

/**
 * Created by zhongyi on 2018/7/5.
 */
public class TestAdvisor implements PointcutAdvisor {

    /**
     * 获取通知处理逻辑
     */
    @Override
    public Advice getAdvice() {
        return new TestAfterAdvice();
    }

    @Override
    public boolean isPerInstance() {
        return false;
    }

    /**
     * 获取切入点
     */
    @Override
    public Pointcut getPointcut() {
        return new TestPointcut();
    }

}