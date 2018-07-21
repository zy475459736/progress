package me.personal.progress.servlet.servletsannotated;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import javax.servlet.AsyncContext;
import javax.servlet.AsyncEvent;
import javax.servlet.AsyncListener;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

//import org.springframework.stereotype.Component;

/**
 * Created by zhongyi on 2017/12/14.
 */
@WebServlet(name = "AsyncServlet", urlPatterns = {"/async"},asyncSupported = true)
public class AsyncServlet extends HttpServlet {
    private final Logger logger = LoggerFactory.getLogger(AsyncServlet.class);
    //todo 典型的bug，servlet service并不是线程安全的.
    private static final AtomicInteger      atomicCount  = new AtomicInteger(0);
    private static final ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(
            200, 1000, 1000 * 60 * 5, TimeUnit.MILLISECONDS, new SynchronousQueue<Runnable>());

    @Autowired
    private ApplicationContext applicationContext;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.info("Get the "+ atomicCount.incrementAndGet() + " async request.Service() Begin");
        long startTime = System.currentTimeMillis();

        AsyncContext asyncContext = req.startAsync();
        asyncContext.setTimeout(8*1000);
        asyncContext.addListener(new AsyncListener() {
            @Override
            public void onTimeout(AsyncEvent event) throws IOException {
                logger.warn("【AsyncListener】Async Process is on TIMEOUT. "+event.toString());
            }
            @Override
            public void onError(AsyncEvent event) throws IOException {
                logger.warn("【AsyncListener】Async Process is on ERROR. "+event.toString());
            }

            @Override
            public void onStartAsync(AsyncEvent event) throws IOException {

            }
            @Override
            public void onComplete(AsyncEvent event) throws IOException {

            }
        });
        poolExecutor.submit(new Runnable() {
            @Override
            public void run() {
                PrintWriter printWriter = null;
                try {
                    printWriter = asyncContext.getResponse().getWriter();
                    printWriter.print("We have "+applicationContext.getBeanDefinitionCount() +" beans in the applicationContext.");
                    printWriter.print("Listed as followed:");

                    Thread.sleep(500);

                    List arrayList = Arrays.asList(applicationContext.getBeanDefinitionNames());
                    PrintWriter finalPrintWriter = printWriter;
                    arrayList.stream().forEach(temp -> finalPrintWriter.println( temp.toString() ));

                } catch (IOException e) {
                    logger.error("Error occurs with IO.+", e.toString());
                } catch (InterruptedException e) {
                    logger.error("Error occurs while sleeping.+", e.toString());
                }finally {
                    printWriter.close();
                    asyncContext.complete();
                }
            }
        });

        long endTime   = System.currentTimeMillis();
        logger.info("Get the "+ atomicCount.get() + " async request.Service() end.The duration:"+(endTime - startTime)+"s");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}

