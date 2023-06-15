package dailypractice;

/**
 * 单独的1.0默认是double类型，若想要float类型，需要加后缀f
 */
public class FloatAndDoubleAndInt {
    public static void main(String[] args) {
        //此时是将低精度int型值为1 向上转型成 float。向上转型不需要显式指定
        float x = 1;
        //单独的1.0默认是double类型，若想要float类型，需要加后缀f。若是没加，则float x2 = 1.0 会报错，因为是向下转型，所以需要加个float强转。
        float x1 = 1.0f;
        float x2 = (float)1.0;
        //多个精度数字同时运算时，结果以最高精度为准
        int y = 2;
        float z = x/y;
        System.out.println(z);

    }
}
