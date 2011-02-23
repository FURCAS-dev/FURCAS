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
 * $Id: OclAnyOclAsSetOperation.java,v 1.3 2011/02/21 08:37:47 ewillink Exp $
 */
package org.eclipse.ocl.examples.library.oclany;

import org.eclipse.ocl.examples.library.AbstractUnaryOperation;
import org.eclipse.ocl.examples.pivot.InvalidValueException;
import org.eclipse.ocl.examples.pivot.values.SetValue;
import org.eclipse.ocl.examples.pivot.values.Value;
import org.eclipse.ocl.examples.pivot.values.ValueFactory;

/**
 * OclAnyOclAsSetOperation realises the OclAny::oclAsSet() library operation.
 * 
 * @since 3.1
 */
public class OclAnyOclAsSetOperation extends AbstractUnaryOperation
{
	public static final OclAnyOclAsSetOperation INSTANCE = new OclAnyOclAsSetOperation();

	public SetValue evaluate(ValueFactory valueFactory, Value argument) throws InvalidValueException {
		if (argument.isInvalid()) {
			throw new InvalidValueException("oclAsSet of invalid");
		}
		else if (argument.isNull()) {
			return valueFactory.createSetValue();
		}
		else {
			return valueFactory.createSetValue(argument);
		}
	}
}
