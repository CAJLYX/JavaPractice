package duckpack;

import birdpack.Bird;

public class Duck3 extends Bird {
    public void construct(int duckFeather){
        //子类中用父类对象反而不能访问父类中的protected变量,此时编译出错
        Bird bird = new Bird();
        //bird.feathers = duckFeather;
    }
}
