package me.personal.progress.servlet.servletsannotated;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by zhongyi on 2017/12/14.
 */
@WebServlet(name = "SyncServlet", urlPatterns = {"/sync"})
public class SyncServlet extends HttpServlet {
    private final Logger logger = LoggerFactory.getLogger(SyncServlet.class);

    private static final AtomicInteger atomicCount = new AtomicInteger(0);

    @Autowired
    private ApplicationContext applicationContext;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.info("Get the "+ atomicCount.incrementAndGet() + "request. Service() Begin");
        long startTime = System.currentTimeMillis();

        PrintWriter printWriter = resp.getWriter();

        printWriter.print("We have "+applicationContext.getBeanDefinitionCount() +" beans in the applicationContext.");
        printWriter.print("Listed as followed:");

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            logger.warn("Error occurs inside doGet()+", e.toString());
        }

        List arrayList = Arrays.asList(applicationContext.getBeanDefinitionNames());
        arrayList.stream().forEach(temp -> printWriter.println( temp.toString() ));

        printWriter.close();

        long endTime   = System.currentTimeMillis();
        logger.info("Get the "+ atomicCount.get() + "request. Service() end.The duration:"+(endTime - startTime));
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}

