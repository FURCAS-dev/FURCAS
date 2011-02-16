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
 * $Id: OclAnyOclTypeOperation.java,v 1.3 2011/02/08 17:47:35 ewillink Exp $
 */
package org.eclipse.ocl.examples.library.oclany;

import org.eclipse.ocl.examples.library.AbstractOperation;
import org.eclipse.ocl.examples.pivot.OperationCallExp;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.evaluation.EvaluationVisitor;
import org.eclipse.ocl.examples.pivot.utilities.TypeManager;
import org.eclipse.ocl.examples.pivot.values.Value;

/**
 * OclAnyOclTypeOperation realises the OclAny::oclType() library operation.
 * 
 * @since 3.1
 */
public class OclAnyOclTypeOperation extends AbstractOperation
{
	public static final OclAnyOclTypeOperation INSTANCE = new OclAnyOclTypeOperation();

	public Value evaluate(EvaluationVisitor evaluationVisitor, Value sourceVal, OperationCallExp operationCall) {
		TypeManager typeManager = evaluationVisitor.getTypeManager();
		Type sourceType = sourceVal.getType(typeManager, operationCall.getSource().getType());
		return evaluationVisitor.getValueFactory().createTypeValue(sourceType);
	}
}
