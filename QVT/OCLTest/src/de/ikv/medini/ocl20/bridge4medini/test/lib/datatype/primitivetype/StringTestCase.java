/*******************************************************************************
 * Copyright (c) 2008 ikv++ technologies ag and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     ikv++ technologies ag - initial API and implementation
 *******************************************************************************/

package de.ikv.medini.ocl20.bridge4medini.test.lib.datatype.primitivetype;

import java.util.Collection;
import java.util.List;
import java.util.Vector;

import junit.framework.Assert;

import de.ikv.medini.ocl20.bridge4medini.test.OclInterpreterTestCase;

public class StringTestCase extends OclInterpreterTestCase {

	public void testSize() throws Exception {
		List result = this.adapter.evaluate("'hallo'.size()");
		Assert.assertEquals(result.size(), 1);
		Assert.assertEquals(5L, ((Number) result.get(0)).longValue());

		result = this.adapter.evaluate("''.size()");
		Assert.assertEquals(result.size(), 1);
		Assert.assertEquals(0L, ((Number) result.get(0)).longValue());

	}

	public void testConcat() throws Exception {
		List result = this.adapter.evaluate("'hallo0'.concat('hallo1')");
		Assert.assertEquals(result.size(), 1);
		Assert.assertEquals("hallo0hallo1", ((String) result.get(0)));

		result = this.adapter.evaluate("''.concat('')");
		Assert.assertEquals(result.size(), 1);
		Assert.assertEquals("", ((String) result.get(0)));
	}

	public void testSubstring() throws Exception {
		List result = this.adapter.evaluate("'hallo'.substring(1,5)");
		Assert.assertEquals(result.size(), 1);
		Assert.assertEquals("hallo", ((String) result.get(0)));

		result = this.adapter.evaluate("'hallo'.substring(2,4)");
		Assert.assertEquals(result.size(), 1);
		Assert.assertEquals("all", ((String) result.get(0)));

	}

	public void testToInteger() throws Exception {
		List result = this.adapter.evaluate("'1'.toInteger()");
		Assert.assertEquals(result.size(), 1);
		Assert.assertEquals(1L, ((Number) result.get(0)).longValue());

		result = this.adapter.evaluate("'-5'.toInteger()");
		Assert.assertEquals(result.size(), 1);
		Assert.assertEquals(-5L, ((Number) result.get(0)).longValue());

	}

	public void testToReal() throws Exception {
		List result = this.adapter.evaluate("'1.5'.toReal()");
		Assert.assertEquals(result.size(), 1);
		Assert.assertEquals(1.5, ((Double) result.get(0)).doubleValue(), 0);

		result = this.adapter.evaluate("'-2.5'.toReal()");
		Assert.assertEquals(result.size(), 1);
		Assert.assertEquals(-2.5, ((Double) result.get(0)).doubleValue(), 0);
	}

	public void testToLower() throws Exception {
		List result = this.adapter.evaluate("'Hallo0'.toLower()");
		Assert.assertEquals(result.size(), 1);
		Assert.assertEquals("Hallo0".toLowerCase(), ((String) result.get(0)));
	}

	public void testToUpper() throws Exception {
		List result = this.adapter.evaluate("'Hallo0'.toUpper()");
		Assert.assertEquals(result.size(), 1);
		Assert.assertEquals("Hallo0".toUpperCase(), ((String) result.get(0)));
	}

	public void testFirstToUpper() throws Exception {
		List result = this.adapter.evaluate("'hallo0'.firstToUpper()");
		Assert.assertEquals(result.size(), 1);
		Assert.assertEquals("Hallo0", ((String) result.get(0)));
	}

	public void testFirstToLower() throws Exception {
		List result = this.adapter.evaluate("'Hallo0'.firstToLower()");
		Assert.assertEquals(result.size(), 1);
		Assert.assertEquals("hallo0", ((String) result.get(0)));
	}

	public void testIndexOf() throws Exception {
		List result = this.adapter.evaluate("'Hallo0'.indexOf('l')");
		Assert.assertEquals(result.size(), 1);
		Assert.assertEquals(2L, ((Number) result.get(0)).longValue());

		// OclInteger indexOf(OclString match);
		// OclInteger indexOf(OclString match, OclInteger from);
	}

	public void testLastIndexOf() throws Exception {
		List result = this.adapter.evaluate("'Hallo0'.lastIndexOf('l')");
		Assert.assertEquals(result.size(), 1);
		Assert.assertEquals(3L, ((Number) result.get(0)).longValue());

		// OclInteger lastIndexOf(OclString match);
		// OclInteger lastIndexOf(OclString match, OclInteger from);
	}

	public void testEndsWith() throws Exception {
		List result = this.adapter.evaluate("'Hallo0'.endsWith('o0')");
		Assert.assertEquals(result.size(), 1);
		Assert.assertEquals(true, ((Boolean) result.get(0)).booleanValue());

		result = this.adapter.evaluate("''.endsWith('o0')");
		Assert.assertEquals(result.size(), 1);
		Assert.assertEquals(false, ((Boolean) result.get(0)).booleanValue());
		// OclBoolean endsWith(OclString match);
	}

	public void testStartsWith() throws Exception {
		List result = this.adapter.evaluate("'Hallo0'.startsWith('Ha')");
		Assert.assertEquals(result.size(), 1);
		Assert.assertEquals(true, ((Boolean) result.get(0)).booleanValue());

		result = this.adapter.evaluate("''.startsWith('Ha')");
		Assert.assertEquals(result.size(), 1);
		Assert.assertEquals(false, ((Boolean) result.get(0)).booleanValue());
		// OclBoolean startsWith(OclString match);
	}

