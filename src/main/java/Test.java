
interface Abc {}

public class Test implements Abc {

    {
        System.out.println("from init");
    }

    public Test() {
        System.out.println("from constructor");
    }

    public static void main(String... args) {
        Test test = new Test();
        System.out.println(test.test(new Test()));
    }

    public boolean test(Abc abc) {
        return abc instanceof Test;
    }

}
