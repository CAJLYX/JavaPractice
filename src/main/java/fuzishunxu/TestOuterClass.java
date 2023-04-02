package fuzishunxu;

public class TestOuterClass {
    public static void main(String[] args) {
        OuterClass outer = new OuterClass();
        System.out.println("外部类静态变量加载时间：" + outer.OUTER_DATE);
        OuterClass outer1 = new OuterClass();
        System.out.println("非静态内部类加载时间"+outer.new InnerClass().INNER_DATE);
        System.out.println("静态内部类加载时间："+ new OuterClass.InnerStaticClass());
        System.out.println("静态内部类加载时间："+ OuterClass.InnerStaticClass.INNER_STATIC_DATE);
    }
}
