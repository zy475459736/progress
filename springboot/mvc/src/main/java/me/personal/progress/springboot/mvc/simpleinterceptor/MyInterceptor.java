package me.personal.progress.springboot.mvc.simpleinterceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by zhongyi on 2017/12/15.
 */
public class MyInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws IOException {
        //���session������Ϊ�գ�˵���Ѿ���¼��ӵ��Ȩ�ޣ�����true�������ʡ�
        System.out.println("session������"+request.getSession().getAttribute("session����"));
        if(request.getSession().getAttribute("session����")!=null){
            return true;
        }
        //���session����Ϊ�գ�˵��û�е�¼������false,�������ض�����ת����¼ҳ��
//        response.sendRedirect("/login.html");
        return false;
    }
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,ModelAndView modelAndView){
        System.out.println("�����󲻱��쳣��˳����ɺ�ִ��");
    }
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex){
        System.out.println("���������Ƿ��쳣����󶼻�ִ�С�����������Դ���ر����ӵ�");
    }
}