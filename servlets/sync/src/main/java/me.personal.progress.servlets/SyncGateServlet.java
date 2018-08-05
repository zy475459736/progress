package me.personal.progress.servlets;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServlet;


public class SyncGateServlet extends HttpServlet {

	private static Logger LOGGER = LoggerFactory.getLogger(SyncGateServlet.class);

    @Override
    public void service(javax.servlet.ServletRequest req, javax.servlet.ServletResponse res) throws javax.servlet.ServletException, java.io.IOException {
        LOGGER.info("hello world " + System.currentTimeMillis());
        try {
            Thread.sleep(500);
            res.setContentType("text/html");
            res.getWriter().printf("hello world inside CallableImpl at " + System.currentTimeMillis()).flush();
            res.getWriter().flush();
        } catch (Exception e) {
            LOGGER.error("Error occurs inside the Callable.call.",e.toString());
        }
    }


}
