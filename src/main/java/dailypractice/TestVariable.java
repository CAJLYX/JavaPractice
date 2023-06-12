package dailypractice;

/**
 *  变量初始化赋值
 *  1.成员变量：类加载时初始化赋值的是静态成员变量，类实例化时初始化非静态成员变量
 *  2.局部变量：没有像成员变量那样在类加载、实例化时会有初始化赋值，所以要使用局部变量时，一定要显式的给它赋值。不然代码会报错
 */
public class TestVariable {
    private static String s1;
    public static void main (String[] args){
        String s;
        //会报错
        // System.out.println("s=" + s);
        //正常
        System.out.println("s1=" + s1);
    }
}
