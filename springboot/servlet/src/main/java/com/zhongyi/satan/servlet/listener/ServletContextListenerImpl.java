package com.zhongyi.satan.servlet.listener;


import com.zhongyi.satan.servlet.servlets_withregistrationbean.servlets_withannotation.ProgrammaticallyConfiguredServlet;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebListener;

@Component
@WebListener
public class ServletContextListenerImpl implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        ServletContext servletContext = servletContextEvent.getServletContext();
        try {
            ProgrammaticallyConfiguredServlet servlet = servletContext.createServlet(ProgrammaticallyConfiguredServlet.class);
            servletContext.addServlet("ProgrammaticallyConfiguredServlet", servlet);
            ServletRegistration servletRegistration = servletContext.getServletRegistration("ProgrammaticallyConfiguredServlet");
            servletRegistration.addMapping("/ProgrammaticallyConfiguredServlet");
        } catch (ServletException servletException) {
            servletContext.log(servletException.getMessage());
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
    }
}
