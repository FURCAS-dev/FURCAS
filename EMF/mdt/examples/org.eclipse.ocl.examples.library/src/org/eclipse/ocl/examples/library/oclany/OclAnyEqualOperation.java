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
 * $Id: OclAnyEqualOperation.java,v 1.2 2011/01/24 19:56:31 ewillink Exp $
 */
package org.eclipse.ocl.examples.library.oclany;

import org.eclipse.ocl.examples.library.AbstractBinaryOperation;
import org.eclipse.ocl.examples.pivot.values.BooleanValue;
import org.eclipse.ocl.examples.pivot.values.InvalidValue;
import org.eclipse.ocl.examples.pivot.values.Value;
import org.eclipse.ocl.examples.pivot.values.ValueFactory;

/**
 * OclAnyEqualOperation realises the OCLAny::=() library operation and
 * regular derived implementations since the Value classes exhibit
 * OCL value semantics.
 * 
 * @since 3.1
 */
public class OclAnyEqualOperation extends AbstractBinaryOperation
{
	public static final OclAnyEqualOperation INSTANCE = new OclAnyEqualOperation();

	public BooleanValue evaluate(ValueFactory valueFactory, Value left, Value right) {
		//
		//	A.2.2 is clear. 11.3.1 is vague.
		//
		InvalidValue invalidLeft = left.asInvalidValue();
		if (invalidLeft != null) {
			return invalidLeft;
		}
		InvalidValue invalidRight = right.asInvalidValue();
		if (invalidRight != null) {
			return invalidRight;
		}
		return valueFactory.booleanValueOf(left.equals(right));
	}
}
