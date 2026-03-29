/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.l2q4;

/**
 *
 * @author ning
 */
public class Min_Max {
    public static <T extends Comparable<T>> String minmax(T[] arr) {
        if (arr == null || arr.length == 0){
            return "Array is empty.";
        }
        
        T min = arr[0];
        T max = arr[0];
        
        for(int i = 1; i < arr.length; i++){
            if(arr[i].compareTo(min) < 0){
                min = arr[i];
            }
            if (arr[i].compareTo(max) > 0){
                max = arr[i];
            }
        }
        
        return ("Min = " + min + "  Max = " + max);
    }
    
    public static void main(String[] args) {
        Integer[] intArray = {5,3,7,1,4,9,8,2};
        String[] strArray = {"red", "blue", "orange", "tan"};
        
        System.out.println(minmax(intArray));
        System.out.println(minmax(strArray));
    }
}
