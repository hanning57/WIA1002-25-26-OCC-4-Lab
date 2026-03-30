/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.l3;

/**
 *
 * @author ning
 */
public class ArrayBag<T> implements BagInterface<T> {
    private T[] bag;
    private int DEFAULT_CAPACITY = 25;
    private int numberOfEntries = 0;
    
    
    public ArrayBag() {
        bag = (T[]) new Object[DEFAULT_CAPACITY];
    }
    
    @Override
    public int getCurrentSize() {
        return numberOfEntries;
    }
    
    @Override
    public boolean isFull() {
        return (numberOfEntries == DEFAULT_CAPACITY);
    }
    
    @Override
    public boolean isEmpty() {
        return (numberOfEntries == 0);
    }
    
    @Override
    public boolean add(T newEntry) {
        if(numberOfEntries < bag.length) {
            bag[numberOfEntries] = newEntry;
            numberOfEntries++;
            return true;
        }
        return false;
    }
    
    @Override
    public T remove() {
        T temp = null;
        if(!isEmpty()){
            temp = bag[numberOfEntries - 1];
            bag[numberOfEntries - 1] = null;
            numberOfEntries -= 1;
        }
        return temp;
    }
    
    @Override
    public boolean remove(T anEntry) {
        for(int i = 0; i < numberOfEntries; i++) {
            if(bag[i].equals(anEntry)) {
                bag[i] = bag[numberOfEntries - 1];
                bag[numberOfEntries - 1] = null;
                numberOfEntries -= 1;
                return true;
            }           
        }
        return false;
    }
    
    @Override
    public void clear() {
        for(int i = 0; i < numberOfEntries; i++) {
            bag[i] = null;
        }
        numberOfEntries = 0;
    }
    
    @Override
    public int getFrequencyOf(T anEntry) {
        int count = 0;
        for(int i = 0; i < numberOfEntries; i++) {
            if(bag[i].equals(anEntry)) {
                count++;
            }
        }
        return count;
    }
    
    @Override
    public boolean contains(T anEntry) {
        if(getFrequencyOf(anEntry) > 0){
            return true;
        }
        return false;
    }
    
    @Override
    public T[] toArray() {
        T[] arr = (T[]) new Object[numberOfEntries];
        for(int i = 0; i < numberOfEntries; i++) {
            arr[i] = bag[i];
        }
        return arr;
    }
    
    
    // Question 2
    @Override
    public BagInterface<T> union(BagInterface<T> anotherBag) {
        BagInterface<T> union = new ArrayBag<>();
        T[] baglist1 = this.toArray();
        for(int i = 0; i < baglist1.length; i++) {
            union.add(baglist1[i]);
        }
        T[] baglist2 = anotherBag.toArray();
        for(int i = 0; i < baglist2.length; i++) {
            union.add(baglist2[i]);
        }
        return union;
    }
    
    
    // Question 3
    @Override
    public BagInterface<T> intersection(BagInterface<T> anotherBag) {
        BagInterface<T> intersection = new ArrayBag<>();
        T[] baglist1 = this.toArray();
        T[] baglist2 = anotherBag.toArray();
        
        for(int i = 0 ; i < baglist1.length; i++) {
            for(int j = 0; j < baglist2.length; j++) {
                if(baglist2[j] != null && baglist2[j].equals(baglist1[i])) {
                    intersection.add(baglist1[i]);
                    baglist2[j] = null;
                    break;
                }
            }
        }
        return intersection;
    }
    
    
    // Question 4
    @Override
    public BagInterface<T> difference(BagInterface<T> anotherBag) {
        BagInterface<T> difference = new ArrayBag<>();
        T[] baglist1 = this.toArray();
        T[] baglist2 = anotherBag.toArray();
        
        for(int i = 0; i < baglist1.length; i++) {
            difference.add(baglist1[i]);
        }
        for(int i = 0; i < baglist2.length; i++) {
            difference.remove(baglist2[i]);
        }
        return difference;
    }

}
