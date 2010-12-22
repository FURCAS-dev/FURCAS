/*******************************************************************************
 * Copyright (c) 2009 SAP AG and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     SAP AG - initial API and implementation
 *******************************************************************************/
package org.eclipse.emf.query.index.internal.maps;

import java.util.Iterator;

import org.eclipse.emf.query.index.Messages;

/**
 * @author Martin Strenge - Initial API and implementation
 * @author Bernd Kolb - Initial API and implementation
 * 
 */
public abstract class AbstractMapBase<K, E> implements Iterable<E>, SerializableMap<K, E> {

	private final class KeyIterator implements Iterator<K> {
		private int tablePos = -1;
		private Object prepared = null;

		public boolean hasNext() {
			if (prepared == null) {
				while (++tablePos < table.length) {
					if (table[tablePos] != null) {
						prepared = getKey(table[tablePos]);
						return true;
					}
				}
				return false;
			}
			return true;
		}

		public K next() {
			hasNext();
			Object ret = prepared;
			prepared = null;
			return (K) ret;
		}

		public void remove() {
			throw new UnsupportedOperationException();
		}
	}

	/**
	 * The default initial capacity - MUST be a power of two.
	 */
	static final int DEFAULT_INITIAL_CAPACITY = 16;

	/**
	 * The maximum capacity, used if a higher value is implicitly specified by
	 * either of the constructors with arguments. MUST be a power of two <=
	 * 1<<30.
	 */
	static final int MAXIMUM_CAPACITY = 1 << 30;

	/**
	 * The load factor used when none specified in constructor.
	 */
	static final float DEFAULT_GROW_LOAD_FACTOR = 0.5f;

	/**
	 * The load factor where the table gets shrunken
	 */
	static final float DEFAULT_SHRINK_LOAD_FACTOR = 0.1f;

	/**
	 * The table, resized as necessary. Length MUST Always be a power of two.
	 */
	protected Object[] table;

	/**
	 * The number of elements contained in this identity hash map.
	 */
	private int size;

	/**
	 * The next size values at which to resize (capacity * load factor).
	 * 
	 * @serial
	 */
	protected int growThreshold;

	protected int shrinkThreshold;

	/**
	 * The load factor for the hash table.
	 * 
	 * @serial
	 */
	protected float growLoadFactor;

	protected float shrinkLoadFactor;

	protected void initialize(Object[] table, int size) {

		this.table = table;
		this.size = size;
		this.growLoadFactor = DEFAULT_GROW_LOAD_FACTOR;
		this.shrinkLoadFactor = DEFAULT_SHRINK_LOAD_FACTOR;
		this.growThreshold = (int) (table.length * this.growLoadFactor);
		this.shrinkThreshold = (int) (table.length * this.shrinkLoadFactor);
	}

	private static int nextKeyIndex(int i, int len) {

		return (i + 1 < len ? i + 1 : 0);
	}

	protected static int hash(Object element, int length) {

		int h = element.hashCode();
		// int h = System.identityHashCode(element);
		return ((h << 1) - (h << 8)) & (length - 1);
	}

	private void resize(int newCapacity) {

		Object[] oldTable = this.table;
		int oldCapacity = oldTable.length;
		if (oldCapacity == MAXIMUM_CAPACITY) {
			this.growThreshold = Integer.MAX_VALUE;
			return;
		}

		Object[] newTable = new Object[newCapacity];
		this.transfer(newTable);
		this.table = newTable;
		this.growThreshold = (int) (newCapacity * this.growLoadFactor);
		this.shrinkThreshold = (int) (newCapacity * this.shrinkLoadFactor);
	}

	/**
	 * Transfers all elements of {@link #table} to the new table via rehashing.
	 * 
	 * @param newTable
	 */
	private void transfer(Object[] newTable) {

		Object[] src = this.table;
		int newCapacity = newTable.length;
		for (int j = 0; j < src.length; j++) {
			Object e = src[j];
			if (e != null) {
				src[j] = null;
				int i = hash(this.getKey(e), newCapacity);
				while (newTable[i] != null) {
					i = ++i % newCapacity;
				}
				newTable[i] = e;
			}
		}
	}

	protected int capacity(int expectedMaxSize) {

		// Compute min capacity for expectedMaxSize given a load factor of 2/3
		int minCapacity = (3 * expectedMaxSize) / 2;

		// Compute the appropriate capacity
		int result;
		if (minCapacity > MAXIMUM_CAPACITY || minCapacity < 0) {
			result = MAXIMUM_CAPACITY;
		} else {
			result = DEFAULT_INITIAL_CAPACITY;
			while (result < minCapacity) {
				result <<= 1;
			}
		}
		return result;
	}

