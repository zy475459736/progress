package me.personal.concurrency.threads;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by zhongyi on 2018/7/23.
 */
public abstract class SimpleThread implements Runnable {

    private volatile boolean running = false;
    private volatile boolean enable = false;
    private volatile AtomicInteger interval = new AtomicInteger(5000);
    @Override
    public void run() {
        while (running){
            try{
                if (!enable) {
                    continue;
                }
                process();

                Thread.sleep(interval.get());
            }catch (Exception e){

            }
        }
    }

    public abstract void process();

    public void setEnable(boolean enable) {
        this.enable = enable;
    }
    public void setRunning(){}
}
