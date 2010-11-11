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
public class TestCtsContentAssistProcessorTCSEnumeration extends
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
		initProcessorForFixture("Enumeration.tcs", null, facade, "TCS");
	}

	@Test
	public void testAfterSyntaxNameProperty() {
		List<String> expected = new ArrayList<String>();
		expected.add("(");
		expected.add("{");

		assertDisplayStrings(expected, 0, 19);
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

		assertDisplayStrings(expected, 12, 0);
	}

	@Test
	public void testEnumerationAutoCreateArgValue() {
		List<String> expected = new ArrayList<String>();
		expected.add("always");
		expected.add("ifmissing");
		expected.add("never");
		expected.add("value");

		assertDisplayStrings(expected, 8, 77);
	}

	@Test
	public void testAfterEnumerationAutoCreateArgValue() {
		List<String> expected = new ArrayList<String>();
		expected.add(",");
		expected.add("}");

		assertDisplayStrings(expected, 8, 86);
	}

	@Test
	public void testAfterEnumerationAutoCreateArgValueAndSeparator() {
		List<String> expected = new ArrayList<String>();
		expected.add(",");
		expected.add("as");
		expected.add("as = template");
		expected.add("autoCreate");
		expected.add("autoCreate = value");
		expected.add("createAs");
		expected.add("createAs =");
		expected.add("createIn");
		expected.add("createIn =");
		expected.add("disambiguate");
		expected.add("disambiguate = disambiguation");
		expected.add("filter");
		expected.add("filter = filter");
		expected.add("forcedLower");
		expected.add("forcedLower = value");
		expected.add("forcedUpper");
		expected.add("forcedUpper = value");
		expected.add("importContext");
		expected.add("lookIn");
		expected.add("lookIn =");
		expected.add("mode");
		expected.add("mode = mode");
		expected.add("partial");
		expected.add("query");
		expected.add("query = query");
		expected.add("refersTo");
		expected.add("refersTo = propertyName");
		expected.add("separator");
		expected.add("separator =");

		assertDisplayStrings(expected, 8, 87);
	}
}
