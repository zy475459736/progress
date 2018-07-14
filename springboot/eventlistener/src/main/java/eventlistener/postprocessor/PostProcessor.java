package eventlistener.postprocessor;//package com.zhongyi.satan.eventlistener.postprocessor;
//
//import org.springframework.beans.BeansException;
//import org.springframework.beans.factory.config.BeanPostProcessor;
//
///**
// * bean后置处理器
// *
// * Created by zhongyi on 2017/12/12.
// */
//public class PostProcessor implements BeanPostProcessor {
//
//    @Override
//    public Object postProcessBeforeInitialization(Object bean,
//                                                  String beanName) throws BeansException {
//        if ("narCodeService".equals(beanName)) {//过滤掉bean实例ID为narCodeService
//            return bean;
//        }
//        System.out.println("后置处理器处理bean=【" + beanName + "】开始");
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        return bean;
//    }
//
//    @Override
//    public Object postProcessAfterInitialization(Object bean,
//                                                 String beanName) throws BeansException {
//        if ("narCodeService".equals(beanName)) {
//            return bean;
//        }
//        System.out.println("后置处理器处理bean=【" + beanName + "】完毕!");
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        return bean;
//    }
//
//}