package test;

public class Target1 {

    public void test1() {
        System.out.println("test5");
    }

    public static Object replaceTest(){
        return Global.value;
    }

    public static int Test(){
        int intValue = 1;
        return intValue;
    }

//    public static int replaceTest2(){
//        return (int) Global.value;
//    }
//
//
//
//    public static Object test(){
//        int a = replaceTest2();
//        return a;
//    }
}
