package jos.learning.jvm.chapter2;

import lombok.extern.slf4j.Slf4j;
import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * Created by jos on 2018/6/9.
 * java.lang.SecurityException: Unsafe
 */
@Slf4j
public class DirectMemoryOOM {

    private static final int _1MB = 1024 * 1024;
    private static int total = 0;


    public static void main1(String[] args) throws Exception {
        Field field = Unsafe.class.getDeclaredField("theUnsafe");
        field.setAccessible(true);
        Unsafe unsafe = (Unsafe) field.get(null);
        while (true) {
            unsafe.allocateMemory(_1MB);

            total += _1MB;
            log.info("alloc total memory about {}B", total);
        }
    }

    public static void main(String[] args) throws Exception {
        Field field = Unsafe.class.getDeclaredField("theUnsafe");
        field.setAccessible(true);
        Unsafe unsafe = (Unsafe) field.get(null);
        unsafe.allocateMemory(50L * 1024L * 1024 * 1024);

        Thread.sleep(5000);
    }
}
