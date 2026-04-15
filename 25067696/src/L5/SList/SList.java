package L5.SList;

public class SList<E> {
    SNode<E> head;
    SNode<E> tail;
    private int size;

    public SList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    /** Append a new element at the end of the list.
     * 
     * @param e
     */
    public void appendEnd(E e) {
        SNode<E> temp = new SNode<>(e);
        if(tail != null) {
            tail.next = temp;
        }
        tail = temp;

        if(head == null) {
            head = temp;
        }
        size++;
    }

    /** Eliminate the first element in the list.
     * 
     * @return
     */
    public E removeInitial() {
        if(size == 0) {
            return null;
        } else {
            SNode<E> temp = head;   // Copy head to temp
            head = head.next;       // Set new head
            size --;

            if(head == null) {      // Check whether head = null
                tail = null;
            }

            return temp.element;
        }
    }

    /** Search for an element and returns true if this list contains the searched element.
     * 
     * @param e
     * @return 
     */
    public boolean contains(E e) {
        SNode<E> temp = head;
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

    /** Empty all elements in the list and return a statement that reports that the list is empty.
     * 
     */
    public void clear() {
        head = null;
        tail = null;
        size = 0;

        System.out.println("List all cleared!");
    }

    /** Display all values from the list in a successive order.
     * 
     */
    public void display() {
        if(size == 0) {
            System.out.println("List is empty!");
        }
        SNode<E> temp = head;
        while(temp != null) {
            System.out.print(temp.element + " ");
            temp = temp.next;
        }
    }

}
