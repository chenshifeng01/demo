package com.csf.common.throttle.ratelimiter;

import java.util.Date;

/**
 * Created by hand on 2019/1/7.
 */
public class RateLimiter {


    //限流四个
    public static void main(String[] args) {
        RateLimiter rateLimiter = RateLimiter.create(4);
        while (true) {
            System.out.println(new Date() + ":" + rateLimiter.acquire());
        }
    }

}
