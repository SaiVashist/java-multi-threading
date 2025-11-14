package Java21and22;

public class RecordsDemo {
    public static void main(String[] args) {

        Employee emp = new Employee("Raju",1);
        System.out.println(emp.name());

    }
}

record Employee(String name , int age){


    Employee {
        if(age < 20){
            throw new IllegalArgumentException("Age cannot be negative");
        }
    }
}
