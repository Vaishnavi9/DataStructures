package com.multithreading;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(){
            @Override
            public void run() {
                System.out.println("We are in new thread "+Thread.currentThread().getName());
                System.out.println("Current thread priority is "+Thread.currentThread().getPriority());
                /*throw new RuntimeException("Intentional error..");*/
            }
        };

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("We are in thread 2 "+Thread.currentThread().getName());
                System.out.println("Current thread priority is "+Thread.currentThread().getPriority());
            }
        });
        /*thread.setName("Misbehave thread");
        thread.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
            @Override
            public void uncaughtException(Thread t, Throwable e) {
                System.out.println("A critical error in thread "+t.getName()+" error: "+e.getMessage());
            }
        });
        thread.start();*/
        thread.setName("Thread - 1");
        thread.setPriority(Thread.MAX_PRIORITY);
        thread1.setName("Thread - 2");
        thread1.setPriority(Thread.MIN_PRIORITY);
        thread.start();
        thread1.start();
    }
}
