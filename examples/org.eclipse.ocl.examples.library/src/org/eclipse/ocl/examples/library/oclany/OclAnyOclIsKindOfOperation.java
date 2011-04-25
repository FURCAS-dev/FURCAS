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
 * $Id: OclAnyOclIsKindOfOperation.java,v 1.6 2011/04/25 09:48:57 ewillink Exp $
 */
package org.eclipse.ocl.examples.library.oclany;

import org.eclipse.ocl.examples.library.AbstractOperation;
import org.eclipse.ocl.examples.pivot.InvalidValueException;
import org.eclipse.ocl.examples.pivot.OperationCallExp;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.evaluation.EvaluationVisitor;
import org.eclipse.ocl.examples.pivot.utilities.TypeManager;
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

	public Value evaluate(EvaluationVisitor evaluationVisitor, Value sourceVal, OperationCallExp operationCall) throws InvalidValueException {
		ValueFactory valueFactory = evaluationVisitor.getValueFactory();
		TypeManager typeManager = evaluationVisitor.getTypeManager();
		Type sourceType = sourceVal.getType(typeManager, operationCall.getSource().getType());
		Value argVal = evaluateArgument(evaluationVisitor, operationCall, 0);
		TypeValue argTypeValue = argVal.asTypeValue();
		Type argType = argTypeValue.getInstanceType();
		return valueFactory.booleanValueOf(typeManager.conformsTo(sourceType, argType, null));
	}
}
