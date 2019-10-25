package com.csf.common.monitor.metric;

import com.codahale.metrics.ConsoleReporter;
import com.codahale.metrics.Meter;
import com.codahale.metrics.MetricRegistry;

import java.util.concurrent.TimeUnit;

/**
 * 监控tps性能
 */
public class Metrics {

    private static final MetricRegistry metric = new MetricRegistry();


    public static void main(String[] args) throws Exception {
        Metrics.init();
        Meter meter = metric.meter("hello-metric");
        while (true) {
            meter.mark();
            TimeUnit.MILLISECONDS.sleep(1);
        }
    }

    public static void init() {
        ConsoleReporter reporter = ConsoleReporter.forRegistry(metric).build();
//        Slf4jReporter reporter = Slf4jReporter.forRegistry(metric)
//                .prefixedWith("chen")
//                .shutdownExecutorOnStop(true)
//                .build();
        reporter.start(3, TimeUnit.SECONDS);
    }

}
