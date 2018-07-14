package com.zhongyi.satan.servlet.servlets_withregistrationbean.servlets_withannotation;

import com.zhongyi.satan.servlet.servlets_withannotation.SimpleServlet;
import com.zhongyi.satan.servlet.servlets_withannotation.SimpleServlet2;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * Created by zhongyi on 2017/12/14.
 */
@Component
public class ServletConfiguration {
    @Bean
    public ServletPushDemoServlet getServletPushDemoServlet(){return new ServletPushDemoServlet();}

    @Bean
    public ServletRegistrationBean test3ServletRegistrationBean(ServletPushDemoServlet servletPushDemoServlet){
        ServletRegistrationBean registration = new ServletRegistrationBean(servletPushDemoServlet);
        registration.setEnabled(true);
        registration.addUrlMappings("/servlet/test3");
        return registration;
    }
    /********************************************/
    @Bean
    public SimpleServlet simpleServlet(){
        return new SimpleServlet();
    }

    @Bean
    public ServletRegistrationBean testServletRegistrationBean(SimpleServlet simpleServlet){
        ServletRegistrationBean registration = new ServletRegistrationBean(simpleServlet);
        registration.setEnabled(true);
        registration.addUrlMappings("/servlet/test");
        return registration;
    }
    /********************************************/
    @Bean
    public SimpleServlet2 simpleServlet2(){
        return new SimpleServlet2();
    }

    @Bean
    public ServletRegistrationBean test2ServletRegistrationBean(SimpleServlet2 simpleServlet2){
        ServletRegistrationBean registration = new ServletRegistrationBean(simpleServlet2);
        registration.setEnabled(true);
        registration.addUrlMappings("/servlet/test2");
        return registration;
    }

}
