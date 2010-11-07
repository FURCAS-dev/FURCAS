package com.sap.furcas.parsergenerator.tcs.scenario;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import com.sap.furcas.parsergenerator.base.GeneratedParserBasedTest;
import com.sap.furcas.parsergenerator.base.ParserGenerationTestHelper;
import com.sap.furcas.parsergenerator.base.StubModelAdapter;
import com.sap.furcas.parsergenerator.base.StubModelElement;
import com.sap.furcas.parsergenerator.emf.lookup.FileBasedEcoreMetaModelLookUp;
import com.sap.furcas.runtime.common.interfaces.IMetaModelLookup;
import com.sap.furcas.runtime.parser.ModelParsingResult;
import com.sap.furcas.test.fixture.FixtureData;

/**
 * Tests generation of TCS Parsers using metamodel in MOIN.
 */
@Ignore("Already ignored in the moin codebase")
public class TCSMQLTest extends GeneratedParserBasedTest {

    private static final String DSLSAMPLEDIR = "./scenarioTestResource/";
    
    private static final String LANGUAGE = "TCSMQLTest";
    private static IMetaModelLookup lookup;


    @BeforeClass
	public static void setupParser() throws Exception {
		setParserGenerationTestHelper(ParserGenerationTestHelper.getDefault());
		setLookup(new FileBasedEcoreMetaModelLookUp(FixtureData.TCS_METAMODEL));
		generateParserForLanguage(LANGUAGE);
	}


    @Test
    public void testSample1() throws Exception {
        // using old obsolete TCS syntax
        String sample = "syntax mySyntax {\n" +
        "  primitiveTemplate identifier for String default using NAME:\n" + 
        "        value = \"%token%\";\n" + 	
        "  template ->ExpressionList main operatored (myOperators)\n" + 
        "    : elements{separator=\",\"}\n" + 
        "    ;\n" +
        " operatorTemplate ->BinaryExpression(operators =\r\n" + 
        "            opPlus, source = \'left\', storeRightTo = \'right\');" + 
        "    \n" +
        "operators myOperators{\n" + 
        "        priority 0 {\n" + 
        "            opPlus = \"+\", 2;\n" + 
        "        }\n" + 
        "    }\n" + 
        "}";
        

        // now test the mql query, requires new parsing
        StubModelAdapter stubModelHandler = new StubModelAdapter();
        Object expected = new Object();
        stubModelHandler.queryResult = expected;
        
        ModelParsingResult result = parseString(sample , LANGUAGE, stubModelHandler);
        assertEquals(result.getErrors().toString(), 0, result.getErrors().size());
        
        StubModelElement ct = stubModelHandler.getElementsbyType("TCS::ClassTemplate").iterator().next();
        assertEquals(expected, ct.get("operatorList"));
        
        assertEquals("test 'my' query", stubModelHandler.mqlQuery);
    }
        
}
