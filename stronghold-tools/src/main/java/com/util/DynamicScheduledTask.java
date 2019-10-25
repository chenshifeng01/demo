package com.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ScheduledFuture;

/**
 * 动态根据定时规则生产调度任务
 */
@Component
public class DynamicScheduledTask {


    private static Logger logger = LoggerFactory.getLogger(DynamicScheduledTask.class);

    private Map<String, ScheduledFuture<?>> map = new ConcurrentHashMap();

    @Autowired
    private ThreadPoolTaskScheduler threadPoolTaskScheduler;

    @Bean
    public ThreadPoolTaskScheduler threadPoolTaskScheduler() {
        ThreadPoolTaskScheduler scheduler = new ThreadPoolTaskScheduler();
        scheduler.setPoolSize(30);
        return scheduler;
    }


    /**
     * 定时更新定时任务
     */
    @PostConstruct
    public void todo() {
        // 销毁所有放入Map的定时器
        stopCronByMap(map);
        // 初始化10个定时器
        String[] expressionArr = {"0/30 * * * * ?", "0/50 * * * * ?"};

        Arrays.asList(expressionArr).forEach(expression -> {
            ScheduledFuture<?> scheduledFuture = initTask(expression);
            map.put(expression, scheduledFuture);
        });
        logger.info("初始化定时任务数目：{}", map.size());
    }


    /**
     * 停止定时任务
     */
    public void stopCronByMap(Map<String, ScheduledFuture<?>> map) {
        Iterator<String> iterator = map.keySet().iterator();
        while (iterator.hasNext()) {
            String key = iterator.next();
            if (map.get(key) != null) {
                map.get(key).cancel(true);
            }
            map.remove(key);
        }
    }


    /**
     * 初始化定时任务
     */
    public ScheduledFuture<?> initTask(String expression) {
        ScheduledFuture<?> future = threadPoolTaskScheduler.schedule(new Runnable() {
            @Override
            public void run() {
                // TODO    定时器需要执行的方法
                doRun(expression);
            }
        }, new CronTrigger(expression));
        return future;
    }


    private void doRun(String expression) {
        System.out.println("doRun开始:" + expression);
    }


}