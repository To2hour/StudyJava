/**
 * @author TwoHour
 * @version 1.0
 * @描述: todo
 * @since 2026-01-06 19:50
 **/
public class testClassLoader extends ClassLoader{
    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        return super.findClass(name);
    }
}
