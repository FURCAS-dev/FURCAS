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
 * $Id: CollectionMaxOperation.java,v 1.2 2011/01/24 19:56:30 ewillink Exp $
 */
package org.eclipse.ocl.examples.library.collection;

import org.eclipse.ocl.examples.library.AbstractOperation;
import org.eclipse.ocl.examples.library.numeric.NumericMaxOperation;
import org.eclipse.ocl.examples.pivot.OperationCallExp;
import org.eclipse.ocl.examples.pivot.evaluation.EvaluationVisitor;
import org.eclipse.ocl.examples.pivot.values.CollectionValue;
import org.eclipse.ocl.examples.pivot.values.Value;

/**
 * CollectionMaxOperation realises the Collection::max() library operation.
 * 
 * @since 3.1
 */
public class CollectionMaxOperation extends AbstractOperation
{
	public static final CollectionMaxOperation INSTANCE = new CollectionMaxOperation();

	public Value evaluate(EvaluationVisitor evaluationVisitor, Value sourceVal, OperationCallExp operationCall) {
		CollectionValue collectionValue = sourceVal.asCollectionValue();
		if (collectionValue != null) {
			// FIXME Bug 301351 Look for user-defined max
			return collectionValue.maxMin(NumericMaxOperation.INSTANCE);
		}
		else {
			return evaluationVisitor.getValueFactory().createInvalidValue(sourceVal, operationCall, "non-collection source for max", null);
		}
	}
}
