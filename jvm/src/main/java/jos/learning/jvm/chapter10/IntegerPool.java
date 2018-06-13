package jos.learning.jvm.chapter10;

/**
 * Created by jos on 2018/6/12.
 */
public class IntegerPool {
    public static void main(String[] args) {
        Integer a = 1;
        Integer b = 2;
        Integer c = 3;
        Integer d = 3;
        Integer e = 321;
        Integer f = 321;
        Long g = 3L;
        Integer h = 32002;
        Integer i = 32003;
        Integer j = 64005;

        /**
         *  if (i >= IntegerCache.low && i <= IntegerCache.high)
         return IntegerCache.cache[i + (-IntegerCache.low)];
         return new Integer(i);
         */

        System.out.println(c == d);
        System.out.println(e == f);
        System.out.println();

        System.out.println(c == (a + b));
        System.out.println(c.equals(a + b));
        System.out.println();

        System.out.println(j == (h + i));
        System.out.println(j.equals(h + i));
        System.out.println();


        // 类型不同,equals恒为false
        System.out.println(g == (a + b));
        System.out.println(g.equals(a + b));
    }

}
