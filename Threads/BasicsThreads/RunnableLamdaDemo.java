package BasicsThreads;

public class RunnableLamdaDemo {
    public static void main(String[] args) {

        Runnable runnable = () -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("It is in runnable with lambda");
        };

        Thread rThread = new Thread(runnable);
        rThread.start();

    }
}
