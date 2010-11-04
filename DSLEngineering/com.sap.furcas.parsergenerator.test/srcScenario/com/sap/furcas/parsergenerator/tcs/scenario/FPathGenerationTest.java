package com.sap.furcas.parsergenerator.tcs.scenario;

import static org.junit.Assert.assertEquals;

import java.util.Set;

import org.junit.BeforeClass;
import org.junit.Test;

import com.sap.furcas.parsergenerator.base.ExtendedGeneratedParserBasedTest;
import com.sap.furcas.parsergenerator.base.ParserGenerationTestHelper;
import com.sap.furcas.parsergenerator.base.StubModelAdapter;
import com.sap.furcas.parsergenerator.base.StubModelElement;
import com.sap.furcas.parsergenerator.emf.lookup.FileBasedEcoreMetaModelLookUp;
import com.sap.furcas.runtime.common.interfaces.IMetaModelLookup;

/**
 * Currently fails because Enums are not implemented yet
 */
public class FPathGenerationTest extends ExtendedGeneratedParserBasedTest {

    private static final String LANGUAGE = "FPath";
    private static IMetaModelLookup lookup;


    @BeforeClass
	public static void setupParser() throws Exception {
		setParserGenerationTestHelper(ParserGenerationTestHelper.getDefault());
		setLookup(new FileBasedEcoreMetaModelLookUp("FPath1.ecore", "FPath.ecore"));
		generateParserForLanguage(LANGUAGE);
	}


    @Test
    public void testSample1() throws Exception {
        String sample = "myFunction(-$root,$a+$b)*.";
      
        StubModelAdapter stubModelHandler = parseString(sample , LANGUAGE, 0);
      
        // some asserts to make sure something reasonable has been parsed
        Set<StubModelElement> functions = stubModelHandler.getElementsbyType("FPath::FunctionCallExp");
        assertEquals(1, functions.size());
        StubModelElement function = functions.iterator().next();
        assertEquals("myFunction", function.get("name"));
        Set<StubModelElement> vars = stubModelHandler.getElementsbyType("FPath::VariableExp");
        assertEquals(3, vars.size());

    }

    @Test
    public void testSample2() throws Exception {
        String sample = "size($c/interface::*[required(.) and not(bound(.))]) > 0";
        StubModelAdapter stubModelHandler = parseString(sample , LANGUAGE, 0);
        
        // some asserts to make sure something reasonable has been parsed
        Set<StubModelElement> functions = stubModelHandler.getElementsbyType("FPath::FunctionCallExp");
        assertEquals(3, functions.size()); // functions: size, required, bound
        
        Set<StubModelElement> vars = stubModelHandler.getElementsbyType("FPath::VariableExp");
        assertEquals(1, vars.size());
        
        Set<StubModelElement> binOps = stubModelHandler.getElementsbyType("FPath::BinaryOperatorExp");
        assertEquals(2, binOps.size()); // and, >

    }

    @Test
    public void testSample3() throws Exception {
        String sample = "$itf/sibling::*/interface::*[provided(.)][subtype(., $itf)]";
        StubModelAdapter stubModelHandler = parseString(sample , LANGUAGE, 0);
        
        
        Set<StubModelElement> functions = stubModelHandler.getElementsbyType("FPath::Step");
        assertEquals(2, functions.size()); // functions: size, required, bound
        

    }

}
