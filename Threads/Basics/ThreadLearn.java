package Basics;
// | Feature                  | Runnable                      | Callable                 |
// | ------------------------ | ----------------------------- | ------------------------ |
// | Method                   | `run()`                       | `call()`                 |
// | Returns value            | ❌ No (void)                   | ✅ Yes (generic type `V`) |
// | Throws checked exception | ❌ No                          | ✅ Yes                    |
// | Used with                | `Thread` or `ExecutorService` | `ExecutorService`        |
// | Result tracking          | ❌ Not possible                | ✅ Through `Future.get()` |



public class ThreadLearn {
    

    public static void main(String[] args) {


        Thread t1 = new Thread(() -> {
            for(int i = 0; i<5; i++){
                     System.out.println("Thread A" + "    " + i);
                     
            }
        });

        Thread t2 = new Thread(() -> {
            for(int i = 0; i < 5 ; i++){
                           System.out.println("Thread B" + "    " + i);
            }
        });

        t1.start();
        try {
            t1.join();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        t2.start();
    
    }
}


