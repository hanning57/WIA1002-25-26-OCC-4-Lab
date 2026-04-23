package L6.l6q4;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.Scanner;

public class Panlinfrome {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String input = sc.nextLine();

        if (input.length() > 15) {
            System.out.println("Error: String exceeds 15 characters.");
            return;
        }

        MyStack<Character> stack = new MyStack<>();

        for(int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            stack.push(c);
        }

        boolean isPalindrome = true;

        for(int i = 0; i < input.length(); i++) {
            char current = stack.pop();
            char c = input.charAt(i);
            if(current != c) {
                isPalindrome = false;
                break;
            }
        }


        if(isPalindrome) {
            System.out.println("'" + input + "' is a palindrome!");
        } else {
            System.out.println("'" + input + "' is NOT a palindrome.");
        }

        sc.close();
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
