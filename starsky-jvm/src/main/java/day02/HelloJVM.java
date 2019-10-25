package day02;


/**
 * 从jvm调用的角度分析Java程序对内存空间的使用：
 * 当jvm进程启动的时候，会从类加载路径中找到包含main方法的入口HelloJVM;
 * 找到Hellojvm后直接读取该文件中的二进制并且吧该类的信息放到运行收的Method内存区域中；
 * 然后会为到Hellojvm中的main方法的字节码中开始执行main方法中的指令：
 * Student student = new Student("dt_spark");
 * 此时会创建student实例对象并且使用student来应用该对象（或者说对该对象命名），其内幕如下：
 * 第一步： jvm会直接到method区域中区查找student类的信息，此时发现没有Student类，就通过
 *         类加载器加载该student类文件；
 * 第二步：在jvm的method区域加载并找到类student类之后会在Heap区域中为student实例对象分配内存，
 *          并且在student的实例对象中持有指向方法区域中的Student类中的应用（内存地址）；
 * 第三步：JVM实例完成后会在当前线程中为stack中的reference建立实例的引用关系，此时会赋予给student
 *
 * 在JVM中方法的调用一定是属于线程行为，也就是说方法调用本身会发展在调用线程的方法调用栈：
 *      线程的方法调用栈（Method Stack Frames），每一个方法的调用就是方法调用栈中的一个Frame，该
 *      Frame包含类方法的参数、局部变量、临时数据等：
 *                          student.sayHello();
 *
 *
 *
 */
public class HelloJVM {


    /**
     * 在jvm运行的时候会通过反射的方式道Method区域找到入口类的入口方法main
     * @param args
     */
    public static void main(String[] args) { //main方法放在method方法区域中的；

        /**
         * student是放在主线程中的Stack区域中的；
         * Student对象实例是放在所有线程共享的Heap区域中的；
         *
         */
        Student student = new Student("dt_spark");

        /**
         * 首先会通过student指针（句柄）找到Student对象，当找到该对象后
         * 会通过对象内部指向方法区域中的指针来调用具体的方法来执行任务
         */
        student.sayHello();




    }

}




class Student {

    //name本身作为成员是否放在Stack区域的，但是name执行的string对象是否放在Heap中；
    private String name;

    public Student (String name) {
        this.name = name;

    }

    public void sayHello () {  //sayHello这个方法是否放在方法区域中的；
        System.out.println("Hello, this is " + this.name);

    }




}
