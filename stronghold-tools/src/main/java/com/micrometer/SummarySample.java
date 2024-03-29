package com.micrometer;

import io.micrometer.core.instrument.DistributionSummary;
import io.micrometer.core.instrument.simple.SimpleMeterRegistry;

public class SummarySample {

    public static void main(String[] args) throws Exception {
        DistributionSummary summary = DistributionSummary.builder("summary")
                .tag("summary", "summary")
                .description("summary")
                .register(new SimpleMeterRegistry());
        summary.record(2D);
        summary.record(3D);
        summary.record(4D);
        System.out.println(summary.measure());
        System.out.println(summary.count());
        System.out.println(summary.max());
        System.out.println(summary.mean());
        System.out.println(summary.totalAmount());
    }

    //Exception in thread "main" redis.clients.jedis.exception.JedisDataException:CROS
}
