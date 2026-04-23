package L4.l4q1;

import java.util.NoSuchElementException;

public class MyLinkedList<E> {
    Node<E> head;
    Node<E> tail;
    private int size;

    MyLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public int getSize() {
        return size;
    }

    public void addFirst(E e) {
        Node<E> newNode = new Node<>(e);
        newNode.next = head;    // copy head
        head = newNode;     // set new head
        size ++;

        if(tail == null) {  // If only one element exist
            tail = head;
        }
    }

    public void addLast(E e) {
        Node<E> temp = new Node<>(e);
        if(tail != null) {
            tail.next = temp;
        }
        tail = temp;

        if(head == null) {
            head = temp;
        }
        size++;
    }

    public void add(int index, E e) {
        if(index == 0) {
            addFirst(e);
        } else if(index >= size) {
            addLast(e);
        } else {
            Node<E> current = head;
            for(int i = 0; i < index - 1; i ++) {   // Stop 1 before the index  
                current = current.next;
            }
            Node<E> temp = current.next;
            current.next = new Node<E>(e);
            (current.next).next = temp;
            size ++;
        }        
    }

    public E removeFirst() {
        if(size == 0) {
            return null;
        } else {
            Node<E> temp = head;   // Copy head to temp
            head = head.next;       // Set new head
            size --;

            if(head == null) {      // Check whether head = null
                tail = null;
            }

            return temp.element;
        }
    }

    public E removeLast() {
        if(size == 0) {
            return null;
        } else if(size == 1) {
            Node<E> temp = head;
            head = tail = null;
            size = 0;
            return temp.element;
        } else {
            Node<E> current = head;
            for(int i = 0; i < size - 2; i++) {
                current = current.next;
            }
            Node<E> temp = tail;
            tail = current;
            tail.next = null;
            size --;
            return temp.element;
            
        }
    }

    public E remove(int index) {
        if(index < 0 || index >= size) {
            return null;
        } else if(index == 0) {
            return removeFirst();
        } else if(index == size - 1) {
            return removeLast();
        } else {
            Node<E> previous = head;
            for(int i = 0; i < index - 1; i++) {    // Stop 1 before target index
                previous = previous.next;
            }
            Node<E> current = previous.next;
            previous.next = current.next;
            size --;
            return current.element;
        }
    }

    /**
     * Return true if list contains the element e
     * @param e
     * @return
     */
    public boolean contains(E e) {
        Node<E> temp = head;
        if(size == 0) {
            return false;
        }
        for(int i = 0; i < size; i++) {
            if(e != null && e.equals(temp.element)) {
                return true;
            }
            temp = temp.next;
        }
        return false;
    }

    /**
     * Return element at the specified index
     * @param index
     * @return
     */
    public E get(int index) {
        if(index < 0 || index >= size) {
            throw new NoSuchElementException();
        }
        Node<E> current = head;
        for(int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.element;
    }

    /**
     * Return the value of the first item
     * @return
     */
    public E getFirst() {
        if(size == 0) {
            throw new NullPointerException();
        }
        return head.element;
    }

    /**
     * Return the value of the last item
     * @return
     */
    public E getLast() {
        if(size == 0) {
            throw new NullPointerException();
        }
        return tail.element;
    }

    /**
     * Return the index of the head matching element in this list. Return -1 of no match.
     * @param e
     * @return
     */
    public int indexOf(E e) {
        Node<E> temp = head;
        if(size == 0) {
            return -1;
        }
        for(int i = 0; i < size; i++) {
            if(e != null && e.equals(temp.element)) {
                return i;
            }
            temp = temp.next;
        }
        return -1;
    }

    /**
     * Return the index of the last matching element in this list. Return -1 of no match.
     * @param e
     * @return
     */
    public int lastIndexOf(E e) {
        int last = -1;
        Node<E> temp = head;
        for(int i = 0; i < size; i++) {
            if(e.equals(temp.element)){
                last = i;
            }
            temp = temp.next;
        }
        return last;
    }

    /**
     * Replace the element at the specified position in this list with the specified element.
     * @param index
     * @param e
     * @return
     */
    public E set(int index, E e) {
        if(index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        Node<E> current = head;
        for(int i = 0; i < index; i++) {
            current = current.next;
        }
        E temp = current.element;
        current.element = e;

        return temp;
    }

    /**
     * Clear the list
     */
    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    /**
     * Print all the elements in the list
     */
    public void print() {
        if(size == 0) {
            System.out.println("List is empty!");
        }
        Node<E> temp = head;
        while(temp != null) {
            System.out.print(temp.element + " ");
            temp = temp.next;
        }
    }

    /**
     * Print all elements in reverse order
     */
    public void reverse() {
        reverseHelper(head);
        System.out.println();
    }

    private void reverseHelper(Node<E> current) {
        if(current == null) {
            return;
        }
        reverseHelper(current.next);

        System.out.print(current.element + " ");
    }


}
