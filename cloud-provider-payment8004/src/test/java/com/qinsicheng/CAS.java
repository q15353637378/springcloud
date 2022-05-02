package com.qinsicheng;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicStampedReference;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @Author qinsicheng
 * @Description 内容：
 * @Date 07/03/2022 14:37
 */
public class CAS {
    public static void main(String[] args) {
//        //设置 原字数 值为 10
//        AtomicInteger atomicInteger = new AtomicInteger(10);
//        // expect:10 预期为10，update:12 改为12 返回一个布尔类型
//        atomicInteger.compareAndSet(10,12);
//        // 执行第二个时，原数据已经发生改变 所有数据没有进行更改
//        atomicInteger.compareAndSet(10,14);
//        // 12
//        System.out.println(atomicInteger.get());

//        AtomicStampedReference<Integer> reference = new AtomicStampedReference<Integer>(1,1);
//        //true
//        System.out.println(reference.compareAndSet(1, 2, 1, 2));
//        //true
//        System.out.println(reference.compareAndSet(2, 1, 2, 3));
//        //false
//        System.out.println(reference.compareAndSet(1, 2, 1, 2));
//        //1
//        System.out.println(reference.getReference());

        //创建一个锁
//        ReentrantLock lock = new ReentrantLock(false);
//        //加锁
//        lock.lock();
//        //开锁
//        lock.unlock();
        for (int i = 0; i < 10; i++) {
            new Thread(CAS::lock).start();
        }


    }

    public synchronized void get() {
        set();
    }

    public synchronized void set() {
    }

    static AtomicInteger atomicInteger = new AtomicInteger(0);
    public static void lock() {
        int current;
        int next;
        do {
            current = atomicInteger.get();
            next = current >= Integer.MAX_VALUE ? 0 : current + 1;
        } while (!atomicInteger.compareAndSet(current, next));
        System.out.println(Thread.currentThread().getName() + " :next:" + next);
    }



}
