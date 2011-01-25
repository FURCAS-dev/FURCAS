/**
 * <copyright>
 * 
 * Copyright (c) 2007,2011 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   IBM - Initial API and implementation
 *   E.D.Willink - Bug 283509, 296409
 *
 * </copyright>
 *
 * $Id: KeywordsTest.java,v 1.2 2011/01/24 23:31:52 ewillink Exp $
 */

package org.eclipse.ocl.examples.test.ecore;

import org.eclipse.ocl.examples.test.generic.GenericKeywordsTest;

/**
 * Tests for usages of model features whose names coincide with "keywords"
 * defined as reserved words by the OCL specification.
 * 
 * @author Christian W. Damus (cdamus)
 */
public class KeywordsTest extends GenericKeywordsTest {

	@Override
	public PivotTestReflection getStaticReflection() {
		return new PivotTestReflection(typeManager);
	}
}
