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

import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.query.index.internal.maps.SerializationStrategy.Channel;

/**
 * @author Martin Strenge - Initial API and implementation
 * @author Bernd Kolb - Initial API and implementation
 * 
 */
@SuppressWarnings("unchecked")
public class ListMap<K, E extends MapEntry> extends AbstractKeylessMapBase<K, E> {

	private final class ListIterator implements Iterator<E> {
		E[] currentList;
		E prepared = null;
		int listPos = -1;
		int lastOne;

		private ListIterator(E[] list) {
			currentList = list;
			lastOne = list != null ? list.length - 1 : -1;
		}

		@Override
		public boolean hasNext() {
			if (currentList != null && prepared == null) {
				if (++listPos <= lastOne) {
					prepared = currentList[listPos];
					return true;
				} else {
					if (lastOne < currentList.length - 1) {
						MapEntry[] newList = null;
						if (lastOne > 0) {
							newList = new MapEntry[lastOne + 1];
							System.arraycopy(currentList, 0, newList, 0, lastOne + 1);
						}
						ListMap.this.putList((K) currentList[0].getKeyElement(keyNr), newList);
						currentList = null;
					}
					return false;
				}
			}
			return false;
		}

		@Override
		public E next() {
			hasNext();
			E ret = prepared;
			prepared = null;
			return ret;
		}

		@Override
		public void remove() { // TODO prevent double remove() calls, exception?
			currentList[listPos] = currentList[lastOne]; // be sure that the last element is still in the array (necessary for comparison in list)
			lastOne--;
			listPos--;
		}
	}

	public ListMap(int keyNr, int capacity) {

		super(keyNr);
		int cap = this.capacity(capacity);
		this.growLoadFactor = DEFAULT_GROW_LOAD_FACTOR;
		this.shrinkLoadFactor = DEFAULT_SHRINK_LOAD_FACTOR;
		this.growThreshold = (int) (cap * DEFAULT_GROW_LOAD_FACTOR);
		this.shrinkThreshold = (int) (cap * DEFAULT_SHRINK_LOAD_FACTOR);
		this.table = new Object[cap];
	}

	/**
	 * Adds the given element to the table. No uniqueness test is performed, so double adding is possible.
	 */
	@Override
	public void put(E element) {

		if (element == null) {
			return;
		}
		int keyNr = this.keyNr;
		Object[] tab = this.table;
		int len = tab.length;
		Object keyElem = element.getKeyElement(keyNr);
		int i = hash(keyElem, len);

		Object item;
		while ((item = tab[i]) != null) {
			E[] ihses = (E[]) item;
			if (ihses[0].getKeyElement(keyNr) == keyElem) {
				E[] newArray = (E[]) new MapEntry[ihses.length + 1];
				System.arraycopy(ihses, 0, newArray, 0, ihses.length);
				newArray[newArray.length - 1] = element;
				tab[i] = newArray;
				return;
			}
			i = ++i % len;
		}
		// else add single Element
		E[] newArray = (E[]) new MapEntry[1];
		newArray[0] = element;

		this.addToTable(i, newArray);
	}

	@Override
	public E get(K keyElem) {

		if (keyElem == null) {
			return null;
		}
		int keyNr = this.keyNr;
		Object[] tab = this.table;
		int len = tab.length;
		int i = hash(keyElem, len);

		while (true) {
			Object item = tab[i];
			if (item == null) {
				return null;
			}
			if (((E[]) item)[0].getKeyElement(keyNr) == keyElem) {
				return ((E[]) item)[0];
			}
			i = ++i % len;
		}
	}

	public E getEqual(K keyElem) {

		if (keyElem == null) {
			return null;
		}
		int keyNr = this.keyNr;
		Object[] tab = this.table;
		int len = tab.length;
		int i = hash(keyElem, len);

		while (true) {
			Object item = tab[i];
			if (item == null) {
				return null;
			}
			if (((E[]) item)[0].getKeyElement(keyNr).equals(keyElem)) {
				return ((E[]) item)[0];
			}
			i = ++i % len;
		}
	}

	public List<E> getAllWithEqualKey(K key) {
		// FIXME return unmodifiable collection
		E[] list = this.getList_Equal(key);
		if (list == null)
			return Collections.emptyList();
		else
			return Arrays.asList(list);
	}

	/**
	 * Removes the given element from the table (if contained).
	 * 
	 * @param element
	 */
	public void remove(E element) {

		if (element == null) {
			return;
		}
		int keyNr = this.keyNr;
		Object[] tab = this.table;
		int len = tab.length;
		Object keyElem = element.getKeyElement(keyNr);
		int i = hash(keyElem, len);

		while (true) {
			Object item = tab[i];
			if (item == null) {
				return;
			}
			if (((E[]) item)[0].getKeyElement(keyNr) == keyElem) {
				E[] elems = (E[]) item;
				for (int j = 0; j < elems.length; j++) {
					if (elems[j] == element) {
						if (elems.length == 1) {
							this.removeFromTable(i);
						} else {
							E[] newArray = (E[]) new MapEntry[elems.length - 1];
							System.arraycopy(elems, 0, newArray, 0, j);
							System.arraycopy(elems, j + 1, newArray, j, elems.length - j - 1);
							tab[i] = newArray;
						}
						return;
					}
				}
			}
			i = ++i % len;
		}
	}

	@Override
	protected Object getKey(Object entry) {
		return ((E[]) entry)[0].getKeyElement(keyNr);
	}

