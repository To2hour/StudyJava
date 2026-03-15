package test2;


import java.lang.ref.Cleaner;
import java.util.concurrent.*;

/**
 * @author TwoHour
 * @version 1.0
 * @描述: todo
 * @since 2025-10-23 16:32
 **/
public class test3 {
    private static final Cleaner cleaner = Cleaner.create();

    public static int aaaaa(int b) {
        if (b == 1) {
            return 1;
        }
        return aaaaa(b - 1) + 1;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        CompletableFuture<Void> completableFuture = CompletableFuture.runAsync(() -> {
            System.out.println(Thread.currentThread().getName());
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },executorService);

        System.out.println(completableFuture.get()); //null


        CompletableFuture<String> objectCompletableFuture = CompletableFuture.supplyAsync(()->{
            System.out.println(Thread.currentThread().getName());
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "hello supplyAsync";
        },executorService);

        System.out.println(objectCompletableFuture.get());//hello supplyAsync

        executorService.shutdown();

    }

}
