package birdpack;

/**
 * 探究Java的protected权限修饰符
 * 1. 定义：除了本包内可访问外，还能被该类的子类所访问，子类可以和父类不在一个包中。
 * 2. 着重关注不在本包的且是子类的情况：
 *      1. 在子类中直接访问父类中的protected变量。   Duck1
 *      2. 在子类中通过子类的对象访问父类中的protected变量。 Duck2
 *      3. 在子类中用父类对象反而不能访问父类中的protected变量。 Duck3
 *      4. 在子类中用另外一个子类的对象也不能访问父类中的protected变量。 Duck4
 * 3. 常见的使用形式是1和2，直接通过父类和另一个子类来访问父类中的protected方法和成员变量就不行（3和4）。
 *
 */
public class Bird {
    protected int feathers;
}
