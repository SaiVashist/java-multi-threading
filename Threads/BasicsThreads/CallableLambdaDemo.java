package BasicsThreads;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableLambdaDemo {
    public static void main(String[] args) throws Exception {


        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Callable<Integer> calls  = () -> {
            System.out.println("Inside callable block");
            Thread.sleep(1000);
            return 20+20;
        };

        Future<Integer> value = executorService.submit(calls);
        System.out.println(value.get());

        Future<Integer> future = executorService.submit(() -> {
            System.out.println("Inside the callable block");
            Thread.sleep(1000);
            return 20+100;
        });
        System.out.println(future.get());

    }
}
