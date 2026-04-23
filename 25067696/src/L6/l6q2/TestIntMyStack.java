package L6.l6q2;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.Scanner;

public class TestIntMyStack {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        MyStack<Integer> intStack = new MyStack<>();

        System.out.print("Enter an integer: ");
        int input = sc.nextInt();

        for (int i = 1; i <= input; i++) {
            intStack.push(i);
        }

        System.out.println("Current size of the stack: " + intStack.getSize());

        System.out.print("Stack contents (popped): ");
        while (!intStack.isEmpty()) {
            System.out.print(intStack.pop() + " ");
        }
        System.out.println();

        sc.close();


        System.out.println("\n\n--- Question ---");
        System.out.println("What is the output of the elements? What is the order, why?");

        System.out.println("\nThe order is descending. Because a Stack is a Last-In, First-Out(LIFO) data structure.");

    }
}




class MyStack<E> {
    private ArrayList<E> list = new ArrayList<>();

    MyStack() {

    }

    /**
     * Put a new item on top of stack
     * @param o
     */
    public void push(E o) {
        list.add(o);
    }

    /**
     * Look for top item and remove it
     * @return E o represent item that has been deleted
     */
    public E pop() {
        if(list.isEmpty()) {
            throw new EmptyStackException();
        }
        E o = list.get(getSize() - 1);
        list.remove(getSize() - 1);
        return o;
    }
    
    /**
     * Look for top item
     * @return E o reprensent item that is on top of stack
     */
    public E peek() {
        if(list.isEmpty()) {
            throw new EmptyStackException();
        }
        return list.get(getSize() - 1);
    }

    /**
     * Get size of the array list
     * @return Integer for size of the array list
     */
    public int getSize() {
        return list.size();
    }

    /**
     * Check whether the array list is empty
     * @return boolean whether the array list is empty or not
     */
    public boolean isEmpty() {
        return list.isEmpty();
    }

    /**
     * To String
     */
    public String toString() {
        return "Stack: " + list.toString();
    }

    /**
     * Check whether the array list contains specific item
     * @param o
     * @return boolean whether contains it or not
     */
    public boolean search(E o) {
        for(int i = 0; i < getSize(); i++) {
            if(list.contains(o)) {
                return true;
            }
        }
        return false;
    }

}
