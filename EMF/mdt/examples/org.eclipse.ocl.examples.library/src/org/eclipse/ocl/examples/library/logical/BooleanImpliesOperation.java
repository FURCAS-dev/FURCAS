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
 * $Id: BooleanImpliesOperation.java,v 1.3 2011/02/21 08:37:47 ewillink Exp $
 */
package org.eclipse.ocl.examples.library.logical;

import org.eclipse.ocl.examples.library.AbstractBinaryOperation;
import org.eclipse.ocl.examples.pivot.InvalidValueException;
import org.eclipse.ocl.examples.pivot.OperationCallExp;
import org.eclipse.ocl.examples.pivot.evaluation.EvaluationVisitor;
import org.eclipse.ocl.examples.pivot.values.BooleanValue;
import org.eclipse.ocl.examples.pivot.values.Value;
import org.eclipse.ocl.examples.pivot.values.ValueFactory;

/**
 * ImpliesOperation realises the implies() library operation.
 * 
 * @since 3.1
 */
public class BooleanImpliesOperation extends AbstractBinaryOperation
{
	public static final BooleanImpliesOperation INSTANCE = new BooleanImpliesOperation();

	@Override
	public BooleanValue evaluate(EvaluationVisitor evaluationVisitor, Value sourceVal, OperationCallExp operationCall) throws InvalidValueException {
		ValueFactory valueFactory = evaluationVisitor.getValueFactory();
		if (sourceVal.isFalse()) {
			return valueFactory.getTrue();
		}
		Value argVal = evaluateArgument(evaluationVisitor, operationCall, 0);
		return evaluate(valueFactory, sourceVal, argVal);
	}

	public BooleanValue evaluate(ValueFactory valueFactory, Value left, Value right) throws InvalidValueException {
		if (left.isFalse()) {
			return valueFactory.getTrue();
		}
		else if (right.isTrue()) {
			return valueFactory.getTrue();
		}
		else {
			return valueFactory.booleanValueOf(!left.asBoolean() || right.asBoolean());
		}
	}
}
