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
 * $Id: BooleanOrOperation.java,v 1.2 2011/01/24 19:56:32 ewillink Exp $
 */
package org.eclipse.ocl.examples.library.logical;

import org.eclipse.ocl.examples.library.AbstractBinaryOperation;
import org.eclipse.ocl.examples.pivot.OperationCallExp;
import org.eclipse.ocl.examples.pivot.evaluation.EvaluationVisitor;
import org.eclipse.ocl.examples.pivot.values.BooleanValue;
import org.eclipse.ocl.examples.pivot.values.Value;
import org.eclipse.ocl.examples.pivot.values.ValueFactory;

/**
 * OrOperation realises the or() library operation.
 * 
 * @since 3.1
 */
public class BooleanOrOperation extends AbstractBinaryOperation
{
	public static final BooleanOrOperation INSTANCE = new BooleanOrOperation();

	@Override
	public BooleanValue evaluate(EvaluationVisitor evaluationVisitor, Value sourceVal, OperationCallExp operationCall) {
		ValueFactory valueFactory = evaluationVisitor.getValueFactory();
		if (sourceVal == valueFactory.getTrue()) {
			return valueFactory.getTrue();
		}
		Value argVal = evaluateArgument(evaluationVisitor, operationCall, 0);
		return evaluate(valueFactory, sourceVal, argVal);
	}

	public BooleanValue evaluate(ValueFactory valueFactory, Value left, Value right) {
		if (left == valueFactory.getTrue()) {
			return valueFactory.getTrue();
		}
		if (right == valueFactory.getTrue()) {
			return valueFactory.getTrue();
		}
		if ((left == valueFactory.getFalse()) && (right == valueFactory.getFalse())) {
			return valueFactory.getFalse();
		}
		return valueFactory.createInvalidValue("non-Boolean 'or' term");
	}
}
