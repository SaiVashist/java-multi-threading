package BasicsThreads;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableDemo {
    public static void main(String[] args) throws Exception {
        ExecutorService executorService = Executors.newCachedThreadPool();
        Future<Integer> value = executorService.submit(new MyCallable());
        System.out.println(value.get());
    }

}

class MyCallable implements Callable<Integer>{

    @Override
    public Integer call() throws Exception {
        System.out.println("Thread started in callable");
        Thread.sleep(1000);
        return 100+100;
    }
}