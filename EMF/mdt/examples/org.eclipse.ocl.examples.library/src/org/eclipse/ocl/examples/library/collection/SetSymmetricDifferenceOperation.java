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
 * $Id: SetSymmetricDifferenceOperation.java,v 1.2 2011/01/24 19:56:31 ewillink Exp $
 */
package org.eclipse.ocl.examples.library.collection;

import org.eclipse.ocl.examples.pivot.values.CollectionValue;
import org.eclipse.ocl.examples.pivot.values.UniqueCollectionValue;
import org.eclipse.ocl.examples.pivot.values.Value;
import org.eclipse.ocl.examples.pivot.values.ValueFactory;

/**
 * SetSymmetricDifferenceOperation realises the Set::symmetricDifference() library operation.
 * 
 * @since 3.1
 */
public class SetSymmetricDifferenceOperation extends AbstractCollectionPairedOperation
{
	public static final SetSymmetricDifferenceOperation INSTANCE = new SetSymmetricDifferenceOperation();

	@Override
	protected Value evaluateCollection(ValueFactory valueFactory, CollectionValue sourceVal, CollectionValue argVal) {
		UniqueCollectionValue leftValue = sourceVal.asUniqueCollectionValue();
		if (leftValue == null) {
			return valueFactory.createInvalidValue(sourceVal, null, "non-unique-collection 'symmetricDifference' source", null);
		}
		UniqueCollectionValue rightValue = argVal.asUniqueCollectionValue();
		if (rightValue == null) {
			return valueFactory.createInvalidValue(sourceVal, null, "non-unique-collection 'symmetricDifference' argument", null);
		}
		return leftValue.symmetricDifference(rightValue);
	}
}
