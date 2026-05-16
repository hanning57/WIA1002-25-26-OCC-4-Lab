package L7.PriorityQueue.l7q2;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Sets {
    public static void main(String[] args) {
        PriorityQueue<String> pq1 = new PriorityQueue<>();
        PriorityQueue<String> pq2 = new PriorityQueue<>();

        pq1.addAll(Arrays.asList("George", "Jim", "John", "Blake", "Kevin", "Michael"));
        pq2.addAll(Arrays.asList("George", "Katie", "Kevin", "Michelle", "Ryan"));


        PriorityQueue<String> unionQueue = new PriorityQueue<>(pq1);
        unionQueue.addAll(pq2);

        PriorityQueue<String> differnceQueue = new PriorityQueue<>(pq1);
        differnceQueue.removeAll(pq2);

        PriorityQueue<String> intersectionQueue = new PriorityQueue<>(pq1);
        intersectionQueue.retainAll(pq2);

        System.out.println("Union: " + unionQueue);
        System.out.println("Difference: " + differnceQueue);
        System.out.println("Intersection: " + intersectionQueue);
    }
}
