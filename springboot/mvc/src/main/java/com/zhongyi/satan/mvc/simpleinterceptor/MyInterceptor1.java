package com.zhongyi.satan.mvc.simpleinterceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by zhongyi on 2017/12/14.
 */

public class MyInterceptor1 implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        System.out.println(">>>MyInterceptor1>>>>>>>��������֮ǰ���е��ã�Controller��������֮ǰ��");

        return true;// ֻ�з���true�Ż��������ִ�У�����falseȡ����ǰ����
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) throws Exception {
        System.out.println(">>>MyInterceptor1>>>>>>>������֮����е��ã���������ͼ����Ⱦ֮ǰ��Controller��������֮��");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
            throws Exception {
        System.out.println(">>>MyInterceptor1>>>>>>>�������������֮�󱻵��ã�Ҳ������DispatcherServlet ��Ⱦ�˶�Ӧ����ͼ֮��ִ�У���Ҫ�����ڽ�����Դ��������");
    }

}