package thread;
//现在有两种线程，氧 oxygen 和氢 hydrogen，你的目标是组织这两种线程来产生水分子。
//        存在一个屏障（barrier）使得每个线程必须等候直到一个完整水分子能够被产生出来。
// 解决方案：先出H，block住O，计数减到0，调起O。
//O在重置计数2，释放两个H。
import java.util.concurrent.Semaphore;

public class H2O {
    private Semaphore H = new Semaphore(2);
    private Semaphore O = new Semaphore(0); //开始就是block住
    volatile int num = 2;

    public H2O() {

    }

    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
        // releaseHydrogen.run() outputs "H". Do not change or remove this line.
        H.acquire();
        releaseHydrogen.run();
        num--;
        if (num == 0) {
            O.release();
        }

    }

    public void oxygen(Runnable releaseOxygen) throws InterruptedException {
        // releaseOxygen.run() outputs "O". Do not change or remove this line.
        O.acquire();
        releaseOxygen.run();
        num = 2;
        H.release(2);
    }
}
