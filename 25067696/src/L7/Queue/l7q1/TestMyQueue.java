package L7.Queue.l7q1;

public class TestMyQueue {
    public static void main(String[] args) {
        // a. Initialize queue with Durian and Blueberry
        String[] initialFruits = {"Durian", "Blueberry"};
        MyQueue<String> fruitQ = new MyQueue<>(initialFruits);

        // b. Add Apple, Orange, Grapes, Cherry
        fruitQ.enqueue("Apple");
        fruitQ.enqueue("Orange");
        fruitQ.enqueue("Grapes");
        fruitQ.enqueue("Cherry");

        // c. Display the queue
        System.out.println("c. " + fruitQ.toString());

        // d. Show the top item
        System.out.println("d. Top item: " + fruitQ.peek());

        // e. Get the queue size
        System.out.println("e. Queue size: " + fruitQ.getSize());

        // f. Delete Durian
        System.out.println("f. Deleting: " + fruitQ.dequeue());

        // g. Get item in index position of 2
        System.out.println("g. Item at index 2: " + fruitQ.getElement(2));

        // h. Check for Cherry
        System.out.println("h. Contains Cherry? " + fruitQ.contains("Cherry"));

        // i. Check for Durian
        System.out.println("i. Contains Durian? " + fruitQ.contains("Durian"));

        // j. Display the queue using the isEmpty() condition
        System.out.print("j. Final Queue items: ");
        while (!fruitQ.isEmpty()) {
            System.out.print(fruitQ.dequeue() + " ");
        }
        System.out.println();
    }
}
