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
 * $Id: CompleteElementIterable.java,v 1.1 2011/03/01 08:47:20 ewillink Exp $
 */
package org.eclipse.ocl.examples.pivot.utilities;

import java.util.List;
import java.util.NoSuchElementException;

/**
 * A CompleteElementIterable supports iteration over the mulktiple model contributions
 * to a Complete Element as if all were mertged in a composite element.
 *
 * @param <O> The Outer type of the Complete Element
 * @param <I> The Inner type of the iterated Complete Element child
 */
public abstract class CompleteElementIterable<O,I> implements Iterable<I>
{
	public static java.util.Iterator<?> EMPTY_ITERATOR = new EmptyIterator();
 
	@SuppressWarnings("unchecked")
	public static final <T> java.util.Iterator<T> emptyIterator() {
    	return (java.util.Iterator<T>) EMPTY_ITERATOR;
        }
	
	protected class Iterator implements java.util.Iterator<I>
	{
		private final java.util.Iterator<O> outerIterator;
		private java.util.Iterator<I> innerIterator;
		
		public Iterator(Iterable<O> models) {
			outerIterator = models.iterator();
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

    public static class EmptyIterator implements java.util.Iterator<Object>
    {
        public boolean hasNext() {
            return false;
        }
        
        public Object next() {
            throw new NoSuchElementException();
        }
        
        public void remove() {
            throw new IllegalStateException();
        }
    }
	
	protected final List<O> models;
	
	public CompleteElementIterable(List<O> models) {
		this.models = models;
	}
	
	/**
	 * Return the iterables for an inner iteration over the model. A null
	 * return may be used to indicate no inner iterations are necessary.
	 * 
	 * @param model
	 * @return the inner iterable or null for none.
	 */
	protected abstract Iterable<I> getInnerIterable(O model);

	protected I getInnerValue(I element) {
		return element;
	}

	public java.util.Iterator<I> iterator() {
		if (models.size() > 1 ) {
			return new Iterator(models);
		}
		else {
			Iterable<I> innerIterable = getInnerIterable(models.get(0));
			if (innerIterable != null) {
				return innerIterable.iterator();
			}
			else {
				return emptyIterator();
			}
		}
	}
}