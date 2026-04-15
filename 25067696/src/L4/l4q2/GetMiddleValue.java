package L4.l4q2;

public class GetMiddleValue<E> {
    Node<E> head;
    Node<E> tail;

    public E getMiddleValue() {
    // Safety check for an empty list
    if (head == null) {
        return null; 
    }

    Node<E> slow = head;
    Node<E> fast = head;

    // The loop stops when fast reaches the end (or falls off the end)
    while (fast != null && fast.next != null) {
        slow = slow.next;             // Moves 1 step
        fast = fast.next.next;        // Moves 2 steps
    }

    // When fast is at the end, slow is at the middle!
    return slow.element;
    }
}
