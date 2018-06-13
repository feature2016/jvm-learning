package jos.learning.jvm.chapter9;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by jos on 2018/6/12.
 */
public class DynamicProxy {
    interface IHello {
        void sayHello(String what);
    }

    static class Hello implements IHello {
        @Override
        public void sayHello(String what) {
            System.out.println(what);
        }
    }

    static class MyProxy implements InvocationHandler {
        private IHello obj;

        Object bind(IHello obj) {
            this.obj = obj;
            return Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(), this);
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            System.out.println("proxying");
            return method.invoke(obj, args);
        }
    }

    public static void main(String[] args) {
        IHello origin = new Hello();
        IHello proxy = (IHello) new MyProxy().bind(origin);

        proxy.sayHello("i do not know proxy");
        origin.sayHello("i am origin");
    }
}
