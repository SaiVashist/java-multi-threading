package CyclicBarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierDemo {
    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(3);
        new Thread(new worker(1,cyclicBarrier)).start();
        new Thread(new worker(2,cyclicBarrier)).start();
        new Thread(new worker(3,cyclicBarrier)).start();
    }
}


class worker implements Runnable{

    private final int id;
    private final CyclicBarrier cyclicBarrier;

    worker(int id, CyclicBarrier cyclicBarrier) {
        this.id = id;
        this.cyclicBarrier = cyclicBarrier;
    }

    @Override
    public void run() {
        System.out.println("Thread with id  " + id + " Started");
        try {
            Thread.sleep(2000);
            System.out.println("Waiting for barrier the id is  " + id);
            cyclicBarrier.await();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (BrokenBarrierException e) {
            throw new RuntimeException(e);
        }

    }
}