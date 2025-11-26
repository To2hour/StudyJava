import java.util.Calendar;
import java.util.Scanner;

/**
 * @author TwoHour
 * @version 1.0
 * @描述: todo
 * @since 2025-10-20 20:48
 **/
public abstract class A {
    public A(){
        String b = new Scanner(System.in).nextLine();
        int a = get(b);
        System.out.println("A");
        Calendar.getInstance();
    }
    public abstract int get(String a);
}