	/**
	 * Not designed!
	 */
	@Override
	public int hashCode() {

		assert false;
		return -1;
	}

	/**
	 * For testing only!
	 */
	@Override
	public boolean equals(Object obj) {

		if (!(obj instanceof ListMap)) {
			return false;
		}
		Object[] table = this.table;
		Object[] otherTable = ((ListMap<K, E>) obj).table;

		if (table.length != otherTable.length) {
			return false;
		}

		Object[] item;
		Object[] otherItem;
		for (int i = 0; i < table.length; i++) {
			if (otherTable[i] != null) {
				if (table[i] == null) {
					return false;
				}
			}
			if (table[i] == null) {
				if (otherTable[i] != null) {
					return false;
				}
			} else {
				item = (Object[]) table[i];
				otherItem = (Object[]) otherTable[i];

				if (item.length != otherItem.length) {
					return false;
				}

				for (int j = 0; j < item.length; j++) {
					if (!((E) item[j]).equals(otherItem[j])) {
						return false;
					}
				}
			}
		}
		return true;
	}

	private E[] getList_Equal(K keyElem) {

		if (keyElem == null) {
			return null;
		}
		int keyNr = this.keyNr;
		Object[] tab = this.table;
		int len = tab.length;
		int i = hash(keyElem, len);

		while (true) {
			Object item = tab[i];
			if (item == null) {
				return null;
			}
			if (((E[]) item)[0].getKeyElement(keyNr).equals(keyElem)) {
				return (E[]) item;
			}
			i = ++i % len;
		}
	}

	private void putList(K key, MapEntry[] list) {
		int keyNr = this.keyNr;
		Object[] tab = this.table;
		int len = tab.length;
		Object keyElem = key;
		int i = hash(keyElem, len);

		Object item;
		while ((item = tab[i]) != null) {
			E[] ihses = (E[]) item;
			if (ihses[0].getKeyElement(keyNr) == keyElem) {
				if (list == null || list.length == 0) {
					this.removeFromTable(i);
				} else {
					tab[i] = list;
				}
				return;
			}
			i = ++i % len;
		}
		// else add single Element
		this.addToTable(i, list);
	}

	/**
	 * Compares via equals()
	 * 
	 * @param key
	 * @return
	 */
	public Iterator<E> iterator(K key) {
		return new ListIterator(this.getList_Equal(key));
	}

	@Override
	public Iterator<E> iterator() {
		return new Iterator<E>() {

			int tablePos = 0;
			int listPos = -1;
			private E preparedValue = null;

			@Override
			public boolean hasNext() {
				if (preparedValue == null) {
					while (tablePos < table.length) {
						if (table[tablePos] != null) {
							MapEntry[] entry = ((MapEntry[]) table[tablePos]);
							if (++listPos < entry.length) {
								assert entry[listPos] != null;
								preparedValue = (E) entry[listPos];
								return true;
							} else {
								listPos = -1;
							}
						}
						tablePos++;
					}
					return false;
				}
				return true;
			}

			@Override
			public E next() {
				hasNext();
				E ret = preparedValue;
				preparedValue = null;
				return ret;
			}

			@Override
			public void remove() {
				throw new UnsupportedOperationException();
			}

		};
	}

	@Override
	public void serialize(SerializationStrategy<K, E> strategy) {
		Object[] tab = table;
		int keyNr = this.keyNr;
		Channel ch = strategy.getChannel();

		// FIXME write arraySize OOME secure
		ch.putInt(table.length);
		ch.putInt(this.size());
		for (int i = 0; i < tab.length; i++) {
			if (tab[i] != null) {
				ch.putInt(i);
				E[] list = (E[]) tab[i];
				strategy.writeKey((K) list[0].getKeyElement(keyNr));
				ch.putInt(list.length);
				for (int j = 0; j < list.length; j++) {
					strategy.writeElement(list[j]);
				}
			}
		}
	}

	@Override
	public void deserialize(SerializationStrategy<K, E> strategy) {
		Channel ch = strategy.getChannel();

		Object[] tab = new Object[ch.getInt()];
		int size = ch.getInt();

		K key;
		int listPos;
		int listSize;
		MapEntry[] list;
		for (int i = 0; i < size; i++) {
			listPos = ch.getInt();
			key = strategy.readKey();
			listSize = ch.getInt();
			list = new MapEntry[listSize];
			for (int j = 0; j < listSize; j++) {
				list[j] = strategy.readElement(key);
			}
			tab[listPos] = list;
		}

		this.initialize(tab, size);
	}

	public <T extends MapEntry> void getPosition(T element, int[] output) {
		if (element == null) {
			throw new IllegalArgumentException("Argument must not be null");
		}
		int keyNr = this.keyNr;
		Object[] tab = this.table;
		int len = tab.length;
		Object keyElem = element.getKeyElement(keyNr);
		int i = hash(keyElem, len);

		while (true) {
			Object item = tab[i];
			if (item == null) {
				throw new IllegalArgumentException("Element not found");
			}
			if (((E[]) item)[0].getKeyElement(keyNr) == keyElem) {
				E[] elems = (E[]) item;
				for (int j = 0; j < elems.length; j++) {
					if (elems[j] == element) {
						output[0] = i;
						output[1] = j;
						return;
					}
				}
			}
			i = ++i % len;
		}
	}

	public E get(int[] position) {
		int j = position[1];
		int i = position[0];
		Object[] tab = (Object[]) this.table[i];
		return (E) tab[j];
	}

}
