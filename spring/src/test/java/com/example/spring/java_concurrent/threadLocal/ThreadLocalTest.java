package com.example.spring.java_concurrent.threadLocal;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.junit.jupiter.api.Test;

class ThreadLocalTest {

    @Test
    void threadLocal1() throws InterruptedException {
        MadThread thread1 = new MadThread("thread-1");
        MadThread thread2 = new MadThread("thread-2");
        MadThread thread3 = new MadThread("thread-3");

        thread1.start();
        thread2.start();
        thread3.start();

        thread1.join();
        thread2.join();
        thread3.join();
    }

    @Test
    void threadLocal2() throws InterruptedException {
        final int numberOfThreads = 5;
        final ExecutorService executorService = Executors.newFixedThreadPool(3); // 스레드 풀 개수 3개로 고정
        final CountDownLatch countDownLatch = new CountDownLatch(numberOfThreads);

        for(int i=1; i<=numberOfThreads; i++) {
            final String name = "thread-" + i;
            MadThread thread = new MadThread(name);
            executorService.execute(thread);
            countDownLatch.countDown();
        }
        countDownLatch.await();
    }

}