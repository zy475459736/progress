package me.personal.concurrency.threads;

import com.netflix.config.DynamicBooleanProperty;
import com.netflix.config.DynamicLongProperty;
import com.netflix.config.DynamicPropertyFactory;

/**
 * Created by zhongyi on 2018/7/23.
 */

public abstract class BasePoller {

    private Thread worker;
    private volatile boolean running = false;
    private DynamicBooleanProperty enable;
    private DynamicLongProperty interval;

    public BasePoller(String name,long timeout) {
        this.enable = DynamicPropertyFactory.getInstance().getBooleanProperty("demo." + name.toLowerCase() + ".enable",true);
        this.interval = DynamicPropertyFactory.getInstance().getLongProperty("demo." + name.toLowerCase() + ".interval",timeout);
        this.worker = new Thread(new Runnable() {

            @Override
            public void run() {
                while (running) {
                    try {
                        if (!enable.get()) continue;

                        process();

                    } catch (Throwable t) {
                        System.out.println((name + "process fail."+ t));
                    } finally {
                        try {
                            Thread.sleep(interval.get());
                        } catch (InterruptedException e) {
                            System.out.println((name + " sleep error!"+e));
                        }
                    }

                }
            }
        }, name);
    }

    public void start() {
        if (!running) {
            this.running = true;
            this.worker.start();
        }
    }

    public void stop() {
        this.running = false;
    }

    public abstract void process();
}
