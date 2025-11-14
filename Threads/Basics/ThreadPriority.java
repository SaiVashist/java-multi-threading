package Basics;

public class ThreadPriority {
    public static void main(String[] args) {
        System.out.println(   Thread.currentThread().getName());
        System.out.println(String.valueOf(Thread.currentThread().getPriority()));
    }
}
