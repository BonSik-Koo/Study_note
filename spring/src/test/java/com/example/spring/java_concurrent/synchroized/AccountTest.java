package com.example.spring.java_concurrent.synchroized;

import org.junit.jupiter.api.Test;

class AccountTest {

    @Test
    void methodSynchroized1() throws InterruptedException {
        Account account = new Account(0);

        Thread thread1 = new Thread(() -> account.depositSyn("[thread1]", 10));
        Thread thread2 = new Thread(() -> account.print("[thread2]"));

        thread1.start();
        thread2.start();
        Thread.sleep(5000);
    }

    @Test
    void methodSynchroized2() throws InterruptedException {
        Account account = new Account(0);

        Thread thread1 = new Thread(() -> account.depositSyn("[thread1]", 1000));
        Thread thread2 = new Thread(() -> account.printSyn("[thread2]"));

        thread1.start();
        thread2.start();
        Thread.sleep(5000);
    }

}