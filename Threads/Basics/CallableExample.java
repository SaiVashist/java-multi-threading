package Basics;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableExample {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        Callable<Integer> task = () -> {
            System.out.println("Callable THread is running");
            return 21;
        };
         ExecutorService executorService = Executors.newSingleThreadExecutor();
         Future<Integer> future = executorService.submit(task);
         Integer result = future.get();
         System.out.println(result);
         
    
    }
    
}
