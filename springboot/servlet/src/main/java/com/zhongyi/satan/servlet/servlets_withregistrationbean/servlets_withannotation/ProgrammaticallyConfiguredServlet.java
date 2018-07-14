package com.zhongyi.satan.servlet.servlets_withregistrationbean.servlets_withannotation;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ProgrammaticallyConfiguredServlet", urlPatterns = {"/ProgrammaticallyConfiguredServlet"})
public class ProgrammaticallyConfiguredServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletOutputStream outputStream = response.getOutputStream();

        outputStream.println(
                "This message was generated from a servlet that was "
                        + "configured programmatically.");
    }
}
