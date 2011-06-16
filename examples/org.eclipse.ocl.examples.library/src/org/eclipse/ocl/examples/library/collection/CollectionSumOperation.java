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
 * $Id: CollectionSumOperation.java,v 1.3 2011/02/21 08:37:46 ewillink Exp $
 */
package org.eclipse.ocl.examples.library.collection;

import org.eclipse.ocl.examples.library.AbstractOperation;
import org.eclipse.ocl.examples.library.integer.IntegerPlusOperation;
import org.eclipse.ocl.examples.library.real.RealPlusOperation;
import org.eclipse.ocl.examples.pivot.InvalidValueException;
import org.eclipse.ocl.examples.pivot.OperationCallExp;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.evaluation.EvaluationVisitor;
import org.eclipse.ocl.examples.pivot.utilities.TypeManager;
import org.eclipse.ocl.examples.pivot.values.CollectionValue;
import org.eclipse.ocl.examples.pivot.values.Value;
import org.eclipse.ocl.examples.pivot.values.ValueFactory;

/**
 * CollectionSumOperation realises the Collection::sum() library operation.
 * 
 * @since 3.1
 */
public class CollectionSumOperation extends AbstractOperation
{
	public static final CollectionSumOperation INSTANCE = new CollectionSumOperation();

	public Value evaluate(EvaluationVisitor evaluationVisitor, Value sourceVal, OperationCallExp operationCall) throws InvalidValueException {
		CollectionValue collectionValue = sourceVal.asCollectionValue();
		TypeManager typeManager = evaluationVisitor.getTypeManager();
		ValueFactory valueFactory = typeManager.getValueFactory();
		// FIXME Bug 301351 Look for user-defined zero
		Type resultType = operationCall.getType();
//		resultType.getZero();
		if (typeManager.conformsTo(resultType, typeManager.getIntegerType(), null)) {
			return collectionValue.sum(IntegerPlusOperation.INSTANCE, valueFactory.integerValueOf(0));
		}
		else {
			return collectionValue.sum(RealPlusOperation.INSTANCE, valueFactory.realValueOf(0.0));
		}
	}
}
