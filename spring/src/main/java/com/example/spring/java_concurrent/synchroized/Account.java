package com.example.spring.java_concurrent.synchroized;

public class Account {
    private long balance;

    public Account(long balance) {
        this.balance = balance;
    }

    public void print(String name) {
        System.out.println(name + " balance = " + balance);
    }

    public synchronized void printSyn(String name) {
        System.out.println(name + " balance = " + balance);
    }

    public synchronized void depositSyn(String name, long amount) {
        System.out.println(name + " Lock");
        try {
            balance += amount;
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(name + " unLock");
    }

}
