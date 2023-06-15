package dailypractice;

/**
 * String的两种创建形式
 * 1. String a = new String("myString")  运行时动态加载的，此时会在堆内存中生成一个myString字符串，指向堆内存字符串地址
 * 2. String b = "myString"  编译时静态加载的，此时会在常量池中存放一个myString字符串，指向常量池字符串地址
 * 3. String c = "my" + "String";  由于字符串常量值相等，故b与c的指向地址一致。
 */
public class StringType {
    public static void main(String[] args) {
        String a = new String("myString");
        String b = "myString";
        String c = "my" + "String";
        String d = c;
        //false a指向堆内存，b指向常量池，因此地址不相等
        System.out.println(a == b);
        //false 同上
        System.out.println(a == c);
        //true 由于c拼接后字符串常量等于b,所以他们指向一致
        System.out.println(b == c);
        //true
        System.out.println(b == d);
    }
}
