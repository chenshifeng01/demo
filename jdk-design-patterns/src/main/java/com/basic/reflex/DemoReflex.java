package com.basic.reflex;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;

public class DemoReflex {

    public static void main(String[] args) throws Exception {


        Class<ReflexObj> reflexObjClass = ReflexObj.class;
        Method demo = reflexObjClass.getMethod("demo");
        System.out.println(demo.getName());

        // 会初始化
        Class clazz2 = Class.forName("com.basic.reflex.ReflexObj");
        Method[] methods = clazz2.getMethods();
        System.out.println("类的所有的方法：" + Arrays.asList(methods));
        Method method = clazz2.getMethod("demo");
        System.out.println(clazz2.getName());
        ReflexObj o = (ReflexObj)clazz2.newInstance();
        o.demo();


        Class<?> aClass = Class.forName("com.basic.reflex.ReflexObj");

        getNotPrivateMethod();

    }


//    @Test
    public static void getNotPrivateMethod() throws Exception {
        Class<ReflexObj> reflexObjClass = ReflexObj.class;
        reflexObjClass.getMethod("toString");

        ReflexObj obj = reflexObjClass.newInstance();

        Object demo = reflexObjClass.getMethod("demo").invoke(obj);
        System.out.println(demo);

    }




}




class ReflexObj {

    public void demo() {
        System.out.println("hello");
    }

}