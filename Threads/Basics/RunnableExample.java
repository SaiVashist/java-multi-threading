package Basics;

public class RunnableExample {
    public static void main(String[] args) {
        Runnable task = () -> {

             System.out.println("Running with Runnable: " + Thread.currentThread().getName());

        };

        Thread thread = new Thread(task);
        thread.start();;
    }
    
}
