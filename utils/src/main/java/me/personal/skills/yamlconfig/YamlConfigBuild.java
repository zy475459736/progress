package me.personal.skills.yamlconfig;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
/**
 * Created by zhongyi on 2018/7/24.
 */
@Configuration
@Slf4j
public class YamlConfigBuild {

    @Value("${A.B.config}")
    private String config = null;

    @Bean
    public TargetConfigs buildConfig() throws Throwable {

    	try{
    	    InputStream in = new ByteArrayInputStream(config.getBytes());
			TargetConfigs config = new YamlConfigurationFactory<TargetConfigs>(TargetConfigs.class,"dw").build(in);
    		return config;
    	}catch (Throwable t){
    	    log.error("read config :"+config + " fail.",t);
    	    throw t;
        }
    }
}