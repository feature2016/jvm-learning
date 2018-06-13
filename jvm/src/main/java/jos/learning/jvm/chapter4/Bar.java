package jos.learning.jvm.chapter4;

import lombok.extern.slf4j.Slf4j;

/**
 * Created by jos on 2018/6/11.
 */
@Slf4j
public class Bar {
    int a = 1;
    static int b = 2;
    String name = "old";

    public Bar() {
        name = "new";
    }

    public int sum(int c) {
        return a + b + c;
    }

    public boolean equalName(String nameEx) {
        return this.name == nameEx;
    }

    public static void main(String[] args) {
        Bar bar = new Bar();
        int sum = bar.sum(3);
        log.info("name {} = {}", bar.name, sum);
        // 堆上分配
        log.info("{}", bar.equalName("new"));
        // 重造
        log.info("{}", bar.equalName(new StringBuilder("new").toString()));
    }
}
