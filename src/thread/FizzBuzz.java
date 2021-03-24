package thread;

import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

//编写一个可以从 1 到 n 输出代表这个数字的字符串的程序，但是：
//
//        如果这个数字可以被 3 整除，输出 "fizz"。
//        如果这个数字可以被 5 整除，输出 "buzz"。
//        如果这个数字可以同时被 3 和 5 整除，输出 "fizzbuzz"。
//        例如，当 n = 15，输出： 1, 2, fizz, 4, buzz, fizz, 7, 8, fizz, buzz, 11, fizz, 13, 14, fizzbuzz
//
//        来源：力扣（LeetCode）
//        链接：https://leetcode-cn.com/problems/fizz-buzz-multithreaded
//        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
public class FizzBuzz {
    //每个函数都是独立的循环
    private int n;
    private Semaphore both = new Semaphore(1);
    private Semaphore three = new Semaphore(0);
    private Semaphore five = new Semaphore(0);
    private Semaphore not = new Semaphore(0);
    private int i = 1;

    public FizzBuzz(int n) {
        this.n = n;
    }

    // printFizz.run() outputs "fizz".
    public void fizz(Runnable printFizz) throws InterruptedException {
        while (i <= n) {
            three.acquire();
            if ((i % 3 == 0) && !(i % 5 == 0)) {
                printFizz.run();
                i++;
                both.release();
            } else {
                five.release();
            }
        }
    }

    // printBuzz.run() outputs "buzz".
    public void buzz(Runnable printBuzz) throws InterruptedException {
        while (i <= n) {
            five.acquire();
            if ((i % 5 == 0) && !(i % 3 == 0)) {
                printBuzz.run();
                i++;
                both.release();
            }else {
                not.release();
            }
        }
    }

    // printFizzBuzz.run() outputs "fizzbuzz".
    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        while (i <= n) {
            both.acquire();
            if (i % 3 == 0 && i % 5 == 0) {
                printFizzBuzz.run();
                i++;
                both.release();
            } else {
                three.release();
            }
        }
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void number(IntConsumer printNumber) throws InterruptedException {
        while (i <= n) {
            not.acquire();
            if (!(i % 3 == 0) && !(i % 5 == 0)) {
                printNumber.accept(i);
                i++;
            }
            both.release();
        }
    }
}
