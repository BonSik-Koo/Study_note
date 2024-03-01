package com.example.spring.java_concurrent.atomic;

import java.util.concurrent.atomic.AtomicLong;

public class AtomicAccount {
    private AtomicLong balance;

    public void deposit1(long amount) {
        balance.addAndGet(amount);
    }

    public void deposit2(long amount) {
        if(!balance.compareAndSet(balance.get(), balance.get() + amount)) {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            throw new RuntimeException("중복 입금이 감지되었습니다.");
        }
    }

    public AtomicAccount(long balance) {
        this.balance = new AtomicLong(balance);
    }

    public long getBalance() {
        return balance.get();
    }

}
