package com.design.patterns.singleton;

/**
 * 饿汉式单例
 * Created by hand on 2019/1/4.
 */
public class HungryManSingleton {

    private static HungryManSingleton singleton = new HungryManSingleton();

    private HungryManSingleton() {
    }

    public static HungryManSingleton getInstance() {
        return singleton;
    }


}
