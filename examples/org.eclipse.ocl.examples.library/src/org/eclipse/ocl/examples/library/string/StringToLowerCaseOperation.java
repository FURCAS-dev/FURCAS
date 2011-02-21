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
 * $Id: StringToLowerCaseOperation.java,v 1.3 2011/02/21 08:37:47 ewillink Exp $
 */
package org.eclipse.ocl.examples.library.string;

import org.eclipse.ocl.examples.library.AbstractUnaryOperation;
import org.eclipse.ocl.examples.pivot.InvalidValueException;
import org.eclipse.ocl.examples.pivot.values.Value;
import org.eclipse.ocl.examples.pivot.values.ValueFactory;

/**
 * StringToLowerCaseOperation realises the String::toLowerCase() library operation.
 * 
 * @since 3.1
 */
public class StringToLowerCaseOperation extends AbstractUnaryOperation
{
	public static final StringToLowerCaseOperation INSTANCE = new StringToLowerCaseOperation();

	public Value evaluate(ValueFactory valueFactory, Value sourceVal) throws InvalidValueException {
		String sourceString = sourceVal.asString();
		return valueFactory.stringValueOf(sourceString.toLowerCase());
	}
}
