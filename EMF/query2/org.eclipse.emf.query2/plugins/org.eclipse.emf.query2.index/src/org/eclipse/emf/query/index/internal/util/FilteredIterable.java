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
public abstract class FilteredIterable<T> implements Iterable<T> {

	public Iterator<T> iterator() {
		return new Iterator<T>() {

			T prepared = null;

			public boolean hasNext() {
				if (prepared == null) {
					while (scope.hasNext()) {
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

			public T next() {
				if (!hasNext()) {
					throw new NoSuchElementException();
				}
				T ret = prepared;
				prepared = null;
				return ret;
			}

			public void remove() {
				throw new UnsupportedOperationException();
			}

		};
	}

	final Iterator<T> scope;

	public FilteredIterable(Iterable<T> _scope) {
		this.scope = _scope.iterator();
	}

	public FilteredIterable(Iterator<T> _scope) {
		this.scope = _scope;
	}

	protected abstract boolean matches(T e);
}
