package com.zhongyi.satan.servlet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.web.servlet.DispatcherServlet;

/**
 * Created by zhongyi on 2017/12/14.
 */
@ServletComponentScan
@SpringBootApplication
public class AppTest {
    public static void main(String[] args) {
        SpringApplication.run(com.zhongyi.satan.servlet.AppTest.class, args);
        DispatcherServlet dispatcherServlet;
    }
}
