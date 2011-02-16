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
 * $Id: OclAnyOclAsTypeOperation.java,v 1.4 2011/02/11 20:00:10 ewillink Exp $
 */
package org.eclipse.ocl.examples.library.oclany;

import org.eclipse.ocl.examples.library.AbstractOperation;
import org.eclipse.ocl.examples.pivot.OperationCallExp;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.evaluation.EvaluationVisitor;
import org.eclipse.ocl.examples.pivot.utilities.TypeManager;
import org.eclipse.ocl.examples.pivot.values.TypeValue;
import org.eclipse.ocl.examples.pivot.values.Value;
import org.eclipse.ocl.examples.pivot.values.ValueFactory;

/**
 * OclAnyOclAsTypeOperation realises the OclAny::oclAsType() library operation.
 * 
 * @since 3.1
 */
public class OclAnyOclAsTypeOperation extends AbstractOperation
{
	public static final OclAnyOclAsTypeOperation INSTANCE = new OclAnyOclAsTypeOperation();

	public Value evaluate(EvaluationVisitor evaluationVisitor, Value sourceVal, OperationCallExp operationCall) {
		ValueFactory valueFactory = evaluationVisitor.getValueFactory();
		TypeManager typeManager = evaluationVisitor.getTypeManager();
		Type sourceType = sourceVal.getType(typeManager, operationCall.getSource().getType());
		if (sourceType == null) {
			return null;
		}
		Value argVal = evaluateArgument(evaluationVisitor, operationCall, 0);
		TypeValue typeVal = argVal.asTypeValue();
		if (typeVal == null) {
			return valueFactory.createInvalidValue(argVal, operationCall, "Type required", null);
		}
		Type argType = typeVal.getType();
		if (typeManager.conformsTo(sourceType, argType, null)) {
			return evaluateConforming(evaluationVisitor, sourceVal, argType);
		}
		else {
			return evaluateNonConforming(evaluationVisitor, sourceVal, argType);
		}
	}

	protected Value evaluateConforming(EvaluationVisitor evaluationVisitor, Value sourceVal, Type argType) {
		return sourceVal;
	}

	protected Value evaluateNonConforming(EvaluationVisitor evaluationVisitor, Value sourceVal, Type argType) {
		return null;
	}
}
