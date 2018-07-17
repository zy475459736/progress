package me.personal.progress.servlets;

import com.netflix.config.DynamicIntProperty;
import com.netflix.config.DynamicLongProperty;
import com.netflix.config.DynamicPropertyFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.naming.Context;
import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.concurrent.Callable;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;


public class AsyncServlet extends HttpServlet {
    private static Logger LOGGER = LoggerFactory.getLogger(AsyncServlet.class);

    private DynamicIntProperty asyncTimeout = DynamicPropertyFactory.getInstance().getIntProperty("ASYNC_TIMEOUT", 20000);
    private DynamicIntProperty coreSize = DynamicPropertyFactory.getInstance().getIntProperty("CORE_SIZE", 200);
    private DynamicIntProperty maximumSize = DynamicPropertyFactory.getInstance().getIntProperty("MAXIMUMSIZE", 2000);
    private DynamicLongProperty aliveTime = DynamicPropertyFactory.getInstance().getLongProperty("ALIVE_TIME", 1000 * 60 * 5);

    private AtomicReference<ThreadPoolExecutor> poolExecutorRef = new AtomicReference<ThreadPoolExecutor>();
    private AtomicLong rejectedRequests = new AtomicLong(0);

    @Override
    public void init() throws ServletException {
        LOGGER.info("hello world from AsyncServlet.init()");
        reNewThreadPool();
        Runnable c = new Runnable() {
            @Override
            public void run() {
                ThreadPoolExecutor p = poolExecutorRef.get();
                p.setCorePoolSize(coreSize.get());
                p.setMaximumPoolSize(maximumSize.get());
                p.setKeepAliveTime(aliveTime.get(), TimeUnit.MILLISECONDS);
            }
        };
        /**
         * when it changes, get the update-config asap
         * */
        coreSize.addCallback(c);
        maximumSize.addCallback(c);
        aliveTime.addCallback(c);
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LOGGER.info("hello world " + System.currentTimeMillis());
        req.setAttribute("org.apache.catalina.ASYNC_SUPPORTED", true);

        AsyncContext asyncContext = req.startAsync();
        asyncContext.setTimeout(asyncTimeout.get());
        asyncContext.addListener(new AsyncGateListener());
        try {
//            poolExecutorRef.get().submit(new GateCallable(ctx,asyncContext, gateRunner,req));
            poolExecutorRef.get().submit(new CallableImpl(asyncContext));
        } catch (RuntimeException e) {
            rejectedRequests.incrementAndGet();
            throw e;
        }
    }

    @Override
    public void destroy() {
        shutdownPoolExecutor(poolExecutorRef.get());
    }

    private void reNewThreadPool() {
        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(coreSize.get(), maximumSize.get(), aliveTime.get(), TimeUnit.MILLISECONDS, new SynchronousQueue<Runnable>());
        ThreadPoolExecutor old = poolExecutorRef.getAndSet(poolExecutor);
        if (old != null) {
            shutdownPoolExecutor(old);
        }
    }

    private void shutdownPoolExecutor(ThreadPoolExecutor old) {
        try {
            old.awaitTermination(5, TimeUnit.MINUTES);
            old.shutdown();
        } catch (InterruptedException e) {
            old.shutdownNow();
            LOGGER.error("Shutdown Gate Thread Pool:", e);
        }

    }

    static class CallableImpl implements Callable {
//        private HttpServletResponse   resp;
        private AsyncContext          asyctx;
        public CallableImpl(AsyncContext asyctx){
            this.asyctx = asyctx;
        }

        /**
         * Computes a result, or throws an exception if unable to do so.
         *
         * @return computed result
         * @throws Exception if unable to compute a result
         */
        @Override
        public Object call() throws Exception {
            try {
                Thread.sleep(1);
                asyctx.getResponse().getWriter().print("hello world " + System.currentTimeMillis());
            } catch (Exception e) {
                LOGGER.error("Error occurs inside the Callable.call.",e.toString());
            }
            return null;
        }
    }


}
