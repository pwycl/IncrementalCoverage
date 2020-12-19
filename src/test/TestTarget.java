package test;

/**
 * The test target we want to see code coverage for.
 */
public class TestTarget implements Runnable {

    public void run() {
//        Target.test1();
        new Target().test1();
        int a = Target.test_int();
        double b = Target.test_double();

        new Target().isPrime(Global.intValue);
    }

}
