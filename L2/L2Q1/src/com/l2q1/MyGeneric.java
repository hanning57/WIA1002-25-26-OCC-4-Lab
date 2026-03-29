/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.l2q1;

/**
 *
 * @author ning
 */
public class MyGeneric<T> {
    private T e;
    
    MyGeneric(){}
    
    MyGeneric(T element){}

    public T getE() {
        return e;
    }

    public void setE(T e) {
        this.e = e;
    }
    
    
    public static void main(String[] args) {
        MyGeneric<String> strObj = new MyGeneric<>();
        MyGeneric<Integer> intObj = new MyGeneric<>();
        
        strObj.setE("Java");
        intObj.setE(100);
        
        System.out.println(strObj.getE());
        System.out.println(intObj.getE());
        
    }
}
