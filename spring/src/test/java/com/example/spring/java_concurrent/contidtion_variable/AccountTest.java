package com.example.spring.java_concurrent.contidtion_variable;

import org.junit.jupiter.api.Test;

class AccountTest {

    @Test
    void conditionVariable() throws InterruptedException {
        Account account = new Account(0);

        Thread thread1 = new Thread(() -> account.withdraw("[thread1]", 60000));
        Thread thread2 = new Thread(() -> account.deposit("[thread2]", 50000));
        Thread thread3 = new Thread(() -> account.deposit("[thread3]", 60000));

        thread1.start();
        thread2.start();
        Thread.sleep(3000);
        thread3.start();

        thread1.join();
        thread2.join();
        thread3.join();

        System.out.println("[balance] = " + account.getBalance());
    }

}