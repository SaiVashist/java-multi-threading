package Java21and22;

import java.util.concurrent.CountDownLatch;

public class TextBlocks {
    static void main() {
//        String json = """
//                {
//                                    "name": "Sai",
//                                    "role": "Backend Developer",
//                                    "skills": ["Java", "Spring", "SQL"]
//                                }
//
//                """;
//
//        System.out.println(json);

        CountDownLatch latch = new CountDownLatch(3);
        new Thread(new Worker(latch,1)).start();
        new Thread(new Worker(latch,2)).start();
        new Thread(new Worker(latch,3)).start();
  }



}

class Worker implements Runnable{
    private final CountDownLatch countDownLatch;
    private final int id;

    Worker(CountDownLatch countDownLatch, int id) {
        this.countDownLatch = countDownLatch;
        this.id = id;
    }

    @Override
    public void run() {

        System.out.println("Thread started and waiting for count down  " + Thread.currentThread().getName());
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Thread is running");

    }
}
