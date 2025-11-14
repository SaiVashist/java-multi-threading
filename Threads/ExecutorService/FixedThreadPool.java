package ExecutorService;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FixedThreadPool {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        for(int i = 0 ; i < 7 ; i++){
            executorService.execute(new work(i));
        }

    }
}

class work implements  Runnable{

    private final int workID;

    work(int workID) {
        this.workID = workID;
    }

    @Override
    public void run() {

        System.out.println("Work Id" + workID + " BEing exectued by " + Thread.currentThread().getName());
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}

