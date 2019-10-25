package com.chen.jdk.basic.day01.thread;

/**
 * join()
 *  1、Thread类里的非静态方法
 *  2、a.join() 等待a线程执行完毕再接着执行a.join()所在的线程
 *  3、main线程先开启了，A,B线程，B线程执行不受a.join影响的 只是说主线程等待A执行完再执行，B线程是独立的不受影响的
 *  4、thread.Join把指定的线程加入到当前线程，可以将两个交替执行的线程合并为顺序执行的线程。
 */
public class V2_3 {

    public static void main(String[] args) throws InterruptedException {
        Thread a = new Thread(new Runnable() {

            public void run() {
                System.out.println("start A");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("end A");
            }
        });
        Thread b = new Thread(new Runnable() {

            public void run() {
                System.out.println("start B");
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("end B");
            }
        });
        //
        a.start();
        b.start();
        a.join();
        b.join();
        System.out.println("end");
    }
}