/**
 * <copyright>
 *
 * Copyright (c) 2005, 2007 IBM Corporation and others.
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
 * $Id: BagImpl.java,v 1.3 2007/10/11 23:04:53 cdamus Exp $
 */

package org.eclipse.ocl.util;

import java.util.AbstractCollection;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;

import org.eclipse.ocl.internal.OCLPlugin;
import org.eclipse.ocl.internal.l10n.OCLMessages;

/**
 * Default implementation of the {@link Bag} interface.
 * 
 * @author Christian W. Damus (cdamus)
 */
final class BagImpl<E> extends AbstractCollection<E> implements Bag<E> {

	public static Bag<?> EMPTY_BAG = new BagImpl<Object>();
	

	private Map<E, MutableInteger> coll;

	private int size;
	
	
	public BagImpl() {
		super();
		this.coll = new HashMap<E, MutableInteger>();
		this.size = 0;
	}

	public BagImpl(Collection<? extends E> c) {
		this();
		addAll(c);
	}

    @SuppressWarnings("unchecked")
	public static <E> Bag<E> emptyBag() {
		return (Bag<E>) EMPTY_BAG;
	}
	
	/**
	 * removes every occurrence of the object from the collection
	 */
	@Override
    public boolean remove(Object o) {
		MutableInteger count = coll.remove(o);
		if (count != null)
			size -= count.i;
		return count != null;
	}

	@Override
    public boolean add(E o) {
		MutableInteger count = coll.get(o);
		if (count == null)
			coll.put(o, new MutableInteger(1));
		else
			count.i++;
		size++;
		// the collection always changes as a result of this call
		return true;
	}

    @Override
    public boolean contains(Object o) {
        return count(o) > 0;
    }
    
    public int count(Object o) {
        MutableInteger count = coll.get(o);
        
        if (count != null) {
            return count.i;
        }
        
        return 0;
    }
    
	@Override
    public int size() {
		return size;
	}

	@Override
    public void clear() {
		size = 0;
		coll.clear();
	}

	/**
	 * Returns true iff this bag and the argument bag have the same number of the same
	 * elements.
	 */
	@Override
    public boolean equals(Object o) {
		if (o instanceof BagImpl) {
			BagImpl<?> b = (BagImpl<?>) o;
			if (size() == b.size()) {
				for (Iterator<?> it = iterator(); it.hasNext();) {
					Object obj = it.next();
					MutableInteger count = coll.get(obj);
					MutableInteger otherCount = b.coll.get(obj);
					if (otherCount == null || otherCount.i != count.i)
						return false;
				}
				return true;
			}
		}
		return false;
	}

	@Override
    public int hashCode() {
		int result = 37;
		result = 37 * result + coll.hashCode();
		result = 37 * result + size;
		return result;
	}

	@Override
    public Iterator<E> iterator() {
		// local inner class
		class MyIterator implements Iterator<E> {

			private Iterator<E> it;
			private int offset;
			private E curr;
			
			public MyIterator() {
				it = coll.keySet().iterator();
				offset = 0;
				curr = null;
			}

			public boolean hasNext() {
				if (it.hasNext())
					return true;
				MutableInteger count = coll.get(curr);
				return curr != null && offset < count.i - 1;
			}

			public E next() {
				if (!hasNext())
					throw new NoSuchElementException();
				MutableInteger count = coll.get(curr);
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
						OCLMessages.RemoveUnsupported_ERROR_);
				OCLPlugin.throwing(getClass(), "remove", error);//$NON-NLS-1$
				throw error;
			}
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

		@Override
        public String toString() {
			return Integer.toString(i);
		}

		public int i;
	}

	@Override
    public String toString() {
		return coll.toString();
	}
}
