package com.sap.furcas.ide.editor.contentassist.processor;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import com.sap.furcas.ide.editor.test.utils.ClassLookupImpl;
import com.sap.furcas.parsergenerator.TCSSyntaxContainerBean;
import com.sap.furcas.runtime.parser.incremental.testbase.GeneratedParserAndFactoryTestConfiguration;
import com.sap.furcas.runtime.parser.testbase.MockPartitionAssignmentHandler;
import com.sap.furcas.test.fixture.ScenarioFixtureData;
import com.sap.furcas.test.testutils.ResourceTestHelper;
import com.sap.ide.cts.parser.incremental.IncrementalParserFacade;

@Ignore("Fails after the EMF migration. Failing for unknown reasons.")
public class TestCtsContentAssistProcessorTCS extends CtsContentAssistProcessorTestBase {

    private static final String LANGUAGE = "TCSObsolete";
    private static final File TCS = ScenarioFixtureData.TCS_OBSOLETE_TCS;
    private static final File[] METAMODELS = { ScenarioFixtureData.TCS_OBSOLETE_METAMODEL };
    
    private static IncrementalParserFacade facade;

    @BeforeClass
    public static void setupParser() throws Exception {
        GeneratedParserAndFactoryTestConfiguration testConfig = new GeneratedParserAndFactoryTestConfiguration(
                LANGUAGE, TCS, METAMODELS);

        ResourceSet resourceSet = testConfig.getSourceConfiguration().getResourceSet();
        TCSSyntaxContainerBean syntaxBean = parseSyntax(testConfig);
        Resource transientParsingResource = ResourceTestHelper.createTransientResource(resourceSet);

        facade = generateParserAndParserFactoryForLanguage(syntaxBean, testConfig, resourceSet,
                new MockPartitionAssignmentHandler(transientParsingResource), new ClassLookupImpl());
        
    }

    @Test
    public void testSequenceAfterSyntaxNameProperty() throws Exception {
        initProcessorForFixture("Sequence.tcs", null, facade);
        
        List<String> expected = new ArrayList<String>();
        expected.add("(");
        expected.add("{");

        assertDisplayStrings(expected, 0, 16);
    }

