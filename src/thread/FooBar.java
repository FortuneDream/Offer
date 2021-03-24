package thread;

import java.util.concurrent.Semaphore;

//两个不同的线程将会共用一个 FooBar 实例。其中一个线程将会调用 foo() 方法，另一个线程将会调用 bar() 方法。
//信号量解决，acquire代表请求该信号量-1，如果>1则可执行，否则会block,release代表+1
//互相取消和设置对方的屏蔽障
public class FooBar {
    private int n;
    private Semaphore semaphore1 = new Semaphore(1);
    private Semaphore semaphore2 = new Semaphore(0);

    public FooBar(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            semaphore1.acquire();
            // printFoo.run() outputs "foo". Do not change or remove this line.
            printFoo.run();
            semaphore2.release();
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            semaphore2.acquire();
            // printBar.run() outputs "bar". Do not change or remove this line.
            printBar.run();
            semaphore1.release();
        }
    }
}
