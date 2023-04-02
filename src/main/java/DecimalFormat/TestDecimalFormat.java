package DecimalFormat;

import java.math.BigDecimal;
import java.text.DecimalFormat;

/*
    TODO:
    #与0的区别：
        #：没有则为空
        0：没有则补0
 */
public class TestDecimalFormat {
    public static void main(String[] args) {
        DecimalFormat decimalFormat = new DecimalFormat("##0.0###");
        DecimalFormat decimalFormat2 = new DecimalFormat("#.######");
        String format = decimalFormat.format(612);
        System.out.println(format);

        BigDecimal bigDecimal = new BigDecimal(612.3400);
        BigDecimal multiply = bigDecimal.multiply(new BigDecimal(0.01));
        System.out.println(decimalFormat2.format(multiply));
    }
}
