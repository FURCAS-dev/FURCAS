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
 * $Id: OclAnyNotEqualOperation.java,v 1.3 2011/02/21 08:37:47 ewillink Exp $
 */
package org.eclipse.ocl.examples.library.oclany;

import org.eclipse.ocl.examples.pivot.InvalidValueException;
import org.eclipse.ocl.examples.pivot.values.BooleanValue;
import org.eclipse.ocl.examples.pivot.values.Value;
import org.eclipse.ocl.examples.pivot.values.ValueFactory;


/**
 * OclAnyNotEqualOperation realises the OCLAny::<>() library operation and
 * regular derived implementations since the Value classes exhibit
 * OCL value semantics.
 * 
 * @since 3.1
 */
public class OclAnyNotEqualOperation extends OclAnyEqualOperation
{
	public static final OclAnyNotEqualOperation INSTANCE = new OclAnyNotEqualOperation();

	@Override
	public BooleanValue evaluate(ValueFactory valueFactory, Value left, Value right) throws InvalidValueException {
		return valueFactory.booleanValueOf(!super.evaluate(valueFactory, left, right).asBoolean());
	}
}
