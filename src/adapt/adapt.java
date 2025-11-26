package adapt;


import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * @author TwoHour
 * @version 1.0
 * @描述: todo
 * @since 2025-10-23 17:00
 **/
public class adapt implements target{

    private final source s;

    public adapt(source s) {

        this.s = s;
    }

    @Override
    public void pay(int amount) {
        s.pay();
        System.out.println(amount);
    }
}
