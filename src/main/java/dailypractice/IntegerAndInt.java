package dailypractice;

/**
 *  Java中的自动装箱和拆箱（以int和Integer为例）
 *  1. Integer a1=17; 实际执行语句是  Integer a1=Integer.valueOf(17);
 *  2. 若上述1中，数值大小在-128-127之间，由于Integer内部有缓存，此时同一值返回的是同一个Integer对象（并不是新建对象）。解释a1、a2与b1、b2
 *  3. new Integer此时肯定不是同一个对象，对象地址肯定不等。解释c1、c2
 *  4. Integer与int比较时，Integer会自动拆箱成int,此时比较的是数值大小。解释d1、d2
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
