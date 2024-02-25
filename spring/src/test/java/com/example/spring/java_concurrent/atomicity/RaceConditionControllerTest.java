package com.example.spring.java_concurrent.atomicity;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class RaceConditionControllerTest {
    @Autowired
    private RaceConditionController controller;

    @Test
    void raceCondition1() throws InterruptedException {
        final int numberOfThreads = 40;
        final ExecutorService executorService = Executors.newFixedThreadPool(numberOfThreads);
        final CountDownLatch countDownLatch = new CountDownLatch(numberOfThreads);

        for(int i=0; i<numberOfThreads; i++) {
            executorService.execute(() -> {
                controller.increaseCount1();
                countDownLatch.countDown();
            });
        }
        countDownLatch.await();

        System.out.println(RaceConditionController.amount);
    }

    @Test
    void raceCondition2() throws InterruptedException {
        final int numberOfThreads = 40;
        final ExecutorService executorService = Executors.newFixedThreadPool(numberOfThreads);
        final CountDownLatch countDownLatch = new CountDownLatch(numberOfThreads);

        for(int i=0; i<numberOfThreads; i++) {
            executorService.execute(() -> {
                try {
                    controller.increaseCount2();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                countDownLatch.countDown();
            });
        }
        countDownLatch.await();
    }

}