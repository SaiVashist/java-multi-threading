package Java21and22;

public class SealedClassDEmo {
    static void main() {
        var user = new User();
        user.getData();
    }
}

sealed interface SealedDe permits User {

    public void getData();

}

final class User implements SealedDe{

    @Override
    public void getData() {
        System.out.println("Sealed has permit");
    }
}
