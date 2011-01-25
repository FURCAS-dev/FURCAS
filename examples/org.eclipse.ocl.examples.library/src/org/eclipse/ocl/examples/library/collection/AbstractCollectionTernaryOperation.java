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
 * $Id: AbstractCollectionTernaryOperation.java,v 1.2 2011/01/24 19:56:31 ewillink Exp $
 */
package org.eclipse.ocl.examples.library.collection;

import org.eclipse.ocl.examples.library.AbstractTernaryOperation;
import org.eclipse.ocl.examples.pivot.values.CollectionValue;
import org.eclipse.ocl.examples.pivot.values.Value;
import org.eclipse.ocl.examples.pivot.values.ValueFactory;

/**
 * AbstractCollectionTernaryOperation provides the standard null to Bag{}
 * conversion for all ternary collection operations.
 * 
 * @since 3.1
 */
public abstract class AbstractCollectionTernaryOperation extends AbstractTernaryOperation
{
	public Value evaluate(ValueFactory valueFactory, Value source, Value arg1, Value arg2) {
		if (source.isInvalid() || arg1.isInvalid() || arg2.isInvalid()) {
			return null;
		}		
		if (source.isNull()) {
			return evaluateCollection(valueFactory, valueFactory.createSetValue(), arg1, arg2);
		}
		CollectionValue collectionValue = source.asCollectionValue();
		if (collectionValue != null) {
			return evaluateCollection(valueFactory, collectionValue, arg1, arg2);
		}
		else {
			return evaluateCollection(valueFactory, valueFactory.createSetValue(source), arg1, arg2);
		}
	}
	
	protected abstract Value evaluateCollection(ValueFactory valueFactory, CollectionValue sourceVal, Value argVal1, Object argVal2);
}
