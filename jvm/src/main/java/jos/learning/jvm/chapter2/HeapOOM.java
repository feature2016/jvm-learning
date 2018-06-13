package jos.learning.jvm.chapter2;

/**
 * Created by jos on 2018/5/15.
 * throw java.lang.OutOfMemoryError: Java heap space
 */

import java.util.ArrayList;
import java.util.List;

public class HeapOOM {

    static class OOMObject {
    }

    public static void main(String[] args) throws InterruptedException {
        List<OOMObject> list = new ArrayList<OOMObject>();

        while (true) {
            list.add(new OOMObject());
        }
    }
}
