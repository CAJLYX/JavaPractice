package dailypractice;

/**
 * Thread.sleep���׳�����쳣��InterruptedException��
 * 1. checked exception��ָ���Ǳ���ʱ�쳣�������쳣��Ҫ���������봦��ģ���try��catch����������throws�׳��쳣
 * 2. runtime exception��ָ��������ʱ�쳣�������쳣�����뱾�������봦����ȻҲ���Դ���
 */
public class ThreadSleep {
    public static void main(String[] args) throws InterruptedException {
        Thread.sleep(3000);
    }
}
