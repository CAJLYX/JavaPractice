package duckpack;

import birdpack.Bird;

public class Duck2 extends Bird {
    public void construct(int duckFeather){
        //��������ͨ������Ķ�����ʸ����е�protected����
        Duck2 duck2 = new Duck2();
        duck2.feathers = duckFeather;
    }
}
