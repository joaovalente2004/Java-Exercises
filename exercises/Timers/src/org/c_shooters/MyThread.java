package org.c_shooters;

public class MyThread implements Runnable{



    @Override
    public void run() {
        System.out.println("Hello from " + Thread.currentThread().getName());
    }
}
