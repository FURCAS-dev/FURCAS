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
 * $Id: ConstrainedOperation.java,v 1.1 2011/04/27 06:19:59 ewillink Exp $
 */
package org.eclipse.ocl.examples.pivot.library;

import java.util.List;

import org.eclipse.ocl.examples.pivot.CallExp;
import org.eclipse.ocl.examples.pivot.ExpressionInOcl;
import org.eclipse.ocl.examples.pivot.OclExpression;
import org.eclipse.ocl.examples.pivot.OperationCallExp;
import org.eclipse.ocl.examples.pivot.Variable;
import org.eclipse.ocl.examples.pivot.evaluation.EvaluationEnvironment;
import org.eclipse.ocl.examples.pivot.evaluation.EvaluationVisitor;
import org.eclipse.ocl.examples.pivot.values.Value;

/**
 * An instance of ConstrainedOperation supports evaluation of
 * an operation defined by constraints.
 */
public class ConstrainedOperation extends AbstractCallableImplementation
{
	protected final ExpressionInOcl expressionInOcl;
	
	public ConstrainedOperation(ExpressionInOcl expressionInOcl) {
		this.expressionInOcl = expressionInOcl;
	}

	public Value evaluate(EvaluationVisitor evaluationVisitor, Value sourceValue, CallExp callExp) {
		EvaluationVisitor nestedVisitor = evaluationVisitor.createNestedVisitor();
		EvaluationEnvironment nestedEvaluationEnvironment = nestedVisitor.getEvaluationEnvironment();
		nestedEvaluationEnvironment.add(expressionInOcl.getContextVariable(), sourceValue);
		List<Variable> parameters = expressionInOcl.getParameterVariables();
		if (!parameters.isEmpty()) {
			List<OclExpression> arguments = ((OperationCallExp)callExp).getArguments();
			for (int i = 0; i < parameters.size(); i++) {
				OclExpression argument = arguments.get(i);
				Value value = argument.accept(evaluationVisitor);
				nestedEvaluationEnvironment.add(parameters.get(i).getRepresentedParameter(), value);
			}
		}
		return expressionInOcl.accept(nestedVisitor);
	}
}