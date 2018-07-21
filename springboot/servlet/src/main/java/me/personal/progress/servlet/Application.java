package me.personal.progress.servlet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

/**
 * Created by zhongyi on 2017/12/14.
 */
@ServletComponentScan(basePackages = "me.personal.progress.servlet.servletsannotated")
@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
