package fuzishunxu;

import java.util.Random;

/*
    new一个对象，代码执行顺序是
    父类（静态成员变量与静态代码块，即类构造器）  -->   子类（静态成员变量与静态代码块，即类构造器）  -->
    父类（对象成员变量与实例代码块） -->    父类（构造函数）   -->
    子类（对象成员变量与实例代码块） -->    子类（构造函数）

    若new的类中有内部类或者静态内部类，在调用时才会被初始化
    内部类： new fuzishunxu.OuterClass.new InnerClass()
    静态内部类：new fuzishunxu.OuterClass.InnerStaticClass()
*/
public class OuterClass {

    //外部类静态成员变量
    public static long OUTER_DATE = System.currentTimeMillis();

    //外部类对象成员变量
    public String name = "abc";

    //外部类静态代码块
    static {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("外部类静态块加载时间：" + System.currentTimeMillis());
    }

    //外部类构造函数
    public OuterClass() {
        System.out.println("外部类构造函数时间：" + System.currentTimeMillis());
    }

    //静态内部类
    static class InnerStaticClass {
        public static long INNER_STATIC_DATE = System.currentTimeMillis();
    }

    //内部类
    class InnerClass {
        public long INNER_DATE = 0;
        public InnerClass() {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            INNER_DATE = System.currentTimeMillis();
        }
    }
}