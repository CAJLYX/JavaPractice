package dailypractice;

/**
 * 基本类型初始化赋值为0，包装类初始化赋值为null.
 * Byte是包装类
 * null4242
 */
class Two{
    Byte x;
}
class PassO{
    public static void main(String[] args){
        PassO p=new PassO();
        p.start();
    }
    void start(){
        Two t=new Two();
        System.out.print(t.x+"");
        Two t2=fix(t);
        System.out.print(t.x+""+t2.x);
    }
    Two fix(Two tt){
        tt.x=42;
        return tt;
    }
}