	public void testTrim() throws Exception {
		List result = this.adapter.evaluate("' Hallo0 '.trim()");
		Assert.assertEquals(result.size(), 1);
		Assert.assertEquals("Hallo0", ((String) result.get(0)));
		// OclString trim();
	}

	public void testEqualsIgnoreCase() throws Exception {
		List result = this.adapter.evaluate("'Hallo0'.equalsIgnoreCase('hALLO0')");
		Assert.assertEquals(result.size(), 1);
		Assert.assertEquals(true, ((Boolean) result.get(0)).booleanValue());
		// OclBoolean equalsIgnoreCase(OclString match);
	}

	public void testSubstringBefore() throws Exception {
		List result = this.adapter.evaluate("'Hallo0'.substringBefore('ll')");
		Assert.assertEquals(result.size(), 1);
		Assert.assertEquals("Ha", ((String) result.get(0)));

		// OclString substringBefore(OclString match);
	}

	public void testSubstringAfter() throws Exception {
		List result = this.adapter.evaluate("'Hallo0'.substringAfter('ll')");
		Assert.assertEquals(result.size(), 1);
		Assert.assertEquals("o0", ((String) result.get(0)));

		// OclString substringAfter(OclString match);
	}

	public void testContainsOnlyLetters() throws Exception {
		List result = this.adapter.evaluate("'Hallo0'.containsOnlyLetters()");
		Assert.assertEquals(result.size(), 1);
		Assert.assertEquals(false, ((Boolean) result.get(0)).booleanValue());

		result = this.adapter.evaluate("'Hall'.containsOnlyLetters()");
		Assert.assertEquals(result.size(), 1);
		Assert.assertEquals(true, ((Boolean) result.get(0)).booleanValue());
		// OclBoolean containsOnlyLetters();
	}

	public void testContainsOnlyDigits() throws Exception {
		List result = this.adapter.evaluate("'Hallo0'.containsOnlyDigits()");
		Assert.assertEquals(result.size(), 1);
		Assert.assertEquals(false, ((Boolean) result.get(0)).booleanValue());

		result = this.adapter.evaluate("'04'.containsOnlyDigits()");
		Assert.assertEquals(result.size(), 1);
		Assert.assertEquals(true, ((Boolean) result.get(0)).booleanValue());
		// OclBoolean containsOnlyDigits();
	}

	public void testContainsOnlyDigitsAndLetters() throws Exception {
		List result = this.adapter.evaluate("'Hallo0#%'.containsOnlyDigitsAndLetters()");
		Assert.assertEquals(result.size(), 1);
		Assert.assertEquals(false, ((Boolean) result.get(0)).booleanValue());

		result = this.adapter.evaluate("'Hallo0'.containsOnlyDigitsAndLetters()");
		Assert.assertEquals(result.size(), 1);
		Assert.assertEquals(true, ((Boolean) result.get(0)).booleanValue());
		// OclBoolean containsOnlyDigitsAndLetters();
	}

	public void testReplace() throws Exception {
		List result = this.adapter.evaluate("'Hallo0'.replace('ll','')");
		Assert.assertEquals(result.size(), 1);
		Assert.assertEquals("Hao0", ((String) result.get(0)));

		result = this.adapter.evaluate("'Hallo0'.replace('(.)(.)(.).*', '$3$2$1')");
		Assert.assertEquals(result.size(), 1);
		Assert.assertEquals("laH", ((String) result.get(0)));
		// OclString replace(OclString match, OclString replacement);
	}

	public void testReplaceFirst() throws Exception {
		List result = this.adapter.evaluate("'Halalo0'.replaceFirst('l','')");
		Assert.assertEquals(result.size(), 1);
		Assert.assertEquals("Haalo0", ((String) result.get(0)));
		// OclString replaceFirst(OclString match, OclString replacement);
	}

	public void testSplit() throws Exception {
		List result = this.adapter.evaluate("'Halalao0'.split('l')");
		Assert.assertEquals(result.size(), 1);
		Collection result1 = (Collection) result.get(0);
		Vector resultExpected = new Vector();
		resultExpected.add("Ha");
		resultExpected.add("a");
		resultExpected.add("ao0");
		Assert.assertEquals(resultExpected, result1);
		// OclSequence split(OclString match);
		// OclSequence split(OclString match, OclInteger limit);
	}

	public void testMatches() throws Exception {
		List result = this.adapter.evaluate("'aaaaab'.matches('a*b')");
		Assert.assertEquals(result.size(), 1);
		Assert.assertEquals(true, ((Boolean) result.get(0)).booleanValue());

		result = this.adapter.evaluate("'a'.matches('.*[a-zA-Z&&[^d-z]&&[^D-W]&&[^XYZ]].*')");
		Assert.assertEquals(result.size(), 1);
		Assert.assertEquals(true, ((Boolean) result.get(0)).booleanValue());

		result = this.adapter.evaluate("'A'.matches('.*[a-zA-Z&&[^d-z]&&[^D-W]&&[^XYZ]].*')");
		Assert.assertEquals(result.size(), 1);
		Assert.assertEquals(true, ((Boolean) result.get(0)).booleanValue());

		// OclBoolean matches(OclString match);
	}

	public void testAdd() throws Exception {
		List result = this.adapter.evaluate("'Hallo0' + 'hihi'");
		Assert.assertEquals(result.size(), 1);
		Assert.assertEquals("Hallo0hihi", ((String) result.get(0)));

		// OclString add(OclString s2);
	}

}
