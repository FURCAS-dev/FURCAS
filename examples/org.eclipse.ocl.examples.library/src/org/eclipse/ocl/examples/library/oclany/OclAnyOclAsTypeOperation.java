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
 * $Id: OclAnyOclAsTypeOperation.java,v 1.7 2011/05/07 16:41:47 ewillink Exp $
 */
package org.eclipse.ocl.examples.library.oclany;

import org.eclipse.ocl.examples.library.AbstractOperation;
import org.eclipse.ocl.examples.pivot.InvalidValueException;
import org.eclipse.ocl.examples.pivot.OperationCallExp;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.evaluation.EvaluationVisitor;
import org.eclipse.ocl.examples.pivot.messages.EvaluatorMessages;
import org.eclipse.ocl.examples.pivot.utilities.TypeManager;
import org.eclipse.ocl.examples.pivot.values.TypeValue;
import org.eclipse.ocl.examples.pivot.values.Value;

/**
 * OclAnyOclAsTypeOperation realises the OclAny::oclAsType() library operation.
 * 
 * @since 3.1
 */
public class OclAnyOclAsTypeOperation extends AbstractOperation
{
	public static final OclAnyOclAsTypeOperation INSTANCE = new OclAnyOclAsTypeOperation();

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
			return sourceVal;
		}
		else {
			return evaluationVisitor.throwInvalidEvaluation(null, operationCall, argType, EvaluatorMessages.IncompatibleArgumentType, argType);
		}
	}
}
