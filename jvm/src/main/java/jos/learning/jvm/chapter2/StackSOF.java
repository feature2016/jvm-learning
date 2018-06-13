package jos.learning.jvm.chapter2;

/**
 * Created by jos on 2018/5/16.
 * java.lang.StackOverflowError
 */
public class StackSOF {

    private int stackLength = 1;

    public void stackLeak() throws InterruptedException {
        System.out.println("stack level:" + stackLength);
        stackLength++;
        stackLeak();
    }

    public static void main(String[] args) throws Throwable {
        StackSOF oom = new StackSOF();
        oom.stackLeak();

    }
}