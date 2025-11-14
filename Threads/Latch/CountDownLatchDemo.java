package Latch;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchDemo {

    public static void main(String[] args) {
        CountDownLatch latch = new CountDownLatch(3);
        Thread t1 = new Thread(new Worker(latch,1));
        Thread t2 = new Thread(new Worker(latch,2));
        Thread t3 = new Thread(new Worker(latch,3));
        //new Thread(new Worker(latch,1)).start();
        t1.start();
        t2.start();
        t3.start();
    }
}

class Worker implements Runnable {

    private final CountDownLatch latch;
    private final int id;

    Worker(CountDownLatch latch, int id) {
        this.latch = latch;
        this.id = id;
    }

    @Override
    public void run() {

        System.out.println("Worker started with id   " + id);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Worker completed his work with id   " + id);
        latch.countDown();

    }
}