	/**
	 * Allows to rehash the table (e.g. if it is build up with gaps from dump)
	 */
	protected void rehash() {

		Object[] table = this.table;
		int s = 0;
		for (int i = 0; i < table.length; i++) {
			if (table[i] != null) {
				s++;
			}
		}
		this.size = s;
		int newCapacity = this.capacity(s);
		this.resize(newCapacity);
	}

	/**
	 * Adds or replaces an element to the table and triggers resizing of the
	 * table if necessary.
	 * 
	 * @param pos
	 *            Position where to add in the table
	 * @param elem
	 *            Element to add
	 * @param needNewPosition
	 *            Specifies if the new position in the table is to be returned
	 *            in case the table got resized.
	 * @return The new position in the table if the table got resized and
	 *         parameter <code>needNewPosition</code> is <code>true</code>.
	 *         Otherwise it returns the value of <code>pos</code>
	 */
	protected int addToTable(int pos, Object elem) {

		assert elem != null;

		// only increment size if it is a new add but no replace
		if (this.table[pos] == null) {
			++this.size;
		}
		this.table[pos] = elem;

		if (this.size >= this.growThreshold) {
			this.resize(this.table.length << 1);
		}
		return pos;
	}

	protected void removeFromTable(int pos) {

		this.removeFromTableWithoutResize(pos);
		if (this.size < this.shrinkThreshold) {
			this.resize(this.table.length >> 1);
		}
	}

	/**
	 * Introduced to allow removing elements during resizing (e.g. for a
	 * cleanup). Avoids infinite recursive calling of resize() if the table
	 * would shrink during the operation.
	 * 
	 * @param pos
	 */
	protected void removeFromTableWithoutResize(int pos) {

		if (this.table[pos] == null) {
			throw new RuntimeException(Messages.getString(Messages.Query2Index_AbstractMapBase_NoElementFound, new String[] { Integer.toString(pos) }));
		}
		this.table[pos] = null;
		--this.size;
		this.closeDeletion(pos);
	}

	/**
	 * Since the tables use no overflow buckets but store colliding elements at
	 * the next free position in the table, removing an element requires to
	 * close the gap in the table that may be left behind to ensure that a
	 * position in the table that is <code>null</code> is a valid break
	 * condition for search.
	 * 
	 * @param d
	 */
	private void closeDeletion(int d) {

		// Adapted from Knuth Section 6.4 Algorithm R
		Object[] tab = this.table;
		int len = tab.length;

		// Look for items to swap into newly vacated slot
		// starting at index immediately following deletion,
		// and continuing until a null slot is seen, indicating
		// the end of a run of possibly-colliding keys.
		Object item;
		Object keyElem;
		for (int i = nextKeyIndex(d, len); (item = tab[i]) != null; i = nextKeyIndex(i, len)) {
			// The following test triggers if the item at slot i (which
			// hashes to be at slot r) should take the spot vacated by d.
			// If so, we swap it in, and then continue with d now at the
			// newly vacated i. This process will terminate when we hit
			// the null slot at the end of this run.
			// The test is messy because we are using a circular table.
			keyElem = this.getKey(item);
			int r = hash(keyElem, len);
			if ((i < r && (r <= d || d <= i)) || (r <= d && d <= i)) {
				tab[d] = item;
				tab[i] = null;
				d = i;
			}
		}
	}

	public int size() {

		return this.size;
	}

	/**
	 * Checks if the size counter {@link #size} is in sync with the actual
	 * number of entries in the table.
	 */
	protected void checkSize() {

		int count = 0;
		Object[] tab = this.table;
		for (int i = 0; i < tab.length; i++) {
			if (tab[i] != null) {
				count++;
			}
		}
		if (count != this.size) {
			throw new RuntimeException(Messages.getString(Messages.Query2Index_AbstractMapBase_SizeCounterDiffers,
					new String[] { Integer.toString(count), Integer.toString(this.size) }));
		}
	}

	public Iterator<K> keyIterator() {
		return new KeyIterator();
	}

	@SuppressWarnings("unchecked")
	public K getExistingKey(Object k) {
		if (k == null) {
			return null;
		}
		Object[] tab = this.table;
		int len = tab.length;
		int i = hash(k, len);
		Object actualKey;

		while (true) {
			E item = (E) tab[i];
			if (item == null) {
				return null;
			}
			if ((actualKey = this.getKey(item)).equals(k)) {
				return (K) actualKey;
			}
			i = ++i % len;
		}
	}

	abstract public Iterator<E> iterator();

	abstract public E get(K keyElem);

	abstract public void serialize(SerializationStrategy<K, E> strategy);

	abstract public void deserialize(SerializationStrategy<K, E> strategy);

	abstract protected Object getKey(Object entry); // TODO return K?
}
