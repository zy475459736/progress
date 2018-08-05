package me.personal.progress.springboot.mvc.configuration;


import me.personal.progress.springboot.mvc.simpleinterceptor.MyInterceptor1;
import me.personal.progress.springboot.mvc.simpleinterceptor.MyInterceptor2;
import me.personal.progress.springboot.mvc.simpleinterceptor.StopWatchHandlerInterceptor;
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
        /**
            ������������һ����������
            addPathPatterns ����������ع���
            excludePathPatterns �û��ų�����
         * */
        registry.addInterceptor(new MyInterceptor1()).addPathPatterns("/**");
        registry.addInterceptor(new MyInterceptor2()).addPathPatterns("/**");
        registry.addInterceptor(new StopWatchHandlerInterceptor()).addPathPatterns("/**");
//        registry.addInterceptor(new MyInterceptor()).addPathPatterns("/**").excludePathPatterns("/error");
        super.addInterceptors(registry);
    }

}