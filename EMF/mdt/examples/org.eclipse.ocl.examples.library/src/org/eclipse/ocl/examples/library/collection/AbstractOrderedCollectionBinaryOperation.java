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
 * $Id: AbstractOrderedCollectionBinaryOperation.java,v 1.2 2011/01/24 19:56:30 ewillink Exp $
 */
package org.eclipse.ocl.examples.library.collection;

import org.eclipse.ocl.examples.library.AbstractBinaryOperation;
import org.eclipse.ocl.examples.pivot.values.OrderedCollectionValue;
import org.eclipse.ocl.examples.pivot.values.Value;
import org.eclipse.ocl.examples.pivot.values.ValueFactory;

/**
 * AbstractOrderedCollectionBinaryOperation provides the standard null to Bag{}
 * conversion for all binary ordered collection operations.
 * 
 * @since 3.1
 */
public abstract class AbstractOrderedCollectionBinaryOperation extends AbstractBinaryOperation
{
	public Value evaluate(ValueFactory valueFactory, Value left, Value right) {
		OrderedCollectionValue leftOrderedCollectionValue = left.asOrderedCollectionValue();
		if (leftOrderedCollectionValue == null) {
			return null;
		}
		if (right.isInvalid()) {
			return null;
		}		
		return evaluateCollection(valueFactory, leftOrderedCollectionValue, right);
	}

	protected abstract Value evaluateCollection(ValueFactory valueFactory, OrderedCollectionValue sourceVal, Value argVal);
}
