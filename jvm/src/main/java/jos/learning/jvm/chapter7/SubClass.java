package jos.learning.jvm.chapter7;

/**
 * 被动使用类字段演示一：
 * 通过子类引用父类的静态字段，不会导致子类初始化
 */
public class SubClass extends SuperClass {

    /**
     * 发生在类加载时
     */
    static {
        System.out.println("SubClass static!");

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 发生在对象创建时
     */
    public SubClass() {
        System.out.println("SubClass init!");
    }

    public static void main(String[] args) {

        System.out.println(SubClass.value);
        System.out.println(SubClass.value2);

        System.out.println("------");

        SuperClass[] sca = new SuperClass[10];
        System.out.println("通过数组定义来引用类，不会触发此类的初始化");

        System.out.println("------");

        System.out.println(new SubClass().value);
    }

}