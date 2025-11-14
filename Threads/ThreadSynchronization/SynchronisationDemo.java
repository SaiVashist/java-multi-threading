package ThreadSynchronization;

public class SynchronisationDemo {
    private static int counter = 0;
    public static void main(String[] args) throws InterruptedException {
        Thread one = new Thread(() -> {
            for (int i = 0 ; i < 10000 ; i++){
                increment();
            }
        });

        Thread t = new Thread(() -> {
            for (int i = 0 ; i < 10000 ; i++){
                increment();
            }
        });


   one.start();
   t.start();
   one.join();
   t.join();

        System.out.println(counter);
    }

    private static synchronized void increment(){
        counter++;
    }
}


