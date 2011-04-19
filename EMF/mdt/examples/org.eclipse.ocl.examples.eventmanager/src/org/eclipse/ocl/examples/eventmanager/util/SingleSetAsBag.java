/*******************************************************************************
 * Copyright (c) 2009, 2010 SAP AG and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     SAP AG - initial API and implementation
 ******************************************************************************/
package org.eclipse.ocl.examples.eventmanager.util;

import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Set;

/**
 * Wraps a single {@link Set} as a {@link Bag}. If the set's {@link Collection#contains(Object)}
 * operation is fast then so will be this bag's {@link #contains(Object)} operation.
 * According to the specification of {@link Bag}, all modifying operations throw an
 * {@link UnsupportedOperationException}.<p>
 * 
 * The underlying {@link Set}, however, can be obtained using {@link #getWrappedSet()} and
 * modified. As the {@link #iterator()} on this bag is obtained from the underlying set,
 * modifications to the set while iterating over this bag will cause a
 * {@link ConcurrentModificationException}.
 * 
 * @author Axel Uhl
 */
public class SingleSetAsBag<E> implements Bag<E> {
	private final Set<E> set;
	
	/**
	 * @param set must not be <code>null</code>, or else, a {@link NullPointerException}
	 * will be thrown.
	 */
	public SingleSetAsBag(Set<E> set) {
		if (set == null) {
			throw new NullPointerException("Only non-null Set objects allowed");
		}
		this.set = set;
	}
	
	public Set<E> getWrappedSet() {
		return set;
	}
	
	public int size() {
		return set.size();
	}

	public boolean isEmpty() {
		return set.isEmpty();
	}

	public boolean contains(Object o) {
		return set.contains(o);
	}

	public Iterator<E> iterator() {
		return set.iterator();
	}

	public Object[] toArray() {
		return set.toArray();
	}

	public <T> T[] toArray(T[] a) {
		return set.toArray(a);
	}

	public boolean add(E o) {
		throw new UnsupportedOperationException();
	}

	public boolean remove(Object o) {
		throw new UnsupportedOperationException();
	}

	public boolean containsAll(Collection<?> c) {
		return set.containsAll(c);
	}

	public boolean addAll(Collection<? extends E> c) {
		throw new UnsupportedOperationException();
	}

	public boolean removeAll(Collection<?> c) {
		throw new UnsupportedOperationException();
	}

	public boolean retainAll(Collection<?> c) {
		throw new UnsupportedOperationException();
	}

	public void clear() {
		throw new UnsupportedOperationException();
	}

	public int count(Object o) {
		return set.contains(o) ? 1 : 0;
	}

}
