package me.personal.progress.springboot.mvc.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * Created by zhongyi on 2018/8/5.
 */
@Component
@Aspect
public class TestAspect {

    @Pointcut(("execution(public * me.personal.progress.springboot.mvc.controller.*.*(..))"))
    public void restPoint() {
    }

    @Before("restPoint()")
    public void before(JoinPoint joinPoint) {
        System.out.println("aspect before pointcut");
    }

    @After("restPoint()")
    public void after(JoinPoint joinPoint) {
        System.out.println("aspect after pointcut");
    }

    @Around("restPoint()")
    public void around(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("aspect around before target method");
        joinPoint.proceed();
        System.out.println("aspect around after target method");
    }
}
