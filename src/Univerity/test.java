package Univerity;


/**
 * @author TwoHour
 * @version 1.0
 * @描述: todo
 * @since 2026-01-06 14:35
 **/
public class test {
    public static void main(String[] args) {
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        System.out.println("systemClassLoader = " + systemClassLoader);
        ClassLoader StringClassLoader = String.class.getClassLoader();
        System.out.println("StringClassLoader = " + StringClassLoader);
        ClassLoader testClassLoader = test.class.getClassLoader();
        System.out.println("testClassLoader = " + testClassLoader);
        ClassLoader classLoader = System.class.getClassLoader();
        System.out.println("classLoader = " + classLoader);
    }
}
