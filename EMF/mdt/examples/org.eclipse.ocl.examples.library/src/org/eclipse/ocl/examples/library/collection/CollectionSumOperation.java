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
 * $Id: CollectionSumOperation.java,v 1.2 2011/01/24 19:56:31 ewillink Exp $
 */
package org.eclipse.ocl.examples.library.collection;

import org.eclipse.ocl.examples.library.AbstractOperation;
import org.eclipse.ocl.examples.library.numeric.NumericPlusOperation;
import org.eclipse.ocl.examples.pivot.OperationCallExp;
import org.eclipse.ocl.examples.pivot.evaluation.EvaluationVisitor;
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

	public Value evaluate(EvaluationVisitor evaluationVisitor, Value sourceVal, OperationCallExp operationCall) {
		CollectionValue collectionValue = sourceVal.asCollectionValue();
		ValueFactory valueFactory = evaluationVisitor.getValueFactory();
		if (collectionValue != null) {
			// FIXME Bug 301351 Look for user-defined zero
//			Type resultType = operationCall.getType();	
//			resultType.getZero();
			return collectionValue.sum(NumericPlusOperation.INSTANCE, valueFactory.getZero());
		}
		else {
			return valueFactory.createInvalidValue(sourceVal, null, "non-collection", null);
		}
	}
}
