package jos.learning.jvm.chapter9;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.lang.reflect.UndeclaredThrowableException;

/**
 * Created by jos on 2018/6/12.
 */
public final class $Proxy0 extends Proxy implements DynamicProxy.IHello {
    private static Method m3;
    private static Method m1;
    private static Method m0;
    private static Method m2;

    public $Proxy0(InvocationHandler paramInvocationHandler) {
        super(paramInvocationHandler);
    }

    public final void sayHello(String what) {
        try {
            this.h.invoke(this, m3, new Object[]{what});
            return;
        } catch (RuntimeException localRuntimeException) {
            throw localRuntimeException;
        } catch (Throwable localThrowable) {
            throw new UndeclaredThrowableException(localThrowable);
        }
    }

    // 此处由于版面原因，省略equals()、hashCode()、toString()三个方法的代码
    // 这3个方法的内容与sayHello()非常相似。

    static {
        try {
            m3 = Class.forName("jos.learning.jvm.chapter9.DynamicProxy$IHello").getMethod("sayHello", new Class[]{String.class});
            m1 = Class.forName("java.lang.Object").getMethod("equals", new Class[]{Class.forName("java.lang.Object")});
            m0 = Class.forName("java.lang.Object").getMethod("hashCode", new Class[0]);
            m2 = Class.forName("java.lang.Object").getMethod("toString", new Class[0]);
        } catch (NoSuchMethodException localNoSuchMethodException) {
            throw new NoSuchMethodError(localNoSuchMethodException.getMessage());
        } catch (ClassNotFoundException localClassNotFoundException) {
            throw new NoClassDefFoundError(localClassNotFoundException.getMessage());
        }
    }

    public static void main(String[] args) {
        DynamicProxy.IHello origin = new DynamicProxy.Hello();
        $Proxy0 proxy = new $Proxy0(new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("proxying");
                return method.invoke(origin, args);
            }
        });

        proxy.sayHello("i do not know proxy");
        origin.sayHello("i am origin");
    }
}
