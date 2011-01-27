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
 * $Id: SequenceSubSequenceOperation.java,v 1.2 2011/01/24 19:56:31 ewillink Exp $
 */
package org.eclipse.ocl.examples.library.collection;

import org.eclipse.ocl.examples.pivot.values.OrderedCollectionValue;
import org.eclipse.ocl.examples.pivot.values.SequenceValue;
import org.eclipse.ocl.examples.pivot.values.Value;
import org.eclipse.ocl.examples.pivot.values.ValueFactory;

/**
 * SequenceSubSequenceOperation realises the OrderedSet::subSequence() library operation.
 * 
 * @since 3.1
 */
public class SequenceSubSequenceOperation extends AbstractOrderedCollectionTernaryOperation
{
	public static final SequenceSubSequenceOperation INSTANCE = new SequenceSubSequenceOperation();

	@Override
	protected Value evaluateCollection(ValueFactory valueFactory, OrderedCollectionValue sourceVal, Value argVal1, Value argVal2) {
		SequenceValue selfValue = sourceVal.asSequenceValue();
		if (selfValue == null) {
			return valueFactory.createInvalidValue(sourceVal, null, "subsequence self", null);
		}
		Integer fromValue = argVal1.asInteger();
		if (fromValue == null) {
			return valueFactory.createInvalidValue(argVal1, null, "subsequence from", null);
		}
		Integer toValue = argVal2.asInteger();
		if (toValue == null) {
			return valueFactory.createInvalidValue(argVal2, null, "subsequence to", null);
		}
		return selfValue.subSequence(fromValue, toValue);
	}
}
