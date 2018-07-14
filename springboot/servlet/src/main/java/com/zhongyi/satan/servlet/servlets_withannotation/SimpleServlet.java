package com.zhongyi.satan.servlet.servlets_withannotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;

/**
 * Created by zhongyi on 2017/12/14.
 */
@WebServlet(name = "SimpleServlet1", urlPatterns = {"/simpleservlet1"})
public class SimpleServlet extends HttpServlet {
    @Autowired
    private ApplicationContext applicationContext;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        System.out.println("zy servlet_1");
//        resp.setContentType("text/html");
        PrintWriter printWriter = resp.getWriter();
        List arrayList = Arrays.asList(applicationContext.getBeanDefinitionNames());
        arrayList.stream().forEach(temp -> printWriter.println( temp.toString() ));
        printWriter.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}

