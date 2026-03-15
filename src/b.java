/**
 * @author TwoHour
 * @version 1.0
 * @描述: todo
 * @since 2025-10-20 20:49
 **/
public class b extends A {


    public b() {
        System.out.println("b");
    }

    public final void test(int a) {
        test();
    }

    public static double test(double i) {
        if (i % 100 == 0) {
            System.out.println(i);
        }
        return test(i + 1);
    }

    public static void main(String[] args) {
        Runtime runtime = Runtime.getRuntime();
        long totalMemory = runtime.totalMemory() / 1024 / 1024;
        long maxMemory = runtime.maxMemory() / 1024 / 1024;
        var cache1 = totalMemory * 64.0 / 1024;
        var cache2 = maxMemory * 4.0 / 1024;
        System.out.println("totalMemory = " + totalMemory + "M");
        System.out.println("totalMemory = " + maxMemory + "M");
        System.out.println("cache1 = " + cache1);
        System.out.println("cache = " + cache2);

    }
}


