package brige;

/**
 * @author TwoHour
 * @version 1.0
 * @描述: todo
 * @since 2025-10-26 12:52
 **/
public abstract class style {
    protected phone p;

    public style(phone p) {
        this.p = p;
    }

    abstract String getStyleName();

    public void call() {
        System.out.println(getStyleName());
        p.call();
    }

    public void close() {
        System.out.println(getStyleName());
        p.close();
    }

    public void open() {
        System.out.println(getStyleName());
        p.open();
    }
}
