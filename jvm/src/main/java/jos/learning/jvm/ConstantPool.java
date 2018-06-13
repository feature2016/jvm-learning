package jos.learning.jvm;

/**
 * Created by jos on 2018/5/16.
 * 字符串进入到常量池的两种方法：
 * 1. new String()的实例调用intern()方法。
 *     执行intern()方法时，若常量池中不存在等值的字符串，JVM就会在常量池中 创建一个等值的字符串，然后返回该字符串的引用。
 * 2. “”（引号）引起来的内容（字面量）。
 *     引号引起来的字符串，首先从常量池中查找是否存在此字符串，如果不存在则在常量池中添加此字符串对象，然后引用此字符串对象。如果存在，则直接引用此字符串。
 * <p/>
 * 参考内存模型文章:https://www.jianshu.com/p/4ee6aec39c89?from=groupmessage
 */
public class ConstantPool {

    public static void main(String[] args) throws InterruptedException {
        String str1 = new StringBuilder("中国").append("钓鱼岛").toString();
        System.out.println(str1.intern() == str1);   // true

        // 如果常量已经存在,则intern直接由常量池返回
        String str2 = new StringBuilder("ja").append("va").toString();
        System.out.println(str2.intern() == str2);    // false


        String temp = "hh";
        String s1 = "a" + temp;
        // 如果调用s1.intern 则最终返回true
        String s2 = "ahh";
        System.out.println(s1 == s2);    // false

        s1 = "ab" + "cd";
        s2 = "abcd";
        System.out.println(s1 == s2);    // true
        System.out.println(s1.intern() == s2);    // true


        temp = "temp";
        // 加号运算发生在堆,字符串的串联是通过StringBuffer类来实现的
        s1 = "s1" + temp;
        s2 = "s1temp";
        System.out.println(s2 == s1);   // false
        System.out.println(s2 == s1.intern());   // true
        System.out.println(s2 == s1);   // false

        s1 = new String("bbb").intern();
        s2 = "bbb";
        System.out.println(s1 == s2);    // true


        // new String 新建对象
        s1 = new String("xxjdsaf");    // 同时会生成堆中的对象 以及常量池中1的对象，但是此时s1是指向堆中的对象的
        s1.intern();
        s2 = "xxjdsaf";
        System.out.println(s1 == s2);    //


        Thread.sleep(1000000);
    }
}
