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
 * $Id: JavaLessThanOperation.java,v 1.3 2011/02/08 17:51:47 ewillink Exp $
 */
package org.eclipse.ocl.examples.pivot.library;

import java.lang.reflect.Method;

public class JavaLessThanOperation extends JavaComparisonOperation
{
	public JavaLessThanOperation(Method method) {
		super(method);
	}

	@Override
	protected boolean evaluateComparison(Integer result) {
		return result.intValue() < 0;
	}
}