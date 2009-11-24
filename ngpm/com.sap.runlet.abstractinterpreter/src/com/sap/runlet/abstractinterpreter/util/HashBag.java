package com.sap.runlet.abstractinterpreter.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Implementation of the {@link Bag} interface.
 */
public class HashBag<T> implements Bag<T>, Cloneable {

    /** The backing map of objects to their count. */
    private final HashMap<T, Integer> elementCountMap;

    /**
     * Creates a Bag with no entries.
     */
    public HashBag() {
	elementCountMap = new HashMap<T, Integer>();
    }

    /**
     * Creates a Bag with all the entries from the collection c.
     * 
     * @param c
     *                The collection to populate the bag with.
     */
    public HashBag(Collection<T> c) {
	this();
	addAll(c);
    }
    
    private HashBag(HashMap<T, Integer> elementCountMap) {
	this.elementCountMap = elementCountMap;
    }

    @SuppressWarnings("unchecked")
    public HashBag<T> clone() {
	HashBag<T> result = new HashBag<T>((HashMap<T, Integer>) elementCountMap.clone());
	return result;
    }

    /**
     * Returns the number of times o appears in the bag.
     * 
     * @param o
     *                The entry to count.
     * @return The number of times o appears in the bag, or 0 if it is not there.
     */
    public int count(T o) {
	Integer value = this.elementCountMap.get(o);
	return value != null ? value.intValue() : 0;
    }

    /**
     * Adds an object to the bag.
     * 
     * @param o
     *                The object to add.
     * @return Always <code>true</code> to indicate that that bag has changed.
     */
    public boolean add(T o) {
	Integer value;
	if (this.elementCountMap.containsKey(o)) {
	    value = this.elementCountMap.get(o);
	    value = Integer.valueOf(value.intValue() + 1);
	} else {
	    value = Integer.valueOf(1);
	}
	this.elementCountMap.put(o, value);
	return true;
    }

    /**
     * Adds a collection of objects to the bag.
     * 
     * @param c
     *                The collection containing the objects to add.
     * @return <code>true</code> when the bag is changed. This is only false if c is empty.
     */
    public boolean addAll(Collection<? extends T> c) {
	Iterator<? extends T> i = c.iterator();
	while (i.hasNext()) {
	    add(i.next());
	}
	return !c.isEmpty();
    }

    /**
     * Clears all entries from the bag.
     */
    public void clear() {

	this.elementCountMap.clear();
    }

    /**
     * Checks if an object is in the bag.
     * 
     * @return <code>true</code> if there are one or more instances of o in this bag.
     */
    public boolean contains(Object o) {
	return this.elementCountMap.containsKey(o);
    }

    /**
     * Returns the hash code value for this bag.
     * 
     * @return A relatively unique value representing the entries.
     */
    @Override
    public int hashCode() {
	return this.elementCountMap.hashCode();
    }

    /**
     * The size of the collection.
     * 
     * @return The total number of entries in the bag, counting duplicates.
     */
    public int size() {
	Iterator<Integer> i = this.elementCountMap.values().iterator();
	int total = 0;
	while (i.hasNext()) {
	    total += i.next().intValue();
	}
	return total;
    }

    /**
     * Checks if the bag has any entries.
     * 
     * @return <code>true</code> if there are no entries in the bag.
     */
    public boolean isEmpty() {
	return this.elementCountMap.isEmpty();
    }

    /**
     * Tests if the bag is equal to another {@link Bag}. The other Bag need not be of this class,
     * but it must meet the same semantics.
     * 
     * @return <code>true</code> if o is a bag with identical entries.
     */
    @SuppressWarnings("unchecked")
    @Override
    public boolean equals(Object o) {
	if (!(o instanceof Bag)) {
	    return false;
	}
	Bag<T> b = (Bag<T>) o;
	if (b.size() != size()) {
	    return false;
	}
	Iterator<T> i = b.iterator();
	while (i.hasNext()) {
	    T entry = i.next();
	    if (b.count(entry) != count(entry)) {
		return false;
	    }
	}
	return true;
    }

    /**
     * Removes a single instance of an object from the bag, if one exists.
     * 
     * @return <code>true</code> if an element was removed.
     */
    @SuppressWarnings("unchecked")
    public boolean remove(Object o) {
	Integer value = this.elementCountMap.get(o);
	if (value == null) {
	    return false;
	}
	int intValue = value.intValue() - 1;
	if (intValue == 0) {
	    this.elementCountMap.remove(o);
	} else {
	    this.elementCountMap.put((T) o, Integer.valueOf(intValue));
	}
	return true;
    }

