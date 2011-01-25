/**
 * <copyright>
 * 
 * Copyright (c) 2009,2010 Eclipse Modeling Project and others.
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
 * $Id: GenericEvaluateBooleanOperationsTest.java,v 1.2 2011/01/24 23:31:52 ewillink Exp $
 */

package org.eclipse.ocl.examples.test.generic;

/**
 * Tests for Boolean operations.
 */
@SuppressWarnings("nls")
public abstract class GenericEvaluateBooleanOperationsTest
	extends GenericTestSuite {

    @Override
    protected void setUp() {
        super.setUp();
//        helper.setContext(getMetaclass("Package"));
        helper.setContext(getMetaclass("String"));
    }

	public void testBooleanAnd() {
		assertQueryFalse(null, "false and false");
		assertQueryFalse(null, "false and true");
		assertQueryFalse(null, "true and false");
		assertQueryTrue(null, "true and true");
		// invalid
		assertQueryFalse(null, "let b : Boolean = invalid in false and b");
		assertQueryInvalid(null, "let b : Boolean = invalid in true and b");
		assertQueryFalse(null, "let a : Boolean = invalid in a and false");
		assertQueryInvalid(null, "let a : Boolean = invalid in a and true");
		assertQueryInvalid(null, "let a : Boolean = invalid, b : Boolean = invalid in a and b");
		// null
		assertQueryFalse(null, "let b : Boolean = null in false and b");
		assertQueryInvalid(null, "let b : Boolean = null in true and b");
		assertQueryFalse(null, "let a : Boolean = null in a and false");
		assertQueryInvalid(null, "let a : Boolean = null in a and true");
		assertQueryInvalid(null, "let a : Boolean = null, b : Boolean = null in a and b");
	}

	public void testBooleanEqual() {
		assertQueryFalse(null, "true = false");

		assertQueryTrue(null, "true = true");
		assertQueryTrue(null, "false = false");
		// invalid
		assertQueryInvalid(null, "let b : Boolean = invalid in b = true");
		assertQueryInvalid(null, "let b : Boolean = invalid in false = b");

		assertQueryInvalid(null, "let b1 : Boolean = invalid, b2 : Boolean = invalid in b1 = b2");
		// null
		assertQueryFalse(null, "let b : Boolean = null in b = true");
		assertQueryFalse(null, "let b : Boolean = null in false = b");

		assertQueryTrue(null, "let b1 : Boolean = null, b2 : Boolean = null in b1 = b2");
	}

	public void testBooleanImplies() {
		assertQueryTrue(null, "false implies false");
		assertQueryTrue(null, "false implies true");
		assertQueryFalse(null, "true implies false");
		assertQueryTrue(null, "true implies true");
		// invalid
		assertQueryTrue(null, "let b : Boolean = invalid in false implies b");
		assertQueryInvalid(null, "let b : Boolean = invalid in true implies b");
		assertQueryInvalid(null, "let a : Boolean = invalid in a implies false");
		assertQueryTrue(null, "let a : Boolean = invalid in a implies true");
		assertQueryInvalid(null, "let a : Boolean = invalid, b : Boolean = invalid in a implies b");
		// null
		assertQueryTrue(null, "let b : Boolean = null in false implies b");
		assertQueryInvalid(null, "let b : Boolean = null in true implies b");
		assertQueryInvalid(null, "let a : Boolean = null in a implies false");
		assertQueryTrue(null, "let a : Boolean = null in a implies true");
		assertQueryInvalid(null, "let a : Boolean = null, b : Boolean = null in a implies b");
	}

	public void testBooleanNot() {
		assertQueryTrue(null, "not false");
		assertQueryFalse(null, "not true");
		// invalid
		assertQueryInvalid(null, "let a : Boolean = invalid in not a");
		// null
		assertQueryInvalid(null, "let a : Boolean = null in not a");
	}

	public void testBooleanNotEqual() {
		assertQueryTrue(null, "true <> false");

		assertQueryFalse(null, "true <> true");
		assertQueryFalse(null, "false <> false");
		// invalid
		assertQueryInvalid(null, "let b : Boolean = invalid in b <> true");
		assertQueryInvalid(null, "let b : Boolean = invalid in false <> b");

		assertQueryInvalid(null, "let b1 : Boolean = invalid, b2 : Boolean = invalid in b1 <> b2");
		// null
		assertQueryTrue(null, "let b : Boolean = null in b <> true");
		assertQueryTrue(null, "let b : Boolean = null in false <> b");

		assertQueryFalse(null, "let b1 : Boolean = null, b2 : Boolean = null in b1 <> b2");
	}

	public void testBooleanOr() {
		assertQueryFalse(null, "false or false");
		assertQueryTrue(null, "false or true");
		assertQueryTrue(null, "true or false");
		assertQueryTrue(null, "true or true");
		// invalid
		assertQueryInvalid(null, "let b : Boolean = invalid in false or b");
		assertQueryTrue(null, "let b : Boolean = invalid in true or b");
		assertQueryInvalid(null, "let a : Boolean = invalid in a or false");
		assertQueryTrue(null, "let a : Boolean = invalid in a or true");
		assertQueryInvalid(null, "let a : Boolean = invalid, b : Boolean = invalid in a or b");
		// null
		assertQueryInvalid(null, "let b : Boolean = null in false or b");
		assertQueryTrue(null, "let b : Boolean = null in true or b");
		assertQueryInvalid(null, "let a : Boolean = null in a or false");
		assertQueryTrue(null, "let a : Boolean = null in a or true");
		assertQueryInvalid(null, "let a : Boolean = null, b : Boolean = null in a or b");
	}

	public void testBooleanToString() {
		assertQueryEquals(null, "false", "false.toString()");
		assertQueryEquals(null, "true", "true.toString()");
		assertQueryEquals(null, "true", "(not false).toString()");
	}

	public void testBooleanXor() {
		assertQueryFalse(null, "false xor false");
		assertQueryTrue(null, "false xor true");
		assertQueryTrue(null, "true xor false");
		assertQueryFalse(null, "true xor true");
		// invalid
		assertQueryInvalid(null, "let b : Boolean = invalid in false xor b");
		assertQueryInvalid(null, "let b : Boolean = invalid in true xor b");
		assertQueryInvalid(null, "let a : Boolean = invalid in a xor false");
		assertQueryInvalid(null, "let a : Boolean = invalid in a xor true");
		assertQueryInvalid(null, "let a : Boolean = invalid, b : Boolean = invalid in a xor b");
		// xor
		assertQueryInvalid(null, "let b : Boolean = null in false xor b");
		assertQueryInvalid(null, "let b : Boolean = null in true xor b");
		assertQueryInvalid(null, "let a : Boolean = null in a xor false");
		assertQueryInvalid(null, "let a : Boolean = null in a xor true");
		assertQueryInvalid(null, "let a : Boolean = null, b : Boolean = null in a xor b");
	}
}
