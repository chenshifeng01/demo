package com.chen.jdk.basic.day01.thread;

/**
 * yield()
 *     Thread的静态方法
 *     线程 从运行状态--到就绪状态
 *     线程在 this.start()准备执行——就绪状态 ，run()运行——就是运行状态
 */
public class V2_5 extends Thread{
    @Override
    public void run() {
        for (int i = 1; i <= 50; i++) {
            System.out.println(this.getName() + "  " + i);
            // 当i为30时，该线程就会把CPU时间让掉，让其他或者自己的线程执行（也就是谁先抢到谁执行）
            if (i == 30) {
                this.yield();
            }
        }
    }

    public static void main(String[] args) {
        V2_5 yt1 = new V2_5();
        V2_5 yt2 = new V2_5();
        yt1.start();
        yt2.start();
    }
}
