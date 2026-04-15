package L5.DoubleLinkedList;

public class DNode<E> {
    E element;
    DNode<E> next;
    DNode<E> previous;

    public DNode() {}

    public DNode(E e) {
        this.element = e;
    }

    public DNode(E e, DNode<E> next, DNode<E> previous) {
        this.element = e;
        this.next = next;
        this.previous = previous;
    }
}
