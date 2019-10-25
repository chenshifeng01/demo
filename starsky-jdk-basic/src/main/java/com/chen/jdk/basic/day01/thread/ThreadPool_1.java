package com.chen.jdk.basic.day01.thread;



import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

/**
 * NewFixedThreadPool
 * 一下实例是用异步并行
 * 如果不用异步并行，程序将至少睡眠10s
 */
public class ThreadPool_1 {

    public static void main (String[] args) throws InterruptedException, ExecutionException {
        new  ThreadPool_1().exec();

        //线程池ArrayBlockingQueue堵塞队列的玩法（最大队列是2500）
        BlockingQueue<Runnable> workQueue = new BlockQueueHack(2500);
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(50, 50, 1, TimeUnit.MINUTES, workQueue);
    }


    void exec() throws InterruptedException, ExecutionException  {
        //进行异步任务列表
        List<FutureTask<Integer>> futureTasks = new ArrayList<FutureTask<Integer>>();
        //线程池 初始化十个线程 和JDBC连接池是一个意思 实现重用
        ExecutorService executorService  = Executors.newFixedThreadPool(10);//创建一个有个3工作线程的线程池
        long start = System.currentTimeMillis();

        Callable callable = new Callable<Integer>() {
            public Integer call() throws Exception {
                Integer res = new Random().nextInt(100);
                Thread.sleep(1000);
                System.out.println("任务执行:获取到结果 :"+res);
                return  res;
            }
        };

        for(int i=0;i<10;i++){
            FutureTask<Integer> futureTask = new FutureTask<Integer>(callable);
            futureTasks.add(futureTask);
            executorService.submit(futureTask);
        }

        int count = 0;
        for (FutureTask<Integer> futureTask : futureTasks) {
            //futureTask.get() 得到我们想要的结果
            //该方法有一个重载get(long timeout, TimeUnit unit) 第一个参数为最大等待时间，第二个为时间的单位
            count+= futureTask.get();
        }
        long end = System.currentTimeMillis();
        System.out.println("线程池的任务全部完成:结果为:"+count+"，main线程关闭，进行线程的清理");
        System.out.println("使用时间："+(end-start)+"ms");
        //清理线程池
        executorService.shutdown();
    }



    public static class BlockQueueHack<T> extends ArrayBlockingQueue<T> {

        private static final long serialVersionUID = 1L;

        public BlockQueueHack(int capacity) {
            super(capacity);
        }

        @Override
        public boolean offer(T task) {
            try {
                this.put(task);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            return true;
        }
    }
}
