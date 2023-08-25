package org.academiadecodigo.bootcamp.concurrency;

import org.academiadecodigo.bootcamp.concurrency.bqueue.BQueue;
import org.academiadecodigo.bootcamp.concurrency.bqueue.Pizza;

/**
 * Consumer of integers from a blocking queue
 */
public class Consumer implements Runnable {

    private final BQueue<Pizza> queue;
    private int elementNum;

    /**
     * @param queue the blocking queue to consume elements from
     * @param elementNum the number of elements to consume
     */
    public Consumer(BQueue queue, int elementNum) {
        this.queue = queue;
        this.elementNum = elementNum;
    }

    @Override
    public void run() {

        for (int i = 0; i < elementNum; i++) {

            try {
                queue.poll();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            if (queue.getSize() == queue.getLimit()){
                System.out.println("Telepizza is empty");
            }

        }
        System.out.println(Thread.currentThread().getName() + " consumed " + elementNum + " pizzas");

    }

}
