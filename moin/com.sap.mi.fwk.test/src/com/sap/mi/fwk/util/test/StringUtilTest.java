package com.sap.mi.fwk.util.test;

import junit.framework.TestCase;

import com.sap.mi.fwk.util.StringUtil;

public class StringUtilTest extends TestCase {

	/**
	 * Tests the escaping of text appearing in HTML markup
	 */
	public void testEscapeForHTML() {
		String testString = "Test these special chars: & < > \" \n";
		String result = StringUtil.escapeForHTML(testString);
		assertEquals("Test these special chars: &amp; &lt; &gt; &quot; &lt;br/&gt;", result);
	}
}
