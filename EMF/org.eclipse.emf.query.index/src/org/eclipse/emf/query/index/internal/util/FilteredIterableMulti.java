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
package org.eclipse.emf.query.index.internal.util;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @author Martin Strenge - Initial API and implementation
 * @author Bernd Kolb - Initial API and implementation
 * 
 */
public abstract class FilteredIterableMulti<T> implements Iterable<T> {

	private static final Iterator<?> NO_IT = new Iterator<Object>() {

		@Override
		public boolean hasNext() {
			return false;
		}

		@Override
		public Object next() {
			throw new NoSuchElementException();
		}

		@Override
		public void remove() {
			throw new UnsupportedOperationException();
		}

	};

	@Override
	public Iterator<T> iterator() {
		this.scope = this.getNextIterator();
		if (scope == null) {
			return (Iterator<T>) NO_IT;
		} else {
			return new Iterator<T>() {

				T prepared = null;

				@Override
				public boolean hasNext() {
					if (prepared == null) {
						while (scope.hasNext() || ((scope = getNextIterator()) != null && scope.hasNext())) {
							T next = scope.next();
							if (matches(next)) {
								prepared = next;
								return true;
							}
						}
						return false;
					} else {
						return true;
					}
				}

				@Override
				public T next() {
					if (!hasNext()) {
						throw new NoSuchElementException();
					}
					T ret = prepared;
					prepared = null;
					return ret;
				}

				@Override
				public void remove() {
					throw new UnsupportedOperationException();
				}

			};
		}
	}

	Iterator<? extends T> scope;

	protected abstract boolean matches(T e);

	protected abstract Iterator<? extends T> getNextIterator();
}
