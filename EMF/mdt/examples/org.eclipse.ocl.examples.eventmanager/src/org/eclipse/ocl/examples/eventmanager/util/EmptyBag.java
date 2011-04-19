package org.eclipse.ocl.examples.eventmanager.util;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;

public class EmptyBag<E> implements Bag<E> {

	public int size() {
		return 0;
	}

	public boolean isEmpty() {
		return true;
	}

	public boolean contains(Object o) {
		return false;
	}

	public Iterator<E> iterator() {
		Set<E> s = Collections.emptySet();
		return s.iterator();
	}

	public Object[] toArray() {
		return new Object[0];
	}

	public <T> T[] toArray(T[] a) {
		for (int i=0; i<a.length; i++) {
			a[i] = null;
		}
		return a;
	}

	public boolean add(E o) {
		throw new UnsupportedOperationException();
	}

	public boolean remove(Object o) {
		throw new UnsupportedOperationException();
	}

	public boolean containsAll(Collection<?> c) {
		return false;
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
		return 0;
	}

}
