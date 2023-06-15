package dailypractice;

/**
 * String�����ִ�����ʽ
 * 1. String a = new String("myString")  ����ʱ��̬���صģ���ʱ���ڶ��ڴ�������һ��myString�ַ�����ָ����ڴ��ַ�����ַ
 * 2. String b = "myString"  ����ʱ��̬���صģ���ʱ���ڳ������д��һ��myString�ַ�����ָ�������ַ�����ַ
 * 3. String c = "my" + "String";  �����ַ�������ֵ��ȣ���b��c��ָ���ַһ�¡�
 */
public class StringType {
    public static void main(String[] args) {
        String a = new String("myString");
        String b = "myString";
        String c = "my" + "String";
        String d = c;
        //false aָ����ڴ棬bָ�����أ���˵�ַ�����
        System.out.println(a == b);
        //false ͬ��
        System.out.println(a == c);
        //true ����cƴ�Ӻ��ַ�����������b,��������ָ��һ��
        System.out.println(b == c);
        //true
        System.out.println(b == d);
    }
}
