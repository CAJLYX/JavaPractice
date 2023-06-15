package duckpack;

import birdpack.Bird;

public class Duck4 extends Bird {
    public void construct(int duckFeather){
        //子类中用另外一个子类的对象也不能访问父类中的protected变量。编译出错
        Duck1 duck1 = new Duck1();
        //duck1.feathers = duckFeather;
    }
}
