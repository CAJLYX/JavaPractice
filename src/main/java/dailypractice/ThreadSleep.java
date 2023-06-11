package dailypractice;

/**
 * Thread.sleep会抛出检查异常（InterruptedException）
 * 1. checked exception：指的是编译时异常，该类异常需要本函数必须处理的，用try和catch处理，或者用throws抛出异常
 * 2. runtime exception：指的是运行时异常，该类异常不必须本函数必须处理，当然也可以处理。
 */
public class ThreadSleep {
    public static void main(String[] args) throws InterruptedException {
        Thread.sleep(3000);
    }
}
