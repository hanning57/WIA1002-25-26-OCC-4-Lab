package L7.PriorityQueue.l7q1;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class Q1 {
    public static void main(String[] args) {
        int[] arr = {4, 8, 1, 2, 9, 6, 3, 7};

        PriorityQueue<Integer> queue = new PriorityQueue<>();

        for(int i = 0; i < arr.length; i++) {
            queue.add(arr[i]);
        }

        // Display all the elements inside this priority queue.
        System.out.println("toString(): " + queue.toString());

        // Retrieve and remove the first element in this priority queue.
        System.out.println("Poll: " + queue.poll());

        System.out.println("Add 5 to the queue.");
        queue.add(5);

        // Convert the priority queue into an array and display.
        System.out.println("toArray(): " + Arrays.toString(queue.toArray()));

        // Retrieve the first element in the priority queue.
        System.out.println("Peek: " + queue.peek());

        // Check if the priority queue consists of element “1”
        System.out.println("Contains '1'? " + queue.contains(1));

        // Get the current size of the priority queue.
        System.out.println("Size: " + queue.size());

        // Display while removing the elements in the queue until it is empty
        System.out.println("Is the queue empty? " + queue.isEmpty());

        System.out.print("Removing ... ");
        while(!queue.isEmpty()) {
            System.out.print(queue.poll() + " ");
        }
        System.out.println();

        System.out.println("Is the queue empty? " + queue.isEmpty());

        // Sort the priority queue in reversing order.
        PriorityQueue<Integer> newQ = new PriorityQueue<>(Collections.reverseOrder());

        for(int i = 0; i < arr.length; i++) {
            newQ.add(arr[i]);
        }

        System.out.print("Reversing Order: ");
        while(!newQ.isEmpty()) {
            System.out.print(newQ.poll() + " ");
        }
        System.out.println();
    }

}
