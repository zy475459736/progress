package configs;


import org.aopalliance.aop.Advice;
import org.springframework.aop.Pointcut;
import org.springframework.aop.PointcutAdvisor;

/**
 * Created by zhongyi on 2018/7/5.
 */
public class TestAdvisor implements PointcutAdvisor {

    /**
     * ��ȡ֪ͨ�����߼�
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
     * ��ȡ�����
     */
    @Override
    public Pointcut getPointcut() {
        return new TestPointcut();
    }

}