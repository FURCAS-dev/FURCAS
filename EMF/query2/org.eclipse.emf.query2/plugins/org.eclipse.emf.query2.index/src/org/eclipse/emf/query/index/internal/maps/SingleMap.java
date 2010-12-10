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

import org.eclipse.emf.query.index.internal.maps.SerializationStrategy.Channel;


/**
 * A hash table that accepts only one element per key. I.e. a hash set. Keys are
 * compared as usual by identity.
 * 
 * @author Martin Strenge - Initial API and implementation
 * @author Bernd Kolb - Initial API and implementation
 * 
 * @param <E>
 */
public class SingleMap<K, E extends MapEntry> extends AbstractKeylessMapBase<K, E> {

	private final class ValueIterator implements Iterator<E> {
		private int tablePos = -1;
		private E prepared = null;

		public boolean hasNext() {
			if (prepared == null) {
				while (++tablePos < table.length) {
					if (table[tablePos] != null) {
						prepared = (E) table[tablePos];
						return true;
					}
				}
				return false;
			}
			return true;
		}

		public E next() {
			hasNext();
			E ret = prepared;
			prepared = null;
			return ret;
		}

		public void remove() {
			throw new UnsupportedOperationException();
		}
	}

	public SingleMap(int keyNr) {

		this(keyNr, DEFAULT_INITIAL_CAPACITY);
	}

	public SingleMap(int keyNr, int capacity) {

		super(keyNr);
		int cap = this.capacity(capacity);
		this.growLoadFactor = DEFAULT_GROW_LOAD_FACTOR;
		this.shrinkLoadFactor = DEFAULT_SHRINK_LOAD_FACTOR;
		this.growThreshold = (int) (cap * DEFAULT_GROW_LOAD_FACTOR);
		this.shrinkThreshold = (int) (cap * DEFAULT_SHRINK_LOAD_FACTOR);
		this.table = new MapEntry[cap];
	}

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

		E item;
		while ((item = (E) tab[i]) != null) {
			if (item.getKeyElement(keyNr) == keyElem) {
				tab[i] = element;
				return;
			}
			i = ++i % len;
		}
		// else add single Element
		this.addToTable(i, element);
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
			E item = (E) tab[i];
			if (item == null) {
				return null;
			}
			if (item.getKeyElement(keyNr) == keyElem) {
				return item;
			}
			i = ++i % len;
		}
	}

	public void remove(E element) {

		if (element == null) {
			return;
		}
		Object keyElem = element.getKeyElement(this.keyNr);
		Object[] tab = this.table;
		int len = tab.length;
		int i = hash(keyElem, len);

		while (true) {
			E item = (E) tab[i];
			if (item == null) {
				return;
			}
			if (item == element) {
				this.removeFromTable(i);
				return;
			}
			i = ++i % len;
		}
	}

	@Override
	protected Object getKey(Object entry) {
		return ((E) entry).getKeyElement(keyNr);
	}

	@Override
	public int hashCode() {

		assert false;
		return -1;
	}

	@Override
	public boolean equals(Object obj) {

		if (!(obj instanceof SingleMap)) {
			return false;
		}
		SingleMap<K, E> other = (SingleMap<K, E>) obj;
		Object[] table = this.table;
		Object[] otherTable = other.table;

		if (table.length != otherTable.length) {
			return false;
		}

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
				if (!(((E) table[i]).equals(otherTable[i]))) {
					return false;
				}
			}
		}
		return true;
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
			E item = (E) tab[i];
			if (item == null) {
				return null;
			}
			if (item.getKeyElement(keyNr).equals(keyElem)) {
				return item;
			}
			i = ++i % len;
		}
	}

	@Override
	public Iterator<E> iterator() {
		return new ValueIterator();
	}

	@Override
	public void serialize(SerializationStrategy<K, E> strategy) {
		Object[] tab = table;
		Channel ch = strategy.getChannel();

		ch.putInt(table.length);
		ch.putInt(this.size());
		for (int i = 0; i < tab.length; i++) {
			if (tab[i] != null) {
				ch.putInt(i);
				E e = (E) tab[i];
				strategy.writeKey((K) e.getKeyElement(keyNr));
				strategy.writeElement(e);
			}
		}
	}

	@Override
	public void deserialize(SerializationStrategy<K, E> strategy) {
		Channel ch = strategy.getChannel();

		Object[] tab = new Object[ch.getInt()];
		int size = ch.getInt();

		K key;
		int pos;
		for (int i = 0; i < size; i++) {
			pos = ch.getInt();
			key = strategy.readKey();
			tab[pos] = strategy.readElement(key);
		}

		this.initialize(tab, size);
	}

	public int getPosition(K key) {

		if (key == null) {
			throw new RuntimeException("parameter null");
		}
		int keyNr = this.keyNr;
		Object[] tab = this.table;
		int len = tab.length;
		int i = hash(key, len);

		while (true) {
			Object item = tab[i];
			if (item == null) {
				return -1;
			}
			if (((E) item).getKeyElement(keyNr) == key) {
				return i;
			}
			i = ++i % len;
		}
	}

	public E get(int pos) {
		return (E) table[pos];
	}

}
