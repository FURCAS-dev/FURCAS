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
 * $Id: CollectionIsEmptyOperation.java,v 1.3 2011/02/21 08:37:46 ewillink Exp $
 */
package org.eclipse.ocl.examples.library.collection;

import org.eclipse.ocl.examples.library.AbstractUnaryOperation;
import org.eclipse.ocl.examples.pivot.InvalidValueException;
import org.eclipse.ocl.examples.pivot.values.CollectionValue;
import org.eclipse.ocl.examples.pivot.values.Value;
import org.eclipse.ocl.examples.pivot.values.ValueFactory;

/**
 * CollectionIsEmptyOperation realises the Collection::isEmpty() library operation.
 * 
 * @since 3.1
 */
public class CollectionIsEmptyOperation extends AbstractUnaryOperation
{
	public static final CollectionIsEmptyOperation INSTANCE = new CollectionIsEmptyOperation();

	public Value evaluate(ValueFactory valueFactory, Value argument) throws InvalidValueException {
		CollectionValue collectionValue = argument.asCollectionValue();
		return collectionValue.isEmpty();
	}
}
