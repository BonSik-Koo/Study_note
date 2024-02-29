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

    @Test
    void blockSynchroized1() throws InterruptedException {
        Account account = new Account(0);

        Thread thread1 = new Thread(() -> account.depositBlockSyn("[thread1]", 1000));
        Thread thread2 = new Thread(() -> account.depositBlockSyn("[thread2]", 5000));

        thread1.start();
        thread2.start();
        Thread.sleep(5000);
    }

    @Test
    void blockSynchroized2() throws InterruptedException {
        Account accoun1 = new Account(0);
        Account accoun2 = new Account(1000);

        Thread thread1 = new Thread(() -> accoun1.depositBlockSyn("[thread1]", 1000));
        Thread thread2 = new Thread(() -> accoun2.depositBlockSyn("[thread2]", 5000));

        thread1.start();
        thread2.start();
        Thread.sleep(5000);
    }

    @Test
    void blockSynchroized3() throws InterruptedException {
        Account account = new Account(0);

        Thread thread1 = new Thread(() -> account.depositBlockSyn("[thread1]", 1000));
        Thread thread2 = new Thread(() -> account.printSyn("[thread2]"));

        thread1.start();
        thread2.start();
        Thread.sleep(5000);
    }

    @Test
    void blockSynchroized4() throws InterruptedException {
        Account account = new Account(0, new User());

        Thread thread1 = new Thread(() -> account.userBlockSyn1("[thread1]"));
        Thread thread2 = new Thread(() -> account.userBlockSyn1("[thread2]"));
        Thread thread3 = new Thread(() -> account.printSyn("[thread3]"));

        thread1.start();
        thread2.start();
        thread3.start();
        Thread.sleep(5000);
    }

    @Test
    void blockSynchroized5() throws InterruptedException {
        Account account = new Account(0, new User());

        Thread thread1 = new Thread(() -> account.userBlockSyn1("[thread1]"));
        Thread thread2 = new Thread(() -> {
            account.setUser(new User());
            account.userBlockSyn1("[thread2]");
        });

        thread1.start();
        thread2.start();
        Thread.sleep(5000);
    }

    @Test
    void blockSynchroized6() throws InterruptedException {
        Account account = new Account(0, new User());

        Thread thread1 = new Thread(() -> account.userBlockSyn2("[thread1]"));
        Thread thread2 = new Thread(() -> {
            account.setUser(new User());
            account.userBlockSyn2("[thread2]");
        });

        thread1.start();
        thread2.start();
        Thread.sleep(5000);
    }

    @Test
    void staticMethodSynchroized() throws InterruptedException {
        Account account = new Account(0, new User());

        Thread thread1 = new Thread(() -> Account.staticMethodSyn("[thread1]"));
        Thread thread2 = new Thread(() -> account.printSyn("[thread2]"));

        thread1.start();
        thread2.start();
        Thread.sleep(5000);
    }

}