/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.emf.emfindex.util;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * An iterator that remembers allowing to look ahead.
 * 
 * @author Jan Köhnlein - Initial contribution and API
 * 
 * @param <T>
 */
public class CachingIterator<T> implements Iterator<T> {

	private List<T> lookaheadCache = new ArrayList<T>();

	private int currentIndex;

	private Iterator<T> wrappedIterator;

	public CachingIterator(Iterator<T> wrappedIterator) {
		currentIndex = 0;
		this.wrappedIterator = wrappedIterator;
	}

	public boolean hasNext() {
		if (lookaheadCache.isEmpty())
			return wrappedIterator.hasNext();
		return true;
	}

	public T next() {
		T next = null;
		if (hasNext()) {
			if (!lookaheadCache.isEmpty()) {
				next = lookaheadCache.get(0);
				lookaheadCache.remove(0);
			} else {
				next = wrappedIterator.next();
			}
			++currentIndex;
		}
		return next;
	}

	public void remove() {
		throw new UnsupportedOperationException();
	}

	public boolean hasSize(int size) {
		if (size <= currentIndex + lookaheadCache.size()) {
			return true;
		}
		int lookahead = size - currentIndex - lookaheadCache.size();
		while (lookahead > 0 && wrappedIterator.hasNext()) {
			lookaheadCache.add(wrappedIterator.next());
			--lookahead;
		}
		return lookahead == 0;
	}

}
