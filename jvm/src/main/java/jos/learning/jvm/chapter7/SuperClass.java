package jos.learning.jvm.chapter7;

/**
 * 被动使用类字段演示一：
 * 通过子类引用父类的静态字段，不会导致子类初始化
 */
public class SuperClass {

    static {
        System.out.println("SuperClass static!");
        /**
         *  8: sipush        234
         11: putstatic     #6                  // Field value:I
         14: bipush        123
         16: putstatic     #6                  // Field value:I

         */
        value = 234;
//        System.out.println(value);//非法向前
    }

    public static int value = 123;
    public static int value2 = 2222;


    public SuperClass() {
        System.out.println("SuperClass init!");
    }
}
