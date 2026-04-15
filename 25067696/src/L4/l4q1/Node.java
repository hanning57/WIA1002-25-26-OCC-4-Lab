package L4.l4q1;

public class Node<E> {
    public E element;
    Node<E> next;
    
    public Node () {
    }

    public Node (E e) {
        this.element = e;
    }
}
