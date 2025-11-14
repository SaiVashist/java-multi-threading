package BasicsThreads;

public class BasicsDemo {

    public static void main(String[] args) {
        MyThread newThread = new MyThread();
        newThread.run();
       RunnableThread runnableThread = new RunnableThread();
     Thread rThread = new Thread(runnableThread);
     rThread.start();

    }
}

class MyThread extends Thread {

    @Override

    public void run(){
        System.out.println("Thread is started running");
    }

}

class RunnableThread implements Runnable{

    @Override
    public void run() {

        System.out.println("Thread is running from runnable");

    }
}
