package duckpack;

import birdpack.Bird;

public class Duck2 extends Bird {
    public void construct(int duckFeather){
        //在子类中通过子类的对象访问父类中的protected变量
        Duck2 duck2 = new Duck2();
        duck2.feathers = duckFeather;
    }
}
