package com.sap.furcas.unparser.testutils;

import static org.junit.Assert.assertEquals;

public class PrettyPrintAssertionUtil {

    public static void assertEqualsIgnoreWhitespaces(String message, String expected, String actual) {
	assertEquals(message, stripWhiteSpace(expected), stripWhiteSpace(actual));
    }
    
    public static void assertEqualsIgnoreWhitespaces(String expected, String actual) {
        assertEquals(stripWhiteSpace(expected), stripWhiteSpace(actual));
    }

    private static String stripWhiteSpace(String expected) {
	return expected.replaceAll(" ", "").replaceAll("\n", "").replaceAll("\r", "").replaceAll("\t", "");
    }
    
}
