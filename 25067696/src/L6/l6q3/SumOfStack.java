package L6.l6q3;

import java.util.ArrayList;
import java.util.EmptyStackException;

public class SumOfStack {

    public int Sum(MyStack<Integer> S) {
        int total = 0;

        MyStack<Integer> tempStack = new MyStack<>();

        while(!S.isEmpty()) {
            int temp =  S.pop();
            total += temp;
            tempStack.push(temp);
        }

        while(!tempStack.isEmpty()) {
            int temp = tempStack.pop();
            S.push(temp);
        }

        return total;
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
