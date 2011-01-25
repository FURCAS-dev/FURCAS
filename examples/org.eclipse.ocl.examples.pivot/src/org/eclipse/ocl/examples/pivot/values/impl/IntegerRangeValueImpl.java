/**
 * <copyright>
 *
 * Copyright (c) 2005,2011 IBM Corporation and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   IBM - Initial API and implementation
 *   E.D.Willink - split off from EvaluationVisitor
 *
 * </copyright>
 *
 * $Id: IntegerRangeValueImpl.java,v 1.2 2011/01/24 20:47:51 ewillink Exp $
 */
package org.eclipse.ocl.examples.pivot.values.impl;

import java.util.NoSuchElementException;

import org.eclipse.ocl.examples.pivot.StandardLibrary;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.messages.OCLMessages;
import org.eclipse.ocl.examples.pivot.util.PivotPlugin;
import org.eclipse.ocl.examples.pivot.values.ValueFactory;

public class IntegerRangeValueImpl extends AbstractValue
{		// FIXME This should implement CollectionValue
	private final int first;
	private final int last;

	public IntegerRangeValueImpl(ValueFactory valueFactory, int first, int last) {
		super(valueFactory);
		this.first = first;
		this.last = last;
	}

	public Object asObject() {
		return this;
	}

//		public int getFirst() {
//			return first;
//		}

//		public int getLast() {
//			return last;
//		}

//		@Override
    public int size() {
		return last - first + 1;
	}

//		@Override
    public Integer get(int index) {
		if (index < 0 || index >= size()) {
			String message = OCLMessages.bind(
					OCLMessages.IndexOutOfRange_ERROR_,
					new Object[] {
							Integer.toString(index),
							Integer.toString(first),
							Integer.toString(last)});
			IllegalArgumentException error = new IllegalArgumentException(
				message);
			PivotPlugin.throwing(getClass(), "get", error);//$NON-NLS-1$
			throw error;
		}
		return new Integer(first + index);
	}

    public Type getType(StandardLibrary standardLibrary, Type staticType) {
		return (first >= 0) && (last >= 0) ? standardLibrary.getUnlimitedNaturalType() : standardLibrary.getIntegerType();
	}

	//		@Override
    public java.util.Iterator<Integer> iterator() {
		// local iterator class that provides
		// hasNext() and next() methods appropriate
		// for this range set
		class IntegerRangeIterator
			implements java.util.Iterator<Integer> {

			public IntegerRangeIterator() {
				curr = first;
				initialized = false;
			}

			public Integer next() {
				if (!initialized) {
					curr = first - 1;
					initialized = true;
				}
				if (hasNext()) {
                    return new Integer(++curr);
                }
				throw new NoSuchElementException();
			}

			public boolean hasNext() {
				return curr < last;
			}

			public void remove() {
				throw new UnsupportedOperationException();
			}

			private int curr;

			private boolean initialized;
		}

		return new IntegerRangeIterator();
	}
}