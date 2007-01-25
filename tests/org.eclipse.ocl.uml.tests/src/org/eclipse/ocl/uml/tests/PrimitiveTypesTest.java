/**
 * <copyright>
 *
 * Copyright (c) 2007 IBM Corporation and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   IBM - Initial API and implementation
 *
 * </copyright>
 *
 * $Id: PrimitiveTypesTest.java,v 1.1 2007/01/25 18:41:55 cdamus Exp $
 */

package org.eclipse.ocl.uml.tests;

import junit.framework.Test;
import junit.framework.TestSuite;

import org.eclipse.ocl.ParserException;
import org.eclipse.ocl.expressions.OCLExpression;
import org.eclipse.ocl.expressions.UnlimitedNaturalLiteralExp;
import org.eclipse.uml2.uml.Classifier;

/**
 * Tests for primitive type expressions.
 *
 * @author Christian W. Damus (cwdamus)
 */
public class PrimitiveTypesTest
	extends AbstractTestSuite {

	public PrimitiveTypesTest(String name) {
		super(name);
	}
	
	public static Test suite() {
		return new TestSuite(PrimitiveTypesTest.class, "Primitive Type Tests"); //$NON-NLS-1$
	}
    
    /**
     * Tests that we correctly interpret the UML UnlimitedNatural
     * primitive type.
     */
    public void test_unlimitedNaturalType() {
        OCLExpression<Classifier> expression = parse(
            "package uml context MultiplicityElement " + //$NON-NLS-1$
            "inv: self.upper " + //$NON-NLS-1$
            "endpackage"); //$NON-NLS-1$
        
        assertSame(
            ocl.getEnvironment().getOCLStandardLibrary().getUnlimitedNatural(),
            expression.getType());
    }
	
    /**
     * Tests declaration of variable with UnlimitedNatural type and
     * the unlimited value.
     */
	public void test_unlimitedValue() {
		OCLExpression<Classifier> expression = parse(
			"package uml context Class " + //$NON-NLS-1$
			"inv: let x : UnlimitedNatural = * in x " + //$NON-NLS-1$
			"endpackage"); //$NON-NLS-1$
		
        assertSame(
            ocl.getEnvironment().getOCLStandardLibrary().getUnlimitedNatural(),
            expression.getType());
        
		Object result = evaluate(expression);
		assertEquals(UnlimitedNaturalLiteralExp.UNLIMITED, result);
	}
    
    /**
     * Tests comparison operations involving the unlimited value.
     */
    public void test_unlimitedValueComparison() {
        helper.setContext(getOCLStandardLibrary().getUnlimitedNatural());
        
        try {
            assertFalse(check(helper, 1, "2 = *")); //$NON-NLS-1$
            assertTrue(check(helper, 1, "2 <> *")); //$NON-NLS-1$
            
            assertTrue(check(helper, 1, "2 < *")); //$NON-NLS-1$
            assertTrue(check(helper, 1, "2 <= *")); //$NON-NLS-1$
            assertTrue(check(helper, 1, "* > 2")); //$NON-NLS-1$
            assertTrue(check(helper, 1, "* >= 2")); //$NON-NLS-1$
            
            assertTrue(check(helper, 1, "* = *")); //$NON-NLS-1$
            assertFalse(check(helper, 1, "* <> *")); //$NON-NLS-1$
            
            assertFalse(check(helper, 1, "* < *")); //$NON-NLS-1$
            assertFalse(check(helper, 1, "* <= *")); //$NON-NLS-1$
            assertFalse(check(helper, 1, "* > *")); //$NON-NLS-1$
            assertFalse(check(helper, 1, "* >= *")); //$NON-NLS-1$
        } catch (Exception e) {
            fail("Failed to parse or evaluate: " + e.getLocalizedMessage()); //$NON-NLS-1$
        }
    }
    
    /**
     * Tests that operations involving integers and unlimited naturals
     * fail to parse or validate because they are incompatible types.
     */
    public void test_unlimitedValueArithmetic_integers() {
        helper.setContext(getOCLStandardLibrary().getUnlimitedNatural());
        
        try {
            assertInvalid(evaluate(helper, 1, "2 + *")); //$NON-NLS-1$
            fail("Should have failed to parse or validate"); //$NON-NLS-1$
        } catch (ParserException e) {
            // Success
            System.out.println("Got expected exception: " + e.getLocalizedMessage()); //$NON-NLS-1$
        }
        
        try {
            assertInvalid(evaluate(helper, 1, "* + 2")); //$NON-NLS-1$
            fail("Should have failed to parse or validate"); //$NON-NLS-1$
        } catch (ParserException e) {
            // Success
            System.out.println("Got expected exception: " + e.getLocalizedMessage()); //$NON-NLS-1$
        }
    }
    
    /**
     * Tests that operations involving reals and unlimited naturals
     * parse but result in OclInvalid.
     */
    public void test_unlimitedValueArithmetic_reals() {
        helper.setContext(getOCLStandardLibrary().getUnlimitedNatural());
        
        try {
            assertInvalid(evaluate(helper, 1, "2.0 + *")); //$NON-NLS-1$
            assertInvalid(evaluate(helper, 1, "2.0 - *")); //$NON-NLS-1$
            assertInvalid(evaluate(helper, 1, "2.0 / *")); //$NON-NLS-1$
            assertInvalid(evaluate(helper, 1, "2.0 * *")); //$NON-NLS-1$
            assertInvalid(evaluate(helper, 1, "2.0.min(*)")); //$NON-NLS-1$
            assertInvalid(evaluate(helper, 1, "2.0.max(*)")); //$NON-NLS-1$
            
            assertInvalid(evaluate(helper, 1, "* + 2.0")); //$NON-NLS-1$
            assertInvalid(evaluate(helper, 1, "* - 2.0")); //$NON-NLS-1$
            assertInvalid(evaluate(helper, 1, "* / 2.0")); //$NON-NLS-1$
            assertInvalid(evaluate(helper, 1, "* * 2.0")); //$NON-NLS-1$
            assertInvalid(evaluate(helper, 1, "*.min(2.0)")); //$NON-NLS-1$
            assertInvalid(evaluate(helper, 1, "*.max(2.0)")); //$NON-NLS-1$
        } catch (Exception e) {
            fail("Failed to parse or evaluate: " + e.getLocalizedMessage()); //$NON-NLS-1$
        }
    }
    
    /**
     * Tests that operations unlimited naturals and other naturals
     * parse but result in OclInvalid.
     */
    public void test_unlimitedValueArithmetic_naturals() {
        helper.setContext(getOCLStandardLibrary().getUnlimitedNatural());
        
        try {
            assertInvalid(evaluate(helper, 1, "*.round()")); //$NON-NLS-1$
            assertInvalid(evaluate(helper, 1, "*.floor()")); //$NON-NLS-1$
            assertInvalid(evaluate(helper, 1, "*.abs()")); //$NON-NLS-1$
            assertInvalid(evaluate(helper, 1, "* + *")); //$NON-NLS-1$
            assertInvalid(evaluate(helper, 1, "* - *")); //$NON-NLS-1$
            assertInvalid(evaluate(helper, 1, "* / *")); //$NON-NLS-1$
            assertInvalid(evaluate(helper, 1, "* * *")); //$NON-NLS-1$
            assertInvalid(evaluate(helper, 1, "*.min(*)")); //$NON-NLS-1$
            assertInvalid(evaluate(helper, 1, "*.max(*)")); //$NON-NLS-1$
            assertInvalid(evaluate(helper, 1, "*.mod(*)")); //$NON-NLS-1$
            assertInvalid(evaluate(helper, 1, "*.div(*)")); //$NON-NLS-1$
        } catch (Exception e) {
            fail("Failed to parse or evaluate: " + e.getLocalizedMessage()); //$NON-NLS-1$
        }
    }
}
