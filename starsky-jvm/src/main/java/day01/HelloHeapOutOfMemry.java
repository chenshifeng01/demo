package day01;

import java.util.ArrayList;
import java.util.List;


/**
 * 堆 : outofMemoryError:java heap space Java堆溢出错误
 * 设置jvm参数，-verbose:gc -Xms10M -Xmx10M -XX:MaxDirectMemorySize=5M -Xss128k -XX:+PrintGCDetails
 */
class Person { }

public class HelloHeapOutOfMemry {

    public static void main(String[] args) {
        System.out.println("HelloHeapOutOfMemry");
        List<Person> persons = new ArrayList<Person>();
        int counter = 0;
        while (true) {
            persons.add(new Person());
            System.out.println("Instance: " + (++counter));
        }




    }

}
