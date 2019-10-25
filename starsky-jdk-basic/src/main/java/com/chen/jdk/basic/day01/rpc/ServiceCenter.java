package com.chen.jdk.basic.day01.rpc;

import java.io.IOException;

public class ServiceCenter implements Server{


    public void stop() {

    }

    public void start() throws IOException {

    }

    public void register(Class serviceInterface, Class impl) {

    }

    public boolean isRunning() {
        return false;
    }

    public int getPort() {
        return 0;
    }
}
