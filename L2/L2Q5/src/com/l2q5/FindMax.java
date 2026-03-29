/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.l2q5;

/**
 *
 * @author ning
 */
public class FindMax {
    public static <E extends Comparable<E>> E max(E[] list){
        E max = list[0];
        
        for (E list1 : list) {
            if (list1.compareTo(max) > 0) {
                max = list1;
            }
        }
        
        return max;
    }
    
    public static void main(String[] args) {
        Integer[] intArr = {1, 2, 3};
        String[] strArr = {"red", "green", "blue"};
        
        Circle[] circleArr = {new Circle(3.0), new Circle(2.9), new Circle(5.9)};
        
        System.out.println(max(intArr));
        System.out.println(max(strArr));
        System.out.println(max(circleArr));
        
    }
}

class Circle implements Comparable<Circle>{
    private double radius;
    
    Circle(double r) {
        radius = r;
    }
    
    @Override
    public int compareTo(Circle otherCircle) {
        return Double.compare(this.radius, otherCircle.radius);
    }
    
    @Override
    public String toString() {
        return "" + this.radius;
    }
}
