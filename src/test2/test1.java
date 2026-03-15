package test2;


import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.FutureTask;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author TwoHour
 * @version 1.0
 * @描述: todo
 * @since 2025-10-23 16:32
 **/
public class test1 {
    test1 t;
    int aaa;
    int bbb;

    public  test1 init() {
        test1 test1 = new test1();
        t = test1;
        return test1;
    }


    public test1 bbb(int b) {
        t.bbb = b;
        return t;
    }
    public static int count = 0;

    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();
        Condition condition = lock.newCondition();
        CompletableFuture<Void> voidCompletableFuture = CompletableFuture.runAsync(() -> {
            lock.lock();
            try {
                condition.await();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            for (int i = 0; i < 1000000; i++) {
                ++count;
            }
            lock.unlock();
        });

        CompletableFuture<Void> voidCompletableFuture1 = CompletableFuture.runAsync(() -> {
            lock.lock();
            for (int i = 0; i < 1000000; i++) {
                --count;
            }
            condition.signal();
//            lock.unlock();
        });
        CompletableFuture.allOf(voidCompletableFuture1,voidCompletableFuture).join();
        System.out.println("count = " + count);
    }
}
