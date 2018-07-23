package me.personal.concurrency.threadlocal;

/**
 * Created by zhongyi on 2018/7/19.
 */
public class DemoThreadLocal {
    protected static Class<? extends DemoThreadLocal> demoThreadLocalClass = DemoThreadLocal.class;

    protected static final ThreadLocal<? extends DemoThreadLocal> threadLocal = new ThreadLocal<DemoThreadLocal>() {
        @Override
        protected DemoThreadLocal initialValue() {
            try {
                return demoThreadLocalClass.newInstance();
            } catch (Throwable e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            }
        }
    };

    /**
     * Override the default RequestContext
     *
     * @param clazz
     */
    public static void setDemoThreadLocalClass(Class<? extends DemoThreadLocal> clazz) {
        demoThreadLocalClass = clazz;
    }
    /**
     * Get the current RequestContext
     *
     * @return the current RequestContext
     */
    public static DemoThreadLocal getCurrentContext() {
        DemoThreadLocal context = threadLocal.get();
        return context;
    }
}
