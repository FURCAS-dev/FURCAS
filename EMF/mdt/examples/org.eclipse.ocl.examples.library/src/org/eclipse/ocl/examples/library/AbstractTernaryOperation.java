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
 * $Id: AbstractTernaryOperation.java,v 1.2 2011/01/24 19:56:31 ewillink Exp $
 */
package org.eclipse.ocl.examples.library;

import org.eclipse.ocl.examples.pivot.OperationCallExp;
import org.eclipse.ocl.examples.pivot.evaluation.EvaluationVisitor;
import org.eclipse.ocl.examples.pivot.values.Value;

/**
 * AbstractBinaryOperation dispatches a binary library operation to
 * matching-type-specific call-backs.
 * 
 * @since 3.1
 */
public abstract class AbstractTernaryOperation extends AbstractOperation implements LibraryTernaryOperation
{
	public Value evaluate(EvaluationVisitor evaluationVisitor, Value sourceVal, OperationCallExp operationCall) {
		if (sourceVal.isInvalid()) {
			return null;
		}
		Value argVal1 = evaluateArgument(evaluationVisitor, operationCall, 0);
		if (argVal1.isInvalid()) {
			return null;
		}
		Value argVal2 = evaluateArgument(evaluationVisitor, operationCall, 1);
		if (argVal2.isInvalid()) {
			return null;
		}
		return evaluate(evaluationVisitor.getValueFactory(), sourceVal, argVal1, argVal2);
	}
}
