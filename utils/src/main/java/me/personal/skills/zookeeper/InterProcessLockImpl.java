//package me.personal.skills.zookeeper;
//
//import org.apache.curator.framework.recipes.locks.InterProcessLock;
//
//import java.util.concurrent.TimeUnit;
//
///**
// * Created by zhongyi on 2018/8/11.
// */
//public class InterProcessLockImpl implements InterProcessLock {
//    /**
//     * 获取锁、阻塞等待、可重入
//     * <p>
//     * Acquire the mutex - blocking until it's available. Each call to acquire must be balanced by a call
//     * to {@link #release()}
//     *
//     * @throws Exception ZK errors, connection interruptions
//     */
//    @Override
//    public void acquire() throws Exception {
//        if (!internalLock(-1, null)) {
//            throw new IOException("Lost connection while trying to acquire lock: " + basePath);
//        }
//    }
//
//    /**
//     * 获取锁、阻塞等待、可重入、超时则获取失败
//     * <p>
//     * Acquire the mutex - blocks until it's available or the given time expires. Each call to acquire that returns true must be balanced by a call
//     * to {@link #release()}
//     *
//     * @param time time to wait
//     * @param unit time unit
//     * @return true if the mutex was acquired, false if not
//     * @throws Exception ZK errors, connection interruptions
//     */
//    @Override
//    public boolean acquire(long time, TimeUnit unit) throws Exception {
//        return false;
//    }
//
//    /**
//     * 释放锁
//     * <p>
//     * Perform one release of the mutex.
//     *
//     * @throws Exception ZK errors, interruptions, current thread does not own the lock
//     */
//    @Override
//    public void release() throws Exception {
//
//    }
//
//    /**
//     * Returns true if the mutex is acquired by a thread in this JVM
//     *
//     * @return true/false
//     */
//    @Override
//    public boolean isAcquiredInThisProcess() {
//        return false;
//    }
//
//
//    private boolean internalLock(long time, TimeUnit unit) throws Exception {
//        /*
//         实现同一个线程可重入性，如果当前线程已经获得锁，
//         则增加锁数据中lockCount的数量(重入次数)，直接返回成功
//        */
//        //获取当前线程
//        Thread currentThread = Thread.currentThread();
//        //获取当前线程重入锁相关数据
//        LockData lockData = threadData.get(currentThread);
//        if (lockData != null) {
//            //原子递增一个当前值，记录重入次数，后面锁释放会用到
//            lockData.lockCount.incrementAndGet();
//            return true;
//        }
//        //尝试连接zookeeper获取锁
//        String lockPath = internals.attemptLock(time, unit, getLockNodeBytes());
//        if (lockPath != null) {
//            //创建可重入锁数据，用于记录当前线程重入次数
//            LockData newLockData = new LockData(currentThread, lockPath);
//            threadData.put(currentThread, newLockData);
//            return true;
//        }
//        //获取锁超时或者zk通信异常返回失败
//        return false;
//    }
//}
