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
 * $Id: JavaEqualOperation.java,v 1.2 2011/01/24 19:56:32 ewillink Exp $
 */
package org.eclipse.ocl.examples.library.java;

import org.eclipse.ocl.examples.library.AbstractBinaryOperation;
import org.eclipse.ocl.examples.pivot.values.BooleanValue;
import org.eclipse.ocl.examples.pivot.values.Value;
import org.eclipse.ocl.examples.pivot.values.ValueFactory;

/**
 * JavaEqualOperation realises the Java::=() library operation.
 * 
 * @since 3.1
 */
public class JavaEqualOperation extends AbstractBinaryOperation
{
	public BooleanValue evaluate(ValueFactory valueFactory, Value left, Value right) {
		String leftString = left.asString();
		String rightString = right.asString();
		if ((leftString != null) && (rightString != null)) {
			return valueFactory.booleanValueOf(leftString.equals(rightString));
		}
		if (left.isInvalid() && right.isInvalid()) {
			return valueFactory.getTrue();
		}
		if (left.isNull() && right.isNull()) {
			return valueFactory.getTrue();
		}			
		return valueFactory.getFalse();
	}
}
