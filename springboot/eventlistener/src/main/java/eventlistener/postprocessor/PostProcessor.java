package eventlistener.postprocessor;//package com.zhongyi.satan.eventlistener.postprocessor;
//
//import org.springframework.beans.BeansException;
//import org.springframework.beans.factory.config.BeanPostProcessor;
//
///**
// * bean���ô�����
// *
// * Created by zhongyi on 2017/12/12.
// */
//public class PostProcessor implements BeanPostProcessor {
//
//    @Override
//    public Object postProcessBeforeInitialization(Object bean,
//                                                  String beanName) throws BeansException {
//        if ("narCodeService".equals(beanName)) {//���˵�beanʵ��IDΪnarCodeService
//            return bean;
//        }
//        System.out.println("���ô���������bean=��" + beanName + "����ʼ");
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
//        System.out.println("���ô���������bean=��" + beanName + "�����!");
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        return bean;
//    }
//
//}