/**
 * <copyright>
 * 
 * Copyright (c) 2009,2011 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *
 * </copyright>
 *
 * $Id: EvaluateOclAnyOperationsTest.java,v 1.2 2011/01/24 23:31:52 ewillink Exp $
 */

package org.eclipse.ocl.examples.test.ecore;

import org.eclipse.ocl.examples.test.generic.GenericEvaluateOclAnyOperationsTest;

/**
 * Tests for evaluate OclAny expressions.
 */
public class EvaluateOclAnyOperationsTest extends GenericEvaluateOclAnyOperationsTest {

	@Override
	public PivotTestReflection getStaticReflection() {
		return new PivotTestReflection(typeManager);
	}
}
