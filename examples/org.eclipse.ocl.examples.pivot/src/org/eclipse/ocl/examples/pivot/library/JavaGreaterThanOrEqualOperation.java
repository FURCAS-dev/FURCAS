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
 * $Id: JavaGreaterThanOrEqualOperation.java,v 1.1 2011/02/08 17:51:47 ewillink Exp $
 */
package org.eclipse.ocl.examples.pivot.library;

import java.lang.reflect.Method;

public class JavaGreaterThanOrEqualOperation extends JavaComparisonOperation
{
	public JavaGreaterThanOrEqualOperation(Method method) {
		super(method);
	}

	@Override
	protected boolean evaluateComparison(Integer result) {
		return result.intValue() >= 0;
	}
}