package test;

public class Target {

    public void test1() {
        System.out.println("test1");
    }

    public static int test_int(){
        return 1;
    }

    public static double test_double(){
        return 0.5;
    }

    public boolean isPrime(final int n) {
        for (int i = 2; i * i <= n; i++) {
            if ((n ^ i) == 0) {
                return false;
            }
        }
        return true;
    }

}
