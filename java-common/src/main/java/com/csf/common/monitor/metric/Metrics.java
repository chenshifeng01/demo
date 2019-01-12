package com.csf.common.monitor.metric;

import com.codahale.metrics.Meter;
import com.codahale.metrics.MetricRegistry;
import com.codahale.metrics.Slf4jReporter;
import org.slf4j.LoggerFactory;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by hand on 2019/1/8.
 */
public class Metrics {

    public static final MetricRegistry metrics = new MetricRegistry();

    private static transient boolean inited = false;

    public synchronized static void init() {
        if (!inited) {
            Slf4jReporter reporter = Slf4jReporter.forRegistry(metrics)
                    .outputTo(LoggerFactory.getLogger(MetricRegistry.class))
                    .convertRatesTo(TimeUnit.SECONDS)
                    .convertDurationsTo(TimeUnit.MILLISECONDS)
                    .build();
            reporter.start(1, TimeUnit.MINUTES);
            inited = true;
        }
    }


    public static void main(String[] args) throws Exception {
        Metrics.init();
        Meter meter = Metrics.metrics.meter("hahaha");

        ThreadPoolExecutor executor = new ThreadPoolExecutor(100, 0, TimeUnit.MILLISECONDS, new BlockingQueue<Runnable>());


    }
    /*
    int corePoolSize,
                              int maximumPoolSize,
                              long keepAliveTime,
                              TimeUnit unit,
                              BlockingQueue<Runnable> workQueue
     */

}
