package Java21and22;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class VirtualThreadDemo {

    public static void main(String[] args) {
      ExecutorService executorService = Executors.newSingleThreadExecutor();

      for(int i = 0 ; i<5 ; i++){
          executorService.submit(() -> {

              System.out.println("Thread is running with name   " + Thread.currentThread().getName());
              try {
                  Thread.sleep(1000);
              } catch (InterruptedException e) {
                  throw new RuntimeException(e);
              }
          });
      }
    }
}


