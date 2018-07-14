package com.zhongyi.satan.servlet.filter;

import org.springframework.stereotype.Component;

import javax.servlet.*;
import java.io.IOException;

@Component
public class SimpleFilter implements Filter {

  private FilterConfig filterConfig;

  @Override
  public void init(FilterConfig filterConfig) throws ServletException {
    this.filterConfig = filterConfig;
  }

  @Override
  public void doFilter(ServletRequest servletRequest,
                       ServletResponse servletResponse, FilterChain filterChain) throws
          IOException, ServletException {
    ServletContext servletContext = filterConfig.getServletContext();
//    servletContext.log("Entering doFilter()");
//    servletContext.log("initialization parameters: ");
//    Enumeration<String> initParameterNames = filterConfig.
//            getInitParameterNames();
//    String parameterName;
//    String parameterValue;
//
//    while (initParameterNames.hasMoreElements()) {
//      parameterName = initParameterNames.nextElement();
//      parameterValue = filterConfig.getInitParameter(parameterName);
//      servletContext.log(parameterName + " = " + parameterValue);
//    }
    System.out.println("**********");
    servletContext.log("Invoking servlet...");
    filterChain.doFilter(servletRequest, servletResponse);
    servletContext.log("Back from servlet invocation");
    System.out.println("**********");
  }

  @Override
  public void destroy() {
    filterConfig = null;
  }
}
