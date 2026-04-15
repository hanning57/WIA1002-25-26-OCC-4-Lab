package L5.DoubleLinkedList;

import java.util.NoSuchElementException;

public class DoubleLinkedList<E> {
    DNode<E> head;
    DNode<E> tail;
    private int size;

    public DoubleLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public int getSize() {
        return size;
    }

    public void addFirst(E e) {
        DNode<E> temp = new DNode<>(e, head, null);
        if(head != null) {
            head.previous = temp;
        }
        head = temp;

        if(tail == null) {
            tail = temp;
        }

        size ++;

        System.out.println("adding: " + e);
    }

    public void addLast(E e) {
        DNode<E> temp = new DNode<>(e, null, tail);
        if(tail != null) {
            tail.next = temp;
        }
        tail = temp;

        if(head == null) {
            head = temp;
        }

        size ++;

        System.out.println("adding: " + e);
    }

    public void add(int index, E e) {
        if(index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }

        if(index == 0) {
            addFirst(e);
        } else if(index == size) {
            addLast(e);
        } else {
            DNode<E> temp = head;
            for(int i = 0; i < index; i++) {
                temp = temp.next;
            }
            DNode<E> insert = new DNode<>(e, temp, temp.previous);
            temp.previous.next = insert;
            temp.previous = insert;
            size ++;
        }       
    }

    public void iterateForward() {
        System.out.println("Iterating forward...");
        DNode<E> temp = head;
        while(temp != null) {
            System.out.print(temp.element);
            System.out.print(" ");
            temp = temp.next;
        }
    }

    public void iterateBackward() {
        System.out.println("Iterating backward...");
        DNode<E> temp = tail;
        while(temp != null) {
            System.out.print(temp.element);
            System.out.print(" ");
            temp = temp.previous;
        }
    }

    public E removeFirst() {
        if(size == 0) {
            throw new NoSuchElementException();
        }
        DNode<E> temp = head;
        head = head.next;
        head.previous = null;
        size --;
        System.out.println("deleted: " + temp.element);
        return temp.element;
    }

    public E removeLast() {
        if(size == 0) {
            throw new NoSuchElementException();
        }
        DNode<E> temp = tail;
        tail = tail.previous;
        tail.next = null;
        size --;
        System.out.println("deleted: " + temp.element);
        return temp.element;
    }

    public E remove(int index) {
        E e = null;
        if(index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        if(index == 0) {
            removeFirst();
        } else if(index == size - 1) {
            removeLast();
        } else {
            DNode<E> temp = head;
            for(int i = 0; i < index; i++) {
                temp = temp.next;
            }
            e = temp.element;
            temp.next.previous = temp.previous;
            temp.previous.next = temp.next;
            temp.next = null;
            temp.previous = null;
            size --;
        }
        return e;
    }

    public void clear() {
        DNode<E> temp = head;
        int cleared = size;

        while(head != null) {
            temp = head.next;
            head.previous = head.next = null;
            head = temp;
        }
        temp = null;
        tail.previous = tail.next = null;
        size = 0;

        System.out.println("Successfully clear " + cleared + " node(s).");
    }


}
