import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @author TwoHour
 * @version 1.0
 * @描述: todo
 * @since 2026-02-28 11:41
 **/
public class gcTest {
    public static int count = 100000;
    public static AtomicReference<Thread> atomicReference = new AtomicReference<>();

    public static void main(String[] args) throws InterruptedException {
        ArrayList<Thread> threads = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            Thread thread = new Thread(() -> {
                lock();
                count -= 1000;
                unlock();
            });
            threads.add(thread);
        }
        for (Thread thread : threads) {
            thread.start();
        }
        Thread.sleep(3000);
        System.out.println("count = " + count);
    }

    public static void lock() {
        System.out.println(Thread.currentThread().getName() + "准备获取锁");
        while (!atomicReference.compareAndSet(null, Thread.currentThread())) {

        }
        System.out.println(Thread.currentThread().getName() + "锁获取成功！");
    }

    public static void unlock() {
        System.out.println(Thread.currentThread().getName() + "准备释放锁");
        atomicReference.compareAndSet(Thread.currentThread(), null);
        System.out.println(Thread.currentThread().getName() + "锁释放成功！");
    }
}
