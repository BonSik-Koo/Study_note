package com.example.spring.java_concurrent.visibility;

public class NoVisibility {
    public static boolean runningFlag = false;
    public static class thread extends Thread {
        @Override
        public void run() {
            while (!runningFlag) {}
            System.out.println("탈출 성공");
        }
    }
    public static void main(String[] args) throws InterruptedException {
        thread thread1 = new thread();
        thread1.start();
        Thread.sleep(3000);
        runningFlag = true;
        thread1.join();
    }
}
