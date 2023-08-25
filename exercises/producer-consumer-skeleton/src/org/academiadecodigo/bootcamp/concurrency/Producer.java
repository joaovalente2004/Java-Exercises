package org.academiadecodigo.bootcamp.concurrency;

import org.academiadecodigo.bootcamp.concurrency.bqueue.BQueue;
import org.academiadecodigo.bootcamp.concurrency.bqueue.Pizza;

/**
 * Produces and stores integers into a blocking queue
 */
public class Producer implements Runnable {

    private final BQueue<Pizza> queue;
    private int elementNum;

    /**
     * @param queue the blocking queue to add elements to
     * @param elementNum the number of elements to produce
     */
    public Producer(BQueue queue, int elementNum) {
        this.queue = queue;
        this.elementNum = elementNum;
    }

    @Override
    public void run() {

            for (int i = 0; i < elementNum; i++) {

                try {
                    queue.offer(new Pizza());

                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                if (queue.getSize() == 0){
                    System.out.println("Telepizza is full");
                }
            }
        System.out.println(Thread.currentThread().getName() + " produced " + elementNum + " pizzas                       ");


    }

}
