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
 * $Id: EObjectOperation.java,v 1.2 2011/02/08 17:51:47 ewillink Exp $
 */
package org.eclipse.ocl.examples.pivot.ecore;

import java.util.List;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.ocl.examples.pivot.CallExp;
import org.eclipse.ocl.examples.pivot.ExpressionInOcl;
import org.eclipse.ocl.examples.pivot.OclExpression;
import org.eclipse.ocl.examples.pivot.OpaqueExpression;
import org.eclipse.ocl.examples.pivot.Operation;
import org.eclipse.ocl.examples.pivot.OperationCallExp;
import org.eclipse.ocl.examples.pivot.ValueSpecification;
import org.eclipse.ocl.examples.pivot.Variable;
import org.eclipse.ocl.examples.pivot.evaluation.CallableImplementation;
import org.eclipse.ocl.examples.pivot.evaluation.EvaluationEnvironment;
import org.eclipse.ocl.examples.pivot.evaluation.EvaluationVisitor;
import org.eclipse.ocl.examples.pivot.utilities.PivotUtil;
import org.eclipse.ocl.examples.pivot.utilities.TypeManager;
import org.eclipse.ocl.examples.pivot.values.Value;

/** 
 * An EObjectOperation provides the standard CallableImplementation to implement an
 * OperationCallExp. When constructed with a null specification, the call returns
 * an invalid. When constructed with a non-null specification,
 * the specification defines the operation body, which if provided as an OpaqueExpression
 * is lazily compiled from OCL source text.
 */
public class EObjectOperation implements CallableImplementation
{
	protected final EOperation eFeature;
	protected ValueSpecification specification;

	public EObjectOperation(EOperation eFeature, ValueSpecification specification) {
		this.eFeature = eFeature;
		this.specification = specification;
	}

	public Value evaluate(EvaluationVisitor evaluationVisitor, Value sourceValue, CallExp callExp) {
		if (!(specification instanceof ExpressionInOcl) && (specification instanceof OpaqueExpression)) {
			Operation operation = PivotUtil.getReferredOperation(callExp);
			String string = PivotUtil.getBody((OpaqueExpression) specification);
			specification = PivotUtil.resolveSpecification(evaluationVisitor.getTypeManager(), operation, string);
		}
		if (specification instanceof ExpressionInOcl) {
			ExpressionInOcl expressionInOcl = (ExpressionInOcl)specification;
			EvaluationVisitor nestedEvaluationVisitor = evaluationVisitor.createNestedVisitor();
			EvaluationEnvironment nestedEvaluationEnvironment = nestedEvaluationVisitor.getEvaluationEnvironment();
			nestedEvaluationEnvironment.add(expressionInOcl.getContextVariable(), sourceValue);
			OperationCallExp operationCall = (OperationCallExp) callExp;	// FIXME iterators
			List<OclExpression> arguments = operationCall.getArguments();
			List<Variable> parameterVariables = expressionInOcl.getParameterVariables();
			int iMax = Math.min(parameterVariables.size(), arguments.size());
			for (int i = 0; i < iMax; i++) {
				Value argumentValue = arguments.get(i).accept(evaluationVisitor);
				nestedEvaluationEnvironment.add(parameterVariables.get(i).getRepresentedParameter(), argumentValue);
			}
			return expressionInOcl.getBodyExpression().accept(nestedEvaluationVisitor);
		}
		else {
			// FIXME eInvoke for alternate protocols ???
			
			/*		for (EOperation eOperation : eClass.getEAllOperations()) {
						if (eOperation.getName().equals(name)) {
							EList<Object> eArguments = new BasicEList<Object>();
							try {
								Object eValue = ((EObject)element).eInvoke(eOperation, eArguments);
								return defaultReturnValue(eOperation, eValue);
							} catch (InvocationTargetException e) {
								return valueFactory.createInvalidValue(sourceValue, operationCallExp, "Failed to load '" + feature.getImplementationClass() + "'", e);
							}
						}
					} */
			Operation operation = PivotUtil.getReferredOperation(callExp);
			return evaluationVisitor.getValueFactory().createInvalidValue(sourceValue, callExp, "No specification for '" + operation + "'", null);
		}
	}

/*	protected Value defaultOperationCall(Feature feature, Value sourceValue, OperationCallExp operationCallExp) {
		Object element = sourceValue.asObject();
		if (!(element instanceof EObject)) {
			return sourceValue.toInvalidValue();
		}
		EClass eClass = ((EObject)element).eClass();
		Operation referredOperation = operationCallExp.getReferredOperation();
		String name = referredOperation.getName();
		for (EOperation eOperation : eClass.getEAllOperations()) {
			if (eOperation.getName().equals(name)) {
				EList<Object> eArguments = new BasicEList<Object>();
				try {
					Object eValue = ((EObject)element).eInvoke(eOperation, eArguments);
					return defaultReturnValue(eOperation, eValue);
				} catch (InvocationTargetException e) {
					return valueFactory.createInvalidValue(sourceValue, operationCallExp, "Failed to load '" + feature.getImplementationClass() + "'", e);
				}
			}
		}
		return valueFactory.createInvalidValue(sourceValue, operationCallExp, "Failed to load '" + feature.getImplementationClass() + "'", null);
	} */

	public Diagnostic validate(TypeManager typeManager, CallExp callExp) {
		return null;
	}
}