package me.personal.progress.springboot.mvc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

/**
 * Created by zhongyi on 2017/12/14.
 */
@ServletComponentScan
@SpringBootApplication
public class AppMVCTest {
    public static void main(String[] args) {
        SpringApplication.run(AppMVCTest.class, args);
    }
}
