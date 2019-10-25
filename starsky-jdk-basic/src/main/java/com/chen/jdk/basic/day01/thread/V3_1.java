package com.chen.jdk.basic.day01.thread;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * AtomicInteger
 *      原子性变量
 */
public class V3_1 {
    private static AtomicInteger atomicInteger = new AtomicInteger(0);

    public static void main(String[] args)  {
        for (int i = 0; i < 100; i++) {
            new Thread(new Runnable() {

                public void run() {
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    atomicInteger.incrementAndGet();
                }
            }).start();
        }
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(atomicInteger);
    }
}