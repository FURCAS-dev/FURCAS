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
 * $Id: NumberConditionsTest.java,v 1.2 2007/12/06 17:58:28 cdamus Exp $
 */

package org.eclipse.emf.query.tests;

import java.math.BigInteger;

import junit.framework.TestCase;

import org.eclipse.emf.query.conditions.numbers.NumberCondition;

/**
 * JUnit tests for {@link NumberCondition} class.
 * 
 * @author Christian W. Damus (cdamus)
 */
public class NumberConditionsTest extends TestCase {
	public void test_integers() {
        assertEqualTrue(10, 10);
        
        assertEqualFalse(10, 9);
        
		assertBetweenTrue(10, 10, 10);
        assertBetweenTrue(10, 10, 11);
        assertBetweenTrue(9, 10, 10);
        assertBetweenTrue(9, 10, 11);
        
        assertBetweenFalse(10, 9, 10);
        assertBetweenFalse(10, 11, 10);
        assertBetweenFalse(10, 9, 11);
        assertBetweenFalse(10, 12, 11);
	}
	
    public void test_doubles() {
        assertEqualTrue(10.0, 10.0);
        
        assertEqualFalse(10.0, 9.0);
        
        assertBetweenTrue(10.0, 10.0, 10.0);
        assertBetweenTrue(10.0, 10.0, 11.0);
        assertBetweenTrue(9.0, 10.0, 10.0);
        assertBetweenTrue(9.0, 10.0, 11.0);
        
        assertBetweenFalse(10.0, 9.0, 10.0);
        assertBetweenFalse(10.0, 11.0, 10.0);
        assertBetweenFalse(10.0, 9.0, 11.0);
        assertBetweenFalse(10.0, 12.0, 11.0);
    }
    
    public void test_bigIntegers() {
        BigInteger big     = new BigInteger("1000000000000"); //$NON-NLS-1$
        BigInteger big2    = new BigInteger("1000000000000"); //$NON-NLS-1$
        BigInteger big3    = new BigInteger("1000000000000"); //$NON-NLS-1$
        
        BigInteger smaller = new BigInteger("100000000000"); //$NON-NLS-1$
        BigInteger bigger  = new BigInteger("10000000000000"); //$NON-NLS-1$
        
        assertEqualTrue(big, big2);
        
        assertEqualFalse(big, smaller);
        
        assertBetweenTrue(big2, big, big3);
        assertBetweenTrue(big2, big, bigger);
        assertBetweenTrue(smaller, big, big3);
        assertBetweenTrue(smaller, big, bigger);
        
        assertBetweenFalse(big2, smaller, big3);
        assertBetweenFalse(big2, bigger, big3);
        assertBetweenFalse(big2, smaller, bigger);
        assertBetweenFalse(smaller, bigger, big3);
    }
    
    public void test_notEqualTo_21177() {
        assertNotEqualTrue(10, 11);
        assertNotEqualTrue(9, 10);
        assertNotEqualFalse(10, 10);
    }
    
    public void test_lessThan_21177() {
        assertLessThanTrue(10, 11);
        assertLessThanFalse(10, 10);
        assertLessThanFalse(11, 10);
    }
    
    public void test_lessOrEqual_21177() {
        assertLessOrEqualTrue(10, 11);
        assertLessOrEqualTrue(10, 10);
        assertLessOrEqualFalse(11, 10);
    }
    
    public void test_greaterThan_21177() {
        assertGreaterThanTrue(11, 10);
        assertGreaterThanFalse(10, 10);
        assertGreaterThanFalse(9, 10);
    }
    
    public void test_greaterOrEqual_21177() {
        assertGreaterOrEqualTrue(11, 10);
        assertGreaterOrEqualTrue(10, 10);
        assertGreaterOrEqualFalse(9, 10);
    }
    
