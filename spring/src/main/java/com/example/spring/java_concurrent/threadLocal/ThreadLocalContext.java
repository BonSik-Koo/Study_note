package com.example.spring.java_concurrent.threadLocal;

public class ThreadLocalContext {
    public final static ThreadLocal<String> THREAD_LOCAL = ThreadLocal.withInitial(() -> "default name");

}
