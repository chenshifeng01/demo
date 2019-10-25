package com;


import com.codahale.metrics.ConsoleReporter;
import com.codahale.metrics.MetricRegistry;
import io.micrometer.core.instrument.Clock;
import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.dropwizard.DropwizardConfig;
import io.micrometer.core.instrument.dropwizard.DropwizardMeterRegistry;
import io.micrometer.core.instrument.util.HierarchicalNameMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.util.concurrent.TimeUnit;

@SpringBootApplication  //springboot启动加载上下文注解
@ComponentScan("com.util")
@Configuration
@EnableScheduling
public class StongHoldApplication {


    public static void main(String[] args) {
        SpringApplication.run(StongHoldApplication.class, args);
    }


//    @Bean
//    public MetricRegistry dropwizardRegistry() {
//        return new MetricRegistry();
//    }
//
//    @Bean
//    public ConsoleReporter consoleReporter(MetricRegistry dropwizardRegistry) {
//        ConsoleReporter reporter = ConsoleReporter.forRegistry(dropwizardRegistry)
//                .convertRatesTo(TimeUnit.SECONDS)
//                .convertDurationsTo(TimeUnit.MILLISECONDS)
//                .build();
//        reporter.start(1, TimeUnit.SECONDS);
//        return reporter;
//    }
//
//    @Bean
//    public MeterRegistry consoleLoggingRegistry(MetricRegistry dropwizardRegistry) {
//        DropwizardConfig consoleConfig = new DropwizardConfig() {
//
//            @Override
//            public String prefix() {
//                return "console";
//            }
//
//            @Override
//            public String get(String key) {
//                return null;
//            }
//
//        };
//
//        return new DropwizardMeterRegistry(consoleConfig, dropwizardRegistry, HierarchicalNameMapper.DEFAULT, Clock.SYSTEM) {
//            @Override
//            protected Double nullGaugeValue() {
//                return null;
//            }
//        };
//    }

}
