/**
 * <copyright>
 *
 * Copyright (c) 2009,2011 E.D.Willink and others.
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
 * $Id: OrderedCollectionInsertAtOperation.java,v 1.3 2011/02/21 08:37:46 ewillink Exp $
 */
package org.eclipse.ocl.examples.library.collection;

import org.eclipse.ocl.examples.library.AbstractTernaryOperation;
import org.eclipse.ocl.examples.pivot.InvalidValueException;
import org.eclipse.ocl.examples.pivot.values.OrderedCollectionValue;
import org.eclipse.ocl.examples.pivot.values.Value;
import org.eclipse.ocl.examples.pivot.values.ValueFactory;

/**
 * OrderedCollectionInsertAtOperation realises the OrderedCollection::insertAt() library operation.
 * 
 * @since 3.1
 */
public class OrderedCollectionInsertAtOperation extends AbstractTernaryOperation
{
	public static final OrderedCollectionInsertAtOperation INSTANCE = new OrderedCollectionInsertAtOperation();

	public Value evaluate(ValueFactory valueFactory, Value source, Value arg1, Value arg2) throws InvalidValueException {
		OrderedCollectionValue selfValue = source.asOrderedCollectionValue();
		Integer indexValue = arg1.asInteger();
		Value insertValue = arg2.asValidValue();
		return selfValue.insertAt(indexValue, insertValue);
	}
}
