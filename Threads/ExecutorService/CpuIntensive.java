package ExecutorService;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CpuIntensive {
    public static void main(String[] args) {
        int cores = Runtime.getRuntime().availableProcessors();
        ExecutorService service = Executors.newFixedThreadPool(cores);
        for (int i = 0 ; i < 20 ; i++){
            service.execute(new CPUTask());
        }
    }

}


class CPUTask implements Runnable{

    @Override
    public void run() {
        System.out.println("Task  " + Thread.currentThread().getName());
    }
}