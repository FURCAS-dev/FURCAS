/**
 * <copyright>
 *
 * Copyright (c) 2005 IBM Corporation and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   IBM - Initial API and implementation
 *
 * </copyright>
 *
 * $Id$
 */

package org.eclipse.emf.ocl.internal.utilities.impl;

import java.util.AbstractCollection;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;

import org.eclipse.emf.ocl.internal.OclEnginePlugin;
import org.eclipse.emf.ocl.internal.l10n.OclMessages;

/**
 * A Bag is an unordered collection which may have duplicate elements.
 */
public final class Bag
	extends AbstractCollection {

	private static final String RemoveUnsupported_ERROR_ =
		OclMessages.RemoveUnsupported_ERROR_;

	public static Bag EMPTY_BAG = new Bag();

	public Bag() {
		super();
		this.coll = new HashMap();
		this.size = 0;
	}

	public Bag(Collection c) {
		this();
		addAll(c);
	}

	/**
	 * removes every occurrence of the object from the collection
	 */
	public boolean remove(Object o) {
		MutableInteger count = (MutableInteger) coll.remove(o);
		if (count != null)
			size -= count.i;
		return count != null;
	}

	public boolean add(Object o) {
		MutableInteger count = (MutableInteger) coll.get(o);
		if (count == null)
			coll.put(o, new MutableInteger(1));
		else
			count.i++;
		size++;
		// the collection always changes as a result of this call
		return true;
	}

	public int size() {
		return size;
	}

	public void clear() {
		size = 0;
		coll.clear();
	}

	/**
	 * Returns true iff this bag and the argument bag have the same number of the same
	 * elements.
	 */
	public boolean equals(Object o) {
		if (o instanceof Bag) {
			Bag b = (Bag) o;
			if (size() == b.size()) {
				for (Iterator it = iterator(); it.hasNext();) {
					Object obj = it.next();
					MutableInteger count = (MutableInteger) coll.get(obj);
					MutableInteger otherCount = (MutableInteger) b.coll
						.get(obj);
					if (otherCount == null || otherCount.i != count.i)
						return false;
				}
				return true;
			}
		}
		return false;
	}

	public int hashCode() {
		int result = 37;
		result = 37 * result + coll.hashCode();
		result = 37 * result + size;
		return result;
	}

	public Iterator iterator() {
		// local inner class
		class MyIterator
			implements Iterator {

			public MyIterator() {
				it = coll.keySet().iterator();
				offset = 0;
				curr = null;
			}

			public boolean hasNext() {
				if (it.hasNext())
					return true;
				MutableInteger count = (MutableInteger) coll.get(curr);
				return curr != null && offset < count.i - 1;
			}

			public Object next() {
				if (!hasNext())
					throw new NoSuchElementException();
				MutableInteger count = (MutableInteger) coll.get(curr);
				if (count != null && offset < count.i - 1) {
					offset++;
					return curr;
				}
				curr = it.next();
				offset = 0;
				return curr;
			}

			public void remove() {
				UnsupportedOperationException error = new UnsupportedOperationException(
					RemoveUnsupported_ERROR_);
				OclEnginePlugin.throwing(getClass(), "remove", error);//$NON-NLS-1$
				throw error;
			}

			private Iterator it;

			private int offset;

			private Object curr;
		} // end of local inner class MyIterator

		return new MyIterator();
	}

	// static inner class for mutable integers
	// TODO: Consider whether we should pull this class out and use
	// it consistently throughout.
	private static class MutableInteger {

		public MutableInteger(int i) {
			this.i = i;
		}

		public String toString() {
			return Integer.toString(i);
		}

		public int i;
	}

	public String toString() {
		return coll.toString();
	}

	private Map coll;

	private int size;
}