package brige;


/**
 * @author TwoHour
 * @version 1.0
 * @描述: todo
 * @since 2025-10-26 12:59
 **/
public class phoneA implements phone {
    @Override
    public void call() {
        System.out.println("Phone A is calling");
    }

    @Override
    public void close() {
        System.out.println("Phone A is closing");
    }

    @Override
    public void open() {
        System.out.println("Phone A is opening");
    }

    @Override
    public void newOpen() {
        System.out.println("Phone A is new opening");
    }
}
