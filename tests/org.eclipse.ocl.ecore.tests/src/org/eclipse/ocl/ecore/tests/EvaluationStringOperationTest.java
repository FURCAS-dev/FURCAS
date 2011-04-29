/**
 * Copyright (c) 2009, 2011 Obeo and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *     Axel Uhl (SAP AG) - Bug 342644
 */
package org.eclipse.ocl.ecore.tests;

// FIXME we're missing oclIsNew and oclIsInState
/**
 * This unit test focuses on the Standard library's String operations.
 * 
 * @author Laurent Goubet (lgoubet)
 */
@SuppressWarnings("nls")
public class EvaluationStringOperationTest
		extends AbstractEvaluationTest {

	public void testStringConcat() {
		assertResult("concatenationTest", "'concatenation'.concat('Test')");
		// according to 9.3.20, StringLiteralExpCS, '\' 'n' is the escape for a life feed LF
		assertResult("concatenation\n", "'concatenation'.concat('\\n')");
	}

	public void testStringConcatInvalid() {
		assertResultInvalid("let s : String = invalid in 'concatenation'.concat(s)");
		assertResultInvalid("let s : String = invalid in s.concat('concatenation')");
	}

	public void testStringConcatNull() {
		assertResultInvalid("let s : String = null in 'concatenation'.concat(s)");
		assertResultInvalid("let s : String = null in s.concat('concatenation')");
	}

	public void testStringEqual() {
		assertResultFalse("'test' = 'se'");
		assertResultTrue("'test' = 'test'");
	}

	public void testStringEqualInvalid() {
		assertResultInvalid("let s : String = invalid in s = 'se'");
		assertResultInvalid("let s : String = invalid in 'test' = s");

		assertResultInvalid("let s1 : String = invalid, s2 : String = invalid in s1 = s2");
	}

	public void testStringEqualNull() {
		assertResultFalse("let s : String = null in s = 'se'");
		assertResultFalse("let s : String = null in 'test' = s");

		assertResultTrue("let s1 : String = null, s2 : String = null in s1 = s2");
	}

	public void testStringGreaterThan() {
		assertResultFalse("'3' > '4'");
		assertResultFalse("'a' > 'b'");
		assertResultFalse("'aardvark' > 'aardvarks'");

		assertResultTrue("'3.2' > '3.1'");
		assertResultTrue("'a' > 'A'");
		assertResultTrue("'aardvark' > 'aardvarK'");

		assertResultFalse("'3' > '3'");
		assertResultFalse("'a' > 'a'");
		assertResultFalse("'aardvark' > 'aardvark'");
	}

	public void testStringGreaterThanInvalid() {
		assertResultInvalid("let s : String = invalid in s > 'se'");
		assertResultInvalid("let s : String = invalid in 'test' > s");

		assertResultInvalid("let s1 : String = invalid, s2 : String = invalid in s1 > s2");
	}

	public void testStringGreaterThanNull() {
		assertResultInvalid("let s : String = null in s > 'se'");
		assertResultInvalid("let s : String = null in 'test' > s");

		assertResultInvalid("let s1 : String = null, s2 : String = null in s1 > s2");
	}

	public void testStringGreaterThanOrEqual() {
		assertResultFalse("'3' >= '4'");
		assertResultFalse("'a' >= 'b'");
		assertResultFalse("'aardvark' >= 'aardvarks'");

		assertResultTrue("'3.2' >= '3.1'");
		assertResultTrue("'a' >= 'A'");
		assertResultTrue("'aardvark' >= 'aardvarK'");

		assertResultTrue("'3' >= '3'");
		assertResultTrue("'a' >= 'a'");
		assertResultTrue("'aardvark' >= 'aardvark'");
	}

	public void testStringGreaterThanOrEqualInvalid() {
		assertResultInvalid("let s : String = invalid in s >= 'se'");
		assertResultInvalid("let s : String = invalid in 'test' >= s");

		assertResultInvalid("let s1 : String = invalid, s2 : String = invalid in s1 >= s2");
	}

	public void testStringGreaterThanOrEqualNull() {
		assertResultInvalid("let s : String = null in s >= 'se'");
		assertResultInvalid("let s : String = null in 'test' >= s");

		assertResultInvalid("let s1 : String = null, s2 : String = null in s1 >= s2");
	}

	public void testStringLessThan() {
		/*
		 * FIXME the standard library doesn't define either less than, less than
		 * or equal, greater than or greater than or equal. Neither should then
		 * compile. If we do define these, why not define them for boolean?
		 */
		assertResultTrue("'3' < '4'");
		assertResultTrue("'a' < 'b'");
		assertResultTrue("'aardvark' < 'aardvarks'");

		assertResultFalse("'3.2' < '3.1'");
		assertResultFalse("'a' < 'A'");
		assertResultFalse("'aardvark' < 'aardvarK'");

		assertResultFalse("'3' < '3'");
		assertResultFalse("'a' < 'a'");
		assertResultFalse("'aardvark' < 'aardvark'");
	}

	public void testStringLessThanInvalid() {
		assertResultInvalid("let s : String = invalid in s < 'se'");
		assertResultInvalid("let s : String = invalid in 'test' < s");

		assertResultInvalid("let s1 : String = invalid, s2 : String = invalid in s1 < s2");
	}

	public void testStringLessThanNull() {
		assertResultInvalid("let s : String = null in s < 'se'");
		assertResultInvalid("let s : String = null in 'test' < s");

		assertResultInvalid("let s1 : String = null, s2 : String = null in s1 < s2");
	}

	public void testStringLessThanOrEqual() {
		assertResultTrue("'3' <= '4'");
		assertResultTrue("'a' <= 'b'");
		assertResultTrue("'aardvark' <= 'aardvarks'");

		assertResultFalse("'3.2' <= '3.1'");
		assertResultFalse("'a' <= 'A'");
		assertResultFalse("'aardvark' <= 'aardvarK'");

		assertResultTrue("'3' <= '3'");
		assertResultTrue("'a' <= 'a'");
		assertResultTrue("'aardvark' <= 'aardvark'");
	}

	public void testStringLessThanOrEqualInvalid() {
		assertResultInvalid("let s : String = invalid in s <= 'se'");
		assertResultInvalid("let s : String = invalid in 'test' <= s");

		assertResultInvalid("let s1 : String = invalid, s2 : String = invalid in s1 <= s2");
	}

	public void testStringLessThanOrEqualNull() {
		assertResultInvalid("let s : String = null in s <= 'se'");
		assertResultInvalid("let s : String = null in 'test' <= s");

		assertResultInvalid("let s1 : String = null, s2 : String = null in s1 <= s2");
	}

	public void testStringNotEqual() {
		assertResultTrue("'test' <> 'se'");
		assertResultFalse("'test' <> 'test'");
	}

	public void testStringNotEqualInvalid() {
		assertResultInvalid("let s : String = invalid in s <> 'se'");
		assertResultInvalid("let s : String = invalid in 'test' <> s");

		assertResultInvalid("let s1 : String = invalid, s2 : String = invalid in s1 <> s2");
	}

	public void testStringNotEqualNull() {
		assertResultTrue("let s : String = null in s <> 'se'");
		assertResultTrue("let s : String = null in 'test' <> s");

		assertResultFalse("let s1 : String = null, s2 : String = null in s1 <> s2");
	}

	public void testStringOclAsType() {
		assertResultInvalid("'test'.oclAsType(Integer)");
		assertResult("test", "'test'.oclAsType(String)");
		assertResult("test", "'test'.oclAsType(OclAny)");
		assertResultInvalid("'test'.oclAsType(OclVoid)");
		assertResultInvalid("'test'.oclAsType(OclInvalid)");
	}

	public void testStringOclIsInvalid() {
		assertResultFalse("'test'.oclIsInvalid()");
		assertResultFalse("''.oclIsInvalid()");
	}

	public void testStringOclIsKindOf() {
		assertResultFalse("'test'.oclIsKindOf(Integer)");
		assertResultTrue("'test'.oclIsKindOf(String)");
		assertResultTrue("'test'.oclIsKindOf(OclAny)");
		assertResultFalse("'test'.oclIsKindOf(OclVoid)");
		assertResultFalse("'test'.oclIsKindOf(OclInvalid)");
	}

	public void testStringOclIsTypeOf() {
		assertResultFalse("'test'.oclIsTypeOf(Integer)");
		assertResultTrue("'test'.oclIsTypeOf(String)");
		assertResultFalse("'test'.oclIsTypeOf(OclAny)");
		assertResultFalse("'test'.oclIsTypeOf(OclVoid)");
		assertResultFalse("'test'.oclIsTypeOf(OclInvalid)");
	}

	public void testStringOclIsUndefined() {
		assertResultFalse("'test'.oclIsUndefined()");
		assertResultFalse("''.oclIsUndefined()");
	}

	public void testStringSize() {
		assertResult(Integer.valueOf(4), "'test'.size()"); //$NON-NLS-2$
		assertResult(Integer.valueOf(0), "''.size()"); //$NON-NLS-2$
	}

	public void testStringSizeInvalid() {
		assertResultInvalid("let s : String = invalid in s.size()"); //$NON-NLS-2$
	}

	public void testStringSizeNull() {
		assertResultInvalid("let s : String = null in s.size()"); //$NON-NLS-2$
	}

	public void testStringSubstring() {
		assertResult("t", "'test'.substring(1, 1)");
		assertResult("es", "'test'.substring(2, 3)");
		assertResult("t", "'test'.substring(4, 4)");
	}

	public void testStringSubstringIllegalArguments() {
		/*
		 * FIXME in OCL, substring(2, 1) is the equivalent of java's
		 * substring(1,1) : an empty String. However this really looks like it
		 * should fail.
		 */
		assertResultInvalid("'test'.substring(2, 1)");
		assertResultInvalid("'test'.substring(3, 1)");
	}

	public void testStringSubstringInvalid() {
		assertResultInvalid("let s : String = invalid in s.substring(1, 1)");
		assertResultInvalid("let s : String = invalid in s.substring(5, 5)");
	}

	public void testStringSubstringNull() {
		assertResultInvalid("let s : String = null in s.substring(1, 1)");
		assertResultInvalid("let s : String = null in s.substring(5, 5)");
	}

	public void testStringSubstringOutOfBounds() {
		assertResultInvalid("'test'.substring(0, 1)");
		assertResultInvalid("'test'.substring(4, 5)");
	}

	public void testStringToInteger() {
		assertResult(Integer.valueOf(4), "'4'.toInteger()");
		assertResult(Integer.valueOf(-4), "'-4'.toInteger()");
		assertResultInvalid("'4.0'.toInteger()");

		assertResultInvalid("'2.4.0'.toInteger()");
		assertResultInvalid("'a'.toInteger()");
	}

	public void testStringToIntegerInvalid() {
		assertResultInvalid("let s : String = invalid in s.toInteger()");
	}

	public void testStringToIntegerNull() {
		assertResultInvalid("let s : String = null in s.toInteger()");
	}

	public void testStringToLower() {
		checkForUTF8Encoding();
		assertResult("4", "'4'.toLower()"); //$NON-NLS-2$
		assertResult("mixed", "'MiXeD'.toLower()"); //$NON-NLS-2$
		assertResult("upper", "'UPPER'.toLower()"); //$NON-NLS-2$
		// Ensures word-final sigma and regular sigmas are converted as needed
		// TODO re-enable once the Unicode problems on Hudson have been resolved
		// assertResult(
		//	"ὀδυσσεύς", "'ὈΔΥΣΣΕΎΣ'.toLower()");
	}

	public void testStringToLowerInvalid() {
		assertResultInvalid("let s : String = invalid in s.toLower()");
	}

	public void testStringToLowerNull() {
		assertResultInvalid("let s : String = null in s.toLower()");
	}

	public void testStringToReal() {
		assertResult(Double.valueOf(4d), "'4'.toReal()");
		assertResult(Double.valueOf(-4d), "'-4'.toReal()");
		assertResult(Double.valueOf(4d), "'4.0'.toReal()");

		assertResultInvalid("'2.4.0'.toReal()");
		assertResultInvalid("'a'.toReal()");
	}

	public void testStringToRealInvalid() {
		assertResultInvalid("let s : String = invalid in s.toReal()");
	}

	public void testStringToRealNull() {
		assertResultInvalid("let s : String = null in s.toReal()");
	}

	public void testStringToUpper() {
		checkForUTF8Encoding();
		assertResult("4", "'4'.toUpper()");
		assertResult("MIXED", "'MiXeD'.toUpper()");
		assertResult("LOWER", "'lower'.toUpper()");
		
		// Ensures word-final sigma and regular sigmas are converted as needed
		// TODO re-enable once the Unicode problems on Hudson have been resolved
		// assertResult("ὈΔΥΣΣΕΎΣ", "'ὀδυσσεύς'.toUpper()");
		
		// Sharp s should be mapped to a double S upper case
		// TODO re-enable once the Unicode problems on Hudson have been resolved
		// assertResult("SS", "'ß'.toUpper()");
	}

	public void testStringToUpperInvalid() {
		assertResultInvalid("let s : String = invalid in s.toUpper()");
	}

	public void testStringToUpperNull() {
		assertResultInvalid("let s : String = null in s.toUpper()");
	}
}
