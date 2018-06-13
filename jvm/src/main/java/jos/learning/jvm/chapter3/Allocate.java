package jos.learning.jvm.chapter3;

import lombok.extern.slf4j.Slf4j;

/**
 * VM参数：-verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8
 */
@Slf4j
public class Allocate {
    private static final int _1MB = 1024 * 1024;

    public void alloc() {
        byte[] allocation1, allocation2, allocation3, allocation4, allocation5;
        allocation1 = new byte[2 * _1MB];
        allocation2 = new byte[2 * _1MB];
        allocation3 = new byte[2 * _1MB];
        allocation4 = new byte[4 * _1MB];  // 出现一次Minor GC
        allocation5 = new byte[4 * _1MB];  // 出现一次Minor GC

        log.info("do something continue");
    }

    public static void main(String[] args) {
        new Allocate().alloc();
    }

}
