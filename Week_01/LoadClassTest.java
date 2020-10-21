package jvm.week01.z4;

import sun.misc.IOUtils;

import java.io.InputStream;
import java.lang.reflect.Method;

/**
 * 第一课作业2
 * @author deepin
 */
public class LoadClassTest {
    public static void main(String[] args) throws Exception {
        InputStream inputStream = LoadClassTest.class.getResourceAsStream("Hello.xlass");
        //获取加密后的class文件字节数组
        byte[] encodeBytes = IOUtils.readAllBytes(inputStream);

        //获取加密前的class文件字节数组
        byte[] decodeBytes = new byte[encodeBytes.length];
        for (int i = 0; i < encodeBytes.length; i++) {
            decodeBytes[i] = (byte) (255 - encodeBytes[i]);
        }
        //反射调用class的hello方法
        Class<?> targetClass = new MyClassLoader(decodeBytes).findClass("Hello");
        Method method = targetClass.getDeclaredMethod("hello");
        method.invoke(targetClass.newInstance());
    }
}
