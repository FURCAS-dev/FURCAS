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
 * $Id: ClosureIteration.java,v 1.5 2011/02/21 08:37:47 ewillink Exp $
 */
package org.eclipse.ocl.examples.library.iterator;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.ocl.examples.library.AbstractIteration;
import org.eclipse.ocl.examples.library.IterationManager;
import org.eclipse.ocl.examples.library.ValidationWarning;
import org.eclipse.ocl.examples.pivot.CallExp;
import org.eclipse.ocl.examples.pivot.CollectionType;
import org.eclipse.ocl.examples.pivot.InvalidValueException;
import org.eclipse.ocl.examples.pivot.IteratorExp;
import org.eclipse.ocl.examples.pivot.LoopExp;
import org.eclipse.ocl.examples.pivot.ParameterableElement;
import org.eclipse.ocl.examples.pivot.TemplateParameter;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.evaluation.EvaluationVisitor;
import org.eclipse.ocl.examples.pivot.messages.OCLMessages;
import org.eclipse.ocl.examples.pivot.utilities.TypeManager;
import org.eclipse.ocl.examples.pivot.values.CollectionValue;
import org.eclipse.ocl.examples.pivot.values.Value;
import org.eclipse.ocl.examples.pivot.values.ValueFactory;

/**
 * ClosureIteration realizes the Collection::closure() library iteration.
 * 
 * @since 3.1
 */
public class ClosureIteration extends AbstractIteration<CollectionValue.Accumulator>
{
	public static final ClosureIteration INSTANCE = new ClosureIteration();

	public Value evaluate(EvaluationVisitor evaluationVisitor, CollectionValue sourceVal, LoopExp iteratorExp) {
		ValueFactory valueFactory = evaluationVisitor.getValueFactory();
		TypeManager typeManager = evaluationVisitor.getTypeManager();
		Type sourceType = iteratorExp.getSource().getType();
		boolean isOrdered = typeManager.isOrdered(sourceType);
		CollectionValue.Accumulator accumulatorValue = createAccumulationValue(valueFactory, isOrdered, true);
		return evaluateIteration(new IterationManager<CollectionValue.Accumulator>(evaluationVisitor,
				iteratorExp, sourceVal, accumulatorValue));
	}

	/**
	 * Recursively evaluates the iterator body expression.
	 */
    protected Value updateAccumulator(IterationManager<CollectionValue.Accumulator> iterationManager) {
		CollectionValue.Accumulator accumulatorValue = iterationManager.getAccumulatorValue();
		if (!iterationManager.isOuterIteration()) {
			// If there is the parent is the iterator
			Value value = iterationManager.get(0);
			if (!accumulatorValue.add(value)) {
				return accumulatorValue;
			}
		}
		Value bodyVal = iterationManager.getBodyValue();		
		if (bodyVal.isInvalid()) {
			return bodyVal;									// Invalid body is invalid
		}
		else if (bodyVal.isUndefined()) {
			return accumulatorValue;						// Null body is termination
		}
		else {
			try {
				evaluateIteration(new IterationManager<CollectionValue.Accumulator>(iterationManager, bodyVal));
			} catch (InvalidValueException e) {
				iterationManager.throwInvalidEvaluation(e);
			}
			return null;
		}
	}

	@Override
	public Diagnostic validate(TypeManager typeManager, CallExp callExp) {
		Type bodyType = ((IteratorExp)callExp).getBody().getType();
		if (bodyType instanceof CollectionType) {
			bodyType = ((CollectionType)bodyType).getElementType();
		}
		Type iteratorType = ((IteratorExp)callExp).getIterators().get(0).getType();
		Map<TemplateParameter, ParameterableElement> bindings = new HashMap<TemplateParameter, ParameterableElement>();
		if (!typeManager.conformsTo(bodyType, iteratorType, bindings)) {
			return new ValidationWarning(OCLMessages.WarningNonConformingBodyType, bodyType, iteratorType);
		}
		return null;
	}
}
