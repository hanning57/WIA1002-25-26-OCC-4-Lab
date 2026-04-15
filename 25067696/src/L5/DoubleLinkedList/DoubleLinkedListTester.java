package L5.DoubleLinkedList;

public class DoubleLinkedListTester {
    public static void main(String[] args) {
        DoubleLinkedList<Integer> dll = new DoubleLinkedList<>();
        
        dll.addFirst(1);  
        dll.addLast(100);
        dll.add(2,2);
        dll.add(3, 10);

        dll.remove(3);

        System.out.println();
        dll.iterateForward();
        dll.iterateBackward();

        System.out.println();
        System.out.printf("\nSize of current Doubly Linked List: %d%n", dll.getSize());

        dll.clear();

        System.out.println();
        System.out.printf("\nSize of current Doubly Linked List: %d%n", dll.getSize());
    }
}
