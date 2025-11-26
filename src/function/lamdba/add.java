package function.lamdba;


import java.io.IOException;
import java.util.Date;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

/**
 * @author TwoHour
 * @version 1.0
 * @描述: todo
 * @since 2025-11-17 19:14
 **/
public class add {
    static lamdbaAdd myAdd = (a, b) -> (a + b) * a + b;
    static lamdbaAdd myAdd2 = (a, b) -> (a - b);

    public static void main(String[] args) throws IOException {
        System.out.println(new Date());
    }

    private void testFilter(BiConsumer<Stu, String> setName) {

    }



    interface lamdbaAdd {
        int add(int a, int b);
    }

    interface filter {
        boolean f(Stu s);
    }
}