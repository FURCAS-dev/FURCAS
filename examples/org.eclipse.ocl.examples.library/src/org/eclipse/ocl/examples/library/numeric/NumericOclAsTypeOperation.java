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
 * $Id: NumericOclAsTypeOperation.java,v 1.6 2011/05/07 16:41:47 ewillink Exp $
 */
package org.eclipse.ocl.examples.library.numeric;

import org.eclipse.ocl.examples.library.oclany.OclAnyOclAsTypeOperation;
import org.eclipse.ocl.examples.pivot.InvalidValueException;
import org.eclipse.ocl.examples.pivot.OperationCallExp;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.evaluation.EvaluationVisitor;
import org.eclipse.ocl.examples.pivot.messages.EvaluatorMessages;
import org.eclipse.ocl.examples.pivot.utilities.TypeManager;
import org.eclipse.ocl.examples.pivot.values.IntegerValue;
import org.eclipse.ocl.examples.pivot.values.RealValue;
import org.eclipse.ocl.examples.pivot.values.TypeValue;
import org.eclipse.ocl.examples.pivot.values.Value;

/**
 * NumericOclAsTypeOperation realises the Real::oclAsType() library operation.
 * 
 * @since 3.1
 */
public class NumericOclAsTypeOperation extends OclAnyOclAsTypeOperation
{
	public static final NumericOclAsTypeOperation INSTANCE = new NumericOclAsTypeOperation();

	@Override
	public Value evaluate(EvaluationVisitor evaluationVisitor, Value sourceVal, OperationCallExp operationCall) throws InvalidValueException {
		TypeManager typeManager = evaluationVisitor.getTypeManager();
		Type sourceType = sourceVal.getType(typeManager, operationCall.getSource().getType());
		if (sourceType == null) {
			return evaluationVisitor.throwInvalidEvaluation(null, operationCall, sourceType, EvaluatorMessages.MissingSourceType);
		}
		Value argVal = evaluateArgument(evaluationVisitor, operationCall, 0);
		TypeValue typeVal = argVal.asTypeValue();
		Type argType = typeVal.getInstanceType();
		if (typeManager.conformsTo(sourceType, argType, null)) {
			if (sourceVal.isUnlimited() && ((argType == typeManager.getIntegerType()) || (argType == typeManager.getRealType()))) {
				return evaluationVisitor.throwInvalidEvaluation(null, operationCall, sourceVal, EvaluatorMessages.NonFiniteIntegerValue);
			}
			else if ((sourceVal instanceof IntegerValue) && (argType == typeManager.getRealType())) {
				return ((IntegerValue)sourceVal).toRealValue();
			}
			else {
				return sourceVal;
			}
		}
		else {
			RealValue realValue = sourceVal.asRealValue();
			if (realValue != null) {
				if (argType == typeManager.getUnlimitedNaturalType()) {
					if (realValue.signum() < 0) {
						return evaluationVisitor.throwInvalidEvaluation(null, operationCall, sourceVal, EvaluatorMessages.NonPositiveUnlimitedNaturalValue);
					}
					return realValue.toIntegerValue();
				}
				else if (argType == typeManager.getIntegerType()) {
					return realValue.toIntegerValue();
				}
				else {
					return evaluationVisitor.throwInvalidEvaluation(null, operationCall, argType, EvaluatorMessages.IncompatibleArgumentType, argType);
				}
			}
			IntegerValue integerValue = sourceVal.asIntegerValue();
			if (integerValue != null) {
				if (argType == typeManager.getUnlimitedNaturalType()) {
					if (integerValue.signum() < 0) {
						return evaluationVisitor.throwInvalidEvaluation(null, operationCall, sourceVal, EvaluatorMessages.NonPositiveUnlimitedNaturalValue);
					}
					return integerValue;
				}
			}
			return evaluationVisitor.throwInvalidEvaluation(null, operationCall, sourceVal, EvaluatorMessages.UnknownSourceType);
		}
	}
}
