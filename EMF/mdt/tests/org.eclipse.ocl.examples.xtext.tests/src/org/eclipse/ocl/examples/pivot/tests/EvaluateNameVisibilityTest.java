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
 *   L.Goubet, E.D.Willink - Initial API and implementation
 *
 * </copyright>
 *
 * $Id: EvaluateNameVisibilityTest.java,v 1.1 2011/03/13 11:44:20 ewillink Exp $
 */

package org.eclipse.ocl.examples.pivot.tests;

import org.eclipse.ocl.examples.pivot.messages.OCLMessages;


/**
 * Tests for Name access.
 */
@SuppressWarnings("nls")
public class EvaluateNameVisibilityTest extends PivotSimpleTestSuite
{
    @Override
    protected void setUp() {
        super.setUp();
        helper.setContext(getMetaclass("Classifier"));
    }

	/**
	 * Tests the let in operator.
	 */
	public void test_let() {
		assertQueryEquals(pkg1, 11, "let a : Integer = 4, b : Integer = 7, c : Integer = a + b in c");
		assertSemanticErrorQuery("let a : Boolean = true, b : Boolean = a and b, c : Boolean = true in c", OCLMessages.UnresolvedProperty_ERROR_, "b", "Boolean");
		assertSemanticErrorQuery("let a : Boolean = b and c, b : Boolean = true, c : Boolean = true in c", OCLMessages.UnresolvedProperty_ERROR_, "b", "Unknown type");

		assertQueryEquals(pkg1, 16, "let a : Integer = 4 in let a : Integer = 7, b : Integer = a + 9 in b");
		assertQueryEquals(pkg1, 16, "let a : Integer = 4 in let a : Integer = 7 in a + 9 ");
	}
}
