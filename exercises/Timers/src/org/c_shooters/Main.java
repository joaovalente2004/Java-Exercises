package org.c_shooters;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i <= 10; i++) {
            Thread thread = new Thread(new MyThread());
            thread.setName(" " + i);
            Thread.sleep(5000);
            thread.start();

        }
    }
}