    public void test_betweenWithExclusivity_21177() {
        assertBetweenTrue(9, true, 10, 11, true);
        assertBetweenTrue(10, true, 10, 11, true);
        assertBetweenTrue(9, true, 10, 10, true);
        assertBetweenTrue(10, true, 10, 10, true);
        assertBetweenFalse(11, true, 10, 11, true);
        assertBetweenFalse(11, true, 12, 11, true);
        
        assertBetweenTrue(9, false, 10, 11, false);
        assertBetweenFalse(10, false, 10, 11, false);
        assertBetweenFalse(9, false, 10, 10, false);
        assertBetweenFalse(10, true, 10, 10, false);
        assertBetweenFalse(11, false, 10, 11, false);
        assertBetweenFalse(11, false, 12, 11, false);
    }
    
	//
	// Test framework methods
	//
    
    <N extends Number & Comparable<? super N>> void assertEqualTrue(
            N test, N value) {
        assertTrue(NumberCondition.equals(value).isSatisfied(test));
    }
    
    <N extends Number & Comparable<? super N>> void assertNotEqualTrue(
            N test, N value) {
        assertTrue(NumberCondition.notEquals(value).isSatisfied(test));
    }
    
    <N extends Number & Comparable<? super N>> void assertLessThanTrue(
            N test, N value) {
        assertTrue(NumberCondition.lessThan(value).isSatisfied(test));
    }
    
    <N extends Number & Comparable<? super N>> void assertLessOrEqualTrue(
            N test, N value) {
        assertTrue(NumberCondition.lessThanOrEquals(value).isSatisfied(test));
    }
    
    <N extends Number & Comparable<? super N>> void assertGreaterThanTrue(
            N test, N value) {
        assertTrue(NumberCondition.greaterThan(value).isSatisfied(test));
    }
    
    <N extends Number & Comparable<? super N>> void assertGreaterOrEqualTrue(
            N test, N value) {
        assertTrue(NumberCondition.greaterThanOrEquals(value).isSatisfied(test));
    }
    
    <N extends Number & Comparable<? super N>> void assertBetweenTrue(
            N low, N test, N high) {
        assertTrue(NumberCondition.between(low, high).isSatisfied(test));
    }
    
    <N extends Number & Comparable<? super N>> void assertBetweenTrue(
            N low, boolean lowInc, N test, N high, boolean highInc) {
        assertTrue(NumberCondition.between(low, lowInc, high, highInc).isSatisfied(test));
    }
    
    
    
    <N extends Number & Comparable<? super N>> void assertEqualFalse(
            N test, N value) {
        assertFalse(NumberCondition.equals(value).isSatisfied(test));
    }
    
    <N extends Number & Comparable<? super N>> void assertNotEqualFalse(
            N test, N value) {
        assertFalse(NumberCondition.notEquals(value).isSatisfied(test));
    }
    
    <N extends Number & Comparable<? super N>> void assertLessThanFalse(
            N test, N value) {
        assertFalse(NumberCondition.lessThan(value).isSatisfied(test));
    }
    
    <N extends Number & Comparable<? super N>> void assertLessOrEqualFalse(
            N test, N value) {
        assertFalse(NumberCondition.lessThanOrEquals(value).isSatisfied(test));
    }
    
    <N extends Number & Comparable<? super N>> void assertGreaterThanFalse(
            N test, N value) {
        assertFalse(NumberCondition.greaterThan(value).isSatisfied(test));
    }
    
    <N extends Number & Comparable<? super N>> void assertGreaterOrEqualFalse(
            N test, N value) {
        assertFalse(NumberCondition.greaterThanOrEquals(value).isSatisfied(test));
    }
    
    <N extends Number & Comparable<? super N>> void assertBetweenFalse(
            N low, N test, N high) {
        assertFalse(NumberCondition.between(low, high).isSatisfied(test));
    }
    
    <N extends Number & Comparable<? super N>> void assertBetweenFalse(
            N low, boolean lowInc, N test, N high, boolean highInc) {
        assertFalse(NumberCondition.between(low, lowInc, high, highInc).isSatisfied(test));
    }
}
