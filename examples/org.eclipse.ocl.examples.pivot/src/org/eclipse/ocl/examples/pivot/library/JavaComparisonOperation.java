/**
 * <copyright>
 *
 * Copyright (c) 2011 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *
 * </copyright>
 *
 * $Id: JavaComparisonOperation.java,v 1.2 2011/02/21 08:37:53 ewillink Exp $
 */
package org.eclipse.ocl.examples.pivot.library;

import java.lang.reflect.Method;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.ocl.examples.pivot.CallExp;
import org.eclipse.ocl.examples.pivot.InvalidValueException;
import org.eclipse.ocl.examples.pivot.OclExpression;
import org.eclipse.ocl.examples.pivot.OperationCallExp;
import org.eclipse.ocl.examples.pivot.evaluation.CallableImplementation;
import org.eclipse.ocl.examples.pivot.evaluation.EvaluationVisitor;
import org.eclipse.ocl.examples.pivot.utilities.TypeManager;
import org.eclipse.ocl.examples.pivot.values.Value;
import org.eclipse.ocl.examples.pivot.values.ValueFactory;

public abstract class JavaComparisonOperation implements CallableImplementation, Value.BinaryOperation
{
	protected final Method method;
	
	public JavaComparisonOperation(Method method) {
		this.method = method;
	}

	public Value evaluate(EvaluationVisitor evaluationVisitor, Value sourceValue, CallExp callExp) {
		OperationCallExp operationCall = (OperationCallExp) callExp;
		OclExpression arg = operationCall.getArguments().get(0);
		Value argVal = arg.accept(evaluationVisitor);
		try {
			return evaluate(evaluationVisitor.getValueFactory(), sourceValue, argVal);
		} catch (InvalidValueException e) {
			return evaluationVisitor.throwInvalidEvaluation(e);
		}
	}

	public Value evaluate(ValueFactory valueFactory, Value leftValue, Value rightValue) throws InvalidValueException {
		Object leftObject = leftValue.asObject();
		Object rightObject = rightValue.asObject();
		try {
			Object result = method.invoke(leftObject, rightObject);
			if (!(result instanceof Integer)) {
				throw new InvalidValueException("non-integer return");
			}
			return valueFactory.booleanValueOf(evaluateComparison((Integer) result));
		} catch (Exception e) {
			throw new InvalidValueException(e);
		}
	}

	protected abstract boolean evaluateComparison(Integer result);

	public Diagnostic validate(TypeManager typeManager, CallExp callExp) {
		return null;
	}
	
}