package org.academiadecodigo.bootcamp.concurrency.bqueue;

import java.util.LinkedList;

/**
 * Blocking Queue
 * @param <T> the type of elements stored by this queue
 */
public class BQueue<T> {

    LinkedList<T> queue;

    /**
     * Constructs a new queue with a maximum size
     * @param limit the queue size
     */

    private int limit;
    public BQueue(int limit) {

        this.limit = limit;

        queue = new LinkedList<>();





        if (limit <= 0) {
            throw new IllegalArgumentException();
        }

        System.out.println("BQueue created with limit " + getLimit());


    }

    /**
     * Inserts the specified element into the queue
     * Blocking operation if the queue is full
     * @param data the data to add to the queue
     */
    public void offer(T data) throws InterruptedException{

        synchronized (queue) {
            while (getSize() == limit) {
                queue.wait();
            }

            queue.offer(data);
            queue.notifyAll();
            System.out.println(Thread.currentThread().getName() + " produced " + data + " in telepizza");
            System.out.println("Queue size is " + queue.size());
            System.out.println("");
            Thread.sleep(1000);
        }


    }

    /**
     * Retrieves and removes data from the head of the queue
     * Blocking operation if the queue is empty
     * @return the data from the head of the queue
     */

    public T poll() throws InterruptedException{

        synchronized (queue) {
            while (getSize() == 0) {
                queue.wait();
            }

            T data = queue.poll();
            queue.notifyAll();
            System.out.println(Thread.currentThread().getName() + " consumed " + data + " from telepizza");
            System.out.println("Queue size is " + queue.size());
            System.out.println("");
            Thread.sleep(1000);
            return data;
        }



    }

    /**
     * Gets the number of elements in the queue
     * @return the number of elements
     */
    public int getSize() {

        return queue.size();


    }

    /**
     * Gets the maximum number of elements that can be present in the queue
     * @return the maximum number of elements
     */
    public int getLimit() {

        return limit;

    }

}
