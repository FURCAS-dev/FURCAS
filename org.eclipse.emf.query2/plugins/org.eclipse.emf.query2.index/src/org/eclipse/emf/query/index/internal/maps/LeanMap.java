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

import java.util.AbstractList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.RandomAccess;

import org.eclipse.emf.query.index.Messages;
import org.eclipse.emf.query.index.internal.maps.SerializationStrategy.Channel;

/**
 * @author Martin Strenge - Initial API and implementation
 * @author Bernd Kolb - Initial API and implementation
 * 
 */
// FIXME introduce fast lists
public class LeanMap<K, E> extends AbstractMapBase<K, E> {

	private static class ArrayListInternal<E> extends AbstractList<E> implements RandomAccess {
		private final Object[] a;

		ArrayListInternal(Object[] array) {
			if (array == null)
				throw new NullPointerException();
			a = array;
		}

		public int size() {
			return a.length - 1;
		}

		public Object[] toArray() {
			return a.clone();
		}

		public <T> T[] toArray(T[] a) {
			throw new UnsupportedOperationException();
		}

		public E get(int index) {
			return (E) a[index + 1];
		}

		public E set(int index, E element) {
			throw new UnsupportedOperationException();
		}

		public int indexOf(Object o) {
			if (o == null) {
				for (int i = 0; i < a.length; i++)
					if (a[i] == null)
						return i - 1;
			} else {
				for (int i = 0; i < a.length; i++)
					if (o.equals(a[i]))
						return i - 1;
			}
			return -1;
		}

		public boolean contains(Object o) {
			return indexOf(o) != -1;
		}
	}

	public LeanMap(int capacity) {
		int cap = this.capacity(capacity);
		this.growLoadFactor = DEFAULT_GROW_LOAD_FACTOR;
		this.shrinkLoadFactor = DEFAULT_SHRINK_LOAD_FACTOR;
		this.growThreshold = (int) (cap * DEFAULT_GROW_LOAD_FACTOR);
		this.shrinkThreshold = (int) (cap * DEFAULT_SHRINK_LOAD_FACTOR);
		this.table = new Object[cap];
	}

	@Override
	public E get(K keyElem) {
		if (keyElem == null) {
			return null;
		}
		Object[] tab = this.table;
		int len = tab.length;
		int i = hash(keyElem, len);

		while (true) {
			Object item = tab[i];
			if (item == null) {
				return null;
			}
			if (((E[]) item)[0] == keyElem) {
				return ((E[]) item)[1];
			}
			i = ++i % len;
		}
	}

	@Override
	protected Object getKey(Object entry) {
		return ((Object[]) entry)[0];
	}

	@Override
	public Iterator<E> iterator() {
		throw new UnsupportedOperationException(Messages.Query2Index_LeanMap_ToImplement);
	}

	public Collection<E> getAll(K key) {
		Object[] list = this.getList_Equal(key);
		if (list == null)
			return Collections.emptyList();
		else
			return new ArrayListInternal<E>(list);
	}

	private Object[] getList_Equal(K keyElem) {

		if (keyElem == null) {
			return null;
		}
		Object[] tab = this.table;
		int len = tab.length;
		int i = hash(keyElem, len);

		while (true) {
			Object item = tab[i];
			if (item == null) {
				return null;
			}
			if (((Object[]) item)[0].equals(keyElem)) {
				return (Object[]) item;
			}
			i = ++i % len;
		}
	}

	public void put(K key, E element) {
		if (element == null) {
			return;
		}
		Object[] tab = this.table;
		int len = tab.length;
		int i = hash(key, len);

		Object item;
		while ((item = tab[i]) != null) {
			Object[] ihses = (Object[]) item;
			if (ihses[0] == key) {
				Object[] newArray = new Object[ihses.length + 1];
				System.arraycopy(ihses, 0, newArray, 0, ihses.length);
				newArray[newArray.length - 1] = element;
				tab[i] = newArray;
				return;
			}
			i = ++i % len;
		}
		// else add single Element
		Object[] newArray = new Object[2];
		newArray[0] = key;
		newArray[1] = element;

		this.addToTable(i, newArray);
	}

	public void remove(K keyElem, E element) {
		if (element == null) {
			return;
		}
		Object[] tab = this.table;
		int len = tab.length;
		int i = hash(keyElem, len);

		while (true) {
			Object item = tab[i];
			if (item == null) {
				return;
			}
			if (((Object[]) item)[0] == keyElem) {
				Object[] elems = (Object[]) item;
				for (int j = 0; j < elems.length; j++) {
					if (elems[j] == element) {
						if (elems.length == 2) {
							this.removeFromTable(i);
						} else {
							Object[] newArray = new Object[elems.length - 1];
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
	public void serialize(SerializationStrategy<K, E> strategy) {
		Object[] tab = table;
		Channel ch = strategy.getChannel();

		// FIXME write arraySize OOME secure
		ch.putInt(table.length);
		ch.putInt(this.size());
		for (int i = 0; i < tab.length; i++) {
			if (tab[i] != null) {
				ch.putInt(i);
				Object[] list = (Object[]) tab[i];
				strategy.writeKey((K) list[0]);
				ch.putInt(list.length);
				for (int j = 1; j < list.length; j++) {
					strategy.writeElement((E) list[j]);
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
		Object[] list;
		for (int i = 0; i < size; i++) {
			listPos = ch.getInt();
			key = strategy.readKey();
			listSize = ch.getInt();
			list = new Object[listSize];
			list[0] = key;
			for (int j = 1; j < listSize; j++) {
				list[j] = strategy.readElement(key);
			}
			tab[listPos] = list;
		}

		this.initialize(tab, size);
	}
}
