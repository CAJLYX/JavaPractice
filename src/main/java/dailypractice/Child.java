package dailypractice;

/**
 * java�ļ����ж��������
 * 1. ���ж���࣬�����ֻ����һ���౻public���Σ����������������ļ���������ͬ
 * 2. ���ж���࣬�������û�б�public���Σ���ʱ�ļ�������������һ���������
 * 3. ʹ��javac ������뵱ǰ���������ļ��������ɶ���ֽ����ļ�
 *
 * ����û�б�public���Σ���Ĭ��Ϊdefault,��ʱ���÷�Χ��������
 *
 * ��Ա������̬
 * 1.�����������̳С���������ָ���������
 * 2.�������п����
 * 3.������͸������ͬ���ĳ�Ա��������ʱ���ʵ��Ǹ���ĳ�Ա����
 */
class Person{
    public String name = "Person";
    int age=0;
}

public class Child extends Person{
    public String grade;
    public static void main(String[] args){
        Person p = new Child();
        System.out.println(p.name);
    }
}
