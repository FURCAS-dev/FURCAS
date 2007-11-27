/**
 * <copyright>
 *
 * Copyright (c) 2006, 2007 IBM Corporation and others.
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
 * $Id: StringConditionsTest.java,v 1.3 2007/11/27 19:28:59 cdamus Exp $
 */

package org.eclipse.emf.query.tests;

import junit.framework.TestCase;

import org.eclipse.emf.query.conditions.strings.StringCondition;
import org.eclipse.emf.query.conditions.strings.StringValue;
import org.eclipse.emf.query.conditions.strings.SubStringValue;

/**
 * JUnit tests for {@link StringCondition} subclasses, to test the adoption of
 * ICU4J.
 * 
 * @author Christian W. Damus (cdamus)
 */
public class StringConditionsTest extends TestCase {
	/**
	 * Tests that rework for ICU4J did not regress the StringValue condition.
	 */
	public void test_caseSensitive_stringValue_114105() {
		StringCondition cond = new StringValue("aba", true); //$NON-NLS-1$
		
		assertTrue(cond.isSatisfied("aba")); //$NON-NLS-1$
		
		assertFalse(cond.isSatisfied("cdc")); //$NON-NLS-1$
		assertFalse(cond.isSatisfied("Aba")); //$NON-NLS-1$
		assertFalse(cond.isSatisfied("ABA")); //$NON-NLS-1$
	}
	
	/**
	 * Tests that rework for ICU4J did not regress the StringValue condition.
	 */
	public void test_caseInsensitive_stringValue_114105() {
		StringCondition cond = new StringValue("aba", false); //$NON-NLS-1$
		
		assertTrue(cond.isSatisfied("aba")); //$NON-NLS-1$
		assertTrue(cond.isSatisfied("Aba")); //$NON-NLS-1$
		assertTrue(cond.isSatisfied("ABA")); //$NON-NLS-1$
		
		assertFalse(cond.isSatisfied("cdc")); //$NON-NLS-1$
	}
	
	/**
	 * Tests that rework for ICU4J did not regress the SubStringValue condition.
	 */
	public void test_caseSensitive_substringValue_114105() {
		final String test = "abacdcaba"; //$NON-NLS-1$
		
		assertSubstring("aba", test, true); //$NON-NLS-1$
		assertSubstring("cdc", test, true); //$NON-NLS-1$
		assertSubstring("cab", test, true); //$NON-NLS-1$
		assertSubstring("bac", test, true); //$NON-NLS-1$
		
		assertNotSubstring("cda", test, true); //$NON-NLS-1$
		assertNotSubstring("Aba", test, true); //$NON-NLS-1$
		assertNotSubstring("CDC", test, true); //$NON-NLS-1$
	}
	
	/**
	 * Tests that rework for ICU4J did not regress the SubStringValue condition.
	 */
	public void test_caseInsensitive_substringValue_114105() {
		final String test = "abacdcaba"; //$NON-NLS-1$
		
		assertSubstring("abA", test, false); //$NON-NLS-1$
		assertSubstring("CdC", test, false); //$NON-NLS-1$
		assertSubstring("cAb", test, false); //$NON-NLS-1$
		assertSubstring("Bac", test, false); //$NON-NLS-1$
		
		assertNotSubstring("cda", test, false); //$NON-NLS-1$
		assertNotSubstring("cDa", test, false); //$NON-NLS-1$
	}

	/**
	 * Tests that evaluating a pattern against an empty string or null just returns false.
	 */
	public void test_emptyString_substringValue_211055() {
		final String test = ""; //$NON-NLS-1$

		assertSubstring(null, null, false);
		assertSubstring("", test, false); //$NON-NLS-1$
		
		assertNotSubstring("", null, false); //$NON-NLS-1$
		assertNotSubstring("a", test, false); //$NON-NLS-1$

		Throwable throwable = null;
		try {
			assertSubstring(null, test, false);
		}
		catch (Exception t)
		{
		  throwable = t;
		}
		assertTrue(throwable instanceof NullPointerException);
	}
	
	//
	// Test framework methods
	//
	
	void assertSubstring(String substring, String test, boolean caseSensitive) {
		assertTrue(new SubStringValue(substring, caseSensitive).isSatisfied(test));
	}
	
	void assertNotSubstring(String substring, String test, boolean caseSensitive) {
		assertFalse(new SubStringValue(substring, caseSensitive).isSatisfied(test));
	}
}
