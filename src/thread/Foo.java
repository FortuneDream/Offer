package thread;//三个不同的线程 A、B、C 将会共用一个 thread.Foo 实例。
//
//        一个将会调用 first() 方法
//        一个将会调用 second() 方法
//        还有一个将会调用 third() 方法
//        请设计修改程序，以确保 second() 方法在 first() 方法之后被执行，third() 方法在 second() 方法之后被执行。

import java.util.concurrent.CountDownLatch;

public class Foo {
    private CountDownLatch countDownLatch12 = new CountDownLatch(1);
    private CountDownLatch countDownLatch23 = new CountDownLatch(1);

    public Foo() {

    }

    public void first(Runnable printFirst) throws InterruptedException {
        printFirst.run();
        countDownLatch12.countDown();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        countDownLatch12.await();
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        countDownLatch23.countDown();
    }

    public void third(Runnable printThird) throws InterruptedException {
        countDownLatch23.await();
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
    }
}
