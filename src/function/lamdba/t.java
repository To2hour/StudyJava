package function.lamdba;


/**
 * @author TwoHour
 * @version 1.0
 * @描述: todo
 * @since 2025-11-18 16:12
 **/
public class t {
    public static void main(String[] args) {
        Cfunc c;
        c = (a, b) -> {
            if (a == 100) {
                return a;
            }
            return b.sort(a + 1, b);
        };
        int sort = c.sort(10, c);
        System.out.println(sort);
    }
}

@FunctionalInterface
interface Cfunc {
    int sort(int a, Cfunc c);
}
