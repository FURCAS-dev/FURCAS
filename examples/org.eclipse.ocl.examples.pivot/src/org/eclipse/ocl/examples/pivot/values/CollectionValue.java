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
 * $Id: CollectionValue.java,v 1.2 2011/01/24 20:47:51 ewillink Exp $
 */
package org.eclipse.ocl.examples.pivot.values;

import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.eclipse.ocl.examples.pivot.CollectionKind;
import org.eclipse.ocl.examples.pivot.TupleType;

public interface CollectionValue extends Value, Iterable<Value>
{
	interface Accumulator extends CollectionValue {
		boolean add(Value value);	
	}

	Collection<Value> asCollection();	
	List<Value> asList();
    IntegerValue count(Value value);
    CollectionValue createNew();
	BooleanValue excludes(Value value);	
	BooleanValue excludesAll(CollectionValue c);
	CollectionValue excluding(Value value);
    CollectionValue flatten();
	boolean flatten(Collection<Value> flattenedElements);
	CollectionKind getKind();
    BooleanValue includes(Value value);	
    BooleanValue includesAll(CollectionValue c);
	CollectionValue including(Value value);
	CollectionValue intersection(CollectionValue c);
	BooleanValue isEmpty();
	Iterator<Value> iterator();
	Value maxMin(BinaryOperation binaryOperation);
	BooleanValue notEmpty();
	Set<TupleValue> product(CollectionValue c, TupleType tupleType);   	
	IntegerValue size();
    OrderedCollectionValue sort(Comparator<Value> comparator);
	Value sum(BinaryOperation binaryOperation, Value zero);
	OrderedCollectionValue toOrderedCollectionValue();
    CollectionValue union(CollectionValue c);
}
