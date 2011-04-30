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
 * $Id: SortedByIteration.java,v 1.7 2011/04/25 09:48:57 ewillink Exp $
 */
package org.eclipse.ocl.examples.library.iterator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.ocl.examples.library.AbstractIteration;
import org.eclipse.ocl.examples.library.IterationManager;
import org.eclipse.ocl.examples.library.ValidationWarning;
import org.eclipse.ocl.examples.pivot.CallExp;
import org.eclipse.ocl.examples.pivot.InvalidValueException;
import org.eclipse.ocl.examples.pivot.LoopExp;
import org.eclipse.ocl.examples.pivot.OclExpression;
import org.eclipse.ocl.examples.pivot.Operation;
import org.eclipse.ocl.examples.pivot.ParameterableElement;
import org.eclipse.ocl.examples.pivot.TemplateParameter;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.evaluation.CallableImplementation;
import org.eclipse.ocl.examples.pivot.evaluation.EvaluationEnvironment;
import org.eclipse.ocl.examples.pivot.evaluation.EvaluationVisitor;
import org.eclipse.ocl.examples.pivot.messages.OCLMessages;
import org.eclipse.ocl.examples.pivot.utilities.PivotConstants;
import org.eclipse.ocl.examples.pivot.utilities.PivotUtil;
import org.eclipse.ocl.examples.pivot.utilities.TypeManager;
import org.eclipse.ocl.examples.pivot.values.BooleanValue;
import org.eclipse.ocl.examples.pivot.values.CollectionValue;
import org.eclipse.ocl.examples.pivot.values.Value;
import org.eclipse.ocl.examples.pivot.values.Value.BinaryOperation;
import org.eclipse.ocl.examples.pivot.values.impl.AbstractValue;

/**
 * SelectIteration realises the Collection::sortedBy() library iteration.
 * 
 * @since 3.1
 */
public class SortedByIteration extends AbstractIteration<SortedByIteration.SortingValue>
{
	protected static class SortingValue extends AbstractValue implements Comparator<Value>
	{
		private final EvaluationEnvironment evaluationEnvironment;
//		private final Value sourceVal;
		private final Map<Value, Value> content = new HashMap<Value, Value>();	// User object to sortedBy value
		private final LoopExp iteratorExp;
		private final Value.BinaryOperation binaryImplementation;

		public SortingValue(EvaluationEnvironment env, Value sourceVal, LoopExp iteratorExp, Value.BinaryOperation binaryImplementation) {
			super(env.getValueFactory());
			this.evaluationEnvironment = env;
//			this.sourceVal = sourceVal;
			this.iteratorExp = iteratorExp;
			this.binaryImplementation = binaryImplementation;
		}

		public Object asObject() {
			return content;
		}

		public Value asValidValue() {
			return this;
		}
		
		public int compare(Value o1, Value o2) {
			if (o1 == o2) {
				return 0;
			}
			Value v1 = content.get(o1);
			Value v2 = content.get(o2);
			if (v1 == v2) {
				return 0;
			}
			try {
				BooleanValue lessThan = binaryImplementation.evaluate(valueFactory, v1, v2).asBooleanValue();
				if (lessThan.isTrue()) {
					return -1;
				}
				BooleanValue greaterThan = binaryImplementation.evaluate(valueFactory, v2, v1).asBooleanValue();
				if (greaterThan.isTrue()) {
					return 1;
				}
				return 0;
			} catch (InvalidValueException e) {
	//			evaluationEnvironment.throwInvalidEvaluation("'<' evaluation failed", e);
				evaluationEnvironment.throwInvalidEvaluation(e);
				return 0;
			}
		}

		public Value createSortedValue() {
			List<Value> result = new ArrayList<Value>(content.keySet());
	//		try {
				Collections.sort(result, this);
	//		}
	//		catch (WrappedInvalidValueException e) {
//	//			evaluationEnvironment.throwInvalidEvaluation(sourceVal, iteratorExp, "'<' evaluation failed", e);
	//			evaluationEnvironment.throwInvalidEvaluation(e);
	//		}
	//		catch (Exception e) {
	//			evaluationEnvironment.throwInvalidEvaluation(sourceVal, iteratorExp, "'<' evaluation failed", e);
	//		}
			// create result from the sorted collection
			Type sourceType = iteratorExp.getSource().getType();
			boolean isUnique = evaluationEnvironment.getTypeManager().isUnique(sourceType);
			return valueFactory.createCollectionValue(true, isUnique, result);
		}

		public Type getType(TypeManager typeManager, Type staticType) {
			return staticType;
		}

		public void put(Value iterVal, Value comparable) {
			content.put(iterVal, comparable);
		}

		@Override
		public String toString() {
			return content.toString();
		}
	}

	public static final SortedByIteration INSTANCE = new SortedByIteration();

