package fuzishunxu;

public class TestOuterClass {
    public static void main(String[] args) {
        OuterClass outer = new OuterClass();
        System.out.println("�ⲿ�ྲ̬��������ʱ�䣺" + outer.OUTER_DATE);
        OuterClass outer1 = new OuterClass();
        System.out.println("�Ǿ�̬�ڲ������ʱ��"+outer.new InnerClass().INNER_DATE);
        System.out.println("��̬�ڲ������ʱ�䣺"+ new OuterClass.InnerStaticClass());
        System.out.println("��̬�ڲ������ʱ�䣺"+ OuterClass.InnerStaticClass.INNER_STATIC_DATE);
    }
}
