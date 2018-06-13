package jos.learning.jvm.chapter7;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by jos on 2018/6/12.
 */
public class MyClassLoader {

        public static void main(String[] args) throws Exception {

            ClassLoader myLoader = new ClassLoader() {
                @Override
                public Class<?> loadClass(String name) throws ClassNotFoundException {
                    try {
                        String fileName = name.substring(name.lastIndexOf(".") + 1) + ".class";
                        InputStream is = getClass().getResourceAsStream(fileName);
                        if (is == null) {
                            return super.loadClass(name);
                        }
                        byte[] b = new byte[is.available()];
                        is.read(b);
                        return defineClass(name, b, 0, b.length);
                    } catch (IOException e) {
                        throw new ClassNotFoundException(name);
                    }
                }
            };

            Class<?> myClass = myLoader.loadClass("jos.learning.jvm.chapter7.MyClassLoader");
            Object obj1 = myClass.newInstance();

            System.out.println(obj1.getClass());
            System.out.println(obj1 instanceof MyClassLoader);

            MyClassLoader obj2 = new MyClassLoader();
            System.out.println(obj2 instanceof MyClassLoader);

        }

}
