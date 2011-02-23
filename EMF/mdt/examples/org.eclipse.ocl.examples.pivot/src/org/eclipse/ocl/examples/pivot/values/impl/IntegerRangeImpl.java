/**
 * <copyright>
 *
 * Copyright (c) 2011 E.D.Willink and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *
 * </copyright>
 *
 * $Id: IntegerRangeImpl.java,v 1.1 2011/02/11 20:00:28 ewillink Exp $
 */
package org.eclipse.ocl.examples.pivot.values.impl;

import java.util.AbstractList;
import java.util.Iterator;
import java.util.NoSuchElementException;

import org.eclipse.ocl.examples.pivot.values.IntegerValue;
import org.eclipse.ocl.examples.pivot.values.Value;
import org.eclipse.ocl.examples.pivot.values.ValueFactory;

class IntegerRangeImpl extends AbstractList<Value>
{
	// local iterator class that provides
	// hasNext() and next() methods appropriate
	// for this range set
	class IntegerRangeIterator implements Iterator<Value>
	{
		private int curr;
		private boolean initialized;

		public IntegerRangeIterator() {
			curr = first;
			initialized = false;
		}

		public IntegerValue next() {
			if (!initialized) {
				curr = first - getDelta();
				initialized = true;
			}
			if (hasNext()) {
				curr = curr + getDelta();
                return valueFactory.integerValueOf(curr);
            }
			throw new NoSuchElementException();
		}

		public boolean hasNext() {
			return !initialized || (curr != last);
		}

		public void remove() {
			throw new UnsupportedOperationException();
		}
	}

	protected final ValueFactory valueFactory;
	protected final int first;
	protected final int last;
	protected final int delta;
	protected final int size;
	
	public IntegerRangeImpl(ValueFactory valueFactory, int first, int last) {
		this.valueFactory = valueFactory;
		this.first = first;
		this.last = last;
		if (last > first) {
			this.delta = 1;
			this.size = last - first + 1;
		}
		else {
			this.delta = -1;
			this.size = first - last + 1;
		}
	}

	@Override
	public IntegerValue get(int index) {
		return valueFactory.integerValueOf(first + index * getDelta());
	}

	public int getDelta() {
		return delta;
	}

	public int getFirst() {
		return first;
	}

	public int getLast() {
		return last;
	}

    @Override
	public Iterator<Value> iterator() {
		return new IntegerRangeIterator();
	}

	@Override
	public int size() {
		return size;
	}
	
}