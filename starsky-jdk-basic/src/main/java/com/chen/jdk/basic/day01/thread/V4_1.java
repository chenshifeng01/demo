package com.chen.jdk.basic.day01.thread;

import java.util.ArrayList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Lock
 *    Lock 接口 ReentrantLock实现类
 *    lock.lock();
 *    lock.unlock();
 *    lock如果定义在线程自己的方法类，则只是锁自己的线程并不能保证多个线程同步执行
 */
public class V4_1 {
    private ArrayList<Integer> arrayList = new ArrayList<Integer>();
    private Lock lock = new ReentrantLock();    //注意这个地方
    public static void main(String[] args)  {
        final V4_1 test = new V4_1();
        for (int i = 0; i < 3; i++) {
            new Thread(){
                public void run() {
                    test.insert(Thread.currentThread());
                };
            }.start();
        }
    }

    public void insert(Thread thread) {
//      Lock lock = new ReentrantLock();    //加在这里不保证外面开启多线程同步
        lock.lock();
        try {

            System.out.println(thread.getName()+"得到了锁");
            for(int i=0;i<5;i++) {
                arrayList.add(i);
            }
        } catch (Exception e) {
        }finally {
            System.out.println(thread.getName()+"释放了锁");
            lock.unlock();
        }
    }
}