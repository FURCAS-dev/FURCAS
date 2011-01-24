/**
 * <copyright>
 *
 * Copyright (c) 2009,2010 E.D.Willink and others.
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
 * $Id: OrderedSetSubOrderedSetOperation.java,v 1.2 2011/01/24 19:56:31 ewillink Exp $
 */
package org.eclipse.ocl.examples.library.collection;

import org.eclipse.ocl.examples.pivot.values.OrderedCollectionValue;
import org.eclipse.ocl.examples.pivot.values.OrderedSetValue;
import org.eclipse.ocl.examples.pivot.values.Value;
import org.eclipse.ocl.examples.pivot.values.ValueFactory;

/**
 * OrderedSetSubOrderedSetOperation realises the OrderedSet::subOrderedSet() library operation.
 * 
 * @since 3.1
 */
public class OrderedSetSubOrderedSetOperation extends AbstractOrderedCollectionTernaryOperation
{
	public static final OrderedSetSubOrderedSetOperation INSTANCE = new OrderedSetSubOrderedSetOperation();

	@Override
	protected Value evaluateCollection(ValueFactory valueFactory, OrderedCollectionValue sourceVal, Value argVal1, Value argVal2) {
		OrderedSetValue selfValue = sourceVal.asOrderedSetValue();
		if (selfValue == null) {
			return valueFactory.createInvalidValue(sourceVal, null, "suborderedset self", null);
		}
		Integer fromValue = argVal1.asInteger();
		if (fromValue == null) {
			return valueFactory.createInvalidValue(argVal1, null, "suborderedset from", null);
		}
		Integer toValue = argVal2.asInteger();
		if (toValue == null) {
			return valueFactory.createInvalidValue(argVal2, null, "suborderedset to", null);
		}
		return selfValue.subOrderedSet(fromValue, toValue);
	}
}
