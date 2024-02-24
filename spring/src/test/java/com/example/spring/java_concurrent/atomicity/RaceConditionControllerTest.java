package com.example.spring.java_concurrent.atomicity;

import static org.assertj.core.api.Assertions.assertThat;

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
    void raceCondition() throws InterruptedException {
        final int numberOfThreads = 100;
        final ExecutorService executorService = Executors.newFixedThreadPool(numberOfThreads);
        final CountDownLatch countDownLatch = new CountDownLatch(numberOfThreads);

        for(int i=0; i<numberOfThreads; i++) {
            executorService.execute(() -> {
                try {
                    controller.increaseCount();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                countDownLatch.countDown();
            });
        }
        countDownLatch.await();
    }

}