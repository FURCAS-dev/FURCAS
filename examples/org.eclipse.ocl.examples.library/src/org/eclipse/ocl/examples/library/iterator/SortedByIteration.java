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
 * $Id: SortedByIteration.java,v 1.3 2011/02/11 20:00:10 ewillink Exp $
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
import org.eclipse.ocl.examples.pivot.CompleteOperation;
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
import org.eclipse.ocl.examples.pivot.utilities.CompleteEnvironmentManager;
import org.eclipse.ocl.examples.pivot.utilities.PivotConstants;
import org.eclipse.ocl.examples.pivot.utilities.PivotUtil;
import org.eclipse.ocl.examples.pivot.utilities.TypeManager;
import org.eclipse.ocl.examples.pivot.values.CollectionValue;
import org.eclipse.ocl.examples.pivot.values.Value;
import org.eclipse.ocl.examples.pivot.values.Value.BinaryOperation;
import org.eclipse.ocl.examples.pivot.values.ValueFactory;
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
		private final EvaluationEnvironment env;
		private final Value sourceVal;
		private final Map<Value, Value> content = new HashMap<Value, Value>();	// User object to sortedBy value
		private final LoopExp iteratorExp;
		private final Value.BinaryOperation binaryImplementation;

		public SortingValue(EvaluationEnvironment env, Value sourceVal, LoopExp iteratorExp, Value.BinaryOperation binaryImplementation) {
			super(env.getValueFactory());
			this.env = env;
			this.sourceVal = sourceVal;
			this.iteratorExp = iteratorExp;
			this.binaryImplementation = binaryImplementation;
		}

		public Object asObject() {
			return content;
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
			Value lessThan = binaryImplementation.evaluate(valueFactory, v1, v2);
			if (lessThan.isTrue()) {
				return -1;
			}
			if (!lessThan.isFalse()) {
				throw new IllegalArgumentException();
			}
			Value greaterThan = binaryImplementation.evaluate(valueFactory, v2, v1);
			if (greaterThan.isTrue()) {
				return 1;
			}
			if (!greaterThan.isFalse()) {
				throw new IllegalArgumentException();
			}
			return 0;
		}

		public Value createSortedValue() {
			List<Value> result = new ArrayList<Value>(content.keySet());
			try {
				Collections.sort(result, this);
			}
			catch (Exception e) {
				return valueFactory.createInvalidValue(sourceVal, iteratorExp, "'<' evaluation failed", e);
			}
			// create result from the sorted collection
			Type sourceType = iteratorExp.getSource().getType();
			boolean isUnique = env.getTypeManager().isUnique(sourceType);
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
		ValueFactory valueFactory = evaluationVisitor.getValueFactory();		
		TypeManager typeManager = evaluationEnvironment.getTypeManager();
		CompleteEnvironmentManager completeManager = typeManager.getCompleteEnvironmentManager();
		OclExpression body = iteratorExp.getBody();		
		Type staticValueType = body.getType();
//		CompleteType completeStaticValueType = completeManager.getCompleteType(staticValueType);
		Operation staticLessThanOperation = typeManager.resolveOperation(staticValueType, PivotConstants.LESS_THAN_OPERATOR, staticValueType);
		if (staticLessThanOperation == null) {
			return valueFactory.createInvalidValue(sourceVal, iteratorExp, "No '" + PivotConstants.LESS_THAN_OPERATOR + "' operation defined", null);
		}
		CompleteOperation staticCompleteOperation = completeManager.getCompleteOperation(staticLessThanOperation);
//		Type dynamicSourceType = sourceValue.getType(getStandardLibrary(), staticSourceType);
//		CompleteType dynamicCompleteType = completeManager.getCompleteType(dynamicSourceType);
//		CompleteOperation dynamicOperation = dynamicCompleteType.getDynamicOperation(staticCompleteOperation);
		Value.BinaryOperation binaryImplementation;
		try {
			CallableImplementation implementation = typeManager.getImplementation(staticCompleteOperation);
			if (implementation == null) {
				return valueFactory.createInvalidValue(sourceVal, iteratorExp, "Failed to load '" + staticCompleteOperation.getImplementationClass() + "'", null);
			}
			if (!(implementation instanceof Value.BinaryOperation)) {
				return valueFactory.createInvalidValue(sourceVal, iteratorExp, "'<' is not a binary operation", null);
			}
			binaryImplementation = (BinaryOperation) implementation;
		} catch (Exception e) {
			return valueFactory.createInvalidValue(sourceVal, iteratorExp, "Failed to load '" + staticCompleteOperation.getImplementationClass() + "'", e);
		}
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
			return bodyVal.toInvalidValue();				// Null body is invalid
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
		Operation operation = typeManager.resolveOperation(type, PivotConstants.LESS_THAN_OPERATOR, type);
		if (operation == null) {
			return new ValidationWarning(OCLMessages.WarningUndefinedOperation, PivotConstants.LESS_THAN_OPERATOR, type);
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
