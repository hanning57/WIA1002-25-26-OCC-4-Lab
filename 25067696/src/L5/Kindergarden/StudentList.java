package L5.Kindergarden;

public class StudentList<E> {
    public Node<E> head;
    public Node<E> tail;
    private int size;

    public StudentList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    /**
     * 
     * @param e
     */
    public void add(E e) {
        Node<E> newNode = new Node<>(e);
        if(head == null) {
            head = newNode;
            tail = head;
        } else {
            tail.next = newNode;
            tail = newNode;
        }  
        size ++;
    }

    /**
     * 
     * @param e
     */
    public void removeElement(E e) {
        if(size == 0) {
            System.out.println("List is empty!");
        } else if(e.equals(head.element)) {
            // Node<E> temp = head;   // Copy head to temp
            head = head.next;       // Set new head
            size --;

            if(head == null) {      // Check whether head = null
                tail = null;
            }
        } else {
            Node<E> temp = head;
            while(temp.next != null) {
                if(temp.next.element.equals(e)) {
                    if(temp.next == tail) {
                        tail = temp;
                    }
                    temp.next = temp.next.next;
                    size --;
                    return;
                }
                temp = temp.next;
            } 
        }
    }

    public void printList() {
        if(size == 0) {
            System.out.println("List is empty!");
        }
        Node<E> temp = head;
        while(temp != null) {
            String punctuation = (temp.next == null) ? "." : ", ";  // Ternary Operator
            System.out.print(temp.element + punctuation);
            temp = temp.next;
        }
    }

    public int getSize() {
        return size;
    }

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

    public void replace(E e, E newE) {
        Node<E> temp = head;
        for(int i = 0; i < size; i++) {
            if(e != null && e.equals(temp.element)) {
                temp.element = newE;
                break;
            }
            temp = temp.next;
        }
    }
}
