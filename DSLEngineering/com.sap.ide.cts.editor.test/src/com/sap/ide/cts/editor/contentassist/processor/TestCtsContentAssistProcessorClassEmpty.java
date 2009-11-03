package com.sap.ide.cts.editor.contentassist.processor;

import generated.ClassLexer;
import generated.ClassParser;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class TestCtsContentAssistProcessorClassEmpty extends
		CtsContentAssistProcessorTestBase {

	@Before
	public void initProcessor() {
		initMetamodelId("sap.com/moin/mm/ap/core");
		initProcessorForFixture("Empty.class", ClassLexer.class,
				ClassParser.class, "Class", ClassLexer.class
						.getResourceAsStream("Class.tcs"));
	}

	@Test
	public void testBeginningOfFile() {
		List<String> expected = new ArrayList<String>();
		expected.add("class");
		expected.add("class name < name > { }");
		expected.add("value");

		assertDisplayStrings(expected, 0, 0);
	}
}
