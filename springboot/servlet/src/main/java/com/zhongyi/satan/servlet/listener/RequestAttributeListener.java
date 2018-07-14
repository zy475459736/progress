package com.zhongyi.satan.servlet.listener;

import org.springframework.stereotype.Component;

import javax.servlet.ServletContext;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;

/**
 * Created by zhongyi on 2017/12/14.
 */
@Component
public class RequestAttributeListener implements ServletRequestListener {

    @Override
    public void requestInitialized(ServletRequestEvent servletRequestEvent) {
        ServletContext servletContext = servletRequestEvent.getServletContext();
        String clientIpAddress = servletRequestEvent.getServletRequest().
                getRemoteAddr();
        servletContext.log("New request initialized for client at IP address: "
                + clientIpAddress);
    }

    @Override
    public void requestDestroyed(ServletRequestEvent servletRequestEvent) {
        ServletContext servletContext = servletRequestEvent.getServletContext();
        String clientIpAddress = servletRequestEvent.getServletRequest().
                getRemoteAddr();
        servletContext.log("Request destroyed for client at IP address: "
                + clientIpAddress);
    }
}