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
 * $Id: NumberConditionsTest.java,v 1.1 2007/11/08 23:00:27 cdamus Exp $
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
    
	//
	// Test framework methods
	//
    
    <N extends Number & Comparable<? super N>> void assertEqualTrue(
            N expected, N test) {
        assertTrue(new NumberCondition<N>(expected).isSatisfied(test));
    }
    
    <N extends Number & Comparable<? super N>> void assertBetweenTrue(
            N low, N test, N high) {
        assertTrue(new NumberCondition<N>(low, high).isSatisfied(test));
    }
    
    <N extends Number & Comparable<? super N>> void assertEqualFalse(
            N expected, N test) {
        assertFalse(new NumberCondition<N>(expected).isSatisfied(test));
    }
    
    <N extends Number & Comparable<? super N>> void assertBetweenFalse(
            N low, N test, N high) {
        assertFalse(new NumberCondition<N>(low, high).isSatisfied(test));
    }
}
