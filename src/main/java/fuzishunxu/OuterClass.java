package fuzishunxu;

import java.util.Random;

/*
    newһ�����󣬴���ִ��˳����
    ���ࣨ��̬��Ա�����뾲̬����飬���๹������  -->   ���ࣨ��̬��Ա�����뾲̬����飬���๹������  -->
    ���ࣨ�����Ա������ʵ������飩 -->    ���ࣨ���캯����   -->
    ���ࣨ�����Ա������ʵ������飩 -->    ���ࣨ���캯����

    ��new���������ڲ�����߾�̬�ڲ��࣬�ڵ���ʱ�Żᱻ��ʼ��
    �ڲ��ࣺ new fuzishunxu.OuterClass.new InnerClass()
    ��̬�ڲ��ࣺnew fuzishunxu.OuterClass.InnerStaticClass()
*/
public class OuterClass {

    //�ⲿ�ྲ̬��Ա����
    public static long OUTER_DATE = System.currentTimeMillis();

    //�ⲿ������Ա����
    public String name = "abc";

    //�ⲿ�ྲ̬�����
    static {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("�ⲿ�ྲ̬�����ʱ�䣺" + System.currentTimeMillis());
    }

    //�ⲿ�๹�캯��
    public OuterClass() {
        System.out.println("�ⲿ�๹�캯��ʱ�䣺" + System.currentTimeMillis());
    }

    //��̬�ڲ���
    static class InnerStaticClass {
        public static long INNER_STATIC_DATE = System.currentTimeMillis();
    }

    //�ڲ���
    class InnerClass {
        public long INNER_DATE = 0;
        public InnerClass() {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            INNER_DATE = System.currentTimeMillis();
        }
    }
}