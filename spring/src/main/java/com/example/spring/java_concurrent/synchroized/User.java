package com.example.spring.java_concurrent.synchroized;

public class User extends Thread{
    @Override
    public void run() {
        System.out.println("구본식 계좌~~");
    }
}
