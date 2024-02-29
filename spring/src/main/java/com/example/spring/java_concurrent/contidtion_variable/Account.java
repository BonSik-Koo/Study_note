package com.example.spring.java_concurrent.contidtion_variable;

public class Account {
    private long balance;

    public synchronized void withdraw(String name, long amount) {
        System.out.println(name + " withdraw Lock");
        while (balance < amount) {
            try {
                System.out.println(name + " withdraw unLock and sleep");
                wait();
                System.out.println(name + " withdraw Lock and wake up");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        balance -= amount;

        System.out.println(name + " withdraw unLock");
    }

    public synchronized void deposit(String name, long amount) {
        System.out.println(name + " deposit Lock");
        balance += amount;
        notifyAll(); // or notify()
        System.out.println(name + " deposit unLock");
    }

    public Account(long balance) {
        this.balance = balance;
    }

    public long getBalance() {
        return balance;
    }

}
