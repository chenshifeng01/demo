package com.micrometer;

import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class MyComponent {

    @Autowired
    private  MeterRegistry registry;


    @PostConstruct
    public void run() {
        doSomeWork("hello");
    }


    private void doSomeWork(String lowCardinalityInput) {
        registry.timer("my.latency", "input", lowCardinalityInput).record(() -> {
            demo();
        });
    }


    private void demo() {
        System.out.println("hello");
    }

}
