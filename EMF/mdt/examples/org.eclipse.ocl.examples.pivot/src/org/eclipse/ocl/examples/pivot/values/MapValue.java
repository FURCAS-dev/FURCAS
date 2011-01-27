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
 * $Id: MapValue.java,v 1.2 2011/01/24 20:47:51 ewillink Exp $
 */
package org.eclipse.ocl.examples.pivot.values;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public interface MapValue extends Value, Iterable<Value>
{
	interface Accumulator extends MapValue {
		boolean put(Value value);	
	}

	Collection<Value> asCollection();	
	List<Value> asList();
    int count(Value value);
	boolean excludes(Value value);	
    boolean excludesAll(MapValue c);
	MapValue excluding(Value value);
    MapValue flatten();
	boolean includes(Value value);	
    boolean includesAll(MapValue c);
	MapValue including(Value value);
	boolean isEmpty();
	Iterator<Value> iterator();
//	Value maxMin(LibraryBinaryOperation binaryOperation);
	boolean notEmpty();
    int size();
    MapValue union(MapValue c);
}
