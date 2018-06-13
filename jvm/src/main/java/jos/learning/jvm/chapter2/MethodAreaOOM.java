package jos.learning.jvm.chapter2;

import lombok.extern.slf4j.Slf4j;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Created by jos on 2018/6/9.
 */
@Slf4j
public class MethodAreaOOM {

    public static void main(String[] args) {
        while (true) {
            MethodAreaOOM oom = new MethodAreaOOM();
            OOMObject oomObject = oom.doEnhance();
            oomObject.wakeup();

            log.info("[{}]:{}", oomObject.hashCode(), "inner object");
        }
    }

    public <T> T doEnhance() {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(OOMObject.class);
        enhancer.setUseCache(false);
        enhancer.setCallback(new MethodInterceptor() {
            public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {

                if (method.getName().contains("hashCode")) {
                    return proxy.invokeSuper(obj, args);
                }

                preEnter();
                Object result = proxy.invokeSuper(obj, args);
                postEnter();
                return result;
            }

            private void preEnter() {
                log.info("[{}]:{}", this.hashCode(), "proxy.preEnter");
            }

            private void postEnter() {
                log.info("[{}]:{}", this.hashCode(), "proxy.postEnter");
            }
        });
        return (T) enhancer.create();
    }

    static class OOMObject {
        public String wakeup() {
            return "i am wakeup";
        }
    }


}