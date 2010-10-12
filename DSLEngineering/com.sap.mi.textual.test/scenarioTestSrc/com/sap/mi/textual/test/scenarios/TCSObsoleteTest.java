package com.sap.mi.textual.test.scenarios;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import com.sap.furcas.parsergenerator.testutils.StringListHelper;
import com.sap.furcas.runtime.common.interfaces.IMetaModelLookup;
import com.sap.furcas.runtime.common.util.QualifiedNamesHelper;
import com.sap.furcas.test.parsing.base.ExtendedGeneratedParserBasedTest;
import com.sap.furcas.test.util.EcoreMetaModelLookUp;
import com.sap.furcas.test.util.StubModelAdapter;
import com.sap.ide.cts.editor.test.util.ParserGenerationTestHelper;

/**
 * Tests generation of TCS Parsers.
 * This is using an old obsolete implementation of TCS whithout direct links betweeen syntax definition and Metamodel
 */
public class TCSObsoleteTest extends ExtendedGeneratedParserBasedTest {

    private static final String DSLSAMPLEDIR = "./scenarioTestResource/";
    
    private static final String LANGUAGE = "TCSObsolete";
    private static IMetaModelLookup lookup;


    @BeforeClass
	public static void setupParser() throws Exception {
		setParserGenerationTestHelper(ParserGenerationTestHelper.getDefault());
		setLookup(new EcoreMetaModelLookUp("TCS.ecore"));
		generateParserForLanguage(LANGUAGE);
	}


    @Test
    public void testSample1() throws Exception {
        String sample = "syntax mySyntax {\n" +
        "  primitiveTemplate identifier for ->String default using NAME:\n" + 
        "        value = \"%token%\";\n" + 	
        "  template ->ExpressionList main\n" + 
        "    : ->elements{separator=\",\"}\n" + 
        "    ;\n" + 
        "    \n" + 
        "}";

        StubModelAdapter stubModelHandler = parseString(sample , LANGUAGE, 0);
        assertEquals(1, stubModelHandler.getElementsbyType("TCS::ClassTemplate").size());
        assertEquals(1, stubModelHandler.getElementsbyType("TCS::PrimitiveTemplate").size());
        assertEquals(1, stubModelHandler.getElementsbyType("TCS::ConcreteSyntax").size());
        assertEquals(2, stubModelHandler.getElementsbyType("TCS::Sequence").size());
    }
    
    @Test
    public void testSample2() throws Exception {
        // test for missing value after disambiguate results in one error after parsing.
        String sample = "syntax mySyntax {\n" +
        "  template ->errortemplate :" +
        " (disambiguate = )" +
        ";" +
        "}";

        parseString(sample , LANGUAGE, 1);
        
    }
    
    @Test
    public void testBibTextTCS() throws Exception {
        StubModelAdapter stubModelHandler = getModifiedAdapterStub();
        parseFile("Bibtext.tcs", LANGUAGE, DSLSAMPLEDIR, 0, stubModelHandler);
        assertEquals(6, stubModelHandler.getElementsbyType("TCS::ClassTemplate").size());
        assertEquals(1, stubModelHandler.getElementsbyType("TCS::PrimitiveTemplate").size());
        assertEquals(1, stubModelHandler.getElementsbyType("TCS::ConcreteSyntax").size());
        assertEquals(7, stubModelHandler.getElementsbyType("TCS::Sequence").size());
    }
    
    @Test
    public void testBibTextLowerTCS() throws Exception {
        StubModelAdapter stubModelHandler = getModifiedAdapterStub();
        parseFile("BibtextForcedLower.tcs", LANGUAGE, DSLSAMPLEDIR, 0, stubModelHandler);
        assertEquals(6, stubModelHandler.getElementsbyType("TCS::ClassTemplate").size());
        assertEquals(1, stubModelHandler.getElementsbyType("TCS::PrimitiveTemplate").size());
        assertEquals(1, stubModelHandler.getElementsbyType("TCS::ConcreteSyntax").size());
        assertEquals(7, stubModelHandler.getElementsbyType("TCS::Sequence").size());
    }
    
