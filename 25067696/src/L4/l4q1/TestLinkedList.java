package L4.l4q1;

public class TestLinkedList {
    public static void main(String[] args) {
        MyLinkedList<Character> ll = new MyLinkedList<>();

        ll.addFirst('a');
        ll.addLast('e');
        ll.add(1, 'b');
        ll.add(2, 'c');
        ll.add(3, 'd');

        System.out.println("=== Current List ===");
        ll.print();

        System.out.println("\n=== After Reversed ===");
        ll.reverse();

        System.out.printf("Number of elements in the current list: %d%n", ll.getSize());

        System.out.println("\nFirst Value: " + ll.getFirst());
        System.out.println("Last Value: " + ll.getLast());

        System.out.println("\n=== Delete 3rd value ===");
        ll.remove(2);

        System.out.println("\nSecond Value index location: " + ll.indexOf('b'));
        System.out.println("Third Value index location: " + ll.indexOf('d'));

        System.out.println("\n=== Contains c? ===");
        System.out.println("Ans: " + ll.contains('c'));

        System.out.println("\n=== Replace with j,a,v,a ===");
        ll.set(0, 'j');
        ll.set(1, 'a');
        ll.set(2, 'v');
        ll.set(3, 'a');

        System.out.println("=== Newest Current List ===");
        ll.print();
    }
}
