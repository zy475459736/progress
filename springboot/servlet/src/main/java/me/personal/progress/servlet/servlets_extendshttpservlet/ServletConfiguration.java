package me.personal.progress.servlet.servlets_extendshttpservlet;

import me.personal.progress.servlet.servletsannotated.AsyncServlet;
import me.personal.progress.servlet.servletsannotated.SimpleServlet;
import me.personal.progress.servlet.servletsannotated.SyncServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by zhongyi on 2017/12/14.
 */
@Configuration
public class ServletConfiguration {
    @Bean
    public ServletPushDemoServlet getServletPushDemoServlet(){return new ServletPushDemoServlet();}

    @Bean
    public ServletRegistrationBean testServletRegistrationBean1(ServletPushDemoServlet servletPushDemoServlet){
        ServletRegistrationBean registration = new ServletRegistrationBean(servletPushDemoServlet);
        registration.setEnabled(true);
        registration.addUrlMappings("/servlet/test3");
        return registration;
    }
    /********************************************/
    @Bean
    public AsyncServlet getAsyncServlet(){return new AsyncServlet();}
    @Bean
    public ServletRegistrationBean testServletRegistrationBean2(AsyncServlet asyncServlet){
        ServletRegistrationBean registration = new ServletRegistrationBean(asyncServlet,"/servlet/async");
        return registration;
    }
    /********************************************/
    @Bean
    public SyncServlet getSyncServlet(){return new SyncServlet();}
    @Bean
    public ServletRegistrationBean testServletRegistrationBean3(SyncServlet syncServlet){
        ServletRegistrationBean registration = new ServletRegistrationBean(syncServlet);
        registration.setEnabled(true);
        registration.addUrlMappings("/servlet/sync");
        return registration;
    }
    /********************************************/
    @Bean
    public ServletRegistrationBean testServletRegistrationBean4(){
        ServletRegistrationBean registration = new ServletRegistrationBean(new SimpleServlet(),"/servlet/simple");
        registration.setEnabled(true);
        return registration;
    }

}
