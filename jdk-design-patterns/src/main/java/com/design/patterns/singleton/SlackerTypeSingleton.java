package com.design.patterns.singleton;

/**
 * 懒汉式单例
 * Created by hand on 2019/1/4.
 */
public class SlackerTypeSingleton {

    private static SlackerTypeSingleton singleton;

    private SlackerTypeSingleton() {
    }

    public static synchronized SlackerTypeSingleton getInstance() {
        if (singleton == null) {
            singleton = new SlackerTypeSingleton();
        }
        return singleton;
    }
}
