package duckpack;

import birdpack.Bird;

public class Duck1 extends Bird {
    public void setFeathers(int duck1){
        // 在子类中直接访问父类中的protected变量
        feathers = duck1;
    }
}
