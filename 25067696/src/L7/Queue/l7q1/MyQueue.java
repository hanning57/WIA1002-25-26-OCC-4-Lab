package L7.Queue.l7q1;

import java.util.LinkedList;
import java.util.Arrays;

public class MyQueue<E> {
    private LinkedList<E> list = new LinkedList<>();

    public MyQueue(E[] e) {
        list.addAll(Arrays.asList(e));
    }

    public MyQueue() {
    }

    public void enqueue(E e) {
        list.addLast(e);
    }

    public E dequeue() {
        return list.removeFirst();
    }

    public E getElement(int i) {
        return list.get(i);
    }

    public E peek() {
        return list.getFirst();
    }

    public int getSize() {
        return list.size();
    }

    public boolean contains(E e) {
        return list.contains(e);
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public String toString() {
        return "Queue: " + list.toString();
    }
}
