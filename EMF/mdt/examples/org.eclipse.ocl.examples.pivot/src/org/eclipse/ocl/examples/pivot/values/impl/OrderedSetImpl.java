/**
 * <copyright>
 *
 * Copyright (c) 2010 E.D.Willink and others.
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
 * $Id: OrderedSetImpl.java,v 1.2 2011/01/24 20:47:51 ewillink Exp $
 */
package org.eclipse.ocl.examples.pivot.values.impl;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;

import org.eclipse.ocl.examples.pivot.values.OrderedSet;

/**
 * Default implementation of the {@link OrderedSet} interface.
 */
public class OrderedSetImpl<E> extends LinkedHashSet<E> implements OrderedSet<E>
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 3297491641047187175L;

	public OrderedSetImpl() {
		super();
	}

	public OrderedSetImpl(Collection<? extends E> elements) {
		super(elements);
	}

	@Override
	public boolean equals(Object o) {
		// This is probably a bug fix on LinkedHashSet that should consider ordering for equals
		if (o == this) {
		    return true;
		}
		if (!(o instanceof OrderedSet)) {
		    return false;
		}
		OrderedSet<?> that = (OrderedSet<?>) o;
		if (that.size() != size())
		    return false;
		Iterator<?> thisIterator = this.iterator();
		Iterator<?> thatIterator = that.iterator();
		while (thisIterator.hasNext()) {
			Object thisElement = thisIterator.next();
			Object thatElement = thatIterator.next();
			if (!thisElement.equals(thatElement)) {
				return false;
			}
		}
        return true;
    }
}
