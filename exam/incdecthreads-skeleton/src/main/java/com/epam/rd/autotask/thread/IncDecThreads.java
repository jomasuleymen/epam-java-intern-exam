package com.epam.rd.autotask.thread;

public class IncDecThreads {
    static final int COUNT = 5000;
    static long value;

    /**
     * In a loop increments {@code COUNT} times the {@code value}
     * and prints to the console the name of the class, the name of
     * the thread and the value of the field {@code value}.
     */
    static class Increment extends Thread {
        @Override
        public void run() {
            IncDecThreads.value += 1;
            System.out.println("Increment : Thread-0 : " + IncDecThreads.value);
        }
    }

    /**
     * In a loop decrements {@code COUNT} times the {@code value}
     * and prints to the console the name of the class, the name of
     * the thread and the value of the field {@code value}.
     */
    static class Decrement implements Runnable {
        @Override
        public void run() {
            IncDecThreads.value -= 1;
            System.out.println("Decrement : Thread-1 : " + IncDecThreads.value);
        }
    }

    public static void main(String[] args) {

        for (int i = 0; i < COUNT; i++) {
            Thread incThread = new Increment();
            Thread decThread = new Thread(new Decrement());

            incThread.start();
            decThread.start();
        }
    }
}
