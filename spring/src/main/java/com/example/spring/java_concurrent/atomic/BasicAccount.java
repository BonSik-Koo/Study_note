package com.example.spring.java_concurrent.atomic;

public class BasicAccount {
    private long balance;

    public void deposit(long amount) {
        balance += amount;
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public BasicAccount(long balance) {
        this.balance = balance;
    }

    public long getBalance() {
        return balance;
    }

}
