package Java21and22;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.StructuredTaskScope;

public class StructuredConcurDemo {
    record User(String name){}
    record Orders(int Id){}
    static User fetchUser() throws InterruptedException {
        Thread.sleep(200);
        return new User("Raju");
    }
    static Orders fetchOrders() throws InterruptedException {
        Thread.sleep(300);
        return new Orders(2);
    }
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        var scope = new StructuredTaskScope.ShutdownOnFailure();
        var userFuture = scope.fork(StructuredConcurDemo::fetchUser);
        var orderFuture = scope.fork(StructuredConcurDemo::fetchOrders);
        scope.join();
        scope.throwIfFailed();
        var users = userFuture.get();
        var orders = orderFuture.get();
        System.out.println(users);


    }
}
