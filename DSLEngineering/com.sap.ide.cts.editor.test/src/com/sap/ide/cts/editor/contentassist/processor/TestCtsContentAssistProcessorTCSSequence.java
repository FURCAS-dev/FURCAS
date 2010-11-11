package com.sap.ide.cts.editor.contentassist.processor;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.sap.furcas.parser.tcs.stableversion.TCSLexer;
import com.sap.furcas.runtime.parser.exceptions.InvalidParserImplementationException;
import com.sap.furcas.runtime.parser.exceptions.UnknownProductionRuleException;
import com.sap.ide.cts.parser.incremental.antlr.IncrementalParserFacade;
import com.sap.mi.tcs.parser.TcsParserFactory;

/**
 * 
 */
public class TestCtsContentAssistProcessorTCSSequence extends
		CtsContentAssistProcessorTestBase {

	@Before
	public void initProcessor() throws IOException,
			UnknownProductionRuleException,
			InvalidParserImplementationException, InstantiationException,
			IllegalAccessException {
		initMetamodelId("demo.sap.com/tcsmeta");
		initSyntax(TCSLexer.class.getResourceAsStream("TCS.tcs"));
		IncrementalParserFacade facade = createFacade(new TcsParserFactory(),
				tcsPackage);
		initProcessorForFixture("Sequence.tcs", null, facade, "TCS");
	}

	@Test
	public void testAfterSyntaxNameProperty() {
		List<String> expected = new ArrayList<String>();
		expected.add("(");
		expected.add("{");

		assertDisplayStrings(expected, 0, 16);
	}

	@Test
	public void testAfterSyntaxOpeningBracket() {
		List<String> expected = new ArrayList<String>();
		expected.add("enumerationTemplate");
		expected.add("enumerationTemplate -> : ;");
		expected.add("enumerationTemplate -> ;");
		expected.add("enumerationTemplate name : ;");
		expected.add("enumerationTemplate name :: name : ;");
		expected.add("enumerationTemplate name :: name ;");
		expected.add("enumerationTemplate name ;");
		expected.add("function");
		expected.add("function functionName ( -> ) : ;");
		expected.add("function functionName ( name ) : ;");
		expected.add("function functionName ( name :: name ) : ;");
		expected.add("keywords");
		expected.add("lexer");
		expected.add("omitted");
		expected.add("operatorTemplate");
		expected
				.add("operatorTemplate -> ( operators = , source = -> name ) : ;");
		expected
				.add("operatorTemplate -> ( operators = , source = -> name ) ;");
		expected
				.add("operatorTemplate -> ( operators = , source = strucfeature ) : ;");
		expected
				.add("operatorTemplate -> ( operators = , source = strucfeature ) ;");
		expected
				.add("operatorTemplate name ( operators = , source = -> name ) : ;");
		expected
				.add("operatorTemplate name ( operators = , source = -> name ) ;");
		expected
				.add("operatorTemplate name ( operators = , source = strucfeature ) : ;");
		expected
				.add("operatorTemplate name ( operators = , source = strucfeature ) ;");
		expected
				.add("operatorTemplate name :: name ( operators = , source = -> name ) : ;");
		expected
				.add("operatorTemplate name :: name ( operators = , source = -> name ) ;");
		expected
				.add("operatorTemplate name :: name ( operators = , source = strucfeature ) : ;");
		expected
				.add("operatorTemplate name :: name ( operators = , source = strucfeature ) ;");
		expected.add("operators");
		expected.add("operators { }");
		expected.add("primitiveTemplate");
		expected
				.add("primitiveTemplate templateName for -> using tokenName : value = value ;");
		expected
				.add("primitiveTemplate templateName for name :: name using tokenName : value = value ;");
		expected
				.add("primitiveTemplate templateName for name using tokenName : value = value ;");
		expected.add("symbols");
		expected.add("template");
		expected.add("template -> : ;");
		expected.add("template -> ;");
		expected.add("template name : ;");
		expected.add("template name :: name : ;");
		expected.add("template name :: name ;");
		expected.add("template name ;");
		expected.add("token");
		expected.add("token name : ;");
		expected.add("}");

		assertDisplayStrings(expected, 1, 0);
	}

	@Test
	public void testAfterEndOfFirstTemplate() {
		List<String> expected = new ArrayList<String>();
		expected.add("enumerationTemplate");
		expected.add("enumerationTemplate -> : ;");
		expected.add("enumerationTemplate -> ;");
		expected.add("enumerationTemplate name : ;");
		expected.add("enumerationTemplate name :: name : ;");
		expected.add("enumerationTemplate name :: name ;");
		expected.add("enumerationTemplate name ;");
		expected.add("function");
		expected.add("function functionName ( -> ) : ;");
		expected.add("function functionName ( name ) : ;");
		expected.add("function functionName ( name :: name ) : ;");
		expected.add("keywords");
		expected.add("lexer");
		expected.add("omitted");
		expected.add("operatorTemplate");
		expected
				.add("operatorTemplate -> ( operators = , source = -> name ) : ;");
		expected
				.add("operatorTemplate -> ( operators = , source = -> name ) ;");
		expected
				.add("operatorTemplate -> ( operators = , source = strucfeature ) : ;");
		expected
				.add("operatorTemplate -> ( operators = , source = strucfeature ) ;");
		expected
				.add("operatorTemplate name ( operators = , source = -> name ) : ;");
		expected
				.add("operatorTemplate name ( operators = , source = -> name ) ;");
		expected
				.add("operatorTemplate name ( operators = , source = strucfeature ) : ;");
		expected
				.add("operatorTemplate name ( operators = , source = strucfeature ) ;");
		expected
				.add("operatorTemplate name :: name ( operators = , source = -> name ) : ;");
		expected
				.add("operatorTemplate name :: name ( operators = , source = -> name ) ;");
		expected
				.add("operatorTemplate name :: name ( operators = , source = strucfeature ) : ;");
		expected
				.add("operatorTemplate name :: name ( operators = , source = strucfeature ) ;");
		expected.add("operators");
		expected.add("operators { }");
		expected.add("primitiveTemplate");
		expected
				.add("primitiveTemplate templateName for -> using tokenName : value = value ;");
		expected
				.add("primitiveTemplate templateName for name :: name using tokenName : value = value ;");
		expected
				.add("primitiveTemplate templateName for name using tokenName : value = value ;");
		expected.add("symbols");
		expected.add("template");
		expected.add("template -> : ;");
		expected.add("template -> ;");
		expected.add("template name : ;");
		expected.add("template name :: name : ;");
		expected.add("template name :: name ;");
		expected.add("template name ;");
		expected.add("token");
		expected.add("token name : ;");
		expected.add("}");

		assertDisplayStrings(expected, 5, 0);
	}

	@Test
	public void testAfterArrow() {
		List<String> expected = new ArrayList<String>();
		expected.add("#");
		expected.add("(");
		expected.add(":");
		expected.add(";");
		expected.add("abstract");
		expected.add("addToContext");
		expected.add("context");
		expected.add("deep");
		expected.add("main");
		expected.add("multi");
		expected.add("namesEntry");
		expected.add("nonPrimary");
		expected.add("operatored");
		expected.add("prefix");
		expected.add("referenceOnly");

		assertDisplayStrings(expected, 2, 13);
	}

	@Test
	public void testAfterA() {
		List<String> expected = new ArrayList<String>();
		expected.add("#");
		expected.add("(");
		expected.add(":");
		expected.add("::");
		expected.add(";");
		expected.add("abstract");
		expected.add("addToContext");
		expected.add("context");
		expected.add("deep");
		expected.add("main");
		expected.add("multi");
		expected.add("nonPrimary");
		expected.add("operatored");
		expected.add("prefix");
		expected.add("referenceOnly");

		assertDisplayStrings(expected, 2, 16);
	}

	@Test
	public void testAfterSeparator() {
		List<String> expected = new ArrayList<String>();
		expected.add("namesEntry");

		assertDisplayStrings(expected, 2, 23);
	}
}
