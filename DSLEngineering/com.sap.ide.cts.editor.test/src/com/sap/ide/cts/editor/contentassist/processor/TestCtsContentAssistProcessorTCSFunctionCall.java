package com.sap.ide.cts.editor.contentassist.processor;

import generated.TCSLexer;
import generated.TCSParser;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

/**
 * 
 */
public class TestCtsContentAssistProcessorTCSFunctionCall extends
		CtsContentAssistProcessorTestBase {

	@Before
	public void initProcessor() {
		initMetamodelId("demo.sap.com/tcsmeta");
		initProcessorForFixture("FunctionCall.tcs", TCSLexer.class,
				TCSParser.class, "TCS", TCSLexer.class
						.getResourceAsStream("TCS.tcs"));
	}

	@Test
	public void testAfterSyntaxNameProperty() {
		List<String> expected = new ArrayList<String>();
		expected.add("(");
		expected.add("{");

		assertDisplayStrings(expected, 0, 20);
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

	@Ignore
	@Test
	public void testBeforeDollar() {
		List<String> expected = new ArrayList<String>();
		// TODO add query to limit keywords to those defined/used in TCS

		assertDisplayStrings(expected, 3, 4);
	}

	@Test
	public void testAfterDollar() {
		List<String> expected = new ArrayList<String>();
		expected.add("calledFunction");

		// refersTo property value query result
		expected.add("reference");

		assertDisplayStrings(expected, 3, 5);
	}
}
