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
 * $Id: BooleanAllInstancesOperation.java,v 1.2 2011/01/24 19:56:32 ewillink Exp $
 */
package org.eclipse.ocl.examples.library.logical;

import org.eclipse.ocl.examples.library.AbstractOperation;
import org.eclipse.ocl.examples.pivot.OperationCallExp;
import org.eclipse.ocl.examples.pivot.evaluation.EvaluationVisitor;
import org.eclipse.ocl.examples.pivot.values.SetValue;
import org.eclipse.ocl.examples.pivot.values.Value;
import org.eclipse.ocl.examples.pivot.values.ValueFactory;

/**
 * BooleanAllInstancesOperation realises the Boolean::allInstances() library operation.
 * 
 * @since 3.1
 */
public class BooleanAllInstancesOperation extends AbstractOperation
{
	public static final BooleanAllInstancesOperation INSTANCE = new BooleanAllInstancesOperation();

	private static SetValue allInstances = null;
	
	public SetValue evaluate(EvaluationVisitor evaluationVisitor, Value sourceVal, OperationCallExp operationCall) {
		// Boolean has two instances: false, true
		if (allInstances == null) {
			ValueFactory valueFactory = evaluationVisitor.getValueFactory();
			allInstances = valueFactory.createSetValue(valueFactory.getFalse(), valueFactory.getTrue());
		}
		return allInstances;
	}
}
