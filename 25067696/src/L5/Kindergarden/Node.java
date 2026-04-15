package L5.Kindergarden;

public class Node<E> {
    public E element;
    Node<E> next;
    
    public Node () {
    }

    public Node (E e) {
        this.element = e;
    }
}
