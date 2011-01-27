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
 * $Id: JavaLessThanOperation.java,v 1.2 2011/01/24 20:42:33 ewillink Exp $
 */
package org.eclipse.ocl.examples.pivot.library;

import java.lang.reflect.Method;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.ocl.examples.pivot.CallExp;
import org.eclipse.ocl.examples.pivot.OclExpression;
import org.eclipse.ocl.examples.pivot.OperationCallExp;
import org.eclipse.ocl.examples.pivot.evaluation.CallableImplementation;
import org.eclipse.ocl.examples.pivot.evaluation.EvaluationVisitor;
import org.eclipse.ocl.examples.pivot.utilities.TypeManager;
import org.eclipse.ocl.examples.pivot.values.Value;
import org.eclipse.ocl.examples.pivot.values.ValueFactory;

public class JavaLessThanOperation implements CallableImplementation, Value.BinaryOperation
{
	protected final Method method;
	
	public JavaLessThanOperation(Method method) {
		this.method = method;
	}

	public Value evaluate(EvaluationVisitor evaluationVisitor, Value sourceValue, CallExp callExp) {
		OperationCallExp operationCall = (OperationCallExp) callExp;
		OclExpression arg = operationCall.getArguments().get(0);
		Value argVal = arg.accept(evaluationVisitor);
		return evaluate(evaluationVisitor.getValueFactory(), sourceValue, argVal);
	}

	public Value evaluate(ValueFactory valueFactory, Value leftValue, Value rightValue) {
		Object leftObject = leftValue.asObject();
		Object rightObject = rightValue.asObject();
		try {
			Object result = method.invoke(leftObject, rightObject);
			if (!(result instanceof Integer)) {
				return valueFactory.createInvalidValue("non-integer return");
			}
			return valueFactory.booleanValueOf(((Integer)result).intValue() < 0);
		} catch (Exception e) {
			return valueFactory.createInvalidValue(method, null, "Evaluation failure", e);
		}
	}

	public Diagnostic validate(TypeManager typeManager, CallExp callExp) {
		return null;
	}
	
}