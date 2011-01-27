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
 * $Id: CollectionProductOperation.java,v 1.2 2011/01/24 19:56:31 ewillink Exp $
 */
package org.eclipse.ocl.examples.library.collection;

import java.util.Set;

import org.eclipse.ocl.examples.library.AbstractOperation;
import org.eclipse.ocl.examples.pivot.CollectionType;
import org.eclipse.ocl.examples.pivot.OperationCallExp;
import org.eclipse.ocl.examples.pivot.TupleType;
import org.eclipse.ocl.examples.pivot.evaluation.EvaluationVisitor;
import org.eclipse.ocl.examples.pivot.values.CollectionValue;
import org.eclipse.ocl.examples.pivot.values.TupleValue;
import org.eclipse.ocl.examples.pivot.values.Value;
import org.eclipse.ocl.examples.pivot.values.ValueFactory;

/**
 * CollectionProductOperation realises the Collection::product() library operation.
 * 
 * @since 3.1
 */
public class CollectionProductOperation extends AbstractOperation // FIXME Make this an AbstractBinaryOperation
{
	public static final CollectionProductOperation INSTANCE = new CollectionProductOperation();

	public Value evaluate(EvaluationVisitor evaluationVisitor, Value sourceVal, OperationCallExp operationCall) {
		ValueFactory valueFactory = evaluationVisitor.getValueFactory();
		if (sourceVal.isUndefined()) {
			return valueFactory.createInvalidValue(sourceVal, operationCall, "Undefined source", null);
		}
		CollectionValue sourceValue = sourceVal.asCollectionValue();
		if (sourceValue == null) {
//			sourceValue = createSetValue(sourceVal);
			return valueFactory.createInvalidValue(sourceVal, operationCall, "Non-collection source", null);
		}
		Value argVal = evaluateArgument(evaluationVisitor, operationCall, 0);
		if (argVal.isUndefined()) {
			return valueFactory.createInvalidValue(argVal, operationCall, "Undefined argument", null);
		}		
		CollectionValue argumentValue = argVal.asCollectionValue();
		if (argumentValue == null) {
			return valueFactory.createInvalidValue(argVal, operationCall, "Non-collection argumrnt", null);
		}
		CollectionType collType = (CollectionType) operationCall.getType();
		TupleType tupleType = (TupleType) collType.getElementType();
		Set<TupleValue> product = sourceValue.product(argumentValue, tupleType);
        return valueFactory.createSetValue(product);
	}
}
