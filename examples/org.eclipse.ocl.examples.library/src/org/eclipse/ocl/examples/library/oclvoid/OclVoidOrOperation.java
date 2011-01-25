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
 * $Id: OclVoidOrOperation.java,v 1.2 2011/01/24 19:56:31 ewillink Exp $
 */
package org.eclipse.ocl.examples.library.oclvoid;

import org.eclipse.ocl.examples.library.AbstractBinaryOperation;
import org.eclipse.ocl.examples.pivot.values.BooleanValue;
import org.eclipse.ocl.examples.pivot.values.Value;
import org.eclipse.ocl.examples.pivot.values.ValueFactory;

/**
 * OclVoidOrOperation realises the OclVoid::or() library operation.
 * 
 * @since 3.1
 */
public class OclVoidOrOperation extends AbstractBinaryOperation
{
	public static final OclVoidOrOperation INSTANCE = new OclVoidOrOperation();

	public BooleanValue evaluate(ValueFactory valueFactory, Value left, Value right) {
		if (right == valueFactory.getTrue()) {
			return valueFactory.getTrue();
		}
		return null;
	}
}
