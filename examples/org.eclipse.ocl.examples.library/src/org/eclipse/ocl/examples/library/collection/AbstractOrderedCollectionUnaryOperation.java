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
 * $Id: AbstractOrderedCollectionUnaryOperation.java,v 1.2 2011/01/24 19:56:30 ewillink Exp $
 */
package org.eclipse.ocl.examples.library.collection;

import org.eclipse.ocl.examples.library.AbstractUnaryOperation;
import org.eclipse.ocl.examples.pivot.values.OrderedCollectionValue;
import org.eclipse.ocl.examples.pivot.values.Value;
import org.eclipse.ocl.examples.pivot.values.ValueFactory;

/**
 * AbstractOrderedCollectionUnaryOperation provides the standard null to Bag{}
 * conversion for all unary ordered collection operations.
 * 
 * @since 3.1
 */
public abstract class AbstractOrderedCollectionUnaryOperation extends AbstractUnaryOperation
{
	public Value evaluate(ValueFactory valueFactory, Value argument) {
		OrderedCollectionValue orderedCollectionValue = argument.asOrderedCollectionValue();
		if (orderedCollectionValue == null) {
			return null;
		}
		return evaluateCollection(orderedCollectionValue);
	}
	
	protected abstract Value evaluateCollection(OrderedCollectionValue sourceVal);
}
