package L6.l6q5;

import java.util.ArrayList;
import java.util.EmptyStackException;

public class TowerOfHanoi {
    public static void main(String[] args) {
        Tower tower = new Tower(3);
        tower.solve();
    }



    static class Tower {
        private MyStack<Integer>[] rod;

        @SuppressWarnings({ "unchecked", "rawtypes" })
        public Tower(int n) {
            rod = new MyStack[3];
            for(int i = 0; i < 3; i++) {
                rod[i] = new MyStack();
            }
            
            // Initialized all the plate in first rod 
            for(int i = n; i > 0; i--) {
                rod[0].push(i);
            }

            System.out.println("Final Rods: ");
            for(int i = 0; i < 3; i++) {
                System.out.println("Rod " + (i+1) + ": " + rod[i]);
            }
            
        }


        // Move disk from source rod to target rod, use temp as helper
        public void moveDisk(int n, int source, int temp, int target) {
            if(n > 0) {
                moveDisk(n-1, source, target, temp);
                int disk = rod[source].pop();
                rod[target].push(disk);
                System.out.println("Move disk " + disk + " from rod " + (source+1) + " to rod " + target + " " + (target+1));
                moveDisk(n-1, temp, source, target);
            }
        }

        public void solve() {
            moveDisk(rod[0].getSize(), 0, 1, 2);
        }

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
