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
 * $Id: BooleanXorOperation.java,v 1.2 2011/01/24 19:56:32 ewillink Exp $
 */
package org.eclipse.ocl.examples.library.logical;

import org.eclipse.ocl.examples.library.AbstractBinaryOperation;
import org.eclipse.ocl.examples.pivot.values.BooleanValue;
import org.eclipse.ocl.examples.pivot.values.Value;
import org.eclipse.ocl.examples.pivot.values.ValueFactory;

/**
 * BooleanXorOperation realises the Boolean::xor() library operation.
 * 
 * @since 3.1
 */
public class BooleanXorOperation extends AbstractBinaryOperation
{
	public static final BooleanXorOperation INSTANCE = new BooleanXorOperation();

	public BooleanValue evaluate(ValueFactory valueFactory, Value left, Value right) {
		if (left == valueFactory.getTrue()) {
			if (right == valueFactory.getTrue()) {
				return valueFactory.getFalse();
			}
			else if (right == valueFactory.getFalse()) {
				return valueFactory.getTrue();
			}
		}
		else if (left == valueFactory.getFalse()) {
			if (right == valueFactory.getTrue()) {
				return valueFactory.getTrue();
			}
			else if (right == valueFactory.getFalse()) {
				return valueFactory.getFalse();
			}
		}
		return valueFactory.createInvalidValue("non-Boolean 'xor' term");
	}
}
