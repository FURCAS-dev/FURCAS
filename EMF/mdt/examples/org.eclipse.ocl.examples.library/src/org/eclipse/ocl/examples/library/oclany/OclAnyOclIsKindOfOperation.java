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
 * $Id: OclAnyOclIsKindOfOperation.java,v 1.2 2011/01/24 19:56:31 ewillink Exp $
 */
package org.eclipse.ocl.examples.library.oclany;

import org.eclipse.ocl.examples.library.AbstractOperation;
import org.eclipse.ocl.examples.pivot.OperationCallExp;
import org.eclipse.ocl.examples.pivot.StandardLibrary;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.evaluation.EvaluationVisitor;
import org.eclipse.ocl.examples.pivot.values.TypeValue;
import org.eclipse.ocl.examples.pivot.values.Value;
import org.eclipse.ocl.examples.pivot.values.ValueFactory;

/**
 * OclAnyOclIsKindOfOperation realises the OclAny::oclIsKindOf() library operation.
 * 
 * @since 3.1
 */
public class OclAnyOclIsKindOfOperation extends AbstractOperation
{
	public static final OclAnyOclIsKindOfOperation INSTANCE = new OclAnyOclIsKindOfOperation();

	public Value evaluate(EvaluationVisitor evaluationVisitor, Value sourceVal, OperationCallExp operationCall) {
		ValueFactory valueFactory = evaluationVisitor.getValueFactory();
		StandardLibrary stdlib = evaluationVisitor.getStandardLibrary();
		Type sourceType = sourceVal.getType(stdlib, operationCall.getSource().getType());
		Value argVal = evaluateArgument(evaluationVisitor, operationCall, 0);
		TypeValue argTypeValue = argVal.asTypeValue();
		if (argTypeValue == null) {
			return valueFactory.createInvalidValue(argVal, operationCall, "Type required", null);
		}
		Type argType = argTypeValue.getType();
		return valueFactory.booleanValueOf(stdlib.conformsTo(sourceType, argType));
	}
}
