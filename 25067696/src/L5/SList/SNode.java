package L5.SList;

public class SNode<E> {
    public E element;
    SNode<E> next;
    
    public SNode () {
    }

    public SNode (E e) {
        this.element = e;
    }
}
