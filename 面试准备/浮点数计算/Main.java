import java.math.BigDecimal;
public class Main {
    public static void main(String[] args) {
        // 0.1 + 0.2 != 0.3
        double a = 0.1;
        double b = 0.2;
        System.out.println(a+b);
        System.out.println((a+b==0.3));
        // strategy 1: error rate
        final double error = 0.000000000001;
        System.out.println((a+b-0.3<error)?true:false);
        // strategy 2: BigDecimal
        // 注意点需要使用字符串而不是double的值，否则还是出问题
        BigDecimal c = new BigDecimal("0.1");
        BigDecimal d = new BigDecimal("0.2");
        BigDecimal result = new BigDecimal("0.3");
        System.out.println(c);
        System.out.println(d);
        System.out.println(c.add(d).equals(result));
    }
}
