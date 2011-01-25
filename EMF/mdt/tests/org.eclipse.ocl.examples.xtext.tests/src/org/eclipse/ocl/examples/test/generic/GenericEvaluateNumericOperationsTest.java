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
 * $Id: GenericEvaluateNumericOperationsTest.java,v 1.2 2011/01/24 23:31:52 ewillink Exp $
 */

package org.eclipse.ocl.examples.test.generic;

import java.math.BigDecimal;

/**
 * Tests for numeric operations.
 */
@SuppressWarnings("nls")
public abstract class GenericEvaluateNumericOperationsTest
	extends GenericTestSuite {

	protected double doubleEpsilon = Math.pow(0.5, Double.SIZE-12);

    @Override
    protected void setUp() {
        super.setUp();
//        helper.setContext(getMetaclass(denormalize("%Package")));
        helper.setContext(getMetaclass("Classifier"));
    }
    
	public void testNumberAbs() {
		// Integer::abs()
		assertQueryEquals(null, 3, "3.abs()");
		assertQueryEquals(null, 3, "(-3).abs()");

		// Real::abs()
		assertQueryEquals(null, 3.0, "(3.0).abs()", 0.0);
		assertQueryEquals(null, 3.0, "(-3.0).abs()", 0.0);
		assertQueryEquals(null, 3.1758, "(3.1758).abs()", 0.0);
		// invalid
		assertQueryInvalid(null, "let i : Integer = invalid in i.abs()");
		assertQueryInvalid(null, "let r : Real = invalid in r.abs()");
		// null
		assertQueryInvalid(null, "let i : Integer = null in i.abs()");
		assertQueryInvalid(null, "let r : Real = null in r.abs()");
	}

	public void testNumberDiv() {
		assertQueryEquals(null, 1, "3.div(2)");
		assertQueryEquals(null, -1, "(-3).div(2)");
		assertQueryEquals(null, -1, "3.div(-2)");
		assertQueryEquals(null, 1, "(-3).div(-2)");
		// by zero
		assertQueryInvalid(null, "1.div(0)");
		// invalid
		assertQueryInvalid(null, "let i : Integer = invalid in 1.div(i)");
		assertQueryInvalid(null, "let i : Integer = invalid in i.div(1)");
		assertQueryInvalid(null, "let i1 : Integer = invalid, i2 : Integer = invalid in i1.div(i2)");
		// null
		assertQueryInvalid(null, "let i : Integer = null in 1.div(i)");
		assertQueryInvalid(null, "let i : Integer = null in i.div(1)");
		assertQueryInvalid(null, "let i1 : Integer = null, i2 : Integer = null in i1.div(i2)");
	}

	public void testNumberDivide() {
		// A.2.1.3 Contrary to other operations, "Integer x Integer -> Real"
		// Integer::/(Integer)
		assertQueryEquals(null, 1.0, "1 / 1", 0.0);
		assertQueryEquals(null, -0.25, "1 / -4", 0.0);

		// Integer::/(Real)
		assertQueryEquals(null, 1.0, "1 / 1.0", 0.0);
		assertQueryEquals(null, -0.25, "1 / -4.0", 0.0);

		// Real::/(Integer)
		assertQueryEquals(null, 1.0, "1.0 / 1", 0.0);
		assertQueryEquals(null, -0.25, "1.0 / -4", 0.0);

		// Real::/(Real)
		assertQueryEquals(null, 1.0, "1.0 / 1.0", 0.0);
		assertQueryEquals(null, 1.11 / 1.12, "1.11 / 1.12", 1 * doubleEpsilon);
		
		// by zero
		assertQueryInvalid(null, "1 / 0");
		assertQueryInvalid(null, "1.0 / 0");
		assertQueryInvalid(null, "1 / 0.0");
		assertQueryInvalid(null, "1.0 / 0.0");

		// invalid
		assertQueryInvalid(null, "let i : Integer = invalid in 1 / i");
		assertQueryInvalid(null, "let i : Integer = invalid in i / 1");
		assertQueryInvalid(null, "let r : Real = invalid in 1 / r");
		assertQueryInvalid(null, "let r : Real = invalid in r / 1");

		assertQueryInvalid(null, "let i1 : Integer = invalid, i2 : Integer = invalid in i1 / i2");
		assertQueryInvalid(null, "let r1 : Real = invalid, r2 : Real = invalid in r1 / r2");

		// null
		assertQueryInvalid(null, "let i : Integer = null in 1 / i");
		assertQueryInvalid(null, "let i : Integer = null in i / 1");
		assertQueryInvalid(null, "let r : Real = null in 1 / r");
		assertQueryInvalid(null, "let r : Real = null in r / 1");

		assertQueryInvalid(null, "let i1 : Integer = null, i2 : Integer = null in i1 / i2");
		assertQueryInvalid(null, "let r1 : Real = null, r2 : Real = null in r1 / r2");
	}

	public void testNumberEqual() {
		assertQueryFalse(null, "4 = 5");
		assertQueryFalse(null, "1 = 4.0");
		assertQueryFalse(null, "1.0 = 4");
		assertQueryFalse(null, "1.0 = 4.0");

		assertQueryTrue(null, "4 = 4");
		assertQueryTrue(null, "1 = 1.0");
		assertQueryTrue(null, "1.0 = 1");
		assertQueryTrue(null, "1.0 = 1.0");
		// invalid
		assertQueryInvalid(null, "let i : Integer = invalid in i = 0");
		assertQueryInvalid(null, "let i : Integer = invalid in -1 = i");
		assertQueryInvalid(null, "let r : Real = invalid in r = 0.0");
		assertQueryInvalid(null, "let r : Real = invalid in -1.0 = r");

		assertQueryInvalid(null, "let i1 : Integer = invalid, i2 : Integer = invalid in i1 = i2");
		assertQueryInvalid(null, "let r1 : Real = invalid, r2 : Real = invalid in r1 = r2");
		// null
		assertQueryFalse(null, "let i : Integer = null in i = 0");
		assertQueryFalse(null, "let i : Integer = null in -1 = i");
		assertQueryFalse(null, "let r : Real = null in r = 0.0");
		assertQueryFalse(null, "let r : Real = null in -1.0 = r");

		assertQueryTrue(null, "let i1 : Integer = null, i2 : Integer = null in i1 = i2");
		assertQueryTrue(null, "let r1 : Real = null, r2 : Real = null in r1 = r2");
	}

	public void testNumberFloor() {
		// Integer::floor()
		assertQueryEquals(null, 3, "3.floor()");
		assertQueryEquals(null, -3, "(-3).floor()");

		// Real::floor()
		assertQueryEquals(null, -2, "(-1.5).floor()");
		assertQueryEquals(null, 1, "(1.01).floor()");
		assertQueryEquals(null, 3, "(3.999).floor()");
		// invalid
		assertQueryInvalid(null, "let i : Integer = invalid in i.floor()");
		assertQueryInvalid(null, "let r : Real = invalid in r.floor()");
		// null
		assertQueryInvalid(null, "let i : Integer = null in i.floor()");
		assertQueryInvalid(null, "let r : Real = null in r.floor()");
	}

	public void testNumberGreaterThan() {
		// Integer::greaterThan(Integer)
		assertQueryTrue(null, "3 > 2");
		assertQueryFalse(null, "-3 > 2");
		assertQueryTrue(null, "3 > -2");
		assertQueryFalse(null, "-3 > -2");

		// Real::greaterThan(Real)
		assertQueryTrue(null, "3.0 > 2.0");
		assertQueryFalse(null, "-3.0 > 2.0");
		assertQueryTrue(null, "3.0 > -2.0");
		assertQueryFalse(null, "-3.0 > -2.0");

		// Real::greaterThan(Integer)
		assertQueryFalse(null, "3.0 > 3");
		assertQueryFalse(null, "-3.0 > 3");
		assertQueryTrue(null, "3.0 > -3");
		assertQueryFalse(null, "-3.0 > -3");

		// Integer::greaterThan(Real)
		assertQueryFalse(null, "3 > 3.0");
		assertQueryFalse(null, "-3 > 3.0");
		assertQueryTrue(null, "3 > -3.0");
		assertQueryFalse(null, "-3 > -3.0");

		// invalid
		assertQueryInvalid(null, "let i : Integer = invalid in i > 0");
		assertQueryInvalid(null, "let i : Integer = invalid in 0 > i");
		assertQueryInvalid(null, "let r : Real = invalid in r > 0");
		assertQueryInvalid(null, "let r : Real = invalid in 0 > r");

		assertQueryInvalid(null, "let i1 : Integer = invalid, i2 : Integer = invalid in i1 > i2");
		assertQueryInvalid(null, "let r1 : Real = invalid, r2 : Real = invalid in r1 > r2");

		// null
		assertQueryInvalid(null, "let i : Integer = null in i > 0");
		assertQueryInvalid(null, "let i : Integer = null in 0 > i");
		assertQueryInvalid(null, "let r : Real = null in r > 0");
		assertQueryInvalid(null, "let r : Real = null in 0 > r");

		assertQueryInvalid(null, "let i1 : Integer = null, i2 : Integer = null in i1 > i2");
		assertQueryInvalid(null, "let r1 : Real = null, r2 : Real = null in r1 > r2");
	}

	public void testNumberGreaterThanOrEqual() {
		// Integer::greaterThanOrEqual(Integer)
		assertQueryTrue(null, "3 >= 2");
		assertQueryFalse(null, "-3 >= 2");
		assertQueryTrue(null, "3 >= -2");
		assertQueryFalse(null, "-3 >= -2");

		// Real::greaterThanOrEqual(Real)
		assertQueryTrue(null, "3.0 >= 2.0");
		assertQueryFalse(null, "-3.0 >= 2.0");
		assertQueryTrue(null, "3.0 >= -2.0");
		assertQueryFalse(null, "-3.0 >= -2.0");

		// Real::greaterThanOrEqual(Integer)
		assertQueryTrue(null, "3.0 >= 3");
		assertQueryFalse(null, "-3.0 >= 3");
		assertQueryTrue(null, "3.0 >= -3");
		assertQueryTrue(null, "-3.0 >= -3");

		// Integer::greaterThanOrEqual(Real)
		assertQueryTrue(null, "3 >= 3.0");
		assertQueryFalse(null, "-3 >= 3.0");
		assertQueryTrue(null, "3 >= -3.0");
		assertQueryTrue(null, "-3 >= -3.0");

		// invalid
		assertQueryInvalid(null, "let i : Integer = invalid in i >= 0");
		assertQueryInvalid(null, "let i : Integer = invalid in 0 >= i");
		assertQueryInvalid(null, "let r : Real = invalid in r >= 0");
		assertQueryInvalid(null, "let r : Real = invalid in 0 >= r");

		assertQueryInvalid(null, "let i1 : Integer = invalid, i2 : Integer = invalid in i1 >= i2");
		assertQueryInvalid(null, "let r1 : Real = invalid, r2 : Real = invalid in r1 >= r2");

		// null
		assertQueryInvalid(null, "let i : Integer = null in i >= 0");
		assertQueryInvalid(null, "let i : Integer = null in 0 >= i");
		assertQueryInvalid(null, "let r : Real = null in r >= 0");
		assertQueryInvalid(null, "let r : Real = null in 0 >= r");

		assertQueryInvalid(null, "let i1 : Integer = null, i2 : Integer = null in i1 >= i2");
		assertQueryInvalid(null, "let r1 : Real = null, r2 : Real = null in r1 >= r2");
	}

	public void testNumberLessThan() {
		// Integer::lessThan(Integer)
		assertQueryFalse(null, "3 < 2");
		assertQueryTrue(null, "-3 < 2");
		assertQueryFalse(null, "3 < -2");
		assertQueryTrue(null, "-3 < -2");

		// Real::lessThan(Real)
		assertQueryFalse(null, "3.0 < 2.0");
		assertQueryTrue(null, "-3.0 < 2.0");
		assertQueryFalse(null, "3.0 < -2.0");
		assertQueryTrue(null, "-3.0 < -2.0");

		// Real::lessThan(Integer)
		assertQueryFalse(null, "3.0 < 3");
		assertQueryTrue(null, "-3.0 < 3");
		assertQueryFalse(null, "3.0 < -3");
		assertQueryFalse(null, "-3.0 < -3");

		// Integer::lessThan(Real)
		assertQueryFalse(null, "3 < 3.0");
		assertQueryTrue(null, "-3 < 3.0");
		assertQueryFalse(null, "3 < -3.0");
		assertQueryFalse(null, "-3 < -3.0");

		// invalid
		assertQueryInvalid(null, "let i : Integer = invalid in i < 0");
		assertQueryInvalid(null, "let i : Integer = invalid in 0 < i");
		assertQueryInvalid(null, "let r : Real = invalid in r < 0");
		assertQueryInvalid(null, "let r : Real = invalid in 0 < r");

		assertQueryInvalid(null, "let i1 : Integer = invalid, i2 : Integer = invalid in i1 < i2");
		assertQueryInvalid(null, "let r1 : Real = invalid, r2 : Real = invalid in r1 < r2");

		// null
		assertQueryInvalid(null, "let i : Integer = null in i < 0");
		assertQueryInvalid(null, "let i : Integer = null in 0 < i");
		assertQueryInvalid(null, "let r : Real = null in r < 0");
		assertQueryInvalid(null, "let r : Real = null in 0 < r");

		assertQueryInvalid(null, "let i1 : Integer = null, i2 : Integer = null in i1 < i2");
		assertQueryInvalid(null, "let r1 : Real = null, r2 : Real = null in r1 < r2");
	}

	public void testNumberLessThanOrEqual() {
		// Integer::lessThanOrEqual(Integer)
		assertQueryFalse(null, "3 <= 2");
		assertQueryTrue(null, "-3 <= 2");
		assertQueryFalse(null, "3 <= -2");
		assertQueryTrue(null, "-3 <= -2");

		// Real::lessThanOrEqual(Real)
		assertQueryFalse(null, "3.0 <= 2.0");
		assertQueryTrue(null, "-3.0 <= 2.0");
		assertQueryFalse(null, "3.0 <= -2.0");
		assertQueryTrue(null, "-3.0 <= -2.0");

		// Real::lessThanOrEqual(Integer)
		assertQueryTrue(null, "3.0 <= 3");
		assertQueryTrue(null, "-3.0 <= 3");
		assertQueryFalse(null, "3.0 <= -3");
		assertQueryTrue(null, "-3.0 <= -3");

		// Integer::lessThanOrEqual(Real)
		assertQueryTrue(null, "3 <= 3.0");
		assertQueryTrue(null, "-3 <= 3.0");
		assertQueryFalse(null, "3 <= -3.0");
		assertQueryTrue(null, "-3 <= -3.0");

		// invalid
		assertQueryInvalid(null, "let i : Integer = invalid in i <= 0");
		assertQueryInvalid(null, "let i : Integer = invalid in 0 <= i");
		assertQueryInvalid(null, "let r : Real = invalid in r <= 0");
		assertQueryInvalid(null, "let r : Real = invalid in 0 <= r");

		assertQueryInvalid(null, "let i1 : Integer = invalid, i2 : Integer = invalid in i1 <= i2");
		assertQueryInvalid(null, "let r1 : Real = invalid, r2 : Real = invalid in r1 <= r2");

		// null
		assertQueryInvalid(null, "let i : Integer = null in i <= 0");
		assertQueryInvalid(null, "let i : Integer = null in 0 <= i");
		assertQueryInvalid(null, "let r : Real = null in r <= 0");
		assertQueryInvalid(null, "let r : Real = null in 0 <= r");

		assertQueryInvalid(null, "let i1 : Integer = null, i2 : Integer = null in i1 <= i2");
		assertQueryInvalid(null, "let r1 : Real = null, r2 : Real = null in r1 <= r2");
	}

	public void testNumberMax() {
		// Integer::max(Integer)
		assertQueryEquals(null, 3, "3.max(2)");
		assertQueryEquals(null, 2, "(-3).max(2)");
		assertQueryEquals(null, 3, "3.max(-2)");
		assertQueryEquals(null, -2, "(-3).max(-2)");

		// Integer::max(Real)
		assertQueryEquals(null, 3.0, "3.max(2.0)", 0.0);
		assertQueryEquals(null, 2.0, "(-3).max(2.0)", 0.0);
		assertQueryEquals(null, 3.0, "3.max(-2.0)", 0.0);
		assertQueryEquals(null, -2.0, "(-3).max(-2.0)", 0.0);

		// Real::max(Integer)
		assertQueryEquals(null, 3.0, "(3.0).max(2)", 0.0);
		assertQueryEquals(null, 2.0, "(-3.0).max(2)", 0.0);
		assertQueryEquals(null, 3.0, "(3.0).max(-2)", 0.0);
		assertQueryEquals(null, -2.0, "(-3.0).max(-2)", 0.0);

		// Real::max(Real)
		assertQueryEquals(null, 3.0, "(3.0).max(2.0)", 0.0);
		assertQueryEquals(null, 2.0, "(-3.0).max(2.0)", 0.0);
		assertQueryEquals(null, 3.0, "(3.0).max(-2.0)", 0.0);
		assertQueryEquals(null, -2.0, "(-3.0).max(-2.0)", 0.0);

		// invalid
		assertQueryInvalid(null, "let i : Integer = invalid in 1.max(i)");
		assertQueryInvalid(null, "let i : Integer = invalid in i.max(1)");
		assertQueryInvalid(null, "let r : Real = invalid in 1.max(r)");
		assertQueryInvalid(null, "let r : Real = invalid in r.max(1)");

		assertQueryInvalid(null, "let i1 : Integer = invalid, i2 : Integer = invalid in i1.max(i2)");
		assertQueryInvalid(null, "let r1 : Real = invalid, r2 : Real = invalid in r1.max(r2)");

		// null
		assertQueryInvalid(null, "let i : Integer = null in 1.max(i)");
		assertQueryInvalid(null, "let i : Integer = null in i.max(1)");
		assertQueryInvalid(null, "let r : Real = null in 1.max(r)");
		assertQueryInvalid(null, "let r : Real = null in r.max(1)");

		assertQueryInvalid(null, "let i1 : Integer = null, i2 : Integer = null in i1.max(i2)");
		assertQueryInvalid(null, "let r1 : Real = null, r2 : Real = null in r1.max(r2)");
	}

	public void testNumberMin() {
		// Integer::min(Integer)
		assertQueryEquals(null, 2, "3.min(2)");
		assertQueryEquals(null, -3, "(-3).min(2)");
		assertQueryEquals(null, -2, "3.min(-2)");
		assertQueryEquals(null, -3, "(-3).min(-2)");

		// Integer::min(Real)
		assertQueryEquals(null, 2.0, "3.min(2.0)", 0.0);
		assertQueryEquals(null, -3.0, "(-3).min(2.0)", 0.0);
		assertQueryEquals(null, -2.0, "3.min(-2.0)", 0.0);
		assertQueryEquals(null, -3.0, "(-3).min(-2.0)", 0.0);

		// Real::min(Integer)
		assertQueryEquals(null, 2.0, "(3.0).min(2)", 0.0);
		assertQueryEquals(null, -3.0, "(-3.0).min(2)", 0.0);
		assertQueryEquals(null, -2.0, "(3.0).min(-2)", 0.0);
		assertQueryEquals(null, -3.0, "(-3.0).min(-2)", 0.0);

		// Real::min(Real)
		assertQueryEquals(null, 2.0, "(3.0).min(2.0)", 0.0);
		assertQueryEquals(null, -3.0, "(-3.0).min(2.0)", 0.0);
		assertQueryEquals(null, -2.0, "(3.0).min(-2.0)", 0.0);
		assertQueryEquals(null, -3.0, "(-3.0).min(-2.0)", 0.0);

		// invalid
		assertQueryInvalid(null, "let i : Integer = invalid in 1.min(i)");
		assertQueryInvalid(null, "let i : Integer = invalid in i.min(1)");
		assertQueryInvalid(null, "let r : Real = invalid in 1.min(r)");
		assertQueryInvalid(null, "let r : Real = invalid in r.min(1)");

		assertQueryInvalid(null, "let i1 : Integer = invalid, i2 : Integer = invalid in i1.min(i2)");
		assertQueryInvalid(null, "let r1 : Real = invalid, r2 : Real = invalid in r1.min(r2)");

		// null
		assertQueryInvalid(null, "let i : Integer = null in 1.min(i)");
		assertQueryInvalid(null, "let i : Integer = null in i.min(1)");
		assertQueryInvalid(null, "let r : Real = null in 1.min(r)");
		assertQueryInvalid(null, "let r : Real = null in r.min(1)");

		assertQueryInvalid(null, "let i1 : Integer = null, i2 : Integer = null in i1.min(i2)");
		assertQueryInvalid(null, "let r1 : Real = null, r2 : Real = null in r1.min(r2)");
	}

	public void testNumberMinus() {
		// Integer::-(Integer)
		assertQueryEquals(null, 0, "1 - 1");
		assertQueryEquals(null, 5, "1 - -4");

		// Integer::-(Real)
		assertQueryEquals(null, 0.0, "1 - 1.0", 2 * doubleEpsilon);
		assertQueryEquals(null, 5.0, "1 - -4.0", 5 * doubleEpsilon);

		// Real::-(Integer)
		assertQueryEquals(null, 0.0, "1.0 - 1", 2 * doubleEpsilon);
		assertQueryEquals(null, 5.0, "1.0 - -4", 5 * doubleEpsilon);

		// Real::-(Real)
		assertQueryEquals(null, 0.0, "1.0 - 1.0", 2 * doubleEpsilon);
		assertQueryEquals(null, -0.01, "1.11 - 1.12", 3 * doubleEpsilon);

		// invalid
		assertQueryInvalid(null, "let i : Integer = invalid in 1 - i");
		assertQueryInvalid(null, "let i : Integer = invalid in i - 1");
		assertQueryInvalid(null, "let r : Real = invalid in 1 - r");
		assertQueryInvalid(null, "let r : Real = invalid in r - 1");

		assertQueryInvalid(null, "let i1 : Integer = invalid, i2 : Integer = invalid in i1 - i2");
		assertQueryInvalid(null, "let r1 : Real = invalid, r2 : Real = invalid in r1 - r2");

		// null
		assertQueryInvalid(null, "let i : Integer = null in 1 - i");
		assertQueryInvalid(null, "let i : Integer = null in i - 1");
		assertQueryInvalid(null, "let r : Real = null in 1 - r");
		assertQueryInvalid(null, "let r : Real = null in r - 1");

		assertQueryInvalid(null, "let i1 : Integer = null, i2 : Integer = null in i1 - i2");
		assertQueryInvalid(null, "let r1 : Real = null, r2 : Real = null in r1 - r2");
	}

	public void testNumberMod() {
		assertQueryEquals(null, 1, "3.mod(2)");
		assertQueryEquals(null, -1, "(-3).mod(2)");
		assertQueryEquals(null, 1, "3.mod(-2)");
		assertQueryEquals(null, -1, "(-3).mod(-2)");

		// by zero
		assertQueryInvalid(null, "1.mod(0)");

		// invalid
		assertQueryInvalid(null, "let i : Integer = invalid in 1.mod(i)");
		assertQueryInvalid(null, "let i : Integer = invalid in i.mod(1)");

		assertQueryInvalid(null, "let i1 : Integer = invalid, i2 : Integer = invalid in i1.mod(i2)");

		// null
		assertQueryInvalid(null, "let i : Integer = null in 1.mod(i)");
//		assertQueryInvalid(null, "let i : Integer = null in mod(1)");

		assertQueryInvalid(null, "let i1 : Integer = null, i2 : Integer = null in i1.mod(i2)");
	}

	public void testNumberNegate() {
		assertQueryEquals(null, -1, "-1");
		assertQueryEquals(null, -1.0, "-1.0", 0.0);
		// invalid
		assertQueryInvalid(null, "let i : Integer = invalid in -i");
		assertQueryInvalid(null, "let r : Real = invalid in -r");
		// null
		assertQueryInvalid(null, "let i : Integer = null in -i");
		assertQueryInvalid(null, "let r : Real = null in -r");
	}

	public void testNumberNotEqual() {
		assertQueryTrue(null, "4 <> 5");
		assertQueryTrue(null, "1 <> 4.0");
		assertQueryTrue(null, "1.0 <> 4");
		assertQueryTrue(null, "1.0 <> 4.0");

		assertQueryFalse(null, "4 <> 4");
		assertQueryFalse(null, "1 <> 1.0");
		assertQueryFalse(null, "1.0 <> 1");
		assertQueryFalse(null, "1.0 <> 1.0");
		// invalid
		assertQueryInvalid(null, "let i : Integer = invalid in i <> 0");
		assertQueryInvalid(null, "let i : Integer = invalid in -1 <> i");
		assertQueryInvalid(null, "let r : Real = invalid in r <> 0.0");
		assertQueryInvalid(null, "let r : Real = invalid in -1.0 <> r");

		assertQueryInvalid(null, "let i1 : Integer = invalid, i2 : Integer = invalid in i1 <> i2");
		assertQueryInvalid(null, "let r1 : Real = invalid, r2 : Real = invalid in r1 <> r2");
		// null
		assertQueryTrue(null, "let i : Integer = null in i <> 0");
		assertQueryTrue(null, "let i : Integer = null in -1 <> i");
		assertQueryTrue(null, "let r : Real = null in r <> 0.0");
		assertQueryTrue(null, "let r : Real = null in -1.0 <> r");

		assertQueryFalse(null, "let i1 : Integer = null, i2 : Integer = null in i1 <> i2");
		assertQueryFalse(null, "let r1 : Real = null, r2 : Real = null in r1 <> r2");
	}


	public void testNumberPlus() {
		// Integer::+(Integer)
		assertQueryEquals(null, 2, "1 + 1");
		assertQueryEquals(null, -3, "1 + -4");

		// Integer::+(Real)
		assertQueryEquals(null, 2.0, "1 + 1.0", 2 * doubleEpsilon);
		assertQueryEquals(null, -3.0, "1 + -4.0", 5 * doubleEpsilon);

		// Real::+(Integer)
		assertQueryEquals(null, 2.0, "1.0 + 1", 2 * doubleEpsilon);
		assertQueryEquals(null, -3.0, "1.0 + -4", 5 * doubleEpsilon);

		// Real::+(Real)
		assertQueryEquals(null, 2.0, "1.0 + 1.0", 2 * doubleEpsilon);
		assertQueryEquals(null, 2.23, "1.11 + 1.12", 3 * doubleEpsilon);

		// invalid
		assertQueryInvalid(null, "let i : Integer = invalid in 1 + i");
		assertQueryInvalid(null, "let i : Integer = invalid in i + 1");
		assertQueryInvalid(null, "let r : Real = invalid in 1 + r");
		assertQueryInvalid(null, "let r : Real = invalid in r + 1");

		assertQueryInvalid(null, "let i1 : Integer = invalid, i2 : Integer = invalid in i1 + i2");
		assertQueryInvalid(null, "let r1 : Real = invalid, r2 : Real = invalid in r1 + r2");

		// null
		assertQueryInvalid(null, "let i : Integer = null in 1 + i");
		assertQueryInvalid(null, "let i : Integer = null in i + 1");
		assertQueryInvalid(null, "let r : Real = null in 1 + r");
		assertQueryInvalid(null, "let r : Real = null in r + 1");

		assertQueryInvalid(null, "let i1 : Integer = null, i2 : Integer = null in i1 + i2");
		assertQueryInvalid(null, "let r1 : Real = null, r2 : Real = null in r1 + r2");
	}

	public void testNumberRound() {
		// Integer::round()
		assertQueryEquals(null, 3, "3.round()");
		assertQueryEquals(null, -3, "(-3).round()");

		// Real::round()
		assertQueryEquals(null, -1, "(-1.5).round()");
		assertQueryEquals(null, 1, "(1.01).round()");
		assertQueryEquals(null, 4, "(3.999).round()");
		// invalid
		assertQueryInvalid(null, "let i : Integer = invalid in i.round()");
		assertQueryInvalid(null, "let r : Real = invalid in r.round()");
		// null
		assertQueryInvalid(null, "let i : Integer = null in i.round()");
		assertQueryInvalid(null, "let r : Real = null in r.round()");
	}

	public void testNumberTimes() {
		// Integer::*(Integer)
		assertQueryEquals(null, 1, "1 * 1");
		assertQueryEquals(null, -4, "1 * -4");

		// Integer::*(Real)
		assertQueryEquals(null, 1.0, "1 * 1.0", 0.0);
		assertQueryEquals(null, -4.0, "1 * -4.0", 0.0);

		// Real::*(Integer)
		assertQueryEquals(null, 1.0, "1.0 * 1", 0.0);
		assertQueryEquals(null, -4.0, "1.0 * -4", 0.0);

		// Real::*(Real)
		assertQueryEquals(null, 1.0, "1.0 * 1.0", 0.0);
		assertQueryEquals(null, BigDecimal.valueOf(1.11).multiply(BigDecimal.valueOf(1.12)), "1.11 * 1.12", 0.0);

		// invalid
		assertQueryInvalid(null, "let i : Integer = invalid in 1 * i");
		assertQueryInvalid(null, "let i : Integer = invalid in i * 1");
		assertQueryInvalid(null, "let r : Real = invalid in 1 * r");
		assertQueryInvalid(null, "let r : Real = invalid in r * 1");

		assertQueryInvalid(null, "let i1 : Integer = invalid, i2 : Integer = invalid in i1 * i2");
		assertQueryInvalid(null, "let r1 : Real = invalid, r2 : Real = invalid in r1 * r2");

		// null
		assertQueryInvalid(null, "let i : Integer = null in 1 * i");
		assertQueryInvalid(null, "let i : Integer = null in i * 1");
		assertQueryInvalid(null, "let r : Real = null in 1 * r");
		assertQueryInvalid(null, "let r : Real = null in r * 1");

		assertQueryInvalid(null, "let i1 : Integer = null, i2 : Integer = null in i1 * i2");
		assertQueryInvalid(null, "let r1 : Real = null, r2 : Real = null in r1 * r2");
	}

	public void testNumberToString() {
		assertQueryEquals(null, "1", "1.toString()");
		assertQueryEquals(null, "3.0", "3.0.toString()");
		assertQueryEquals(null, "4.0", "(1.0+3.0).toString()");
		assertQueryEquals(null, "null", "null.toString()");
		assertQueryEquals(null, "invalid", "invalid.toString()");
		assertQueryEquals(null, "*", "*.toString()");
	}

	public void testUnlimitedAbs() {
		assertQueryInvalid(null, "*.abs()");
		// invalid
		assertQueryInvalid(null, "let u : UnlimitedNatural = invalid in u.abs()");
		// null
		assertQueryInvalid(null, "let u : UnlimitedNatural = null in u.abs()");
	}

/* FIXME	public void testUnlimitedDiv() {
		/ *
		 * FIXME I'm expecting the UnlimitedNatural to conform to Integer, div
		 * and mod calls should then at least parse for them even though they
		 * return an invalid value.
		 * /
		assertQueryInvalid(null, "1.div(*)");
		assertQueryInvalid(null, "*.div(1)");

		assertQueryInvalid(null, "*.div(*)");
		// invalid
		assertQueryInvalid(null, "let u : UnlimitedNatural = invalid in 1.div(u)");
		assertQueryInvalid(null, "let u : UnlimitedNatural = invalid in u.div(1)");
		// null
		assertQueryInvalid(null, "let u : UnlimitedNatural = null in 1.div(u)");
		assertQueryInvalid(null, "let u : UnlimitedNatural = null in u.div(1)");
	} */

	public void testUnlimitedDivide() {
		assertQueryInvalid(null, "1 / *");
		assertQueryInvalid(null, "* / 1");

		assertQueryInvalid(null, "1.0 / *");
		assertQueryInvalid(null, "* / 1.0");

		assertQueryInvalid(null, "* / *");

		// by zero
		assertQueryInvalid(null, "* / 0");
		assertQueryInvalid(null, "* / 0.0");

		// invalid
		assertQueryInvalid(null, "let u : UnlimitedNatural = invalid in * / u");
		assertQueryInvalid(null, "let u : UnlimitedNatural = invalid in u / *");

		assertQueryInvalid(null, "let u1 : UnlimitedNatural = invalid, u2 : UnlimitedNatural = invalid in u1 / u2");

		// null
		assertQueryInvalid(null, "let u : UnlimitedNatural = null in * / u");
		assertQueryInvalid(null, "let u : UnlimitedNatural = null in u / *");

		assertQueryInvalid(null, "let u1 : UnlimitedNatural = null, u2 : UnlimitedNatural = null in u1 / u2");
	}

	public void testUnlimitedEqual() {
		assertQueryFalse(null, "* = 1");
		assertQueryFalse(null, "1 = *");
		assertQueryFalse(null, "* = 1.0");
		assertQueryFalse(null, "1.0 = *");
		assertQueryFalse(null, "* = -1");
		assertQueryFalse(null, "-1 = *");
		assertQueryFalse(null, "* = -1.0");
		assertQueryFalse(null, "-1.0 = *");

		assertQueryTrue(null, "* = *");
		// invalid
		assertQueryInvalid(null, "let u : UnlimitedNatural = invalid in u = *");

		assertQueryInvalid(null, "let u1 : UnlimitedNatural = invalid, u2 : UnlimitedNatural = invalid in u1 = u2");
		// null
		assertQueryFalse(null, "let u : UnlimitedNatural = null in u = *");

		assertQueryTrue(null, "let u1 : UnlimitedNatural = null, u2 : UnlimitedNatural = null in u1 = u2");
	}

	public void testUnlimitedFloor() {
		assertQueryInvalid(null, "*.floor()");

		// invalid
		assertQueryInvalid(null, "let u : UnlimitedNatural = invalid in u.floor()");

		// null
		assertQueryInvalid(null, "let u : UnlimitedNatural = null in u.floor()");
	}

	public void testUnlimitedGreaterThan() {
		assertQueryFalse(null, "1 > *");
		assertQueryTrue(null, "* > 1");
		assertQueryFalse(null, "* > *");

		// invalid
		assertQueryInvalid(null, "let u : UnlimitedNatural = invalid in u > 0");
		assertQueryInvalid(null, "let u : UnlimitedNatural = invalid in 0 > u");

		assertQueryInvalid(null, "let u1 : UnlimitedNatural = invalid, u2 : UnlimitedNatural = invalid in u1 > u2");

		// null
		assertQueryInvalid(null, "let u : UnlimitedNatural = null in u > 0");
		assertQueryInvalid(null, "let u : UnlimitedNatural = null in 0 > u");

		assertQueryInvalid(null, "let u1 : UnlimitedNatural = null, u2 : UnlimitedNatural = null in u1 > u2");
	}

	public void testUnlimitedGreaterThanOrEqual() {
		/*
		 * FIXME "(* = *) == true" but "(* >= *) == false" ? something's amiss
		 * and since this behavior isn't defined in the specification, we'll
		 * have to make an arbitrary choice. The "expected" here is Java's
		 * behavior with Double.POSITIVE_INFINITY.
		 */
		assertQueryFalse(null, "1 >= *");
		assertQueryTrue(null, "* >= 1");
		assertQueryTrue(null, "* >= *");

		// invalid
		assertQueryInvalid(null, "let u : UnlimitedNatural = invalid in u >= 0");
		assertQueryInvalid(null, "let u : UnlimitedNatural = invalid in 0 >= u");

		assertQueryInvalid(null, "let u1 : UnlimitedNatural = invalid, u2 : UnlimitedNatural = invalid in u1 >= u2");

		// null
		assertQueryInvalid(null, "let u : UnlimitedNatural = null in u >= 0");
		assertQueryInvalid(null, "let u : UnlimitedNatural = null in 0 >= u");

		assertQueryInvalid(null, "let u1 : UnlimitedNatural = null, u2 : UnlimitedNatural = null in u1 >= u2");
	}

	public void testUnlimitedLessThan() {
		assertQueryTrue(null, "1 < *");
		assertQueryFalse(null, "* < 1");
		assertQueryFalse(null, "* < *");

		// invalid
		assertQueryInvalid(null, "let u : UnlimitedNatural = invalid in u < 0");
		assertQueryInvalid(null, "let u : UnlimitedNatural = invalid in 0 < u");

		assertQueryInvalid(null, "let u1 : UnlimitedNatural = invalid, u2 : UnlimitedNatural = invalid in u1 < u2");

		// null
		assertQueryInvalid(null, "let u : UnlimitedNatural = null in u < 0");
		assertQueryInvalid(null, "let u : UnlimitedNatural = null in 0 < u");

		assertQueryInvalid(null, "let u1 : UnlimitedNatural = null, u2 : UnlimitedNatural = null in u1 < u2");
	}

	public void testUnlimitedLessThanOrEqual() {
		/*
		 * FIXME "(* = *) == true" but "(* <= *) == false" ? something's amiss
		 * and since this behavior isn't defined in the specification, we'll
		 * have to make an arbitrary choice. The "expected" here is Java's
		 * behavior with Double.POSITIVE_INFINITY.
		 */
		assertQueryTrue(null, "1 <= *");
		assertQueryFalse(null, "* <= 1");
		assertQueryTrue(null, "* <= *");

		// invalid
		assertQueryInvalid(null, "let u : UnlimitedNatural = invalid in u <= 0");
		assertQueryInvalid(null, "let u : UnlimitedNatural = invalid in 0 <= u");

		assertQueryInvalid(null, "let u1 : UnlimitedNatural = invalid, u2 : UnlimitedNatural = invalid in u1 <= u2");

		// null
		assertQueryInvalid(null, "let u : UnlimitedNatural = null in u <= 0");
		assertQueryInvalid(null, "let u : UnlimitedNatural = null in 0 <= u");

		assertQueryInvalid(null, "let u1 : UnlimitedNatural = null, u2 : UnlimitedNatural = null in u1 <= u2");
	}

	public void testUnlimitedMax() {
		assertQueryUnlimited(null, "1.max(*)");
		assertQueryUnlimited(null, "*.max(1)");

		assertQueryInvalid(null, "(1.0).max(*)");
		assertQueryInvalid(null, "*.max(1.0)");

		assertQueryUnlimited(null, "*.max(*)");

		// invalid
		assertQueryInvalid(null, "let u : UnlimitedNatural = invalid in *.max(u)");
		assertQueryInvalid(null, "let u : UnlimitedNatural = invalid in u.max(*)");

		assertQueryInvalid(null, "let u1 : UnlimitedNatural = invalid, u2 : UnlimitedNatural = invalid in u1.max(u2)");

		// null
		assertQueryInvalid(null, "let u : UnlimitedNatural = null in *.max(u)");
		assertQueryInvalid(null, "let u : UnlimitedNatural = null in u.max(*)");

		assertQueryInvalid(null, "let u1 : UnlimitedNatural = null, u2 : UnlimitedNatural = null in u1.max(u2)");
	}

	public void testUnlimitedMin() {
		assertQueryEquals(null, 1, "1.min(*)");
		assertQueryEquals(null, 1, "*.min(1)");

		assertQueryInvalid(null, "(1.0).min(*)");
		assertQueryInvalid(null, "*.min(1.0)");

		assertQueryUnlimited(null, "*.min(*)");

		// invalid
		assertQueryInvalid(null, "let u : UnlimitedNatural = invalid in *.min(u)");
		assertQueryInvalid(null, "let u : UnlimitedNatural = invalid in u.min(*)");

		assertQueryInvalid(null, "let u1 : UnlimitedNatural = invalid, u2 : UnlimitedNatural = invalid in u1.min(u2)");

		// null
		assertQueryInvalid(null, "let u : UnlimitedNatural = null in *.min(u)");
		assertQueryInvalid(null, "let u : UnlimitedNatural = null in u.min(*)");

		assertQueryInvalid(null, "let u1 : UnlimitedNatural = null, u2 : UnlimitedNatural = null in u1.min(u2)");
	}

	public void testUnlimitedMinus() {
		assertQueryInvalid(null, "1 - *");
		assertQueryInvalid(null, "* - 1");

		assertQueryInvalid(null, "1.0 - *");
		assertQueryInvalid(null, "* - 1.0");

		assertQueryInvalid(null, "* - *");

		// invalid
		assertQueryInvalid(null, "let u : UnlimitedNatural = invalid in * - u");
		assertQueryInvalid(null, "let u : UnlimitedNatural = invalid in u - *");

		assertQueryInvalid(null, "let u1 : UnlimitedNatural = invalid, u2 : UnlimitedNatural = invalid in u1 - u2");

		// null
		assertQueryInvalid(null, "let u : UnlimitedNatural = null in * - u");
		assertQueryInvalid(null, "let u : UnlimitedNatural = null in u - *");

		assertQueryInvalid(null, "let u1 : UnlimitedNatural = null, u2 : UnlimitedNatural = null in u1 - u2");
	}

/* FIXME	public void testUnlimitedMod() {
		/ *
		 * FIXME I'm expecting the UnlimitedNatural to conform to Integer, div
		 * and mod calls should then at least parse for them even though they
		 * return an invalid value.
		 * /
		assertQueryInvalid(null, "1.mod(*)");
		assertQueryInvalid(null, "*.mod(1)");

		assertQueryInvalid(null, "*.mod(*)");

		// invalid
		assertQueryInvalid(null, "let u : UnlimitedNatural = invalid in 1.mod(u)");
		assertQueryInvalid(null, "let u : UnlimitedNatural = invalid in u.mod(1)");

		// null
		assertQueryInvalid(null, "let u : UnlimitedNatural = null in 1.mod(u)");
		assertQueryInvalid(null, "let u : UnlimitedNatural = null in u.mod(1)");
	} */

	public void testUnlimitedNegate() {
		assertQueryInvalid(null, "-*");
		// invalid
		assertQueryInvalid(null, "let u : UnlimitedNatural = invalid in -u");
		// null
	}

	public void testUnlimitedNotEqual() {
		assertQueryTrue(null, "* <> 1");
		assertQueryTrue(null, "1 <> *");
		assertQueryTrue(null, "* <> 1.0");
		assertQueryTrue(null, "1.0 <> *");
		assertQueryTrue(null, "* <> -1");
		assertQueryTrue(null, "-1 <> *");
		assertQueryTrue(null, "* <> -1.0");
		assertQueryTrue(null, "-1.0 <> *");

		assertQueryFalse(null, "* <> *");
		// invalid
		assertQueryInvalid(null, "let u : UnlimitedNatural = invalid in u <> *");

		assertQueryInvalid(null, "let u1 : UnlimitedNatural = invalid, u2 : UnlimitedNatural = invalid in u1 <> u2");
		// null
		assertQueryTrue(null, "let u : UnlimitedNatural = null in u <> *");

		assertQueryFalse(null, "let u1 : UnlimitedNatural = null, u2 : UnlimitedNatural = null in u1 <> u2");
	}

	public void testUnlimitedPlus() {
		assertQueryInvalid(null, "1 + *");
		assertQueryInvalid(null, "* + 1");

		assertQueryInvalid(null, "1.0 + *");
		assertQueryInvalid(null, "* + 1.0");

		assertQueryInvalid(null, "* + *");
		// invalid
		assertQueryInvalid(null, "let u : UnlimitedNatural = invalid in * + u");
		assertQueryInvalid(null, "let u : UnlimitedNatural = invalid in u + *");
		assertQueryInvalid(null, "let u1 : UnlimitedNatural = invalid, u2 : UnlimitedNatural = invalid in u1 + u2");
		// null
		assertQueryInvalid(null, "let u : UnlimitedNatural = null in * + u");
		assertQueryInvalid(null, "let u : UnlimitedNatural = null in u + *");
		assertQueryInvalid(null, "let u1 : UnlimitedNatural = null, u2 : UnlimitedNatural = null in u1 + u2");
	}

	public void testUnlimitedRound() {
		assertQueryInvalid(null, "*.round()");
		// invalid
		assertQueryInvalid(null, "let u : UnlimitedNatural = invalid in u.round()");
		// null
		assertQueryInvalid(null, "let u : UnlimitedNatural = null in u.round()");
	}

	public void testUnlimitedTimes() {
		assertQueryInvalid(null, "1 * *");
		assertQueryInvalid(null, "* * 1");

		assertQueryInvalid(null, "1.0 * *");
		assertQueryInvalid(null, "* * 1.0");

		assertQueryInvalid(null, "* * *");

		// invalid
		assertQueryInvalid(null, "let u : UnlimitedNatural = invalid in * * u");
		assertQueryInvalid(null, "let u : UnlimitedNatural = invalid in u * *");

		assertQueryInvalid(null, "let u1 : UnlimitedNatural = invalid, u2 : UnlimitedNatural = invalid in u1 * u2");
		// null
		assertQueryInvalid(null, "let u : UnlimitedNatural = null in * * u");
		assertQueryInvalid(null, "let u : UnlimitedNatural = null in u * *");

		assertQueryInvalid(null, "let u1 : UnlimitedNatural = null, u2 : UnlimitedNatural = null in u1 * u2");
	}
}
