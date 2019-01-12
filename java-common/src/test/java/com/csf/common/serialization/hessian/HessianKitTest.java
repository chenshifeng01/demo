package com.csf.common.serialization.hessian;

import com.google.gson.Gson;
import jdk.internal.instrumentation.InstrumentationTarget;
import org.apache.commons.io.IOUtils;
import sun.instrument.InstrumentationImpl;

import java.io.FileInputStream;
import java.lang.instrument.Instrumentation;
import java.util.Map;

/**
 * Created by hand on 2019/1/8.
 */
public class HessianKitTest {

    public static void main(String[] args) throws Exception {
        String line = IOUtils.toString(
                new FileInputStream(
                        "E:\\data\\github\\demo\\java-common\\src\\test\\java\\com\\csf\\common\\serialization\\hessian\\json.json")
                , "utf-8");

        Gson gson = new Gson();
        Map map1 = gson.fromJson(line, Map.class);
        System.out.println(HessianKit.toHessian1(map1).length);
        System.out.println(HessianKit.toHessian2(map1).length);
    }


}
