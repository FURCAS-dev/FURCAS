package com.sap.ide.refactoring.test;

import static org.junit.Assert.assertEquals;

public class RefactoringAssertionUtil {

    public static void assertEqualsIgnoreWhitespaces(String message, String expected, String actual) {
	assertEquals(message, stripWhiteSpace(expected), stripWhiteSpace(actual));
    }

    public static void assertEqualsIgnoreWhitespacesAndDefaultMultiplicity(String message, String expected, String actual) {
	// Yupp, that is a crude hack
	assertEquals(message, 
		stripWhiteSpace(expected).replaceAll("0..1", "").replaceAll("0..", "").replaceAll("1..1", ""),
		  stripWhiteSpace(actual).replaceAll("0..1", "").replaceAll("0..", "").replaceAll("1..1", ""));
    }

    private static String stripWhiteSpace(String expected) {
	return expected.replaceAll(" ", "").replaceAll("\n", "").replaceAll("\r", "").replaceAll("\t", "");
    }
}
