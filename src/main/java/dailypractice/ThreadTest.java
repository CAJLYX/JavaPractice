package dailypractice;

/**
 * Thread�е�yield��������
 * 1. ��ͣ��ǰ����ִ�е��̶߳��󣬲�ִ�������̡߳�
 * 2. ���ã���ǰ�̴߳�����״̬ת��������״̬�����п���û��Ч��
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
