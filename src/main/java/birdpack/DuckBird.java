package birdpack;

public class DuckBird{
    public void setFeathers(int duck1){
        //跟Duck3对比，此时不报错，是因为protected还有本包访问的权限
        Bird bird = new Bird();
        bird.feathers = duck1;
    }
}
