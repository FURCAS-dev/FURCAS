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
 * $Id: UnimplementedOperation.java,v 1.1 2011/04/27 06:19:59 ewillink Exp $
 */
package org.eclipse.ocl.examples.pivot.library;

import org.eclipse.ocl.examples.pivot.CallExp;
import org.eclipse.ocl.examples.pivot.Operation;
import org.eclipse.ocl.examples.pivot.OperationCallExp;
import org.eclipse.ocl.examples.pivot.evaluation.EvaluationVisitor;
import org.eclipse.ocl.examples.pivot.values.Value;

/**
 * The static instance of UnimplementedOperation supports evaluation of
 * an operation that has not been implemented.
 */
public class UnimplementedOperation extends AbstractCallableImplementation
{
	public static final UnimplementedOperation INSTANCE = new UnimplementedOperation();

	public Value evaluate(EvaluationVisitor evaluationVisitor, Value sourceValue, CallExp callExp) {
		OperationCallExp operationCall = (OperationCallExp) callExp;
		Operation operation = operationCall.getReferredOperation();
		return evaluationVisitor.throwInvalidEvaluation("No implementation for '" + operation + "'", null, callExp, null);
	}
}