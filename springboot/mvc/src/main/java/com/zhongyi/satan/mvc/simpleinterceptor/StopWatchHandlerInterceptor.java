package com.zhongyi.satan.mvc.simpleinterceptor;

import org.springframework.core.NamedThreadLocal;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *    ���ܼ��
 *
    ���¼һ������Ĵ���ʱ�䣬�õ�һЩ�������紦��ʱ�䳬��500���룩���Ӷ��������ܸĽ���һ��ķ�������������apache������������ܣ����˴�������ʾһ��ʹ����������ôʵ�֡�
 ʵ�ַ�����
 1���ڽ��봦����֮ǰ��¼��ʼʱ�䣬������������preHandle��¼��ʼʱ�䣻
 2���ڽ���������֮���¼����ʱ�䣬������������afterCompletion��¼����ʵ�֣����ý���ʱ��-��ʼʱ��õ��������Ĵ���ʱ�䡣
 ���⣺
 ���ǵ��������ǵ�������˲����û�������ٴζ�ֻ��һ��������ʵ�֣����̲߳���ȫ��������Ӧ����ô��¼ʱ���أ�
 ���������ʹ��ThreadLocal�������̰߳󶨵ı������ṩ�ֲ߳̾�������һ���߳�һ��ThreadLocal��A�̵߳�ThreadLocalֻ�ܿ���A�̵߳�ThreadLocal�����ܿ���B�̵߳�ThreadLocal����

 * Created by zhongyi on 2017/12/15.
 */
/****/
public class StopWatchHandlerInterceptor extends HandlerInterceptorAdapter {

    private NamedThreadLocal<Long> startTimeThreadLocal = new NamedThreadLocal<Long>("StopWatch-StartTime");

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
                             Object handler) throws Exception {
        long beginTime = System.currentTimeMillis();//1����ʼʱ��
        startTimeThreadLocal.set(beginTime);//�̰߳󶨱�����������ֻ�е�ǰ������߳̿ɼ���
        return true;//��������
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response,
                                Object handler, Exception ex) throws Exception {
        long endTime = System.currentTimeMillis();//2������ʱ��
        long beginTime = startTimeThreadLocal.get();//�õ��̰߳󶨵ľֲ���������ʼʱ�䣩
        long consumeTime = endTime - beginTime;//3�����ĵ�ʱ��
//        if(consumeTime > 500) {//�˴���Ϊ����ʱ�䳬��500���������Ϊ������
            //TODO ��¼����־�ļ�
            System.out.println(
                    String.format("%s consume %d millis", request.getRequestURI(), consumeTime));
//        }
    }
}