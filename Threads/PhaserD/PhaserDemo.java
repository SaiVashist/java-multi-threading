package PhaserD;

import java.util.concurrent.Phaser;

public class PhaserDemo {
    public static void main(String[] args) {

        Phaser phaser = new Phaser(4);
        Runnable task = () -> {
            System.out.println(Thread.currentThread().getName() + "---- phase 0 work");
            phaser.arriveAndAwaitAdvance();
            System.out.println(Thread.currentThread().getName() + "---- phase 1 work");
            phaser.arriveAndAwaitAdvance();
            System.out.println(Thread.currentThread().getName() + "---- phase 2 work");
            phaser.arriveAndAwaitAdvance();
        };

        new Thread(task,"T1").start();
        new Thread(task,"T2").start();
        new Thread(task,"T3").start();
        new Thread(task,"T4").start();
    }


}
