package brige;


/**
 * @author TwoHour
 * @version 1.0
 * @描述: 桥接模式
 * @since 2025-10-26 13:00
 **/
public class client {
    public static void main(String[] args) {
        style s1 = new styleA(new phoneA());
        s1.open();
        s1.call();
        s1.close();
        System.out.println("-------------");
        style s2 = new styleB(new phoneA());
        s2.open();
        s2.call();
        s2.close();
        System.out.println("-------------");
        style s3 = new styleA(new phoneB());
        s3.open();
        s3.call();
        s3.close();
        System.out.println("-------------");
        style s4 = new styleB(new phoneB());
        s4.open();
        s4.call();
        s4.close();
    }
}
