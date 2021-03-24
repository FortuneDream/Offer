package code;
//静态内部类
public class Single2 {

    private Single2() {

    }

    public static Single2 getInstance() {
        return Inner.single;
    }

    private static class Inner {
        private static Single2 single = new Single2();
    }
}
