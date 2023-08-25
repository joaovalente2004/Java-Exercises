package org.academiadecodigo.containers;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.PriorityQueue;

public class TodoList {


    public enum Importance {
        HIGH,
        MEDIUM,
        LOW
    }

    private PriorityQueue<TodoItem> list = new PriorityQueue<>();


    private Importance importance;

    private int priority;

    private String todo;





    public void add(Importance importance, int priority, String todo) {

        list.add(new TodoItem(importance, priority, todo));

    }

    private class TodoItem  implements Comparable{

        private Importance importance;

        private int priority;

        private String todo;

        public TodoItem(Importance importance, int priority, String todo) {
            this.importance = importance;
            this.priority = priority;
            this.todo = todo;
        }

        public Importance getImportance() {
            return importance;
        }

        public int getPriority() {
            return priority;
        }




        @Override
        public String toString() {
            return "TodoItem{" +
                    "importance=" + importance +
                    ", priority=" + priority +
                    ", item='" + todo + '\'' +
                    '}';
        }





        @Override
        public int compareTo(Object o) {
            //compare all the items

            TodoItem todoItem = (TodoItem) o;

            if (this.importance.compareTo(todoItem.getImportance()) == 0) {
                return this.priority - todoItem.getPriority();
            }

            return this.importance.compareTo(todoItem.getImportance());

        }
    }



    public String remove() {

        //use method compareTo to compare the importance of the items

        return list.remove().toString();


    }

    public boolean isEmpty() {
        return list.isEmpty();

    }



}
