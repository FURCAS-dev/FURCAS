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
 * $Id: SetMinusOperation.java,v 1.3 2011/02/21 08:37:46 ewillink Exp $
 */
package org.eclipse.ocl.examples.library.collection;

import org.eclipse.ocl.examples.library.AbstractBinaryOperation;
import org.eclipse.ocl.examples.pivot.InvalidValueException;
import org.eclipse.ocl.examples.pivot.values.UniqueCollectionValue;
import org.eclipse.ocl.examples.pivot.values.Value;
import org.eclipse.ocl.examples.pivot.values.ValueFactory;

/**
 * SetMinusOperation realises the Set::-() library operation.
 * 
 * @since 3.1
 */
public class SetMinusOperation extends AbstractBinaryOperation
{
	public static final SetMinusOperation INSTANCE = new SetMinusOperation();

	public Value evaluate(ValueFactory valueFactory, Value left, Value right) throws InvalidValueException {
		UniqueCollectionValue leftValue = left.asUniqueCollectionValue();
		UniqueCollectionValue rightValue = right.asUniqueCollectionValue();
		return leftValue.minus(rightValue);
	}
}
