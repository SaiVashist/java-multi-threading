package BlockingQ;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.BlockingQueue;

public class BlockingQDEmo {

    public static void main(String[] args) {
        BlockingQueue<Integer> q = new ArrayBlockingQueue<>(3);

        new Thread(new Producer(q)).start();
        new Thread(new Consumer(q)).start();
    }

}


class Producer implements Runnable {
    private BlockingQueue<Integer> queue;

    Producer(BlockingQueue<Integer> queue) {
        this.queue = queue;
    }

    public void run() {
        int value = 1;
        try {
            while (true) {
                System.out.println("Producing " + value);
                queue.put(value);
                value++;
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {}
    }
}


class Consumer implements Runnable {
    private BlockingQueue<Integer> queue;

    Consumer(BlockingQueue<Integer> queue) {
        this.queue = queue;
    }

    public void run() {
        try {
            while (true) {
                int value = queue.take();
                System.out.println("Consumed " + value);
                Thread.sleep(1500);
            }
        } catch (InterruptedException e) {}
    }
}



