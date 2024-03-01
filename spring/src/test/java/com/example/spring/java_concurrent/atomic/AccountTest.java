package com.example.spring.java_concurrent.atomic;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.junit.jupiter.api.Test;

class AccountTest {

    @Test
    void basicTest() throws InterruptedException {
        BasicAccount account = new BasicAccount(0);

        final int numberOfThreads = 100;
        final ExecutorService executorService = Executors.newFixedThreadPool(numberOfThreads);
        final CountDownLatch countDownLatch = new CountDownLatch(numberOfThreads);

        for(int i=1; i<=numberOfThreads; i++) {
            executorService.execute(() -> {
                account.deposit(1000);
                countDownLatch.countDown();
            });
        }
        countDownLatch.await();

        System.out.println("[balance] = " + account.getBalance());
    }


    @Test
    void atomicTest1() throws InterruptedException {
        AtomicAccount account = new AtomicAccount(0);

        final int numberOfThreads = 100;
        final ExecutorService executorService = Executors.newFixedThreadPool(numberOfThreads);
        final CountDownLatch countDownLatch = new CountDownLatch(numberOfThreads);

        for(int i=1; i<=numberOfThreads; i++) {
            executorService.execute(() -> {
                account.deposit1(1000);
                countDownLatch.countDown();
            });
        }
        countDownLatch.await();

        System.out.println("[balance] = " + account.getBalance());
    }


    @Test
    void atomicTest2() throws InterruptedException {
        AtomicAccount account = new AtomicAccount(0);

        final int numberOfThreads = 100;
        final ExecutorService executorService = Executors.newFixedThreadPool(numberOfThreads);
        final CountDownLatch countDownLatch = new CountDownLatch(numberOfThreads);

        for(int i=1; i<=numberOfThreads; i++) {
            executorService.execute(() -> {
                try {
                    account.deposit2(1000);
                } catch (RuntimeException ex) {
                    System.out.println(ex.getMessage());
                }

                countDownLatch.countDown();
            });
        }
        countDownLatch.await();

        System.out.println("[balance] = " + account.getBalance());
    }

}