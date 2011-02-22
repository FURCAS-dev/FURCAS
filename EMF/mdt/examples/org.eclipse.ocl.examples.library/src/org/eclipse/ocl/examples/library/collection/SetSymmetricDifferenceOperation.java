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
 * $Id: SetSymmetricDifferenceOperation.java,v 1.3 2011/02/21 08:37:46 ewillink Exp $
 */
package org.eclipse.ocl.examples.library.collection;

import org.eclipse.ocl.examples.library.AbstractBinaryOperation;
import org.eclipse.ocl.examples.pivot.InvalidValueException;
import org.eclipse.ocl.examples.pivot.values.UniqueCollectionValue;
import org.eclipse.ocl.examples.pivot.values.Value;
import org.eclipse.ocl.examples.pivot.values.ValueFactory;

/**
 * SetSymmetricDifferenceOperation realises the Set::symmetricDifference() library operation.
 * 
 * @since 3.1
 */
public class SetSymmetricDifferenceOperation extends AbstractBinaryOperation
{
	public static final SetSymmetricDifferenceOperation INSTANCE = new SetSymmetricDifferenceOperation();

	public Value evaluate(ValueFactory valueFactory, Value left, Value right) throws InvalidValueException {
		UniqueCollectionValue leftValue = left.asUniqueCollectionValue();
		UniqueCollectionValue rightValue = right.asUniqueCollectionValue();
		return leftValue.symmetricDifference(rightValue);
	}
}
