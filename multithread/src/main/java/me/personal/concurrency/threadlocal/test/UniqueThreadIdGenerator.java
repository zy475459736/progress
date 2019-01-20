package me.personal.concurrency.threadlocal.test;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by zhongyi on 2019/1/20.
 */
public class UniqueThreadIdGenerator {

    // 原子整型
    private static final AtomicInteger uniqueId = new AtomicInteger(0);

    // 线程局部整型变量
    private static final ThreadLocal <Integer> uniqueNum =
            new ThreadLocal < Integer > () {
                @Override protected Integer initialValue() {
                    return uniqueId.incrementAndGet();
                }
            };

    //变量值
    public static int getUniqueId() {
        return uniqueId.get();
    }

    public static void main(String[] args) {
        UniqueThreadIdGenerator uniqueThreadId = new UniqueThreadIdGenerator();
        // 为每个线程生成一个唯一的局部标识
        TaskThread t1 = new TaskThread<UniqueThreadIdGenerator>("custom-thread-1", uniqueThreadId);
        TaskThread t2 = new TaskThread<UniqueThreadIdGenerator>("custom-thread-2", uniqueThreadId);
        TaskThread t3 = new TaskThread<UniqueThreadIdGenerator>("custom-thread-3", uniqueThreadId);
        t1.start();
        t2.start();
        t3.start();
    }

}
