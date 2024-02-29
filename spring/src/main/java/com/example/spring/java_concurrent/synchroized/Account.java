package com.example.spring.java_concurrent.synchroized;

public class Account {
    private User user;
    private long balance;

    public Account(long balance) {
        this.balance = balance;
    }

    public Account(long balance, User user) {
        this.balance = balance;
        this.user = user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void print(String name) {
        System.out.println(name + " balance = " + balance);
    }

    public synchronized void printSyn(String name) {
        System.out.println(name + " print Lock");
        try {
            System.out.println(name + " balance = " + balance);
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(name + " print unLock");
    }

    public synchronized void depositSyn(String name, long amount) {
        System.out.println(name + " deposit Lock");
        try {
            balance += amount;
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(name + " deposit unLock");
    }

    public void depositBlockSyn(String name, long amount) {
        System.out.println(name + " deposit come in");

        synchronized (this) {
            System.out.println(name + " deposit Lock");
            try {
                balance += amount;
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(name + " deposit unLock");
        }
    }

    public void userBlockSyn1(String name) {
        synchronized (user) {
            System.out.println(name + " Lock");
            user.run();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(name + " unLock");
        }
    }

    public void userBlockSyn2(String name) {
        synchronized (User.class) {
            System.out.println(name + " Lock");
            user.run();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(name + " unLock");
        }
    }

    public static synchronized void staticMethodSyn(String name) {
        System.out.println(name + " Lock");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(name + " unLock");
    }

}
