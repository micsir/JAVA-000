/**
 * 第一课作业2
 * @author deepin
 */
public class MyClassLoader extends ClassLoader{
    private final byte[] bytes;

    public MyClassLoader(byte[] bytes) {
        this.bytes = bytes;
    }

    @Override
    protected Class<?> findClass(String var1)  {
            return defineClass(var1,bytes,0,bytes.length);
     }
}
