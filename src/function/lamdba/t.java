package function.lamdba;


/**
 * @author TwoHour
 * @version 1.0
 * @描述: todo
 * @since 2025-11-18 16:12
 **/
public class t {
    public static void main(String[] args) {
        int x = 10;
        Thread.startVirtualThread(new Runnable() {
            @Override
            public void run() {
                System.out.println("aa");
            }
        });

        Cfunc c = a -> a + x;
        test aNew = Stu::new;

    }

}

@FunctionalInterface
interface Cfunc {
    int sort(int a);
}

@FunctionalInterface
interface test {
    Stu sort();
}

class Stu {
    static void highOrder(Cfunc lambda) {
        int sort = lambda.sort(100);
        System.out.println(sort);
    }
}
