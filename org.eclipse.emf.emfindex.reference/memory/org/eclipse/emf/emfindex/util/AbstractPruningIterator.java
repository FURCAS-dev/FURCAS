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
import java.util.Stack;

/**
 * @author koehnlein
 * 
 */
public abstract class AbstractPruningIterator<DescriptorType> implements Iterator<DescriptorType> {

	private List<Iterator<?>> state;

	private DescriptorType next;

	protected AbstractPruningIterator(Iterable<?> initialContents) {
		if (initialContents != null) {
			state = new ArrayList<Iterator<?>>(10);
			state.add(initialContents.iterator());
			next = peek();
		} else {
			next = null;
		}
	}

	protected AbstractPruningIterator(Object initialElement) {
		Iterator<?> iterator = getChildrenIterator(initialElement);
		if (iterator != null) {
			state = new Stack<Iterator<?>>();
			state.add(iterator);
			next = peek();
		} else {
			next = null;
		}
	}

	@SuppressWarnings("unchecked")
	private DescriptorType peek() {
		for (;;) {
			if (state.isEmpty())
				return null;
			Iterator<?> lastIterator = state.get(state.size()-1);

			while (!lastIterator.hasNext()) {
				state.remove(state.size()-1);
				if (state.isEmpty())
					return null;
				lastIterator = state.get(state.size()-1);
			}
			Object next = lastIterator.next();
			Iterator<?> nextChildrenIterator = getChildrenIterator(next);
			if (nextChildrenIterator != null) {
				state.add(nextChildrenIterator);
			}
			if (isReturnType(next)) {
				return (DescriptorType) next;
			}
		}
	}

	protected abstract boolean isReturnType(Object next);

	protected abstract Iterator<?> getChildrenIterator(Object next);

	public boolean hasNext() {
		return next != null;
	}

	public DescriptorType next() {
		DescriptorType returnValue = next;
		next = peek();
		return returnValue;
	}

	public void remove() {
		throw new IllegalStateException("Operation not implemented");
	}
}
