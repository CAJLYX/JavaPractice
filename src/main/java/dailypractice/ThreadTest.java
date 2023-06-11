package dailypractice;

/**
 * Thread中的yield函数考察
 * 1. 暂停当前正在执行的线程对象，并执行其他线程。
 * 2. 作用：当前线程从运行状态转到可运行状态，但有可能没有效果
 */
public class ThreadTest extends Thread{

    @Override
    public void run(){
        System.out.println("In Run");
        yield();
        System.out.println("Leaving run");
    }

    public static void main(String[] args) {
        (new ThreadTest()).start();
    }
}
