package com.sap.ide.cts.editor.contentassist.processor;

import generated.ClassLexer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import ngpm.NgpmPackage;

import org.junit.Before;
import org.junit.Test;

import com.sap.ap.cts.monet.parser.ClassParserFactory;
import com.sap.ide.cts.parser.incremental.antlr.IncrementalParserFacade;
import com.sap.mi.textual.grammar.exceptions.InvalidParserImplementationException;
import com.sap.mi.textual.grammar.exceptions.UnknownProductionRuleException;

public class TestCtsContentAssistProcessorClassEmpty extends
		CtsContentAssistProcessorTestBase {

	@Before
	public void initProcessor() throws IOException,
			UnknownProductionRuleException,
			InvalidParserImplementationException, InstantiationException,
			IllegalAccessException {
		initMetamodelId("sap.com/moin/mm/ap/core");
		initSyntax(ClassLexer.class.getResourceAsStream("Class.tcs"));
		IncrementalParserFacade facade = createFacade(new ClassParserFactory(),
				connection.getPackage(NgpmPackage.PACKAGE_DESCRIPTOR));
		initProcessorForFixture("Empty.class", facade, "Class");
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
