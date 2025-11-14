package Java21and22;

public class PatternMatchingDemo {

    static String format(Object obj){
        return switch (obj){
            case null          -> "null value";
            case Integer i     -> "int: " + i;
            case String s      -> "string(" + s.toUpperCase() + ")";

            default            -> "unknown: " + obj;
        };
    }

    static void main() {
        System.out.println(format(22));
    }
}