    @Test
    public void testSequenceAfterSyntaxOpeningBracket() throws Exception {
        initProcessorForFixture("Sequence.tcs", null, facade);
        
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
        expected.add("operatorTemplate -> ( operators = , source = -> name ) : ;");
        expected.add("operatorTemplate -> ( operators = , source = -> name ) ;");
        expected.add("operatorTemplate -> ( operators = , source = strucfeature ) : ;");
        expected.add("operatorTemplate -> ( operators = , source = strucfeature ) ;");
        expected.add("operatorTemplate name ( operators = , source = -> name ) : ;");
        expected.add("operatorTemplate name ( operators = , source = -> name ) ;");
        expected.add("operatorTemplate name ( operators = , source = strucfeature ) : ;");
        expected.add("operatorTemplate name ( operators = , source = strucfeature ) ;");
        expected.add("operatorTemplate name :: name ( operators = , source = -> name ) : ;");
        expected.add("operatorTemplate name :: name ( operators = , source = -> name ) ;");
        expected.add("operatorTemplate name :: name ( operators = , source = strucfeature ) : ;");
        expected.add("operatorTemplate name :: name ( operators = , source = strucfeature ) ;");
        expected.add("operators");
        expected.add("operators { }");
        expected.add("primitiveTemplate");
        expected.add("primitiveTemplate templateName for -> using tokenName : value = value ;");
        expected.add("primitiveTemplate templateName for name :: name using tokenName : value = value ;");
        expected.add("primitiveTemplate templateName for name using tokenName : value = value ;");
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
    public void testSequenceAfterEndOfFirstTemplate() throws Exception {
        initProcessorForFixture("Sequence.tcs", null, facade);
        
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
        expected.add("operatorTemplate -> ( operators = , source = -> name ) : ;");
        expected.add("operatorTemplate -> ( operators = , source = -> name ) ;");
        expected.add("operatorTemplate -> ( operators = , source = strucfeature ) : ;");
        expected.add("operatorTemplate -> ( operators = , source = strucfeature ) ;");
        expected.add("operatorTemplate name ( operators = , source = -> name ) : ;");
        expected.add("operatorTemplate name ( operators = , source = -> name ) ;");
        expected.add("operatorTemplate name ( operators = , source = strucfeature ) : ;");
        expected.add("operatorTemplate name ( operators = , source = strucfeature ) ;");
        expected.add("operatorTemplate name :: name ( operators = , source = -> name ) : ;");
        expected.add("operatorTemplate name :: name ( operators = , source = -> name ) ;");
        expected.add("operatorTemplate name :: name ( operators = , source = strucfeature ) : ;");
        expected.add("operatorTemplate name :: name ( operators = , source = strucfeature ) ;");
        expected.add("operators");
        expected.add("operators { }");
        expected.add("primitiveTemplate");
        expected.add("primitiveTemplate templateName for -> using tokenName : value = value ;");
        expected.add("primitiveTemplate templateName for name :: name using tokenName : value = value ;");
        expected.add("primitiveTemplate templateName for name using tokenName : value = value ;");
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
    public void testSequenceAfterArrow() throws Exception {
        initProcessorForFixture("Sequence.tcs", null, facade);
        
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
    public void testSequenceAfterA() throws Exception {
        initProcessorForFixture("Sequence.tcs", null, facade);
        
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
    public void testSequenceAfterSeparator() throws Exception {
        initProcessorForFixture("Sequence.tcs", null, facade);
        
        List<String> expected = new ArrayList<String>();
        expected.add("namesEntry");

        assertDisplayStrings(expected, 2, 23);
    }
    
    @Test
    public void testEnumerationAfterSyntaxNameProperty() throws Exception {
        initProcessorForFixture("Enumeration.tcs", null, facade);
        
        List<String> expected = new ArrayList<String>();
        expected.add("(");
        expected.add("{");

        assertDisplayStrings(expected, 0, 19);
    }

    @Test
    public void testEnumerationAfterSyntaxOpeningBracket() throws Exception {
        initProcessorForFixture("Enumeration.tcs", null, facade);
        
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
        expected.add("operatorTemplate -> ( operators = , source = -> name ) : ;");
        expected.add("operatorTemplate -> ( operators = , source = -> name ) ;");
        expected.add("operatorTemplate -> ( operators = , source = strucfeature ) : ;");
        expected.add("operatorTemplate -> ( operators = , source = strucfeature ) ;");
        expected.add("operatorTemplate name ( operators = , source = -> name ) : ;");
        expected.add("operatorTemplate name ( operators = , source = -> name ) ;");
        expected.add("operatorTemplate name ( operators = , source = strucfeature ) : ;");
        expected.add("operatorTemplate name ( operators = , source = strucfeature ) ;");
        expected.add("operatorTemplate name :: name ( operators = , source = -> name ) : ;");
        expected.add("operatorTemplate name :: name ( operators = , source = -> name ) ;");
        expected.add("operatorTemplate name :: name ( operators = , source = strucfeature ) : ;");
        expected.add("operatorTemplate name :: name ( operators = , source = strucfeature ) ;");
        expected.add("operators");
        expected.add("operators { }");
        expected.add("primitiveTemplate");
        expected.add("primitiveTemplate templateName for -> using tokenName : value = value ;");
        expected.add("primitiveTemplate templateName for name :: name using tokenName : value = value ;");
        expected.add("primitiveTemplate templateName for name using tokenName : value = value ;");
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
    public void testEnumerationAfterEndOfFirstTemplate() throws Exception {
        initProcessorForFixture("Enumeration.tcs", null, facade);
        
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
        expected.add("operatorTemplate -> ( operators = , source = -> name ) : ;");
        expected.add("operatorTemplate -> ( operators = , source = -> name ) ;");
        expected.add("operatorTemplate -> ( operators = , source = strucfeature ) : ;");
        expected.add("operatorTemplate -> ( operators = , source = strucfeature ) ;");
        expected.add("operatorTemplate name ( operators = , source = -> name ) : ;");
        expected.add("operatorTemplate name ( operators = , source = -> name ) ;");
        expected.add("operatorTemplate name ( operators = , source = strucfeature ) : ;");
        expected.add("operatorTemplate name ( operators = , source = strucfeature ) ;");
        expected.add("operatorTemplate name :: name ( operators = , source = -> name ) : ;");
        expected.add("operatorTemplate name :: name ( operators = , source = -> name ) ;");
        expected.add("operatorTemplate name :: name ( operators = , source = strucfeature ) : ;");
        expected.add("operatorTemplate name :: name ( operators = , source = strucfeature ) ;");
        expected.add("operators");
        expected.add("operators { }");
        expected.add("primitiveTemplate");
        expected.add("primitiveTemplate templateName for -> using tokenName : value = value ;");
        expected.add("primitiveTemplate templateName for name :: name using tokenName : value = value ;");
        expected.add("primitiveTemplate templateName for name using tokenName : value = value ;");
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
    public void testEnumerationAutoCreateArgValue() throws Exception {
        initProcessorForFixture("Enumeration.tcs", null, facade);
        
        List<String> expected = new ArrayList<String>();
        expected.add("always");
        expected.add("ifmissing");
        expected.add("never");
        expected.add("value");

        assertDisplayStrings(expected, 8, 77);
    }

    @Test
    public void testAfterEnumerationAutoCreateArgValue() throws Exception {
        initProcessorForFixture("Enumeration.tcs", null, facade);
        
        List<String> expected = new ArrayList<String>();
        expected.add(",");
        expected.add("}");

        assertDisplayStrings(expected, 8, 86);
    }

    @Test
    public void testAfterEnumerationAutoCreateArgValueAndSeparator() throws Exception {
        initProcessorForFixture("Enumeration.tcs", null, facade);
        
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
    
    @Test
    public void testFunctionCallAfterSyntaxNameProperty() throws Exception {
        initProcessorForFixture("FunctionCall.tcs", null, facade);
        
        List<String> expected = new ArrayList<String>();
        expected.add("(");
        expected.add("{");

        assertDisplayStrings(expected, 0, 20);
    }

    @Test
    public void testFunctionCallAfterSyntaxOpeningBracket() throws Exception {
        initProcessorForFixture("FunctionCall.tcs", null, facade);
        
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
        expected.add("operatorTemplate -> ( operators = , source = -> name ) : ;");
        expected.add("operatorTemplate -> ( operators = , source = -> name ) ;");
        expected.add("operatorTemplate -> ( operators = , source = strucfeature ) : ;");
        expected.add("operatorTemplate -> ( operators = , source = strucfeature ) ;");
        expected.add("operatorTemplate name ( operators = , source = -> name ) : ;");
        expected.add("operatorTemplate name ( operators = , source = -> name ) ;");
        expected.add("operatorTemplate name ( operators = , source = strucfeature ) : ;");
        expected.add("operatorTemplate name ( operators = , source = strucfeature ) ;");
        expected.add("operatorTemplate name :: name ( operators = , source = -> name ) : ;");
        expected.add("operatorTemplate name :: name ( operators = , source = -> name ) ;");
        expected.add("operatorTemplate name :: name ( operators = , source = strucfeature ) : ;");
        expected.add("operatorTemplate name :: name ( operators = , source = strucfeature ) ;");
        expected.add("operators");
        expected.add("operators { }");
        expected.add("primitiveTemplate");
        expected.add("primitiveTemplate templateName for -> using tokenName : value = value ;");
        expected.add("primitiveTemplate templateName for name :: name using tokenName : value = value ;");
        expected.add("primitiveTemplate templateName for name using tokenName : value = value ;");
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
    public void testFunctionCallAfterEndOfFirstTemplate() throws Exception {
        initProcessorForFixture("FunctionCall.tcs", null, facade);
        
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
        expected.add("operatorTemplate -> ( operators = , source = -> name ) : ;");
        expected.add("operatorTemplate -> ( operators = , source = -> name ) ;");
        expected.add("operatorTemplate -> ( operators = , source = strucfeature ) : ;");
        expected.add("operatorTemplate -> ( operators = , source = strucfeature ) ;");
        expected.add("operatorTemplate name ( operators = , source = -> name ) : ;");
        expected.add("operatorTemplate name ( operators = , source = -> name ) ;");
        expected.add("operatorTemplate name ( operators = , source = strucfeature ) : ;");
        expected.add("operatorTemplate name ( operators = , source = strucfeature ) ;");
        expected.add("operatorTemplate name :: name ( operators = , source = -> name ) : ;");
        expected.add("operatorTemplate name :: name ( operators = , source = -> name ) ;");
        expected.add("operatorTemplate name :: name ( operators = , source = strucfeature ) : ;");
        expected.add("operatorTemplate name :: name ( operators = , source = strucfeature ) ;");
        expected.add("operators");
        expected.add("operators { }");
        expected.add("primitiveTemplate");
        expected.add("primitiveTemplate templateName for -> using tokenName : value = value ;");
        expected.add("primitiveTemplate templateName for name :: name using tokenName : value = value ;");
        expected.add("primitiveTemplate templateName for name using tokenName : value = value ;");
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
    public void testFunctionCallBeforeDollar() throws Exception {
        initProcessorForFixture("FunctionCall.tcs", null, facade);
        
        List<String> expected = new ArrayList<String>();
        // TODO add query to limit keywords to those defined/used in TCS

        assertDisplayStrings(expected, 3, 4);
    }

    @Test
    public void testFunctionCallAfterDollar() throws Exception {
        initProcessorForFixture("FunctionCall.tcs", null, facade);
        
        List<String> expected = new ArrayList<String>();
        expected.add("calledFunction");

        // refersTo property value query result
        expected.add("reference");

        assertDisplayStrings(expected, 3, 5);
    }
}
