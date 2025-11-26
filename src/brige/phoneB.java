package brige;


/**
 * @author TwoHour
 * @version 1.0
 * @描述: todo
 * @since 2025-10-26 13:32
 **/
public class phoneB implements phone {
    @Override
    public void call() {
        System.out.println("Phone B is calling");
    }

    @Override
    public void close() {
        System.out.println("Phone B is closing");
    }

    @Override
    public void open() {
        System.out.println("Phone B is opening");
    }

    @Override
    public void newOpen() {
        System.out.println("Phone B is new opening");
    }
}