    @Test
    public void testBibTextFunctionsTCS() throws Exception {
        StubModelAdapter stubModelHandler = getModifiedAdapterStub();
        parseFile("BibtextWithFunction.tcs", LANGUAGE, DSLSAMPLEDIR, 0, stubModelHandler);
        assertEquals(6, stubModelHandler.getElementsbyType("TCS::ClassTemplate").size());
        assertEquals(1, stubModelHandler.getElementsbyType("TCS::PrimitiveTemplate").size());
        assertEquals(1, stubModelHandler.getElementsbyType("TCS::ConcreteSyntax").size());
        assertEquals(2, stubModelHandler.getElementsbyType("TCS::FunctionTemplate").size());
    }
    
    @Test
    public void testEnumTCS() throws Exception {
        StubModelAdapter stubModelHandler = getModifiedAdapterStub();
        parseFile("EnumTest.tcs", LANGUAGE, DSLSAMPLEDIR, 0, stubModelHandler);
        assertEquals(4, stubModelHandler.getElementsbyType("TCS::ClassTemplate").size());
        assertEquals(1, stubModelHandler.getElementsbyType("TCS::PrimitiveTemplate").size());
        assertEquals(1, stubModelHandler.getElementsbyType("TCS::ConcreteSyntax").size());
        assertEquals(4, stubModelHandler.getElementsbyType("TCS::Sequence").size());
    }
    
    @Test
    public void testExpression() throws Exception {
        StubModelAdapter stubModelHandler = getModifiedAdapterStub();
        parseFile("Expression.tcs", LANGUAGE, DSLSAMPLEDIR, 0, stubModelHandler);
        assertEquals(6, stubModelHandler.getElementsbyType("TCS::ClassTemplate").size());
        assertEquals(2, stubModelHandler.getElementsbyType("TCS::PrimitiveTemplate").size());
        assertEquals(1, stubModelHandler.getElementsbyType("TCS::ConcreteSyntax").size());
        assertEquals(12, stubModelHandler.getElementsbyType("TCS::Sequence").size());
    }
    
    @Test
    public void testFPath() throws Exception {
        StubModelAdapter stubModelHandler = getModifiedAdapterStub();
        parseFile("FPath.tcs", LANGUAGE, DSLSAMPLEDIR, 0, stubModelHandler);
        assertEquals(10, stubModelHandler.getElementsbyType("TCS::ClassTemplate").size());
        assertEquals(3, stubModelHandler.getElementsbyType("TCS::PrimitiveTemplate").size());
        assertEquals(1, stubModelHandler.getElementsbyType("TCS::ConcreteSyntax").size());
        assertEquals(13, stubModelHandler.getElementsbyType("TCS::Sequence").size());
        assertEquals(1, stubModelHandler.getElementsbyType("TCS::EnumerationTemplate").size());
    }

    
    @Test
    public void testTCS() throws Exception {
        StubModelAdapter stubModelHandler = getModifiedAdapterStub();
        parseFile("TCSObsolete.tcs", LANGUAGE, DSLSAMPLEDIR, 0, stubModelHandler);
        assertEquals(69, stubModelHandler.getElementsbyType("TCS::ClassTemplate").size());
        assertEquals(5, stubModelHandler.getElementsbyType("TCS::PrimitiveTemplate").size());
        assertEquals(1, stubModelHandler.getElementsbyType("TCS::ConcreteSyntax").size());
        assertEquals(145, stubModelHandler.getElementsbyType("TCS::Sequence").size());
    }
    
    @Test
    public void testXPath() throws Exception {
        StubModelAdapter stubModelHandler = getModifiedAdapterStub();
        parseFile("XPath.tcs", LANGUAGE, DSLSAMPLEDIR, 0, stubModelHandler);
        assertEquals(28, stubModelHandler.getElementsbyType("TCS::ClassTemplate").size());
        assertEquals(4, stubModelHandler.getElementsbyType("TCS::PrimitiveTemplate").size());
        assertEquals(1, stubModelHandler.getElementsbyType("TCS::ConcreteSyntax").size());
        assertEquals(36, stubModelHandler.getElementsbyType("TCS::Sequence").size());
    }


    private static StubModelAdapter getModifiedAdapterStub() {
        return new StubModelAdapter() {
            public Object createElement(List<String> typeName) {
                if (StringListHelper.list("TCS","Symbol").equals(typeName)) {
                 // Literal extends symbol, but StubModelHandler is unable to deal with Subtypes.
                    return model.create("TCS::Literal");   
                } else {
                    return model.create(QualifiedNamesHelper.getQualifiedString(typeName));
                }
            }
        };
    }
    
}
