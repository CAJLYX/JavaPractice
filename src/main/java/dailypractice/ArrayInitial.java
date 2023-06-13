package dailypractice;

/**
 * 数组初始化：
 * 1. 分为静态初始化（指定默认值）与动态初始化（指定长度）
 * 2. 不要既指定默认值又指定长度
 * 3. 数组一旦初始化，数组的长度将不可改变
 */
public class ArrayInitial {
    public static void main(String[] args) {
        //静态初始化：显示指定每个数组元素的初始值，由系统决定数组的长度
        //常规静态初始化
        int[] staicInitialArray = new int[]{1,2,3};
        //简化静态初始化（必须在声明语句中）
        int[] simplifyStaticInitialArray = {1,2,3};
        //动态初始化：程序员指定数组的长度，由系统初始化每个数组元素的默认值(int型默认值是0)
        int[] dynamicInitialArray = new int[3];
    }
}
