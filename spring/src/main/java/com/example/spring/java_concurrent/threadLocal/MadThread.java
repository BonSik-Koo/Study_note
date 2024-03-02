package com.example.spring.java_concurrent.threadLocal;

public class MadThread extends Thread {
    private final String name;

    @Override
    public void run() {
        System.out.printf("%s start!, ThreadLocal name = %s\n", name, ThreadLocalContext.THREAD_LOCAL.get());
        ThreadLocalContext.THREAD_LOCAL.set(name);
        System.out.printf("%s end!, ThreadLocal name = %s\n", name, ThreadLocalContext.THREAD_LOCAL.get());
        ThreadLocalContext.THREAD_LOCAL.remove();
    }

    public MadThread(String name) {
        this.name = name;
    }

}
