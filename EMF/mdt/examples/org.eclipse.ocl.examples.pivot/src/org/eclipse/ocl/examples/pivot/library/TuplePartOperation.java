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
 * $Id: TuplePartOperation.java,v 1.1 2011/02/11 20:00:29 ewillink Exp $
 */
package org.eclipse.ocl.examples.pivot.library;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.ocl.examples.pivot.CallExp;
import org.eclipse.ocl.examples.pivot.Property;
import org.eclipse.ocl.examples.pivot.PropertyCallExp;
import org.eclipse.ocl.examples.pivot.evaluation.CallableImplementation;
import org.eclipse.ocl.examples.pivot.evaluation.EvaluationVisitor;
import org.eclipse.ocl.examples.pivot.utilities.TypeManager;
import org.eclipse.ocl.examples.pivot.values.TupleValue;
import org.eclipse.ocl.examples.pivot.values.Value;
import org.eclipse.ocl.examples.pivot.values.ValueFactory;

public class TuplePartOperation implements CallableImplementation
{
	public static final CallableImplementation INSTANCE = new TuplePartOperation();
	
	public TuplePartOperation() {}

	public Value evaluate(EvaluationVisitor evaluationVisitor, Value sourceValue, CallExp callExp) {
		if (!(sourceValue instanceof TupleValue) || sourceValue.isUndefined()) {
			if (sourceValue.isInvalid()) {
				return sourceValue;
			}
			else {
				ValueFactory valueFactory = evaluationVisitor.getValueFactory();
				return valueFactory.createInvalidValue("non-tuple source");
			}
		}
		PropertyCallExp propertyCallExp = (PropertyCallExp) callExp;
		Property property = propertyCallExp.getReferredProperty();
		Value resultValue = ((TupleValue)sourceValue).getValue(property);
		return resultValue;		// null is a static type error so no need to diagnose dynamically
	}

	public Diagnostic validate(TypeManager typeManager, CallExp callExp) {
		return null;
	}
	
}