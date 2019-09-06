package com.jmx.algorithm.concurrent.easy;

/**
 * 按序打印。
 * public class Foo {
 *   public void one() { print("one"); }
 *   public void two() { print("two"); }
 *   public void three() { print("three"); }
 * }
 * 三个不同的线程将会共用一个 Foo 实例。
 *
 * 线程 A 将会调用 one() 方法
 * 线程 B 将会调用 two() 方法
 * 线程 C 将会调用 three() 方法
 * 请设计修改程序，以确保 two() 方法在 one() 方法之后被执行，three() 方法在 two() 方法之后被执行。
 *
 */

import java.util.concurrent.CountDownLatch;

/**
 * 解题思路： 方法执行顺序，one--->two--->three。即线程A先执行。线程B后执行，线程C最后执行。每次只能执行一个线程
 * 可以通过synchronize锁控制变量。也可以使用countdownLatch控制
 * 该方法通过countdownLatch控制
 */
public class PrintInOrder {
    //利用两个countDownLatch分别控制B和C线程
    private CountDownLatch countDownLatch1;
    private CountDownLatch countDownLatch2;

    public PrintInOrder() {
        countDownLatch1 = new CountDownLatch(1);
        countDownLatch2 = new CountDownLatch(1);
    }

    public void first(Runnable printFirst) throws InterruptedException {
        //A线程不需要控制，可以直接执行
        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        //执行完毕后使B线程执行
        countDownLatch1.countDown();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        //只有countDownLatch01为0才能通过，否则会一直阻塞
        countDownLatch1.await();
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        //执行完毕后使C线程执行
        countDownLatch2.countDown();
    }

    public void third(Runnable printThird) throws InterruptedException {
        //只有countDownLatch02为0才能通过，否则会一直阻塞
        countDownLatch2.await();
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
    }
}
