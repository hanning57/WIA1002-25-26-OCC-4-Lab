/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package L3;

/**
 *
 * @author ning
 */
public class ArrayBagDemo {

    /**
     * @param args the command line arguments
     */
    private static void testAdd(BagInterface<String> aBag, String[] content) {
        System.out.print("Adding ");
        for(int i = 0; i < content.length; i++){
            aBag.add(content[i]);
            System.out.print(content[i] + " ");
        }
        System.out.println();
    }
    
    
    public static void displayBag(BagInterface<String> aBag) {
        System.out.print("The bag contains " + aBag.getCurrentSize() + " String(s), as follows: \n");
        Object[] arr = aBag.toArray();
        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        
        ArrayBag<String> bag1 = new ArrayBag<>();
        ArrayBag<String> bag2 = new ArrayBag<>();
        
        String[] contentsOfBag1 = {"A", "A", "B", "A", "C", "A"};
        String[] contentsOfBag2 = {"A", "B", "A", "C", "B", "C", "D", "another string"};
        
        System.out.println("bag1:");
        testAdd(bag1, contentsOfBag1);
        displayBag(bag1);
        
        System.out.println("\nbag2:");
        testAdd(bag2, contentsOfBag2);
        displayBag(bag2);
        
        
        BagInterface<String> bag3 = bag1.union(bag2);
        System.out.println("\nbag3, test the method union of bag1 and bag2: ");
        displayBag(bag3);
        
        
        BagInterface<String> bag4 = bag1.intersection(bag2);
        System.out.println("\nbag4, test the method intersection of bag1 and bag2: ");
        displayBag(bag4);
        
        
        BagInterface<String> bag5 = bag1.difference(bag2);
        System.out.println("\nbag5, test the method difference of bag1 and bag2: ");
        displayBag(bag5);
    }
    
}
