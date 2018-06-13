package jos.learning.jvm.chapter4;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by jos on 2018/6/11.
 */
//@Slf4j
public class StackTrace {
    public final static Logger log = LoggerFactory.getLogger("");

    public static void main(String[] args) throws ClassNotFoundException {
        Thread.getAllStackTraces().forEach((thr, elem) -> {
            log.warn("thread {} begin", thr.getName());
            for (int i = 0; i < elem.length; i++) {
                log.warn("{}. {}", i + 1, elem[i].toString());
            }
        });

        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        log.info("default loader {}", loader.toString());

        loader.loadClass("Bar");
    }
}
