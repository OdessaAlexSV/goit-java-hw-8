package main.java.homeWork;

import java.util.LinkedList;
import java.util.Queue;

public class MainMyQueue {
    public static void main(String[] args) {
        int[] arr = new int[]{0, 15};

        Queue<String> queue = new LinkedList<>();
        queue.add("First");
        queue.add("Second");
        queue.add("Third");
        queue.add("Forth");
        queue.add("Fifth");
        System.out.println("Queue:");
        System.out.println(queue);
        System.out.println("Size = " + queue.size());

        for (int index : arr) {
            try {
                ((LinkedList<String>) queue).remove(index);
                System.out.println("Element[" + index +"] is removed");
            } catch (Exception e) {
                System.out.println("Element[" + index + "] does not exist");
            }
        }

        System.out.println(queue);
        System.out.println("Size = " + queue.size());
        System.out.println("Queue's peek is " + queue.peek());
        queue.poll();
        System.out.println("Queue after poll is " + queue);
        System.out.println("Size = " + queue.size());
        queue.clear();
        System.out.println(queue);
        System.out.println("Size = " + queue.size());

        System.out.println("-".repeat(15));

        MyQueue<String> myQueue = new MyQueue<>();
        myQueue.add("First");
        myQueue.add("Second");
        myQueue.add("Third");
        myQueue.add("Forth");
        myQueue.add("Fifth");
        System.out.println("MyQueue:");
        System.out.println(myQueue);
        System.out.println("Size = " + myQueue.size());

        for (int index : arr) {
            myQueue.remove(index);
        }

        System.out.println(myQueue);
        System.out.println("Size = " + myQueue.size());
        System.out.println("Queue's peek is " + myQueue.peek());
        myQueue.poll();
        System.out.println("Queue after poll is " + myQueue);
        System.out.println("Size = " + myQueue.size());
        myQueue.clear();
        System.out.println(myQueue);
        System.out.println("Size = " + myQueue.size());
        System.out.println("-".repeat(15));
    }
}