	public Value evaluate(EvaluationVisitor evaluationVisitor, CollectionValue sourceVal, LoopExp iteratorExp) {
		EvaluationEnvironment evaluationEnvironment = evaluationVisitor.getEvaluationEnvironment();
		TypeManager typeManager = evaluationEnvironment.getTypeManager();
		OclExpression body = iteratorExp.getBody();		
		Type staticValueType = PivotUtil.getBehavioralType(body.getType());
//		CompleteType completeStaticValueType = completeManager.getCompleteType(staticValueType);
		Operation staticLessThanOperation = typeManager.resolveOperation(staticValueType, PivotConstants.LESS_THAN_OPERATOR, staticValueType);
		if (staticLessThanOperation == null) {
			return evaluationEnvironment.throwInvalidEvaluation("No '" + PivotConstants.LESS_THAN_OPERATOR + "' operation defined", null, iteratorExp, sourceVal);
		}
//		CompleteOperation staticCompleteOperation = typeManager.getCompleteOperation(staticLessThanOperation);
//		Type dynamicSourceType = sourceValue.getType(getStandardLibrary(), staticSourceType);
//		CompleteType dynamicCompleteType = completeManager.getCompleteType(dynamicSourceType);
//		CompleteOperation dynamicOperation = dynamicCompleteType.getDynamicOperation(staticCompleteOperation);
		CallableImplementation implementation = null;
		try {
			implementation = typeManager.getImplementation(staticLessThanOperation);
		} catch (Exception e) {
			evaluationEnvironment.throwInvalidEvaluation("Failed to load '" + staticLessThanOperation.getImplementationClass() + "'", e, iteratorExp, sourceVal);
		}
		if (implementation == null) {
			evaluationEnvironment.throwInvalidEvaluation("Failed to load '" + staticLessThanOperation.getImplementationClass() + "'", null, iteratorExp, sourceVal);
		}
		if (!(implementation instanceof Value.BinaryOperation)) {
			evaluationEnvironment.throwInvalidEvaluation("'<' is not a binary operation", null, iteratorExp, sourceVal);
		}
		Value.BinaryOperation binaryImplementation = (BinaryOperation) implementation;
		SortingValue accumulatorValue = new SortingValue(evaluationEnvironment, sourceVal, iteratorExp, binaryImplementation);
//		IterationManager iterationManager = new IterationManager(evaluationVisitor, iteratorExp, (CollectionValue) sourceVal);
//		return evaluateIteration(iterationManager, accumulatorValue);
//		Accumulator accumulatorValue = createAccumulationValue(valueFactory, true, false);
		return evaluateIteration(new IterationManager<SortingValue>(evaluationVisitor,
				iteratorExp, sourceVal, accumulatorValue));
	}
	
	@Override
	protected Value resolveTerminalValue(IterationManager<SortingValue> iterationManager) {
		SortingValue accumulatorValue = iterationManager.getAccumulatorValue();
		return accumulatorValue.createSortedValue();
	}

	@Override
    protected Value updateAccumulator(IterationManager<SortingValue> iterationManager) {
		SortingValue accumulatorValue = iterationManager.getAccumulatorValue();
		Value bodyVal = iterationManager.getBodyValue();		
		if (bodyVal.isUndefined()) {
			iterationManager.throwInvalidEvaluation("null body");//bodyVal.toInvalidValue();				// Null body is invalid
		}
		// must have exactly one iterator
		Value iterValue = iterationManager.get(0);
		accumulatorValue.put(iterValue, bodyVal);
		return null;										// Carry on
	}

	@Override
	public Diagnostic validate(TypeManager typeManager, CallExp callExp) {
		Type type = ((LoopExp)callExp).getBody().getType();
		TemplateParameter templateParameter = type.getOwningTemplateParameter();
		if (templateParameter != null) {
			Map<TemplateParameter, ParameterableElement> templateParameterSubstitutions = PivotUtil.getAllTemplateParameterSubstitutions(null, callExp.getSource().getType());
//			templateParameterSubstitutions = PivotUtil.getAllTemplateParameterSubstitutions(templateParameterSubstitutions, callExp.getReferredOperation());
			type = (Type) templateParameterSubstitutions.get(templateParameter);
		}
		type = PivotUtil.getBehavioralType(type);			// FIXME make this a general facility
		Operation operation = typeManager.resolveOperation(type, PivotConstants.LESS_THAN_OPERATOR, type);
		if (operation == null) {
			return new ValidationWarning(OCLMessages.UnresolvedOperation_ERROR_, PivotConstants.LESS_THAN_OPERATOR, type + " value");
		}
		try {
			CallableImplementation implementation = typeManager.getImplementation(operation);
			if (implementation == null) {
				return new ValidationWarning("Failed to load '" + operation.getImplementationClass() + "'");
			}
			else if (!(implementation instanceof Value.BinaryOperation)) {
				return new ValidationWarning(type.toString() + "::_'" + PivotConstants.LESS_THAN_OPERATOR + "'(" + type.toString() + ") is not a binary operation");
			}
			else {
				return null;
			}
		} catch (Exception e) {
			return new ValidationWarning("Failed to load '" + operation.getImplementationClass() + "'");  //, e);
		}
	}
}
