package dailypractice;

/**
 * java文件中有多个类的情况
 * 1. 若有多个类，则最多只能有一个类被public修饰，且这个类的类名和文件名必须相同
 * 2. 若有多个类，所有类均没有被public修饰，此时文件名可以是任意一个类的名字
 * 3. 使用javac 命令编译当前含多个类的文件，会生成多个字节码文件
 *
 * 若类没有被public修饰，则默认为default,此时作用范围：本包。
 *
 * 成员变量多态
 * 1.存在条件：继承、父类引用指向子类对象
 * 2.编译运行看左边
 * 3.若子类和父类存在同名的成员变量，此时访问的是父类的成员变量
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
