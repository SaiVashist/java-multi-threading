package ExchangeDemo;

import java.util.concurrent.Exchanger;

public class ExchangeDemo {
    public static void main(String[] args) {
        Exchanger exchanger = new Exchanger<>();
        new Thread(new Worker1(exchanger)).start();
        new Thread(new Worker2(exchanger)).start();
    }

}

class Worker1 implements Runnable{

    private final Exchanger exchanger;

    Worker1(Exchanger exchanger) {
        this.exchanger = exchanger;
    }

    @Override
    public void run() {
        String data = "I am workr one";
        System.out.println("worker 1 preparing Data");
        try {
            Thread.sleep(2000);
            String dataReceved = exchanger.exchange(data).toString();
            System.out.println("data rfeceived from worker two   " + dataReceved);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}


class Worker2 implements Runnable{

    private final Exchanger exchanger;

    Worker2(Exchanger exchanger) {
        this.exchanger = exchanger;
    }

    @Override
    public void run() {
        String data = "I am worker two";
        System.out.println("worker 1 preparing Data");
        try {
            Thread.sleep(2000);
            String dataReceved = exchanger.exchange(data).toString();
            System.out.println("data rfeceived from worker one   " + dataReceved);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
