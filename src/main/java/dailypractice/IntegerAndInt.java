package dailypractice;

/**
 *  Java�е��Զ�װ��Ͳ��䣨��int��IntegerΪ����
 *  1. Integer a1=17; ʵ��ִ�������  Integer a1=Integer.valueOf(17);
 *  2. ������1�У���ֵ��С��-128-127֮�䣬����Integer�ڲ��л��棬��ʱͬһֵ���ص���ͬһ��Integer���󣨲������½����󣩡�����a1��a2��b1��b2
 *  3. new Integer��ʱ�϶�����ͬһ�����󣬶����ַ�϶����ȡ�����c1��c2
 *  4. Integer��int�Ƚ�ʱ��Integer���Զ������int,��ʱ�Ƚϵ�����ֵ��С������d1��d2
 */
public class IntegerAndInt {
    public static void main(String[] args) {
        Integer a1=17,a2=17;
        Integer b1=2017,b2=2017;
        Integer c1 = new Integer(17);
        Integer c2 = new Integer(17);
        Integer d1 = new Integer(2017);
        int d2 = 2017;
        //a1 == a2 :true
        System.out.println("a1 == a2 :"+(a1 == a2));
        //b1 == b2 :false
        System.out.println("b1 == b2 :"+(b1 == b2));
        //c1 == c2 :false
        System.out.println("c1 == c2 :"+(c1 == c2));
        //d1 == d2 :true
        System.out.println("d1 == d2 :"+(d1 == d2));
    }
}
