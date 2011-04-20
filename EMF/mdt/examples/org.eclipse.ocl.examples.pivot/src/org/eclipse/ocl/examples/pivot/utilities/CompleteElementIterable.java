/**
 * <copyright>
 *
 * Copyright (c) 2011 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *
 * </copyright>
 *
 * $Id: CompleteElementIterable.java,v 1.4 2011/04/20 19:02:46 ewillink Exp $
 */
package org.eclipse.ocl.examples.pivot.utilities;

import java.util.List;

import com.google.common.collect.Iterators;

/**
 * A CompleteElementIterable supports iteration over the multiple iterable contributions
 * to a Complete Element as if all were merged in a composite element.
 *
 * @param <O> The Outer type of the Complete Element
 * @param <I> The Inner type of the iterated Complete Element child
 */
public abstract class CompleteElementIterable<O,I> implements Iterable<I>
{
	protected class Iterator implements java.util.Iterator<I>
	{
		private final java.util.Iterator<? extends O> outerIterator;
		private java.util.Iterator<I> innerIterator;
		
		public Iterator(Iterable<? extends O> iterables) {
			outerIterator = iterables.iterator();
			advance();
		}

		protected boolean advance() {
			while (outerIterator.hasNext()) {
				Iterable<I> innerIterable = getInnerIterable(outerIterator.next());
				if (innerIterable != null) {
					innerIterator = innerIterable.iterator();
					if (innerIterator.hasNext()) {
						return true;
					}
				}
			}
			return false;
		}

		public boolean hasNext() {
			if (innerIterator == null) {
				return false;
			}
			if (innerIterator.hasNext()) {
				return true;
			}
			return advance();
		}

		public I next() {
			return innerIterator != null ? getInnerValue(innerIterator.next()) : null;
		}

		public void remove() {
			throw new IllegalStateException();
		}
	}
	
	protected final Iterable<? extends O> iterables;
	
	public CompleteElementIterable(Iterable<? extends O> iterables) {
		this.iterables = iterables;
	}
	
	/**
	 * Return the iterables for an inner iteration over the iterable. A null
	 * return may be used to indicate no inner iterations are necessary.
	 * 
	 * @param iterable
	 * @return the inner iterable or null for none.
	 */
	protected abstract Iterable<I> getInnerIterable(O iterable);

	protected I getInnerValue(I element) {
		return element;
	}

	public java.util.Iterator<I> iterator() {
		if (iterables instanceof List<?>) {
			@SuppressWarnings("unchecked")
			List<O> list = (List<O>)iterables;
			if (list.size() == 0) {
				return Iterators.emptyIterator();
			}
			else if (list.size() == 1) {
				Iterable<I> innerIterable = getInnerIterable(list.get(0));
				if (innerIterable != null) {
					return innerIterable.iterator();
				}
				else {
					return Iterators.emptyIterator();
				}
			}
		}
		if (iterables != null) {
			return new Iterator(iterables);
		}
		else {
			return Iterators.emptyIterator();
		}
	}
}