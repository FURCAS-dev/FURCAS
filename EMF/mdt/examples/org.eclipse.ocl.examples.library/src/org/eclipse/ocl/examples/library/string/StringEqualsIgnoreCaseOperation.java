/**
 * <copyright>
 *
 * Copyright (c) 2010 E.D.Willink and others.
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
 * $Id: StringEqualsIgnoreCaseOperation.java,v 1.2 2011/01/24 19:56:31 ewillink Exp $
 */
package org.eclipse.ocl.examples.library.string;

import org.eclipse.ocl.examples.pivot.values.Value;
import org.eclipse.ocl.examples.pivot.values.ValueFactory;

/**
 * OrderedSetSubOrderedSetOperation realises the OrderedSet::subOrderedSet() library operation.
 * 
 * @since 3.1
 */
public class StringEqualsIgnoreCaseOperation extends AbstractStringBinaryOperation
{
	public static final StringEqualsIgnoreCaseOperation INSTANCE = new StringEqualsIgnoreCaseOperation();

	@Override
	protected Value evaluateString(ValueFactory valueFactory, String left, String right) {
		return valueFactory.booleanValueOf(left.equalsIgnoreCase(right));
	}
}
