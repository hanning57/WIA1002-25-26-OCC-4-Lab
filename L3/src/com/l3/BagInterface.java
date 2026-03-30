/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.l3;

/**
 *
 * @author ning
 */

/**
An interface that describes the operations of a bag of objects.
*/
public interface BagInterface<T> {
    /** Gets the current number of entries in this bag.
     @return the integer number of entries currently in the bag */
    public int getCurrentSize();
    
    /** Sees whether this bag is full.
     @return true if the bag is full, or false if not */
    public boolean isFull();
    
    /** Sees whether this bag is empty.
     @return true if the bag is empty, or false if not */
    public boolean isEmpty();
    
    /** Adds a new entry to this bag.
     @param newEntry the object to be added as a new entry
     @return true if the addition is successful, or false if not */
    public boolean add(T newEntry);
    
    /** Removes one unspecified entry from this bag, if possible.
     @return either the removed entry, if the removal was successful,
     or null */
    public T remove();
    
    /** Removes one occurrence of a given entry from this bag.
     @param anEntry the entry to be removed
     @return true if the removal was successful, or false if not */
    public boolean remove(T anEntry);
    
    /** Removes all entries from this bag. */
    public void clear();
    
    /** Counts the number of times a given entry appears in this bag.
     @param anEntry the entry to be counted
     @return the number of times anEntry appears in the bag */
    public int getFrequencyOf(T anEntry);
    
    /** Tests whether this bag contains a given entry.
     @param anEntry the entry to locate
     @return true if this bag contains anEntry, or false otherwise */
    public boolean contains(T anEntry);
    
    /** Retrieves all entries that are in this bag.
    @return a newly allocated array of all the entries in the bag */
    public T[] toArray();
    
    
    
    // === Question 2 ===
    /** Returns a new bag that is the union of this bag and another bag.
     * The union contains all items from both bags, including duplicates.
     * @param anotherBag The bag to be combined with this bag.
     * @return A new BagInterface containing the combined contents. */
    public BagInterface<T> union(BagInterface<T> anotherBag);
    
    
    
    // === Question 3 ===
    /** Returns a new bag that contains the intersection of this bag and another bag.
     * The intersection consists of the entries that occur in both bags.
     * @param anotherBag The bag to be compared with this bag.
     * @return A new BagInterface containing the intersecting items. */
    public BagInterface<T> intersection(BagInterface<T> anotherBag);
    
    
    
    // === Question 4 ===
    /** Returns a new bag that is the difference of this bag and another bag.
     * The difference contains the entries that would be left in this bag 
     * after removing those that also occur in the second bag.
     * @param anotherBag The bag whose entries will be removed from this bag.
     * @return A new BagInterface containing the remaining items. */
    public BagInterface<T> difference(BagInterface<T> anotherBag);
    
} // end BagInterface
