package ExecutorService;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledExService {
    public static void main(String[] args) throws InterruptedException {
        ScheduledExecutorService service = Executors.newScheduledThreadPool(1);
        service.scheduleAtFixedRate(new ProbeTask() , 100,2000, TimeUnit.MILLISECONDS);
        if(!service.awaitTermination(1000,TimeUnit.MILLISECONDS)){
            service.shutdownNow();;
        }
    }


}

class ProbeTask implements  Runnable{
    @Override
    public void run() {
        System.out.println("probing end point for updates");
    }
}

