package com.zhongyi.satan.mvc.configuration;


import com.zhongyi.satan.mvc.simpleinterceptor.MyInterceptor1;
import com.zhongyi.satan.mvc.simpleinterceptor.MyInterceptor2;
import com.zhongyi.satan.mvc.simpleinterceptor.StopWatchHandlerInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by zhongyi on 2017/12/14.
 */
@Configuration
public class WebMVCAppConfiguration extends WebMvcConfigurerAdapter {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 多个拦截器组成一个拦截器链
        // addPathPatterns 用于添加拦截规则
        // excludePathPatterns 用户排除拦截
        registry.addInterceptor(new MyInterceptor1()).addPathPatterns("/**");
        registry.addInterceptor(new MyInterceptor2()).addPathPatterns("/**");
        registry.addInterceptor(new StopWatchHandlerInterceptor()).addPathPatterns("/**");
//        registry.addInterceptor(new MyInterceptor()).addPathPatterns("/**").excludePathPatterns("/error");
        super.addInterceptors(registry);
    }

}