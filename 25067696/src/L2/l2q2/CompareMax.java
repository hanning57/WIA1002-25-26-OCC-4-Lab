/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package L2.l2q2;

import java.util.Random;

/**
 *
 * @author ning
 */
public class CompareMax {
    public static <T extends Comparable<T>> T maximum (T a, T b, T c){
    T max = a; // assume x is the largest initially

        if (b.compareTo(max) > 0) {
            max = b;
        }
        if (c.compareTo(max) > 0) {
            max = c;
        }

        return max;
    }
    
    public static void main(String[] args) {
        Random r = new Random();
        int n1 = r.nextInt(10) + 1;
        int n2 = r.nextInt(10) + 1;
        int n3 = r.nextInt(10) + 1;
        
        System.out.printf("3 Random Numbers Generated = %d %d %d%n", n1, n2, n3);
        System.out.println("Maximum = " + maximum(n1,n2,n3));
    }
}
