package dailypractice;

/**
 * ������1.0Ĭ����double���ͣ�����Ҫfloat���ͣ���Ҫ�Ӻ�׺f
 */
public class FloatAndDoubleAndInt {
    public static void main(String[] args) {
        //��ʱ�ǽ��;���int��ֵΪ1 ����ת�ͳ� float������ת�Ͳ���Ҫ��ʽָ��
        float x = 1;
        //������1.0Ĭ����double���ͣ�����Ҫfloat���ͣ���Ҫ�Ӻ�׺f������û�ӣ���float x2 = 1.0 �ᱨ����Ϊ������ת�ͣ�������Ҫ�Ӹ�floatǿת��
        float x1 = 1.0f;
        float x2 = (float)1.0;
        //�����������ͬʱ����ʱ���������߾���Ϊ׼
        int y = 2;
        float z = x/y;
        System.out.println(z);

    }
}