    /**
     * Tests if this bag contains all the elements in another collection. The number of elements in
     * this bag and the collection is not considered.
     * 
     * @return <code>true</code> if every element of <em>a</em> is found in this bag.
     */
    public boolean containsAll(Collection<?> a) {
	for (Object key : a) {
	    if (!this.elementCountMap.containsKey(key)) {
		return false;
	    }
	}
	return true;
    }

    /**
     * Removes all elements from <em>a</em> from this bag. At the end of this operation the bag
     * will not contain any elements that are in <em>a</em>.
     * 
     * @return <code>true</code> if this bag was modified.
     */
    public boolean removeAll(Collection<?> a) {
	boolean changed = false;
	for (Object key : a) {
	    if (this.elementCountMap.remove(key) != null) {
		changed = true;
	    }
	}
	return changed;
    }

    /**
     * Removes all entries which are not found in <em>a</em>. Duplicates in this bag which only
     * appear once in <em>a</em> will be left alone.
     * 
     * @return <code>true</code> if this bag was modified.
     */
    public boolean retainAll(Collection<?> a) {
	boolean changed = false;
	Iterator<T> i = this.elementCountMap.keySet().iterator();
	while (i.hasNext()) {
	    Object key = i.next();
	    if (!a.contains(key)) {
		i.remove();
		changed = true;
	    }
	}
	return changed;
    }

    /**
     * Gets an iterator for this bag. Identical elements are returned in groups.
     * 
     * @return A new iterator.
     */
    public Iterator<T> iterator() {
	return new BagIterator<T>(this.elementCountMap.entrySet().iterator());
    }

    /**
     * Converts the entries in this bag to an array.
     * 
     * @return An array of objects with all the elements from the bag.
     */
    public Object[] toArray() {

	return toArrayList().toArray();
    }

    /**
     * Converts the entries in this bag to an array.
     * 
     * @param a
     *                The array to populate.
     * @return The populated array.
     */
    @SuppressWarnings("unchecked")
    public Object[] toArray(Object[] a) {
	return toArrayList().toArray(a);
    }

    /**
     * Helper method to convert the contents to an array.
     * 
     * @return An {@link ArrayList} containing the elements of this bag.
     */
    private ArrayList<T> toArrayList() {
	ArrayList<T> array = new ArrayList<T>(size());
	Iterator<Map.Entry<T, Integer>> i = this.elementCountMap.entrySet().iterator();
	while (i.hasNext()) {
	    Map.Entry<T, Integer> entry = i.next();
	    T key = entry.getKey();
	    int entries = entry.getValue().intValue();
	    for (int n = 0; n < entries; n++) {
		array.add(key);
	    }
	}
	return array;
    }

    /**
     * toString defined on java.lang.Object.
     */
    @Override
    public String toString() {
	return this.elementCountMap.toString();
    }

    /**
     * An {@link java.util.Iterator} implementation to return the elements of the current bag.
     */
    private static final class BagIterator<T> implements Iterator<T> {
	// an iterator for the internal map
	private Iterator<Map.Entry<T, Integer>> elementCountMapIterator;

	// The current entry in the map
	private Map.Entry<T, Integer> entry;

	// The current position within the group of identical elements,
	// starting at 1
	private int entryPosition;

	// The number of identical elements for the current entry
	private int entrySize;

	/**
	 * Default constructor. Picks up an iterator from the map in the encapsulating class.
	 */
	BagIterator(Iterator<Map.Entry<T, Integer>> elementCountMapIterator) {
	    this.elementCountMapIterator = elementCountMapIterator;
	    this.entry = null;
	    this.entrySize = 0;
	    this.entryPosition = 1;
	}

	/**
	 * Removes the current element. Should not be needed.
	 */
	public void remove() {
	    if (--this.entrySize == 0) {
		this.elementCountMapIterator.remove();
	    } else {
		this.entry.setValue(Integer.valueOf(this.entrySize));
	    }
	}

	/**
	 * Tests if there are more elements in the collection.
	 * 
	 * @return <code>true</code> if there are more elements in the collection.
	 */
	public boolean hasNext() {
	    return this.entryPosition < this.entrySize || this.elementCountMapIterator.hasNext();
	}

	/**
	 * Retrieves the next element.
	 * 
	 * @return the next element from the collection.
	 */
	public T next() {
	    if (++this.entryPosition > this.entrySize) {
		this.entry = this.elementCountMapIterator.next();
		this.entrySize = (this.entry.getValue()).intValue();
		this.entryPosition = 1;
	    }
	    return this.entry.getKey();
	}
    }
}
