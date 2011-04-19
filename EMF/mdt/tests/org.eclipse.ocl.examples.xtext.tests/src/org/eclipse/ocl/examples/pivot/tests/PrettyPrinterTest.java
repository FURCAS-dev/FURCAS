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
 *   E.D.Willink - Initial API and implementation
 *
 * </copyright>
 *
 * $Id: PrettyPrinterTest.java,v 1.2 2011/03/17 20:24:43 ewillink Exp $
 */

package org.eclipse.ocl.examples.pivot.tests;

import org.eclipse.ocl.examples.pivot.ExpressionInOcl;
import org.eclipse.ocl.examples.pivot.ParserException;
import org.eclipse.ocl.examples.pivot.prettyprint.PrettyPrintExprVisitor;

/**
 * Tests for OclAny operations.
 */
@SuppressWarnings("nls")
public class PrettyPrinterTest extends PivotSimpleTestSuite
{
    @Override
    protected void setUp() {
        super.setUp();
        helper.setContext(getMetaclass("Classifier"));
    }
    
	protected Object assertPrintResults(Object context, String expression) {
		try {
			ExpressionInOcl query = helper.createQuery(expression);
			String prettyExpression = PrettyPrintExprVisitor.prettyPrint(query, null);
			assertEquals(expression, prettyExpression);
		} catch (ParserException e) {
            fail("Failed to parse \"" + expression + "\": " + e.getLocalizedMessage());
		}
		return null;
	}

	/**
	 * Tests the precedence on a specialized collection operator.
	 */
	public void test_SetDifference() {
		assertPrintResults(null, "let a : Set(Integer) = Set{1} in let b : Set(Integer) = Set{1} in a - b");
	}

	/**
	 * Tests the precedence on a specialized collection operator.
	 */
	public void test_SourceNavigationPrecedence() {
		assertPrintResults(null, "let a : Set(Integer) = Set{1} in (a - a)->isEmpty()");
		assertPrintResults(null, "let a : Set(Integer) = Set{1} in a->isEmpty()");
		assertPrintResults(null, "let a : Set(Integer) = Set{1} in a->asSet()->asSet()");
		assertPrintResults(null, "let a : Set(Integer) = Set{1} in a->select(true)->asSet()");
	}

	/**
	 * Tests the precedence on a specialized collection operator.
	 */
	public void test_ImplicitCollect() {
// FIXME		assertPrintResults(null, "Set{1}.toString()");
	}
}
