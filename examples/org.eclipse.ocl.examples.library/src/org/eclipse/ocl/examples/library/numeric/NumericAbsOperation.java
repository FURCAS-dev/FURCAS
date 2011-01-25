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
 * $Id: NumericAbsOperation.java,v 1.2 2011/01/24 19:56:31 ewillink Exp $
 */
package org.eclipse.ocl.examples.library.numeric;

import org.eclipse.ocl.examples.pivot.values.NumericValue;
import org.eclipse.ocl.examples.pivot.values.Value;


/**
 * AbsOperation realises the abs() library operation.
 * 
 * @since 3.1
 */
public class NumericAbsOperation extends AbstractNumericUnaryOperation
{
	public static final NumericAbsOperation INSTANCE = new NumericAbsOperation();

	@Override
	protected Value evaluateNumeric(NumericValue left) {
		return left.abs();
	}
}
